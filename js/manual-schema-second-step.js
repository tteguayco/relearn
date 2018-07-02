
function getAttributeGroup() {
	return $('<div class="attribute-group"></div>');
}

function getAttributeNameTextBox() {
	var textBox = $('<input type="text" class="attribute-name" placeholder="Attribute Name"></input>');

	// CSS styles (should be moved to an external styles file)
	textBox.css("width", "65%");
	textBox.css("display", "inline-block");

	return textBox;
}

function getDomainsDropdown() {
	var attributeDomainDropdown = $('<select class="ui dropdown attribute-domain"></select>');

	// Domain dropdown options
	attributeDomainDropdown.append('<option value="0">String</option>');
	attributeDomainDropdown.append('<option value="1">Char</option>');
	attributeDomainDropdown.append('<option value="2">Integer</option>');
	attributeDomainDropdown.append('<option value="3">Float</option>');
	attributeDomainDropdown.append('<option value="4">Date</option>');

	// CSS styles (should be moved to an external styles file)
	attributeDomainDropdown.css("width", "30%");
	attributeDomainDropdown.css("display", "inline-block");

	return attributeDomainDropdown;
}

function addAttribute() {
	var attributeList = $(this).siblings('.attribute-list');
	var newAttributeGroup = getAttributeGroup();

	attributeList.append(newAttributeGroup);
	newAttributeGroup.append(getAttributeNameTextBox());
	newAttributeGroup.append(getDomainsDropdown());
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

function prepareSecondModal() {
	var databaseName = $("#db-name").text();
	var relationsList = $(".rel-name").map(function(i, elem) { if (elem.value.length > 0) { return elem.value } });
	var formSecondModal = $("#form-second-modal");
	var accordion = $('<div class="ui accordion attribute-list-accordion"></div>');

	formSecondModal.empty();
	formSecondModal.append(accordion);
	$(".ui.accordion").accordion();

	for (i = 0; i < relationsList.length; i++) {
		var currentRelationName = relationsList[i];

		var accordionTitle = $('<div class="title"></div>');
		var accordionContent = $('<div class="content"></div>');

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

		addButton.click(addAttribute);
		removeButton.click(removeAttribute);

		// Attribute names and domains
		var segment = $('<div class="ui segment attribute-list"></div>');
		var attributeGroup1 = getAttributeGroup();
		var attributeNameTextbox1 = getAttributeNameTextBox();
		var attributeDomainDropdown1 = getDomainsDropdown();

		var attributeGroup2 = getAttributeGroup();
		var attributeNameTextbox2 = getAttributeNameTextBox();
		var attributeDomainDropdown2 = getDomainsDropdown();
					
		accordionContent.append(segment);

		segment.append(attributeGroup1);
		attributeGroup1.append(attributeNameTextbox1);
		attributeGroup1.append(attributeDomainDropdown1);

		segment.append(attributeGroup2);
		attributeGroup2.append(attributeNameTextbox2);
		attributeGroup2.append(attributeDomainDropdown2);

		// Open first accordion
		if (i == 0) {
			accordionTitle.addClass("active");
			accordionContent.addClass("active");
		}
	}
}

$(document).ready(function() {

	//$("#second-step-next-btn").click();
});