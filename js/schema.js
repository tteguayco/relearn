
/**
 * Upload a file in the dropzone using a file chooser.
 */
function selectFile() {

	document.getElementById("filechooser").click();
	document.getElementById("filechooser").onchange = function() {
  		var fileFullPath = this.value;
  		var splittedPath = fileFullPath.split('\\');
  		var filename = splittedPath[splittedPath.length - 1];

  		// Place the name of the selected file inside the dropzone
  		$("#selected-filename").text(filename);

  		// Set hidden the content of the file in the DOM
  		var file = document.getElementById("filechooser").files[0];
  		if (file) {
  			var reader = new FileReader();
		    reader.readAsText(file, "UTF-8");

		    reader.onload = function (evt) {
		    	var fileContent = evt.target.result;
		        $("#db-definition-file-content").text(fileContent);
		    }

		    reader.onerror = function (evt) {
		        console.err("Error loading database definition file.");
		    }
  		}
	};
}

$(document).ready(function() {

	$("#dropzone").click(selectFile);
});