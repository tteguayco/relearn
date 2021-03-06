
const NUM_OF_ATTRIBUTES_PER_RELATION = 1;

const EMPTY_ATTRIBUTE_NAME_MESSAGE = "This name cannot be blank";
const BAD_ATTRIBUTE_NAME_MESSAGE = "Only letters, digits and underscores are allowed in an attribute's name. The first character must be a letter";

// TODO: check if there are repited names for attributes in the same relation
const REPEATED_ATTRIBUTE_NAME_MESSAGE = "This attribute name already exists in this relation"

function getAttributeGroup() {
	return $('<div class="ui input attribute-group"></div>');
}

function getAttributeNameTextBox() {
	var textBox = $('<input type="text" class="attribute-name" placeholder="Attribute Name"></input>');

	// CSS styles (should be moved to an external styles file)
	textBox.css("width", "45%");
	textBox.css("display", "inline-block");

	return textBox;
}

function getDomainsDropdown() {
	var dropdownContainer = $('<div class="dropdown-container"></div>');
	var attributeDomainDropdown = $('<select class="ui fluid dropdown attribute-domain"></select>');
	dropdownContainer.append(attributeDomainDropdown);
	attributeDomainDropdown.dropdown();
	
	// Domain dropdown options
	attributeDomainDropdown.append('<option value="string">String</option>');
	attributeDomainDropdown.append('<option value="char">Character</option>');
	attributeDomainDropdown.append('<option value="int">Integer</option>');
	attributeDomainDropdown.append('<option value="float">Float</option>');
	attributeDomainDropdown.append('<option value="date">Date</option>');

	return dropdownContainer;
}

function getAttributeErrorsPanel() {
	var errorsPanel = $('<p class="attribute-errors-panel"></p>');

	return errorsPanel;
}

function addAttribute() {
	var attributeList = $(this).siblings('.attribute-list');
	var newAttributeGroup = getAttributeGroup();

	attributeList.append(newAttributeGroup);
	newAttributeGroup.append(getAttributeNameTextBox());
	newAttributeGroup.append(getDomainsDropdown());
	newAttributeGroup.append(getAttributeErrorsPanel());
}

function removeAttribute() {
	var attributeList = $(this).siblings('.attribute-list');
	var numOfAttributes = attributeList.children('.attribute-group').length;

	// Remove last attribute
	if (numOfAttributes > 1) {
		attributeList.children()[numOfAttributes - 1].remove();
	}

	// Display alert: there must be at leaste one attribute
	else {
		$.uiAlert({
			textHead: 'Attribute removal not allowed',
			text: ' All the relations must have at least one attribute. ',
			bgcolor: '#DB2828',
			textcolor: '#fff',
			position: 'top-left',
			icon: 'remove circle',
			time: 3
		});
	}
}

function disableExclamationWarnings() {
	$(".exclamation-warning").hide();
}

function prepareSecondModal() {
	var databaseName = $("#db-name").text();
	var relationsList = $(".rel-name").map(function(i, elem) { if (elem.value.length > 0) { return elem.value } });
	var formSecondModal = $("#form-second-modal");
	var accordion = $('<div class="ui accordion attribute-list-accordion"></div>');

	disableExclamationWarnings();

	formSecondModal.empty();
	formSecondModal.append(accordion);

	for (i = 0; i < relationsList.length; i++) {
		var currentRelationName = relationsList[i];

		var accordionTitle = $('<div class="title"></div>');
		var accordionContent = $('<div class="content"></div>');

		accordion.append(accordionTitle);
		accordion.append(accordionContent);
		accordionTitle.append('<i class="dropdown icon"></i>');
		accordionTitle.append('<label><b>Relation <span class="relation-name-second-step"><i>' + currentRelationName + ' </i></span></b></label>');
		accordionTitle.append('<i class="exclamation-warning red icon">!</i>');

		// Buttons to add/remove attribute
		var attributeLabel = $('<label class="attribute-label-second-modal"><b>Attributes </b></label>');
		var addButton = $('<div class="ui circular tiny compact icon button add-attribute-btn" data-tooltip="Add an attribute" data-position="top center" data-inverted="">');
		var removeButton = $('<div class="ui circular tiny compact icon button remove-attribute-btn" data-tooltip="Remove last attribute" data-position="right center" data-inverted="">');
		addButton.append('<i class="plus icon" data-variation="inverted"></i>');
		removeButton.append('<i class="minus icon"></i>');
		
		accordionContent.append(attributeLabel);
		accordionContent.append(addButton);
		accordionContent.append(removeButton);

		addButton.click(addAttribute);
		removeButton.click(removeAttribute);

		// Attribute names and domains
		var attrList = $('<div class="ui attribute-list"></div>');
		accordionContent.append(attrList);

		for (j = 0; j < NUM_OF_ATTRIBUTES_PER_RELATION; j++) {
			var attributeGroup = getAttributeGroup();
			var attributeNameTextbox = getAttributeNameTextBox();
			var attributeDomainDropdown = getDomainsDropdown();
			var attributeErrorsPanel = getAttributeErrorsPanel();

			attrList.append(attributeGroup);
			attributeGroup.append(attributeNameTextbox);
			attributeGroup.append(attributeDomainDropdown);
			attributeGroup.append(attributeErrorsPanel);
		}

		// Open first accordion
		if (i == 0) {
			accordionTitle.addClass("active");
			accordionContent.addClass("active");
		}
	}

	disableExclamationWarnings();

	// Initialize UI components
	$(".ui.accordion").accordion();
}

function attributeNameIsValid(name, textbox) {
	var valid = true;
	var errorText = "";
	var exclamationMark = null;

	if (name.length <= 0) {
		errorText = EMPTY_ATTRIBUTE_NAME_MESSAGE;
	}

	else {
		if (!name.match(/^[A-Za-z]\w*$/)) {
			errorText = BAD_ATTRIBUTE_NAME_MESSAGE;
		}
	}

	
	if (errorText.length > 0) {
		// Show tooltip (popup) with a detailed message of the error
		textbox.addClass("input-text-with-errors");
		textbox.popup({ content : errorText	});

		// Display exclamation mark in relation's title
		exclamationMark = textbox.parents(".content").prev(".title").children(".exclamation-warning");
		exclamationMark.show();

		valid = false;
	}

	return valid;
}

/**
 * Validates form and builds error messages.
 */
 function formSecondModalIsValid() {
	var valid = true;
	var attrLists = $(".attribute-list");

	disableExclamationWarnings();

	for (i = 0; i < attrLists.length; i++) {
		var attrNames = attrLists.eq(i).find(".attribute-name").map(function(i, elem) { return elem.value; });
		var attrNamesTextBoxes = attrLists.eq(i).find(".attribute-name");

		if (attrNames.length == attrNamesTextBoxes.length) {
			for (j = 0; j < attrNames.length; j++) {
				if (!attributeNameIsValid(attrNames[j], attrNamesTextBoxes.eq(j))) {
					valid = false;
				}
			}
		}

		else {
			var errorMsg = "Attributes elements length do not match [";
			errorMsg += "Names: " + attrNames.length + ", ";
			errorMsg += "Domains: " + attrDomains.length + ", ";
			errorMsg += "Error panels: " + attrErrorPanel.length + "]";
			console.error(errorMsg);
		}
	}

	return valid;
}

function resetErrorsFromSecondModal() {
	// Remove red text boxes
	$("#modal-manual-def-second-step")
	.find(".input-text-with-errors")
	.removeClass("input-text-with-errors");

	// Remove popup with error messages
	$(".attribute-name").popup('destroy');
}

function goToThirdStepFromSecondStep() {

	resetErrorsFromSecondModal();

	if (formSecondModalIsValid()) {
		prepareThirdModal();
		$("#modal-manual-def-third-step").modal("show");
	}

	else {
		// Display errors
		console.log("Second modal's form was submitted with errors.");
	}
}

function goToFirstStepFromSecondStep() {
	$("#modal-manual-def-first-step").modal("show");
}

$(document).ready(function() {
	$("#second-step-next-btn").click(goToThirdStepFromSecondStep);
	$("#second-step-back-btn").click(goToFirstStepFromSecondStep);

	$('#modal-manual-def-second-step').modal();
	$('#modal-manual-def-second-step').modal({
		onApprove: function () {
			return false;
		}
	});
});