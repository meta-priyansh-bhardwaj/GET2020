var classVal;
var pass;
var pass_value;
var name;

function onLoadLabel() {
   classVal = 0;
   document.getElementsByClassName("*label")[0].innerHTML = document.getElementsByClassName("Labels")[classVal].innerHTML;
   document.getElementById("val_error_message").style.color = "red";
}


function next() {

   if (validate()) {

      document.getElementById("input").value = "";
      document.getElementById('val_error_message').innerHTML = "";
      classVal++;

      if (classVal < 11) {
         if (classVal == 1) {
            document.getElementById("genderLabel").innerHTML = "hi " + name + " can you please specify your gender?";
            document.getElementsByClassName("*label")[0].innerHTML = document.getElementsByClassName("Labels")[classVal].innerHTML;
            document.getElementById("*div").style.display = "none";

         }
         else if (classVal == 4) {
            document.getElementById("*div").style.display = "block";
            document.getElementsByClassName("*label")[0].innerHTML = document.getElementsByClassName("Labels")[classVal].innerHTML;
            document.getElementById("input").type = "password";
            document.getElementById("input").onkeyup = passStrength;
         }
         else if (classVal == 5) {
            document.getElementById("*div").style.display = "block";
            document.getElementsByClassName("*label")[0].innerHTML = document.getElementsByClassName("Labels")[classVal].innerHTML;

            document.getElementById("input").onkeyup = match_pass;
         }
         else if (classVal == 6) {
            document.getElementById("*div").style.display = "block";
            document.getElementsByClassName("*label")[0].innerHTML = document.getElementsByClassName("Labels")[classVal].innerHTML;
            document.body.style.backgroundColor = "#d9f2e6";
         }
         else if (classVal == 7) {
            document.getElementsByClassName("*label")[0].innerHTML = document.getElementsByClassName("Labels")[classVal].innerHTML;
            document.getElementById("*div").style.display = "none";
         }
         else if (classVal == 9) {
            document.getElementsByClassName("*label")[0].innerHTML = document.getElementsByClassName("Labels")[classVal].innerHTML;
            document.getElementById("*div").style.display = "none";
         }
         else if (classVal == 10) {

            document.getElementsByClassName("*label")[0].innerHTML = `<div style="text-align: center;">Your pass cost for ${pass_value}</div>`;
            document.getElementById("next_button").style.display = "none";
            document.getElementById("*div").style.display = "none";
            document.body.style.backgroundColor = "#ffe6cc";



         }
         else {
            document.getElementById("*div").style.display = "block";
            document.getElementsByClassName("*label")[0].innerHTML = document.getElementsByClassName("Labels")[classVal].innerHTML;
         }
      }
      else {
         alert("successfully registerd");
         classVal = 0;
         document.getElementsByClassName("*label")[0].innerHTML = document.getElementsByClassName("Labels")[classVal].innerHTML;

      }
   }

}
function validate() {

   var val = document.getElementById("input").value;


   if (val.length == 0 && classVal != 1 && classVal != 7 && classVal != 9) {
      document.getElementById('val_error_message').innerHTML = "Input field is empty!!";

      return false;
   }
   else {

      if (classVal == "0") {
         var first_name_letters = /^([A-Za-z]+[ ]?|[a-z]+)+$/;

         if (!val.match(first_name_letters)) {
            document.getElementById("val_error_message").innerHTML = "Name should not contain any numbers or special character";

            return false;
         }
         if (val.length < 2) {
            document.getElementById("val_error_message").innerHTML = "Name must contain minimum two character";
            return false;
         }
         name = val;
         return true;
      }
      else if (classVal == "1") {

         return true;
      }
      else if (classVal == "2") {

         var email_regx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
         if (!val.match(email_regx)) {
            document.getElementById('val_error_message').innerHTML = "Unable to recognize email pattern";
            document.getElementById('val_error_message').style.color = "red";
            return false;
         }
         document.getElementById("input").maxLength = 10;
         return true;
      }
      else if (classVal == "3") {
         var contact_regx = /^[0-9]+$/;

         if (!val.match(contact_regx)) {

            document.getElementById('val_error_message').innerHTML = "Please Enter Digits";
            return false;
         }
         else if (val.length < 10) {
            document.getElementById('val_error_message').innerHTML = "Please Enter 10 Digit Contact Number";
            return false;
         }
         document.getElementById("input").maxLength = 15;
         return true;
      }
      else if (classVal == "4") {
         
         if (passStrength()) {
            return true;
         }

         else {
            alert("Please Enter Correct Password Pattern.");
            return false;
         }
      }
      else if (classVal == "5") {
         if (!match_pass()) {
            document.getElementById('val_error_message').innerHTML = "Sorry Password Does not match!!!";
            return false;
         }
         else {

            alert("User Successfully Registerd!");
            document.getElementById("input").type = "text";
            document.getElementById("input").style.borderColor = "";
            return true;
         }


      }
      else if (classVal == "6") {
         var first_name_letters = /^([A-Za-z]+[ ]?|[a-z]+)+$/;

         if (!val.match(first_name_letters)) {
            document.getElementById("val_error_message").innerHTML = "Name should not contain any numbers or special character";

            return false;
         }
         if (val.length < 2) {
            document.getElementById("val_error_message").innerHTML = "Name must contain minimum two character";
            return false;
         }

         return true;
      }
      else if (classVal == "7") {
         if (passPricedetails()) {
            document.getElementById("input").maxLength = 4;
            return true;
         }
         return false;

      }

      else if (classVal == "8") {

         var vehicle_Num_regx = /^[0-9]+$/;
         

         if (!val.match(vehicle_Num_regx)) {

            document.getElementById('val_error_message').innerHTML = "Please Enter digits";
            return false;
         }
         else if (val.length < 4) {
            document.getElementById('val_error_message').innerHTML = "Please Enter last 4 digits";
            return false;
         }

         return true;
      }

      else if (classVal == "9") {
         pass_value = displayPassPrice();
         if (pass_value != "null") {
            return true;

         }
         return false;



      }
      else if (classVal == "10") {
         return true;
      }

   }
}
function passStrength() {
   var pwd = document.getElementById("input").value;
   if (pwd.length < 6) {
      document.getElementById('val_error_message').innerHTML = "Weak password must be greater than 6 ";
      document.getElementById("input").style.borderColor = "red";
      return false;

   }
   else if (pwd.length >= 6) {
      var pwd_regx = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{6,})/;

      if (pwd.match(pwd_regx)) {
         document.getElementById("input").style.borderColor = "#00ff7f";
         document.getElementById('val_error_message').innerHTML = "Password accepted go ahead!";
         pass = pwd;
         return true;
      }
      else {
         document.getElementById("input").style.borderColor = "#FFA500";
         document.getElementById('val_error_message').innerHTML = "At least One capital letter and One digit and One special charecter should be present";
         return false;
      }


   }
   return false;
}
function match_pass() {
   confirm_pass = document.getElementById("input").value;
   if (pass == confirm_pass) {
      document.getElementById("input").style.borderColor = "#00ff7f";
      return true;
   }
   else {
      document.getElementById("input").style.borderColor = "red";
      return false;
   }

}
function passPricedetails() {
   var dailyPassPrice, monthlyPassPrice, yearlyPassPrice;
   if (document.getElementById("vehicleType1").checked) {
      dailyPassPrice = 5;
      monthlyPassPrice = 100;
      yearlyPassPrice = 500;
      document.getElementById("daily").value = dailyPassPrice;
      document.getElementById("monthly").value = monthlyPassPrice;
      document.getElementById("yearly").value = yearlyPassPrice;
      return true;

   }
   else if (document.getElementById("vehicleType2").checked) {
      dailyPassPrice = 10;
      monthlyPassPrice = 200;
      yearlyPassPrice = 1000;
      document.getElementById("daily").value = dailyPassPrice;
      document.getElementById("monthly").value = monthlyPassPrice;
      document.getElementById("yearly").value = yearlyPassPrice;
      return true;

   }
   else if (document.getElementById("vehicleType3").checked) {
      dailyPassPrice = 20;
      monthlyPassPrice = 500;
      yearlyPassPrice = 3500;
      document.getElementById("daily").value = dailyPassPrice;
      document.getElementById("monthly").value = monthlyPassPrice;
      document.getElementById("yearly").value = yearlyPassPrice;
      return true;

   }
   return false;

}
function displayPassPrice() {
   if (document.getElementById("daily").checked) {
      return "Daily is: Rs." + document.getElementById("daily").value;
   }
   else if (document.getElementById("monthly").checked) {
      return "Monthly is: Rs." + document.getElementById("monthly").value;
   }
   else if (document.getElementById("yearly").checked) {
      return "Yearly is: Rs." + document.getElementById("yearly").value;
   }
   else {
      return "null";
   }
}