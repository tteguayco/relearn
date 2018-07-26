
function setEditorsConfiguration() {
	var relalgEditor = ace.edit("relalg-editor");
	relalgEditor.setTheme("ace/theme/dawn");
    document.getElementById('relalg-editor').style.fontSize='18px';
    relalgEditor.session.setMode("ace/mode/javascript");
    relalgEditor.setShowPrintMargin(false);
    relalgEditor.resize();

	var sqlEditor = ace.edit("sql-editor");
    sqlEditor.setTheme("ace/theme/dawn");
    document.getElementById('sql-editor').style.fontSize='18px';
    sqlEditor.session.setMode("ace/mode/javascript");
    sqlEditor.setShowPrintMargin(false);
    sqlEditor.resize();
    sqlEditor.setReadOnly(true);
	sqlEditor.renderer.$cursorLayer.element.style.display = "none";		// Hide cursor
	sqlEditor.setOption("highlightActiveLine", false);
}

function setTabsConfiguration() {
	// Initialize tabs
	$('.tabular.menu .item').tab();

	// Initially, disable the SQL tab


	// Set focus on the relalg editor when its tab is clicked
	$('.top.menu .item').tab({
		'onVisible': function() {
			$("#relalg-editor").focus();
		}
	});
}

$(document).ready(function() {
	setEditorsConfiguration();
	setTabsConfiguration();
});