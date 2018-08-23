
function displayErrorsInSchemaPage(errorsToDisplay) {
	// Add HTML breaklines
	errorsToDisplay = errorsToDisplay.replace("\n", "<br>");

	$("#errors-messages").html(errorsToDisplay);
	$(".schema-errors-panel").show();
}

function createDatabaseFromDefinition() {
	var schemaDefinitionDSL = $("#db-definition-file-content").text();

	if (schemaDefinitionDSL.length <= 0) {

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
		sendSchemaDefinitionToServerAndHandleResponse(schemaDefinitionDSL);
	}
}

$(document).ready(function() {
	$("#next-btn").click(function() {
		createDatabaseFromDefinition();
	});
});