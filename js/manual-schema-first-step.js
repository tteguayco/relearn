function addRelationNameTextBox() {
	$("#relations-names-panel").append('<input type="text" class="rel-name" placeholder="Relation Name" style="margin-top:5px">');
}

function removeLatestRelationNameTextBox() {

	// There must be at least one relation name text box
	var numOfTextBoxes = $("#relations-names-panel").children().length;

	if (numOfTextBoxes > 1) {
		$("#relations-names-panel").children().last().remove();
	}

	else {
		// Display alert in the top left corner
		$.uiAlert({
			textHead: 'Relation name removal not allowed',
			text: ' You need to provide at least one relation to your schema. ',
			bgcolor: '#DB2828',
			textcolor: '#fff',
			position: 'top-left',
			icon: 'remove circle',
			time: 5
		});
	}
}

$(document).ready(function() {

	$("#add-relation-btn").click(addRelationNameTextBox);
	$("#remove-relation-btn").click(removeLatestRelationNameTextBox);
});