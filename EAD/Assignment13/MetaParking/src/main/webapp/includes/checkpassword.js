var tryConfirmPassword = function(event) {
	const password = document.getElementById("password").value;
	const confirm_password = document.getElementById("confirm-password").value;
	var submit = document.getElementById("submit-btn");
	if(password && password!=="" && password===confirm_password){
		submit.disabled = false;
	} else {
		submit.disabled = true;
	}
}

const confirm_password = document.getElementById("confirm-password");
confirm_password.setAttribute('onkeyup', 'tryConfirmPassword(this)');