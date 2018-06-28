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
			textHead: 'Relation removal not allowed',
			text: ' You need to provide at least one relation in your schema. ',
			bgcolor: '#DB2828',
			textcolor: '#fff',
			position: 'top-left',
			icon: 'remove circle',
			time: 3
		});
	}
}

function isValidName(aName) {
	var valid = true;

	// Empty name
	if (aName.length < 1) {
		valid = false;
	}

	// The first character of the name is different from a letter
	if (!aName.charAt(0).match(/[a-z]/i)) {
		valid = false;
	}

	// The name contains spaces
	if (aName.indexOf(' ') >= 0) {
		valid = false;
	}

	return valid;
}

function checkFields() {
	var errors = false;

	// Database name
	var databaseName = $("#db-name").val();
	if (!isValidName(databaseName)) {
		errors = true;
	}
	
	// Relations names
	var textBoxes = $(".rel-name");
	var relationsNames = [];
	var auxName;

	// Collect non-empty relation names
	for (i = 0; i < textBoxes.length; i++) {
		auxName = textBoxes[i].value.trim();
		if (auxName.length > 0) {
			relationsNames.push(auxName);
		}
	}

	// At least one relation name must be non-empty
	if (relationsNames.length > 0) {
		for (i = 0; i < relationsNames.length; i++) {
			if (!isValidName(relationsNames[i])) {
				errors = true;
				break;
			}
		}
	} else {
		errors = true;
	}

	// Display info errors panel
	if (errors) {
		$("#errors-modal-first-step").show();
	}
	
	else {
		alert("No errors..");
	}
}

function goToFirstStep() {
	$("#modal-manual-def-first-step").modal("show");
}

function goToSecondStepFromThirdStep() {
	$("#modal-manual-def-second-step").modal("show");	
}

function goToSecondStep() {
	//var noerrors = checkFields();
	var noerrors = true;

	// Close current modal and open modal for the next step
	if (noerrors) {
		$("#modal-manual-def-second-step").modal("show");
	}

}

function goToThirdStep() {
	//var noerrors = checkFieldsFirstModal();
	var noerrors = true;

	// Close current modal and open modal for the next step
	if (noerrors) {
		$("#modal-manual-def-third-step").modal("show");
	}
}

$(document).ready(function() {

	// First modal buttons
	$("#add-relation-btn").click(addRelationNameTextBox);
	$("#remove-relation-btn").click(removeLatestRelationNameTextBox);
	//$("#first-step-next-btn").click(checkFields);
	$("#first-step-next-btn").click(goToSecondStep);

	// Second modal buttons
	$("#second-step-back-btn").click(goToFirstStep);
	$("#second-step-next-btn").click(goToThirdStep);

	// Third modal buttons
	$("#third-step-back-btn").click(goToSecondStepFromThirdStep);

	// To prevent a modal action from causing the modal to close
	$('.modal').modal({
		onApprove: function () {
			return false;
		}
	});
});