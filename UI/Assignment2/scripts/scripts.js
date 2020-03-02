
$(document).ready(function(){
    $(".navlink").on('click', function(event) {
      if (this.hash !== "") {
        event.preventDefault();
        var hash = this.hash;

        if($(hash).is(':hidden')){
          $('.registrationForm').hide();
          $('#pricing').hide();
          $(hash).show(500);
        }

        $('html, body').animate({
          scrollTop: $(hash).offset().top-60
        }, 800, function(){});
      }
    });

    $('.registrationForm').hide();
    $('#pricing').hide();

    $(".registrationFormOption").click(function(event){
      event.preventDefault();
      
      let index = ($(this).index()-1)/2;
      if(index < 3){
        if($('.registrationForm').eq(index).is(':hidden')){
          $('.registrationForm').hide();
          $('#pricing').hide();

          $('.registrationForm').eq(index).show(500);
          $('html, body').animate({
            scrollTop: $(".registrationForm").eq(index).offset().top-60
          }, 800, function(){});
        }
      } else {
        if($('#pricing').is(':hidden')){
          $('.registrationForm').hide();
          $('#pricing').hide();

          $('#pricing').show(500);
          $('html, body').animate({
            scrollTop: $("#pricing").offset().top-60
          }, 800, function(){});
        }
      }
    });
  });