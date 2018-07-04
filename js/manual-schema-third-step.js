
const NUM_OF_TUPLES_PER_RELATION = 1;

const BAD_STRING_MESSAGE = "Only letters, digits and underscores are allowed in an attribute of type string. The first character must be a letter.";
const BAD_CHAR_MESSAGE = "Only one letter is allowed in an attribute of type character.";
const BAD_INTEGER_MESSAGE = "This is not a valid integer value (10 digits max).";
const BAD_FLOAT_MESSAGE = "This is not a valid float value (10 digits max). The dot is the only valid separator.";
const BAD_DATE_MESSAGE = "The date format is DD/MM/YYYY.";

function addTuple() {

}

function removeTuple() {

}

function prepareThirdModal() {
	var formThirdModal = $("#form-third-modal");
	var relationsList = $(".rel-name").map(function(i, elem) { if (elem.value.length > 0) { return elem.value } });
	var accordion = $('<div class="ui accordion tuple-list-accordion"></div>');

	formThirdModal.empty();
	formThirdModal.append(accordion);

	// Get a list of attributes list
	var attrLists = $(".attribute-list");
	var attrListOfLists = [];
	var domainListOfLists = [];
	for (i = 0; i < attrLists.length; i++) {
		var attrList = attrLists.eq(i).find(".attribute-name").map(function(i, elem) { return elem.value; });
		var domainList = attrLists.eq(i).find(".attribute-domain > select").find(":selected").map(function(i, elem) { return elem.value; });

		attrListOfLists.push(attrList);
		domainListOfLists.push(domainList);
	}

	for (i = 0; i < relationsList.length; i++) {
		var currentRelationName = relationsList[i];

		var accordionTitle = $('<div class="title"></div>');
		var accordionContent = $('<div class="content"></div>');

		accordion.append(accordionTitle);
		accordion.append(accordionContent);
		accordionTitle.append('<i class="dropdown icon"></i>');
		accordionTitle.append('<label><b>Relation <span class="relation-name-second-step"><i>' + currentRelationName + ' </i></span></b></label>');

		// Buttons to add/remove attribute
		var tupleLabel = $('<label class="tuple-label-third-modal"><b>Tuples </b></label>');
		var addButton = $('<div class="ui circular tiny compact icon button add-tuple-btn" data-tooltip="Add a tuple" data-position="top center" data-inverted="">');
		var removeButton = $('<div class="ui circular tiny compact icon button remove-tuple-btn" data-tooltip="Remove last tuple" data-position="right center" data-inverted="">');
		addButton.append('<i class="plus icon" data-variation="inverted"></i>');
		removeButton.append('<i class="minus icon"></i>');

		accordionContent.append(tupleLabel);
		accordionContent.append(addButton);
		accordionContent.append(removeButton);

		addButton.click(addTuple);
		removeButton.click(removeTuple);

		var tuple = $('<div class="ui input values-list"></div>');
		var attrNamesRow = $('<div class="attribute-names-row"></div>');
		
		accordionContent.append(attrNamesRow);
		accordionContent.append(tuple);

		attrListForCurrentRelation = attrListOfLists[i];
		domainListForCurrentRelation = domainListOfLists[i];

		for (j = 0; j < attrListForCurrentRelation.length; j++) {
			var attrName = attrListForCurrentRelation[j];
			var domainName = domainListForCurrentRelation[j];

			// Display the names of the attributes in the first row
			if (j == 0) {
				var attrLabelContainer = $('<div class="attribute-label-container"></div>');
				var attrLabel = $('<label class="attribute-name-label"><b>' + attrName + ' (<i>' + domainName + '</i>) </b></label>');
				
				attrNamesRow.append(attrLabelContainer);
				attrLabelContainer.append(attrLabel);
			}

			var tupleValueTextbox = $('<input type="text" class="tuple-value-textbox" attribute-name="' + attrName + '" domain="' + domainName + '" placeholder="Value"></input>');
			tuple.append(tupleValueTextbox);
		}

		// Open first accordion
		if (i == 0) {
			accordionTitle.addClass("active");
			accordionContent.addClass("active");
		}
	}

	// Initialize UI components
	$(".ui.accordion").accordion();
}

function goToSecondStepFromThirdStep() {
	$("#modal-manual-def-second-step").modal("show");	
}

function goToMainAppFromThirdStep() {
	alert("Not implemented yet: going to main app");
}

$(document).ready(function() {
	$("#third-step-next-btn").click(goToMainAppFromThirdStep);
	$("#third-step-back-btn").click(goToSecondStepFromThirdStep);
});