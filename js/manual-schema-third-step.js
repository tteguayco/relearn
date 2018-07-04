
const NUM_OF_TUPLES_PER_RELATION = 1;

const BAD_STRING_MESSAGE = "Only letters, digits and underscores are allowed in an attribute of type string. The first character must be a letter.";
const BAD_CHAR_MESSAGE = "Only one letter is allowed in an attribute of type character.";
const BAD_INTEGER_MESSAGE = "This is not a valid integer value (10 digits max).";
const BAD_FLOAT_MESSAGE = "This is not a valid float value (10 digits max). The dot is the only valid separator.";
const BAD_DATE_MESSAGE = "The date format is DD/MM/YYYY.";

function prepareThirdModal() {

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