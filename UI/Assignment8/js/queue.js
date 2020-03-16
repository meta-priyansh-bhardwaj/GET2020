class Queue {
    constructor() {
        this.items = [];
    }
    enqueue(element) {
        this.items.push(element);
    }
    dequeue() {
        if (this.items.length == 0)
            return "Underflow Situation";
        this.items.shift();
    }
}
var queue = new Queue();
// to add element in Queue and set text format and visibility
function enqueueFunction() {
    var value = document.getElementById("inputValue").value;
    if (value != "") {
        queue.enqueue(value);
        if (queue.items.length == 1) {
            document.getElementById("ShowQueue").style.display = "block";
        }
        document.getElementById("QueueItems").innerHTML = queue.items;
    } else {
        alert("Please insert some value to be inserted");
    }
}
// to remove element from Queue and set text format and visibility
function dequeueFunction() {
    var valueGet = queue.dequeue();
    if (queue.items.length >= 1) {
        document.getElementById("QueueItems").innerHTML = queue.items;
    } else {
        document.getElementById("ShowQueue").style.display = "none";
    }
}