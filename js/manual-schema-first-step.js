
const EMPTY_NAME_MESSAGE = "This name cannot be blank.";
const DATABASE_NAME_NOT_VALID_MSG = "Only letters, digits and underscores are allowed in an database name. The first character must be a letter.";
const RELATION_NAME_NOT_VALID_MSG = "Only letters, digits and underscores are allowed in an database name. The first character must be a letter.";

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

function formFirstModalIsValid() {
	var valid = true;
	var databaseNameTextbox = $("#db-name");
	var relationsNamesTextboxes = $(".rel-name");
	var databaseName = databaseNameTextbox.val();
	var databaseNameErrorMsg = "";
	var relationNameErrorMsg = "";

	if (databaseName.length > 0) {
		if (!databaseName.match(/^[A-Za-z]\w*$/)) {
			databaseNameErrorMsg = DATABASE_NAME_NOT_VALID_MSG;
		}
	} else {
		databaseNameErrorMsg = EMPTY_NAME_MESSAGE;
	}

	if (databaseNameErrorMsg.length > 0) {
		databaseNameTextbox.addClass("input-text-with-errors");
		databaseNameTextbox.popup({ content : databaseNameErrorMsg });
		valid = false;
	}

	for (i = 0; i < relationsNamesTextboxes.length; i++) {
		relationNameErrorMsg = "";
		var relationName = relationsNamesTextboxes.eq(i).val();
		
		if (relationName.length > 0) {
			if (!relationName.match(/^[A-Za-z]\w*$/)) {
				relationNameErrorMsg = RELATION_NAME_NOT_VALID_MSG;
			}
		} else {
			relationNameErrorMsg = EMPTY_NAME_MESSAGE;
		}
		
		if (relationNameErrorMsg.length > 0) {
			relationsNamesTextboxes.eq(i).addClass("input-text-with-errors");
			relationsNamesTextboxes.eq(i).popup({ content : relationNameErrorMsg });
			valid = false;
		}
	}

	return valid;
}

function resetErrorsFromFirstModal() {
	// Remove red text boxes
	$("#modal-manual-def-first-step")
	.find(".input-text-with-errors")
	.removeClass("input-text-with-errors");

	// Remove popup with error messages
	$("#db-name").popup('destroy');
	$(".rel-name").popup('destroy');
}

function goToSecondStep() {
	
	resetErrorsFromFirstModal();

	if (formFirstModalIsValid()) {
		prepareSecondModal();
		$("#modal-manual-def-second-step").modal("show");
	}

	else {
		// Display errors
		console.error("Form not valid");
	}
}

$(document).ready(function() {

	$("#add-relation-btn").click(addRelationNameTextBox);
	$("#remove-relation-btn").click(removeLatestRelationNameTextBox);
	$("#first-step-next-btn").click(goToSecondStep);

	// To prevent a modal action from causing the modal to close
	$('.modal').modal({
		onApprove: function () {
			return false;
		}
	});
});