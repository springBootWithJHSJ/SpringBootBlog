const Editor = toastui.Editor;

const editor = new Editor({
    el: document.querySelector('#editor'),
    height: '600px',
    initialEditType: 'markdown',
    previewStyle: 'vertical'
});
let content = document.querySelector(`#article_content`);
content.innerHtml = editor.getMarkdown();


(function () {
    let autoSave = {};
    (function (obj) {
        obj.configuration = {
            interval: 60 // second(s)
        };
        obj.bindTimer = function () {
            let textEle = document.querySelector('.ProseMirrorS');
            console.log(textEle)
            let textVal = textEle.innerHtml
            console.log(textVal)
            let ref1, ref2, ref3; // Newer -&gt; Older

            // Save to localStorage
            let encodedTextVal = btoa(textVal);
            ref1 = window.localStorage.getItem('textval-01');
            ref2 = window.localStorage.getItem('textval-02');

            if ((window.localStorage) && (encodedTextVal != ref1)) {
                window.localStorage.setItem('textval-01', encodedTextVal);
                window.localStorage.setItem('textval-02', ref1);
                window.localStorage.setItem('textval-03', ref2);
            } else if (!window.localStorage) {
                console.log('Error' + ': Your browser not support')
                return false;
            }
        };

        obj.start = function () {
            obj.bindTimer();
            setTimeout(function () {
                obj.start();
            }, obj.configuration.interval * 1000);
        };
        obj.start();
    })(autoSave);
})();
    
