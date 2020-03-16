class Stack {
    constructor() {
        this.items = [];
    }
    push(element) {
        this.items.push(element);
    }
    pop() {
        if (this.items.length == 0)
            return "Underflow";
        return this.items.pop();
    }
}
var stack = new Stack();
// to push element in stack and set text format and visibility
function pushFunction() {
    var value = document.getElementById("inputValue").value;
    if (value != "") {
        stack.push(value);
        if (stack.items.length == 1) {
            document.getElementById("showStack").style.display = "block";
        }
        document.getElementById("StackItem").innerHTML = "";
        for (var i = stack.items.length - 1; i >= 0; i--) {
            document.getElementById("StackItem").innerHTML += "<span>" + stack.items[i] + "</br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>";
        }
    } else {
        alert("Please enter some value to be pushed.");
    }

}
// to pop element from stack and set text format and visibility
function popFunction() {
    var popedValue = stack.pop();
    document.getElementById("StackItem").innerHTML = "";
    if (stack.items.length >= 1) {
        for (var i = stack.items.length - 1; i >= 0; i--) {
            document.getElementById("StackItem").innerHTML += "<span>" + stack.items[i] + "</br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>";
        }
    } else {
        document.getElementById("showStack").style.display = "none";
    }
}