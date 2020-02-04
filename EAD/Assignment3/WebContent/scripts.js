function validateStudentForm() {
    var valid = true;
    var regex_name=/^[A-Z,a-z ,.'-]+$/;
    var regex_email=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    
    if ((document.getElementById('firstName').value) == "") {
        document.getElementById('firstname_error').innerHTML = "Enter Name";
        valid = false;
    } else if ((document.getElementById('firstName').value).length < 2) {
        document.getElementById('firstname_error').innerHTML = "Name must be contain atleast two charcter";
        valid = false;
    } else if ((regex_name.test(document.getElementById('firstName').value)) == false) {
        document.getElementById('firstname_error').innerHTML = "Name does not contain any character";
        valid = false;
    } else {
        document.getElementById('firstname_error').innerHTML = "";
    }
   
    if ((document.getElementById('lastName').value) == "") {
        document.getElementById('lastname_error').innerHTML = "Enter Last Name";
        valid = false;
    } else if ((document.getElementById('lastName').value).length < 2) {
        document.getElementById('lastname_error').innerHTML = "Name must be contain atleast two charcter";
        valid = false;  
    } else if ((regex_name.test(document.getElementById('lastName').value)) == false) {
        document.getElementById('lastname_error').innerHTML = "Name does not contain any character";
        valid = false;
    } else {
        document.getElementById('lastname_error').innerHTML = "";
    }

    if ((document.getElementById('fatherName').value) == "") {
        document.getElementById('fathername_error').innerHTML = "Enter Father Name";
        valid = false;
    } else if ((document.getElementById('fatherName').value).length < 2) {
        document.getElementById('fathername_error').innerHTML = "Name must be contain atleast two charcter";
        valid = false;
    } else if ((regex_name.test(document.getElementById('fatherName').value)) == false) {
        document.getElementById('fathername_error').innerHTML = "Name does not contain any character";
        valid = false;
    } else {
        document.getElementById('fathername_error').innerHTML = "";
    }
   
    if (document.getElementById('email_id').value == "") {
        document.getElementById('email_error').innerHTML = "Enter  Email";
        valid = false;
    } else if (regex_email.test(document.getElementById('email_id').value)==false ){
        document.getElementById('email_error').innerHTML = "Invaild email";
        valid = false;
    }
      else {
        document.getElementById('email_error').innerHTML = "";
    }

    if(document.getElementById('age').value==""){
        document.getElementById('age_error').innerHTML = "Enter Age";
        valid = false;
    } else if(Number(document.getElementById('age').value)<=0 || Number(document.getElementById('age').value)>100) {
        document.getElementById('age_error').innerHTML ="Invalid age";
        valid = false;
    } else {
        document.getElementById('age_error').innerHTML = "";
    }

    if(document.getElementById('class').value==""){
        document.getElementById('class_error').innerHTML = "Enter Class";
        valid = false;
    } else if(document.getElementById('class').value<=0 || document.getElementById('class').value>12) {
        document.getElementById('class_error').innerHTML ="Invalid Class";
        valid = false;
    } else {
        document.getElementById('class_error').innerHTML = "";
    }
    return valid;
 }
function  addStudent(){
     
        document.getElementById("display").style.display = "none";
        document.getElementById("addStudent").style.display = "block";
}
function Showdetail(){
    window.location = "/EAD-3/list";
}
function searchStudent(){
   document.getElementById("display").style.display = "none";
   document.getElementById("searchStudent").style.display = "block";
}

function search() {
    var valid = true;
    var regex_name=/^[A-Z,a-z ,.'-]+$/;
    var regex_email=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

    if ((document.getElementById('firstname').value) == "") {
        document.getElementById('firstname_error').innerHTML = "Enter Name";
        valid = false;
    } else if ((document.getElementById('firstname').value).length < 2) {
        document.getElementById('firstname_error').innerHTML = "Name must be contain atleast two charcter";
        valid = false;
    } else if ((regex_name.test(document.getElementById('firstname').value)) == false) {
        document.getElementById('firstname_error').innerHTML = "Name does not contain any character";
        valid = false;
    } else {
        document.getElementById('firstname_error').innerHTML = "";
    }
   
    if ((document.getElementById('lastname').value) == "") {
        document.getElementById('lastname_error').innerHTML = "Enter Last Name";
        valid = false;
    } else if ((document.getElementById('lastname').value).length < 2) {
        document.getElementById('lastname_error').innerHTML = "Name must be contain atleast two charcter";
        valid = false;  
    } else if ((regex_name.test(document.getElementById('lastname').value)) == false) {
        document.getElementById('lastname_error').innerHTML = "Name does not contain any character";
        valid = false;
    } else {
        document.getElementById('lastname_error').innerHTML = "";
    }
}
