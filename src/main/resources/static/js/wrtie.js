const Editor = toastui.Editor;

const editor = new Editor({
    el: document.querySelector('#editor'),
    height: '600px',
    initialEditType: 'markdown',
    previewStyle: 'vertical'
});

//에디터 안의 내용물을 담습니다.
document.querySelector(`#article_content`).insertAdjacentHTML('afterbegin', editor.getHTML());
editor.getMarkdown();

