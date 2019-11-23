$("body").append("<div id='toTop'>Back To Top</div>");
$(window).scroll(function() {
	if ($(this).scrollTop() > 200) {
		$('#toTop').fadeIn();
	} else {
		$('#toTop').fadeOut();
	}
});
$('#toTop').click(
		function() {
			$("html, body").bind(
					"scroll mousedown DOMMouseScroll mousewheel keyup",
					function() {
						$('html, body').stop();
					});
			$('html,body').animate({
				scrollTop : 0
			}, 1200);
			return false;
		});