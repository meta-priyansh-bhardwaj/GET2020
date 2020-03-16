String.prototype.repeatify = function(counter) {

    newString = ""
    for (var i = 0; i < counter; i++) {
        newString += this;

    }
    return newString;
};

function stringFunction() {
    var count = document.getElementById("inputValue").value;
    var str = document.getElementById("inputText").value;

    var repetedString = str.repeatify(count)

    document.getElementById("showResult").innerHTML = repetedString;
}