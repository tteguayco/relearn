
function loadFileContentInDOM(filename, file) {
	// Place the name of the selected file inside the dropzone
	if (filename.length > 0) {
		$("#selected-filename").html("<b>" + filename + "<b/>");
	}

	// Set hidden the content of the file in the DOM
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
}

/**
 * Upload a file in the dropzone using a file chooser.
 */
function loadSelectedFile() {

	document.getElementById("filechooser").click();
	document.getElementById("filechooser").onchange = function() {
  		var fileFullPath = this.value;
  		var splittedPath = fileFullPath.split('\\');
  		var filename = splittedPath[splittedPath.length - 1];
  		var file = document.getElementById("filechooser").files[0];

	  	loadFileContentInDOM(filename, file);
	};
}

/**
 * Load the dropped file inside the DOM (hidden)
 */
function loadDroppedFile(e) {
	var filename = e.originalEvent.dataTransfer.files[0].name;
	var file = e.originalEvent.dataTransfer.files[0];

	loadFileContentInDOM(filename, file);
}

$(document).ready(function() {

	var mainColor = "#3b83c0";
	var secondColor = "#bfbfbf";

	// Prevent the browser to open a file dropped inside in the window
	window.addEventListener("dragover", function(e) { e = e || event; e.preventDefault(); }, false);
	window.addEventListener("drop", function(e) { e = e || event; e.preventDefault(); }, false);

	$("#dropzone").click(loadSelectedFile);
	$("#dropzone").on("drop", loadDroppedFile);

	$("#dropzone").bind({
		dragover: function () {
			$("#dropzone").css("border-color", mainColor);
		},
		dragleave: function() {
			$("#dropzone").css("border-color", secondColor);
		}
	});

	$("#dropzone").hover(function() {
		$("#dropzone").css("border-color", secondColor);
	});

	$("#dropzone").mouseover(function() {
		$("#dropzone").css("border-color", mainColor);
	});
});