
CREATE_NEW_DB_MSG = "Create a new database";
ALTER_CURRENT_DB_MSG = "Alter database";
DELETE_CURRENT_DB_MSG = "Delete/drop database";
SAVE_CURRENT_DB = "Dump database definition to file";
DEFAULT_NAME_DOWNLOADED_RELALG_QUERY = "query.ra";
RUN_RELALG_QUERY_MSG = "Run Relational Algebra query";
SAVE_RELALG_QUERY_MSG = "Download Relational Algebra query";

function setEditorsConfiguration() {
	var relalgEditor = ace.edit("relalg-editor");
	relalgEditor.setTheme("ace/theme/dawn");
    document.getElementById('relalg-editor').style.fontSize='18px';
    relalgEditor.session.setMode("ace/mode/javascript");
    relalgEditor.setShowPrintMargin(false);
    relalgEditor.resize();

	var sqlEditor = ace.edit("sql-editor");
    sqlEditor.setTheme("ace/theme/dawn");
    document.getElementById('sql-editor').style.fontSize='18px';
    sqlEditor.session.setMode("ace/mode/javascript");
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
		$("#relalg-editor").focus();
		$("#relalg-editor").navigateFileEnd();
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
}

function setUpMessageBoxesClosing() {
	$('.message .close').on('click', function() {
    	$(this).closest('.message').transition('fade');
	});
}

function getRelationalAlgebraEditorContent() {
    return ace.edit("relalg-editor").getValue();
}

function sendCurrentQueryToServer() {
    var queryToSend = getRelationalAlgebraEditorContent();
    var selectedDatabaseName = $("#databases-dropdown").text().trim();

    alert("Running Relational Algebra query!");

    if (queryToSend.length > 0) {
        dataForServer = {
            "RelationalAlgebraQuery": queryToSend,
            "SelectedDatabaseName": selectedDatabaseName
        }

        $.ajax({
            data: dataForServer,
            url: "/executeQuery",
            success: function() {

            },
            error: function() {

            },
            beforeSend: function() {

            },
            complete: function() {

            }
        });
    }
}

function saveCurrentQuery() {
    var queryToSave = getRelationalAlgebraEditorContent();

    if (queryToSave.length > 0) {
        downloadContentAsFile(queryToSave, DEFAULT_NAME_DOWNLOADED_RELALG_QUERY);
    }
}

$(document).ready(function() {
	setEditorsConfiguration();
	setTabsConfiguration();
	setAccordionsConfiguration();
	setUpToolTips();
	setUpMessageBoxesClosing();

    $("#run-query-btn").click(function() {
        sendCurrentQueryToServer();
    });

    $("#save-query-btn").click(function() {
        saveCurrentQuery();
    });
});