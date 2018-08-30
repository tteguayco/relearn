
function downloadContentAsFile(content, filename) {
    var a = document.createElement('a');
    var blob = new Blob([content], { 'type': "text/plain" });
    a.href = window.URL.createObjectURL(blob);
    a.download = filename;
    a.click();
}

function sendSchemaDefinitionToServerAndHandleResponse(schemaDefinition) {
    dataForServer = {
        "DatabaseSchemaDefinition": schemaDefinition
    };

    $.ajax({
        data: dataForServer,
        url: "/checkSchemaDefinitionFromFile",
        success: function(syntaxOrSemanticErrors) {
            // Display errors in panel
            if (syntaxOrSemanticErrors.length > 0) {
                displayErrorsInSchemaPage(syntaxOrSemanticErrors);
            }

            // Go to main app
            else {
                window.location = "/main";
            }
        },
        error: function(xhr, status, error) {
            displayErrorsInSchemaPage(error);
        },
        beforeSend: function() { 
            $('#loading-db-creation-modal').modal({ closable: false }).modal('show');
        },
        complete: function() {
            $('#loading-db-creation-modal').modal('hide');
        }
    });
}