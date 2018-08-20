
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
			success: function(response) {
				alert(response);
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
		alert("Not implemented yet: going to main app...");
	}

	else {
		
	}
}

$(document).ready(function() {

	$("#next-btn").click(goToMainPage);
});