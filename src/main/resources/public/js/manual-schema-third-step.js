
const NUM_OF_TUPLES_PER_RELATION = 1;

const BAD_STRING_MESSAGE = "Only letters, digits and underscores are allowed in an attribute of type string. The first character must be a letter.";
const BAD_CHAR_MESSAGE = "Only one letter is allowed in an attribute of type character.";
const BAD_INTEGER_MESSAGE = "This is not a valid integer value (10 digits max).";
const BAD_FLOAT_MESSAGE = "This is not a valid float value (10 digits max). The dot is the only valid separator.";
const BAD_DATE_MESSAGE = "The date format is DD/MM/YYYY.";

function getNewTupleValueTextbox(attrName, attrDomain, relationName) {
	return $('<input type="text" class="tuple-value-textbox"' 
		+ 'relation="' + relationName 
		+ '" attribute-name="' + attrName 
		+ '" domain="' + attrDomain 
		+ '" placeholder="Value"></input>');
}

function addTuple() {
	var aTuple =  $(this).siblings().find(".values-list").eq(0);
	var clonedTuple = aTuple.clone();

	aTuple.after(clonedTuple);
}

function removeTuple() {
	var numOfTuples = $(this).siblings().find(".values-list").length;

	if (numOfTuples > 1) {
		$(this).siblings().find(".values-list").last().remove();
	}

	// Display alert
	else {
		$.uiAlert({
			textHead: 'Tuple removal not allowed',
			text: 'You need to provide at least one tuple in your schema.',
			bgcolor: '#DB2828',
			textcolor: '#fff',
			position: 'top-right',
			icon: 'remove circle',
			time: 3
		});
	}
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
		accordionTitle.append('<i class="exclamation-warning red icon">!</i>');

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

		var tuplesAndAttributesNamesContainer = $('<div class="tuples-and-attributes-names-container"></div>');
		var tuple = $('<div class="ui input values-list"></div>');
		var attrNamesRow = $('<div class="attribute-names-row"></div>');
		var tuplesContainer = $('<div class="tuples-container"></div>');

		accordionContent.append(tuplesAndAttributesNamesContainer);
		tuplesAndAttributesNamesContainer.append(attrNamesRow);
		tuplesAndAttributesNamesContainer.append(tuplesContainer);
		tuplesContainer.append(tuple);

		attrListForCurrentRelation = attrListOfLists[i];
		domainListForCurrentRelation = domainListOfLists[i];

		// Set attributes names and tuples in the modal
		for (j = 0; j < attrListForCurrentRelation.length; j++) {
			var attrName = attrListForCurrentRelation[j];
			var domainName = domainListForCurrentRelation[j];
			var attrLabelContainer = $('<div class="attribute-label-container"></div>');
			var attrLabel = $('<label class="attribute-name-label"><b>' + attrName + ' (<i>' + domainName + '</i>) </b></label>');
			var tupleValueTextbox = getNewTupleValueTextbox(attrName, domainName, currentRelationName);

			attrNamesRow.append(attrLabelContainer);
			attrLabelContainer.append(attrLabel);
			tuple.append(tupleValueTextbox);
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

/**
 * Checks domains and changes red color of textbox if any mistake.
 */
function valueIsValid(value, domain, textbox) {
	var valid = true;
	var errorText = "";
	var exclamationMark = null;

	switch (domain) {
		case "string":
			if (!value.match(/^[A-Za-z]\w*$/)) {
				errorText = BAD_STRING_MESSAGE;
			}
			break;

		case "char":
			if (!value.match(/^[A-Za-z]$/)) {
				errorText = BAD_CHAR_MESSAGE;	
			}
			break;

		case "int":
			if (!value.match(/^\d{1,10}$/)) {
				errorText = BAD_INTEGER_MESSAGE;		
			}
			break;

		case "float":
			if (!value.match(/^\d{1,5}\.[\d]{1,5}$/)) {
				errorText = BAD_FLOAT_MESSAGE;
			}
			break;

		case "date":
			if (!value.match(/^\d\d\/\d\d\/\d\d\d\d$/)) {
				errorText = BAD_DATE_MESSAGE;
			}
			break;
	}

	if (errorText.length > 0) {
		textbox.addClass("input-text-with-errors");
		textbox.popup({ content : errorText	});

		// Display exclamation warnings
		exclamationMark = textbox.parents(".content").prev(".title").children(".exclamation-warning");
		exclamationMark.show();

		valid = false;
	}

	return valid;
}

/**
 * Validates form and builds error messages.
 */
function formThirdModalIsValid() {
	var valid = true;
	var valuesElem = $(".tuple-value-textbox");
	var auxValue = "";
	var auxDomain = "";

	disableExclamationWarnings();

	for (i = 0; i < valuesElem.length; i++) {
		auxValue = valuesElem.eq(i).val();
		auxDomain = valuesElem.eq(i).attr("domain");
		if (!valueIsValid(auxValue, auxDomain, valuesElem.eq(i))) {
			valid = false;
		}
	}

	return valid;
}

function resetErrorsFromThirdModal() {
	// Remove red text boxes
	$("#modal-manual-def-third-step")
	.find(".input-text-with-errors")
	.removeClass("input-text-with-errors");

	// Remove popup with error messages
	$(".tuple-value-textbox").popup('destroy');
}

function goToSecondStepFromThirdStep() {
	$("#modal-manual-def-second-step").modal("show");	
}

function buildSchemaDSLDefinition() {
	var databaseName = $("#db-name").val();
	var tuplesTextboxes = $(".tuple-value-textbox");
	var relationsNamesList = [];
	var attributesDict = {};
	var tuplesDict = {};

	// Collect data about relations and attributes
	tuplesTextboxes.each(function() {
		var relationName = $(this).attr("relation");
		var attrName = $(this).attr("attribute-name");
		var domain = $(this).attr("domain");
		var tupleValue = $(this).val();

		// Store relation name
		if (relationsNamesList.indexOf(relationName) < 0) {
			relationsNamesList.push(relationName);
		}

		// Store attributes' info in dictionary
		if (attributesDict[relationName] == undefined) {
			attributesDict[relationName] = {
				"domains": [],
				"names": []
			}
		}

		// Store attribute's info if it does not already exist
		if (attributesDict[relationName]["names"].indexOf(attrName) < 0) {
			attributesDict[relationName]["names"].push(attrName);
			attributesDict[relationName]["domains"].push(domain);
		}
	});

	// Collect data about tuples
	tuples = [];
	$(".tuples-and-attributes-names-container").each(function(i, val) {
		
		valuesList = $(this).find(".values-list");
		valuesList.each(function() {
			
			tupleValueTextBox = $(this).find(".tuple-value-textbox");
			tuple = [];	
			tupleValueTextBox.each(function() {
				tupleVal = {};
				tupleVal["relation"] = $(this).attr("relation");
				tupleVal["attribute-name"] = $(this).attr("attribute-name");
				tupleVal["domain"] = $(this).attr("domain");
				tupleVal["value"] = $(this).val();
				tuple.push(tupleVal);
			});
			tuples.push(tuple);
		});
	});

	//console.log(databaseName);
	//console.log(JSON.stringify(relationsNamesList));
	//console.log(JSON.stringify(attributesDict));
	//console.log(tuples);

	// Build definition
	schemaDefinition = "";
	schemaDefinition += "DATABASE " + databaseName + ";\n";

	for (var i = 0; i < relationsNamesList.length; i++) {
		var currentRelationName = relationsNamesList[i];
		var attributesForCurrentRelation = attributesDict[currentRelationName];
		var currentRelationAttrDomains = attributesForCurrentRelation["domains"];
		var currentRelationAttrNames = attributesForCurrentRelation["names"];

		schemaDefinition += "\nTABLE " + currentRelationName + "(";
		if (currentRelationAttrDomains.length == currentRelationAttrNames.length) {
			for (var j = 0; j < currentRelationAttrDomains.length; j++) {
				var currentAttrDomain = currentRelationAttrDomains[j];
				var currentAttrName = currentRelationAttrNames[j];

				schemaDefinition += currentAttrName + ": " + currentAttrDomain;

				// Add comma or final bracket
				if (j < currentRelationAttrDomains.length - 1) {
					schemaDefinition += ", ";
				}
				else {
					schemaDefinition += ")\n=>\n";
				}
			}
		}

		tuplesForCurrentRelation = [];
		for (var j = 0; j < tuples.length; j++) {
			if ((tuples[j][0])["relation"] == currentRelationName) {
				tuplesForCurrentRelation.push(tuples[j]);
			}
		}

		// Write tuples
		for (var j = 0; j < tuplesForCurrentRelation.length; j++) {
			schemaDefinition += "(";
			
			for (var k = 0; k < tuplesForCurrentRelation[j].length; k++) {
				var domain = tuplesForCurrentRelation[j][k]["domain"];
				var value = tuplesForCurrentRelation[j][k]["value"];
				
				if (domain == "string" || domain == "char") {
					schemaDefinition += "'" + value + "'";	
				}
				else {
					schemaDefinition += value;
				}
				
				// Add comma or final bracket
				if (k < tuplesForCurrentRelation[j].length - 1) {
					schemaDefinition += ", ";
				}
				else {
					schemaDefinition += ");\n";
				}
			}

			schemaDefinition += "\n";
		}
	}

	//console.log(schemaDefinition);
	return schemaDefinition;
}

function goToMainAppFromThirdStep() {

	resetErrorsFromThirdModal();

	if (formThirdModalIsValid()) {
		schemaDefinition = buildSchemaDSLDefinition();
		sendSchemaDefinitionToServerAndHandleResponse(schemaDefinition);
	}

	else {
		// Display errors
		console.log("Third modal's form was submitted with errors.");
	}
}

$(document).ready(function() {
	$("#third-step-next-btn").click(goToMainAppFromThirdStep);
	$("#third-step-back-btn").click(goToSecondStepFromThirdStep);

	$('#modal-manual-def-third-step').modal();
	$('#modal-manual-def-third-step').modal({
		onApprove: function () {
			return false;
		}
	});
});