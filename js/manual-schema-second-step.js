
function prepareSecondModal() {
	var databaseName = $("#db-name").text();
	var relationsList = $(".rel-name").map(function(i, elem) { if (elem.value.length > 0) { return elem.value } });
	var formSecondModal = $("#form-second-modal");
		
	formSecondModal.empty();

	for (i = 0; i < relationsList.length; i++) {
		var currentRelationName = relationsList[i];

		var accordion = $('<div class="ui accordion attribute-list-accordion"></div>');
		var accordionTitle = $('<div class="title"></div>');
		var accordionContent = $('<div class="content"></div>');

		// Open first accordion
		if (i == 0) {
			accordion = $('<div class="ui accordion active"></div>');
		}

		formSecondModal.append(accordion);
		accordion.append(accordionTitle);
		accordion.append(accordionContent);
		accordionTitle.append('<i class="dropdown icon"></i>');
		accordionTitle.append('<label><b>Relation <span class="relation-name-second-step"><i>' + currentRelationName + ' </i></span></b></label>');

		// Buttons to add/remove attribute
		var attributeLabel = $('<label class="attribute-label-second-modal"><b>Attributes </b></label>');
		var addButton = $('<div class="ui circular tiny compact icon button add-attribute-btn" data-tooltip="Add an attribute" data-position="top center" data-inverted="">');
		var removeButton = $('<div class="ui circular tiny compact icon button remove-attribute-btn" data-tooltip="Remove lastest attribute" data-position="right center" data-inverted="">');
		addButton.append('<i class="plus icon" data-variation="inverted"></i>');
		removeButton.append('<i class="minus icon"></i>');
		
		accordionContent.append(attributeLabel);
		accordionContent.append(addButton);
		accordionContent.append(removeButton);

		// Attribute names and domains
		var segment = $('<div class="ui segment attribute-list"></div>');
		var attributeGroup = $('<div class="attribute-group"></div>');
		var attributeNameTextbox = $('<input type="text" class="attribute-name" placeholder="Attribute Name"></input>');
		var attributeDomainDropdown = $('<select class="ui dropdown attribute-domain"></select>');

		// Domain dropdown options
		attributeDomainDropdown.append('<option value="0">String</option>');
		attributeDomainDropdown.append('<option value="1">Char</option>');
		attributeDomainDropdown.append('<option value="2">Integer</option>');
		attributeDomainDropdown.append('<option value="3">Float</option>');
		attributeDomainDropdown.append('<option value="4">Date</option>');
					
		accordionContent.append(segment);
		segment.append(attributeGroup);
		attributeGroup.append(attributeNameTextbox);
		attributeGroup.append(attributeDomainDropdown);
	}

	// Initialize accordions
	$(".ui.accordion").accordion();
}

$(document).ready(function() {

	//$("#second-step-next-btn").click();
});