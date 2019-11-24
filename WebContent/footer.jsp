

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Footer</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style_web.css" rel="stylesheet" type="text/css"
	media="all" />
<meta name="viewport"
	content="width=device-width,height=device-height,user-scalable=yes, initial-scale=1, minimum-scale=1.0, maximum-scale=3.0">
<link
	href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900'
	rel='stylesheet' type='text/css'>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<script>
	$(function() {
		$("#slider1").responsiveSlides({
			auto : true,
			speed : 100,
			namespace : "callbacks",
			pager : true,
		});
	});
</script>
<script>
	$(document).ready(function(c) {
		$('.alert-close').on('click', function(c) {
			$('.message').fadeOut('slow', function(c) {
				$('.message').remove();
			});
		});
	});
</script>
<script>
	$(document).ready(function(c) {
		$('.alert-close1').on('click', function(c) {
			$('.message1').fadeOut('slow', function(c) {
				$('.message1').remove();
			});
		});
	});
</script>
</head>
<body>
	<div class="truyencv-footer" style="background: url(bgImages/footer-bg.jpg) fixed">
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="footer-block">
						<div class="footer-block-header">
							<h4>Giới thiệu</h4>
						</div>
						<div class="footer-block-content">
							<p>Truyencv là website đọc truyện convert online cập nhật
								liên tục và nhanh nhất các truyện tiên hiệp, kiếm hiệp, huyền ảo
								được các thành viên liên tục đóng góp rất nhiều truyện hay và
								nổi bật.</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<div class="footer-block">
						<div class="footer-block-header">
							<h4>Liên hệ quảng cáo</h4>
						</div>
						<div class="footer-block-content">
							<ul class="footer-block-list">
								<li><a href="mailto:vuongtn6996@gmail.com"> <span
										class="block-list-icon"><i
											class="truyencv-icon icon-email"></i></span> Email:
										vuongtn6996@gmail.com
								</a></li>
								<li><a "href="tel:0939060997"> <span
										class="block-list-icon"><i
											class="truyencv-icon icon-phone"></i></span> Phone: 0989989989
								</a></li>
								<li><a "href="skype:vuongtn6996@gmail.com"> <span
										class="block-list-icon"><i
											class="truyencv-icon icon-skype"></i></span> Skype: vuongtn
								</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$(document).ready(function() {
				$().UItoTop({
					easingType : 'easeOutQuart'
				});
			});
		</script>
		<a href="#" id="toTop"
			style="display: block; background: url(images/backtotop.png) no-repeat">
			<span id="toTopHover" style="opacity: 1;"> </span>
		</a>

	</div>
</body>
</html>
