
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
		// TODO send definition to server and check it is valid

	}

	return valid;
}

function goToMainPage() {
	
	if (definedSchemaIsValid()) {
		alert("Not implemented yet: going to main app...");
	}

	else {
		
	}
}

$(document).ready(function() {

	$("#next-btn").click(goToMainPage);
});