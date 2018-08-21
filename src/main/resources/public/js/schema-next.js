
function displayErrorsInSchemaPage(errorsToDisplay) {
	// Add HTML breaklines
	errorsToDisplay = errorsToDisplay.replace("\n", "<br>");

	$("#errors-messages").html(errorsToDisplay);
	$(".schema-errors-panel").show();
}

function definedSchemaIsValid() {
	var valid = true;
	var schemaDefinitionDSL = $("#db-definition-file-content").text();


	if (schemaDefinitionDSL.length <= 0) {
		valid = false;

		// Display alert in the top left corner
		$.uiAlert({
			textHead: 'No schema specified',
			text: 'You must define a schema before continuing.',
			bgcolor: '#DB2828',
			textcolor: '#fff',
			position: 'top-left',
			icon: 'remove circle',
			time: 4
		});
	
	} else {
		// Send the schema definition to the server to check if it is valid
		var dataForServer = {
			"DatabaseSchemaDefinition": schemaDefinitionDSL
		};

		$.ajax({
			data: dataForServer,
			url: "/checkSchemaDefinitionFromFile",
			success: function(syntaxOrSemanticErrors) {
				// Display errors in panel
				if (syntaxOrSemanticErrors.length > 0) {
					valid = false;
					displayErrorsInSchemaPage(syntaxOrSemanticErrors);
				}
			},
			error: function(xhr, status, error) {
				alert(error);
			}
		});
	}

	return valid;
}

function goToMainPage() {
	
	if (definedSchemaIsValid()) {
		//TODO: GO TO MAIN APP
	}
}

$(document).ready(function() {

	$("#next-btn").click(goToMainPage);
});