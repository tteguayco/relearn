
function downloadContentAsFile(content, filename) {
    var a = document.createElement('a');
    var blob = new Blob([content], { 'type': "text/plain" });
    a.href = window.URL.createObjectURL(blob);
    a.download = filename;
    a.click();
}