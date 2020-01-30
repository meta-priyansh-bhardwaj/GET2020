var numberOfVehicles = 132;
var typeOfVehicle;

function validateRegForm() {
    var valid = true;
    if ((document.getElementById('fname').value) == "") {
        document.getElementById('fname_error').innerHTML = "Enter Name";
        valid = false;
    } else if ((document.getElementById('fname').value).length < 2) {
        document.getElementById('fname_error').innerHTML = "Name must be contain atleast two charcter";
        valid = false;
    } else if ((/^[A-Z]*[a-z]{2,}/.test(document.getElementById('fname').value)) == false) {
        document.getElementById('fname_error').innerHTML = "Name not contain any number";
        valid = false;
    } else {
        document.getElementById('fname_error').innerHTML = "";
    }
    if ((document.getElementById('lname').value) == "") {
        document.getElementById('lname_error').innerHTML = "Enter Name";
        valid = false;
    } else if ((document.getElementById('lname').value).length < 2) {
        document.getElementById('lname_error').innerHTML = "Name must be contain atleast two charcter";
        valid = false;
    } else if ((/^[A-Z]*[a-z]{2,}/.test(document.getElementById('lname').value)) == false) {
        document.getElementById('lname_error').innerHTML = "Name not contain any number";
        valid = false;
    } else {
        document.getElementById('lname_error').innerHTML = "";
    }
    if ((document.getElementById('m1').checked == false) && (document.getElementById('f1').checked == false)) {
        document.getElementById('gender_error').innerHTML = "Must be select one option";
        valid = false;
    } else {
        document.getElementById('gender_error').innerHTML = "";
    }
    if (document.getElementById('email_id').value == "") {
        document.getElementById('email_error').innerHTML = "enter  email";
        valid = false;
    } else if (document.getElementById('email_id').value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/) == false) {
        document.getElementById('email_error').innerHTML = "enter valid email";
        valid = false;
    } else {
        document.getElementById('email_error').innerHTML = "";
    }
    if ((document.getElementById('password').value) == "") {
        document.getElementById('pass_error').innerHTML = "enter password";
        valid = false;
    } else if ((document.getElementById('password').value).length < 8) {
        document.getElementById('pass_error').innerHTML = "password must contain atleast 8 character";
        valid = false;
    } else if ((/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/.test(document.getElementById('password').value)) == false) {
        document.getElementById('pass_error').innerHTML = "enter in correct format";
        valid = false;
    } else {
        document.getElementById('pass_error').innerHTML = "";
    }
    if (!check("confirm_password")) {
        valid = false;
    }
    if ((document.getElementById('contact').value) == "") {
        document.getElementById('con_error').innerHTML = "enter contact number";
        valid = false;
    } else if ((document.getElementById('contact').value).length < 8) {
        document.getElementById('con_error').innerHTML = "contact number must contain 8 number";
        valid = false;
    } else if ((/^[0-9]{10}/.test(document.getElementById('contact').value)) == false) {
        document.getElementById('con_error').innerHTML = "enter correct contact number";
        valid = false;
    } else {
        document.getElementById('con_error').innerHTML = "";
    }

    if (valid) {
        document.getElementById("registerFor").style.display = "none";
        document.getElementById("carRegistration").style.display = "block";
        var registrationId = ++numberOfVehicles;
        document.getElementById("registrationId").innerHTML = registrationId;
    }
}

function check(id) {

    if (document.getElementById('password').value !== "") {
        if (document.getElementById('password').value ==
            document.getElementById(id).value) {

            document.getElementById('message').innerHTML = "match";
            document.getElementById('message').style.color = "green";
            return true;

        } else {
            document.getElementById('message').innerHTML = "no match";
            document.getElementById('message').style.color = "red";
            return false;
        }
    }
    return false;
}

function valCarform() {
    var valid = true;

    if ((document.getElementById('car_name').value) == "") {
        document.getElementById('car_error').innerHTML = "Enter car name";
        valid = false;
    } else if ((/^[A-Z]*[a-z]{2,}/).test(document.getElementById('car_name').value) == false) {
        document.getElementById('car_error').innerHTML = "Enter correct car name";
        valid = false;
    } else {
        document.getElementById('car_error').innerHTML = "";
    }
    if (document.getElementById('veh_type').value == "") {
        document.getElementById('veh_error').innerHTML = "select any option";
        valid = false;
    } else {
        document.getElementById('veh_error').innerHTML = "";
    }
    if ((document.getElementById('veh_num').value) == "") {
        document.getElementById('num_error').innerHTML = "enter vehicle number";
        valid = false;
    } else if ((/^(?=.*\d)(?=.*[A-Z]).{9,10}/).test(document.getElementById('veh_num').value) == false) {
        document.getElementById('num_error').innerHTML = "enter correct number";
        valid = false;
    } else {
        document.getElementById('num_error').innerHTML = "";
    }
    if ((document.getElementById('employee_id').value) == "") {
        document.getElementById('emp_error').innerHTML = "enter employee id";
        valid = false;
    } else if ((/^[A-Z]*[a-z]*[0-9]{1,}/).test(document.getElementById('employee_id').value) == false) {
        document.getElementById('emp_error').innerHTML = "enter correct employee id";
        valid = false;
    } else {
        document.getElementById('emp_error').innerHTML = "";
    }
    if (valid) {
        document.getElementById("carRegistration").style.display = "none";
        document.getElementById("passTypeForm").style.display = "block";
        typeOfVehicle = document.getElementById('veh_type').value;
    }
}

function valPassForm() {
    var valid = true;
    if (document.getElementById('pass_type').value == "") {
        document.getElementById('pass_error').innerHTML = "select any option";
        valid = false;
    } else {
        document.getElementById('pass_error').innerHTML = "";
    }
    if (valid) {
        document.getElementById("passTypeForm").style.display = "none";
        document.getElementById("Thank_you").style.display = "block";
    }
}

var xmlHttp = new XMLHttpRequest();
var theUrl = "http://api.currencylayer.com/live?access_key=2243dba5ea20e9d54f41fc7da3486f04&currencies=USD,INR,JPY";
xmlHttp.open("GET", theUrl, false);
xmlHttp.send(null);
var currencyRates = JSON.parse(xmlHttp.responseText).quotes;
var currentCurrency = "INR";

function exchangeCurrency(amount) {
    if (currentCurrency === "INR") {
        return "&#8377; " + amount;
    } else if (currentCurrency === "USD") {
        return "$ " + Math.round(amount / currencyRates.USDINR * 100) / 100;
    } else if (currentCurrency === "YEN") {
        return "&#165; " + Math.round(amount * currencyRates.USDJPY / currencyRates.USDINR * 100) / 100;
    }
}

function calculate() {
    var type = typeOfVehicle;
    document.getElementById("currentCurrency").innerHTML = currentCurrency;
    if (type == "Cycle") {
        var passtype = document.getElementById('pass_type').value;
        if (passtype == "daily") {
            document.getElementById('price').innerHTML = exchangeCurrency(5);
        } else if (passtype == "weekly") {
            document.getElementById('price').innerHTML = exchangeCurrency(100);
        } else if (passtype == "monthly") {
            document.getElementById('price').innerHTML = exchangeCurrency(500);
        }
    } else if (type == "Two wheeler") {
        var passtype = document.getElementById('pass_type').value;
        if (passtype == "daily") {
            document.getElementById('price').innerHTML = exchangeCurrency(10);
        } else if (passtype == "weekly") {
            document.getElementById('price').innerHTML = exchangeCurrency(200);
        } else if (passtype == "monthly") {
            document.getElementById('price').innerHTML = exchangeCurrency(1000);
        }
    } else if (type == "Four wheeler") {
        var passtype = document.getElementById('pass_type').value;
        if (passtype == "daily") {
            document.getElementById('price').innerHTML = exchangeCurrency(20);
        } else if (passtype == "weekly") {
            document.getElementById('price').innerHTML = exchangeCurrency(500);
        } else if (passtype == "monthly") {
            document.getElementById('price').innerHTML = exchangeCurrency(3500);
        }
    }
    return true;
}

function changeToInr() {
    currentCurrency = "INR";
    calculate();
}

function changeToUsd() {
    currentCurrency = "USD";
    calculate();
}

function changeToYen() {
    currentCurrency = "YEN";
    calculate();
}