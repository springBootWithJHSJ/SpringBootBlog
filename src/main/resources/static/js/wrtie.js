const Editor = toastui.Editor;

const editor = new Editor({
    el: document.querySelector('#editor'),
    height: '1200px',
    initialEditType: 'markdown',
    previewStyle: 'vertical'
});


editor.getMarkdown();

