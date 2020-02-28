let popHtml = "<img width='170px' class='img-fluid img-thumbnail rounded-circle' src='../pictures/blank.png' alt='Profile Picture' />";
popHtml += "<br /><input type='file' /><input type='text' />";

const profilePictureId = document.getElementById('profile-picture');
let profilePictureId2 = "../pictures/blank.png";
if(profilePicture && profilePicture!==""){
	if(profilePictureId){
		profilePictureId.src = profilePicture;
	}
	profilePictureId2 = profilePicture;
}

$(function () {
  $('#profile-picture').popover({
	  content:
		  `<img width='170px' class='img-fluid' src='${profilePictureId2}' id='profile-picture-2' alt='Profile Picture' />
		  <br />
		  <form method="post" action="/upload-profile-picture" enctype="multipart/form-data">
		  	<div class="form-group font-weight-bold">
		  		<label for="picture">Upload Here:</label><br />
		  		<input type="file" name="picture" id="picture" accept="image/*" /><br />
		  		<button class="btn btn-primary btn-sm mt-2">Submit</button>
		  	</div>
		  </form>`,
	  html: true,
	  sanitize: false
  })
})