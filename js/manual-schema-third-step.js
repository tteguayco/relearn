
function prepareThirdModal() {

}

function goToSecondStepFromThirdStep() {
	$("#modal-manual-def-second-step").modal("show");	
}

function goToMainApp() {
	alert("Not implemented yet: going to main app");
}

$(document).ready(function() {
	$("#third-step-next-btn").click(goToMainApp);
	$("#third-step-back-btn").click(goToSecondStepFromThirdStep);
});