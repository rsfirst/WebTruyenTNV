

<%@page import="model.Users"%>
<%@page import="model.Cart"%>
<%@page import="model.Product"%>
<%@page import="dao.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thông Tin Sản Phẩm</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<script src="js/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style_web.css" rel="stylesheet" type="text/css"
	media="all" />
<meta name="viewport"
	content="width=device-width,height=device-height,user-scalable=yes, initial-scale=1, minimum-scale=1.0, maximum-scale=3.0">
<script type="application/x-javascript">
	
	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 








</script>
<link
	href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" />
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
<!--slider-script-->
<script src="js/responsiveslides.min.js"></script>
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
<!--//slider-script-->
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
<style>
.a1 {
	width: 100%;
	height: auto;
	margin-bottom: 50px;
}

.a1 .a2 {
	width: 80%;
	height: auto;
	margin: 0 auto;
}
</style>
</head>
<body
	style="background: #2E363F">
	<%
		ProductDAO p = new ProductDAO();
		Product p2 = new Product();
		String productID2 = "";
		if (request.getParameter("productID") != null) {
			productID2 = request.getParameter("productID");
			p2 = ProductDAO.getProduct(Long.parseLong(productID2));
		}
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="a1">
		<div class="a2">
			<div class="tab-content" style="color: #333">
				<p
					style="background: rgba(0, 0, 0, 0.4); color: white; font-size: 25px; padding-left: 486px; padding-top: 10px; padding-bottom: 10px;">Mô
					tả chi tiết</p>
				<div class="tab-pane fade in active" style="background: white;">
					<div class="row">
						<div class="col-sm-12 col-md-8 col-lg-9">
							<div class="brief" style="display: block; padding: 2em">
								<%=p2.getProductDescription()%>
							</div>
						</div>
					</div>
				</div>

				<div class="clearfix"></div>

			</div>		
			<div class="clearfix"></div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
