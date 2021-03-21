angular.module('')
    .controller('NoteController', function () {
    });



document.getElementById("nextNote").addEventListener("click", function(e) {
    var nextt = document.getElementById("page"); document.getElementById("nextPage").appendChild(nextt.cloneNode(true));
});

window.addEventListener("paste", function(e){
    var item = Array.from(e.clipboardData.items).find(x => /^image\//.test(x.type));

    var blob = item.getAsFile();

    var img = new Image();

    var reader = new FileReader();
    document.getElementById("dragImg").innerHTML= '<img id="showImage"></img>';
    reader.onload = function(event) {
        document.getElementById("showImage").src = event.target.result;

    };
    reader.readAsDataURL(blob);
});
