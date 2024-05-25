// script.js
document.addEventListener('DOMContentLoaded', function() {
    const importStatementDiv = document.getElementById('import-statement');
    if (importStatementDiv) {
        importStatementDiv.innerHTML = `<div class="import-statement">
            <p>Import Statement: {</p>
            <div class="import-declaration" style="margin-left: ${Space.currentValue * 20}px;">
            </div>
            <p>}</p>
        </div>`;
    }
});

