$(document).ready(function(){
    $(".navlink").on('click', function(event) {
      if (this.hash !== "") {
        event.preventDefault();
        var hash = this.hash;
        $('html, body').animate({
          scrollTop: $(hash).offset().top-60
        }, 800, function(){});
      }
    });

    $('.registrationForm').hide();
    $('#pricing').hide();

    $(".registrationFormOption").click(function(event){
      event.preventDefault();
      $('.registrationForm').hide();
      $('#pricing').hide();
      let index = ($(this).index()-1)/2;
      console.log(index)
      if(index < 3){
        $('.registrationForm').eq(index).show(500);
        $('html, body').animate({
          scrollTop: $(".registrationForm").eq(index).offset().top-60
        }, 800, function(){});
      } else {
        $('#pricing').show(500);
        $('html, body').animate({
          scrollTop: $("#pricing").offset().top-60
        }, 800, function(){});
      }
    });
  });