
CREATE_NEW_DB_MSG = "Create a new database";
ALTER_CURRENT_DB_MSG = "Alter database";
DELETE_CURRENT_DB_MSG = "Drop database";
SAVE_CURRENT_DB = "Dump database definition to file";
DEFAULT_NAME_DOWNLOADED_RELALG_QUERY = "query.ra";
RUN_RELALG_QUERY_MSG = "Run Relational Algebra Query";
RUN_PARTIAL_RELALG_QUERY_MSG = "Run Selected Relational Algebra Query";
SAVE_RELALG_QUERY_MSG = "Download Relational Algebra Query";
IMPORT_RELALG_QUERY_MSG = "Import Relational Algebra Query";
SCHEMA_DEFINITION_FORMAT_FILE = ".db";

function setEditorsConfiguration() {
	var relalgEditor = ace.edit("relalg-editor");
	relalgEditor.setTheme("ace/theme/sqlserver");
    document.getElementById('relalg-editor').style.fontSize='16px';
    relalgEditor.session.setMode("ace/mode/relalg");
    relalgEditor.setShowPrintMargin(false);
    relalgEditor.resize();
    relalgEditor.getSession().setUseWorker(false);

	var sqlEditor = ace.edit("sql-editor");
    sqlEditor.setTheme("ace/theme/sqlserver");
    document.getElementById('sql-editor').style.fontSize='18px';
    sqlEditor.session.setMode("ace/mode/sql");
    sqlEditor.setShowPrintMargin(false);
    sqlEditor.resize();
    sqlEditor.setReadOnly(true);
	sqlEditor.renderer.$cursorLayer.element.style.display = "none";		// Hide cursor
	sqlEditor.setOption("highlightActiveLine", false);
}

function setTabsConfiguration() {
	// Initialize tabs
	$('.tabular.menu .item').tab();

	// Initially, disable the SQL tab


	// Set focus on the relalg editor when its tab is clicked
	$('#relalg-tab').click(function() {
		// TODO make this work
		//$("#relalg-editor").focus();
		//$("#relalg-editor").navigateFileEnd();
	});
}

function setAccordionsConfiguration() {
	$('.ui.accordion').accordion();
}

function setUpToolTips() {
	$('#create-db-btn').popup({ content: CREATE_NEW_DB_MSG });
	$('#alter-db-btn').popup({ content: ALTER_CURRENT_DB_MSG });
	$('#delete-db-btn').popup({ content: DELETE_CURRENT_DB_MSG });
	$('#save-db-btn').popup({ content: SAVE_CURRENT_DB });
    $('#run-query-btn').popup({ content: RUN_RELALG_QUERY_MSG });
    $('#save-query-btn').popup({ content: SAVE_RELALG_QUERY_MSG });
    $('#import-relalg-query-btn').popup({ content: IMPORT_RELALG_QUERY_MSG });
}

function setUpMessageBoxesClosing() {
	$('.message .close').on('click', function() {
    	$(this).closest('.message').transition('fade');
	});
}

function getRelationalAlgebraEditorContent() {
    return ace.edit("relalg-editor").getValue();
}

function activateSQLEditorTab() {
    // Deselect all tabs
    $(".item.disabled").removeClass("active");

    // Select SQL tab
    $("#sql-tab").addClass("active");   // Tab title
    $.tab("change tab", "sql-tab");     // Tab content
}

function displayErrorMessages(errorsToDisplay) {
    // Display errors panels
    $("#errors-messages").html(errorsToDisplay);
    $(".schema-errors-panel").show();
    $("#error-execution-msg").show();

    // Hide success panels
    $("#result-table-row").hide();
    $("#success-execution-msg").hide();
}

function displayResultTable(resultTableAsJson) {
    var htmlTableContent = "";
    var head = "<thead><tr>";
    var body = "<tbody>";
    var resultTable = $("#result-table");

    for (var key in resultTableAsJson) {
        if (resultTableAsJson.hasOwnProperty(key)) {

            // COLUMNS NAMES
            if (key.trim() === "columnNames") {
                for (columnName in resultTableAsJson[key]) {
                    head += "<th>" + resultTableAsJson[key][columnName].toUpperCase() + "</th>";
                }
            }

            // ROWS VALUES
            else {
                body += "<tr>";
                for (rowValue in resultTableAsJson[key]) {
                    body += "<td>" + resultTableAsJson[key][rowValue] + "</td>";
                }
                body += "</tr>";
            }
        }
    }

    head += "</tr></thead>";
    body += "</tbody>";
    htmlTableContent = head + body;

    resultTable.html(htmlTableContent);

    // Display result table
    $("#success-execution-msg").show();
    $("#result-table-row").show();

    // Hide errors messages
    $(".schema-errors-panel").hide();
    $("#error-execution-msg").hide();
}
    
function sendCurrentQueryToServer() {
    var queryToSend = getRelationalAlgebraEditorContent();
    var selectedDatabaseName = $("#databases-dropdown").text().trim();
    var sqlEditor = ace.edit("sql-editor");

    if (queryToSend.length > 0) {
        dataForServer = {
            "RelationalAlgebraQuery": queryToSend,
            "SelectedDatabaseName": selectedDatabaseName
        }

        $.ajax({
            data: dataForServer,
            url: "/executeQuery",
            success: function(responseFromServer) {
                var responseAsJson = JSON.parse(responseFromServer);
                var translationErrors = responseAsJson["map"]["RelationalAlgebraTranslationErrors"];
                var sqlTranslation = "";
                var queryTableResult = null;

                if (translationErrors.length == 0) {
                    sqlTranslation = responseAsJson["map"]["SQLTranslation"];
                    queryTableResult = responseAsJson["map"]["TranslationExecutionResult"];

                    if (queryTableResult.hasOwnProperty("map")) {
                        queryTableResult = queryTableResult["map"];
                    }

                    // Set SQL query and switch to SQL tab
                    sqlEditor.setValue(sqlTranslation, 1);
                    activateSQLEditorTab();

                    // Build query result table and show it
                    displayResultTable(queryTableResult);
                }

                // ERRORS
                else {
                    displayErrorMessages(translationErrors);
                }
            },
            error: function(error) {

            },
            beforeSend: function() {
                // Loading icon in RUN button
                $("#run-query-btn").addClass("loading");
            },
            complete: function() {
                $("#run-query-btn").removeClass("loading");
            }
        });
    }
}

function saveCurrentQueryInLocalStorage() {
    var queryToSave = getRelationalAlgebraEditorContent();
    localStorage.setItem("formerQuery", queryToSave);
}

function saveCurrentQuery() {
    var queryToSave = getRelationalAlgebraEditorContent();

    if (queryToSave.length > 0) {
        downloadContentAsFile(queryToSave, DEFAULT_NAME_DOWNLOADED_RELALG_QUERY);
    }
}

function importRelalgQuery() {
    var relalgEditor = ace.edit("relalg-editor");
    document.getElementById("filechooser").click();
    document.getElementById("filechooser").onchange = function() {
        var fileFullPath = this.value;
        var splittedPath = fileFullPath.split('\\');
        var filename = splittedPath[splittedPath.length - 1];
        var file = document.getElementById("filechooser").files[0];
    
        // Dump file content to the query editor
        if (file) {
            var reader = new FileReader();
            reader.readAsText(file, "UTF-8");

            reader.onload = function (evt) {
                var fileContent = evt.target.result;
                relalgEditor.setValue(fileContent, 1);
            }

            reader.onerror = function (evt) {
                console.err("Error loading Relational Algebra query.");
            }
        }
    }
}

function dumpCurrentDatabaseSchemaDefinitionToFile() {
    var schemaDefinition = $("#schema-definition").text().trim();
    var databaseName = $("#databases-dropdown").text().trim();

    if (schemaDefinition.length > 0) {
        downloadContentAsFile(schemaDefinition, databaseName + SCHEMA_DEFINITION_FORMAT_FILE);
    }
}

function showDatabaseRemovalConfirmationDialog(databaseNameToDrop, callbackOnApprove) {
    // Display the name of the database to remove inside the modal's content
    $("#delete-db-confirmation-dialog").find("#db-name-to-drop").text(databaseNameToDrop);
    $("#delete-db-confirmation-dialog").modal({
        onApprove: callbackOnApprove
    });
    $("#delete-db-confirmation-dialog").modal("show");
}

function deleteCurrentDatabaseAndRedirectToDatabaseDefinition() {
    var databaseNameToDrop = $("#databases-dropdown").text().trim();

    showDatabaseRemovalConfirmationDialog(databaseNameToDrop, function() {
        dataForServer = {
            "DatabaseToDrop": databaseNameToDrop
        }

        $.ajax({
            data: dataForServer,
            url: "/dropDatabase",
            success: function(responseFromServer) {
                sleepFor(500);
                window.location.href = "/database";
            }
            ,error: function(error) {
                console.err(error);
            },
        });
    });
}

function setFormerRelalgQuery() {
    var formerQuery = localStorage.getItem("formerQuery");

    if (formerQuery != null && formerQuery.length > 0) {
        ace.edit("relalg-editor").setValue(formerQuery, 1);
    }
}

$(document).ready(function() {
	setEditorsConfiguration();
	setTabsConfiguration();
	setAccordionsConfiguration();
	setUpToolTips();
	setUpMessageBoxesClosing();
    setFormerRelalgQuery();

    $("#run-query-btn").click(function() {
        sendCurrentQueryToServer();
        saveCurrentQueryInLocalStorage();
    });

    $("#save-query-btn").click(function() {
        saveCurrentQuery();
    });

    $("#import-relalg-query-btn").click(function() {
        importRelalgQuery();
    });

    $("#save-db-btn").click(function() {
        dumpCurrentDatabaseSchemaDefinitionToFile();
    });

    $("#delete-db-btn").click(function() {
        deleteCurrentDatabaseAndRedirectToDatabaseDefinition();
    });
});