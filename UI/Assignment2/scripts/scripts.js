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
  });