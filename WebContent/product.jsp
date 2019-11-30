

<%@page import="model.Users"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Cart"%>
<%@page import="model.Story"%>
<%@page import="dao.StoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>product</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<script src="js/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport"
	content="width=device-width,height=device-height,user-scalable=yes, initial-scale=1, minimum-scale=1.0, maximum-scale=3.0">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link
	href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
            jQuery(document).ready(function ($)
            {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>
<!--slider-script-->
<script src="js/responsiveslides.min.js"></script>
<script>
            $(function ()
            {
                $("#slider1").responsiveSlides({
                    auto: true,
                    speed: 100,
                    namespace: "callbacks",
                    pager: true,
                });
            });
        </script>
<!--//slider-script-->
<script>$(document).ready(function (c) {
                $('.alert-close').on('click', function (c) {
                    $('.message').fadeOut('slow', function (c) {
                        $('.message').remove();
                    });
                });
            });
        </script>
<script>$(document).ready(function (c) {
                $('.alert-close1').on('click', function (c) {
                    $('.message1').fadeOut('slow', function (c) {
                        $('.message1').remove();
                    });
                });
            });
        </script>
</head>
<body style="background: url(bgImages/body-bg-tl.jpg) fixed">
	<jsp:include page="header.jsp"></jsp:include>

	<%
            StoryDAO storyDAO = new StoryDAO();
            String category_id = "";
            if (request.getParameter("category") != null) 
            {
                category_id = request.getParameter("category");
            }
            Cart cart = (Cart) session.getAttribute("cart");
            if(cart == null)
            {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            int pages = 0, firstResult = 0 ,maxResult = 0,total = 0;
            if(request.getParameter("pages") != null )
            {
                pages = Integer.parseInt(request.getParameter("pages")) ;
            }
            total = storyDAO.countStoryByCategory(Long.parseLong(category_id));
            if(total <= 4 )
            {
                firstResult = 1;
                maxResult = total;
            }
            else
            {
                firstResult = (pages)* 4 - 4;
                maxResult = 4;
            }
            ArrayList<Story> list = storyDAO.getListStoryByNav(Long.parseLong(category_id) , firstResult, maxResult)  ;
            String categoryName=storyDAO.getCategoryById(category_id);
        %>
	<div class="container" style="margin-top: 60px;">
		<div class="content"
			style="background: white; border-radius: 1em; padding: 1em;">
			<div class="content-top">
				<h3 class="future"
					style="padding-top: 0.5em; color: #6b9876; font-size: 30px"><%=categoryName%></h3>
				<%
                        for(Story p: list )  {
                    %>
				<div class="col-md-3 md-col" style="margin-top: 30px;">
					<div class="col-md" style="background: rgba(0, 0, 0, 0.4)">
						<div>
							<i class="fas fa-home" style="color: white;"><%=p.getCategoryName()%></i><span><i
								style="padding-left: 53px; float: right; color: white;"
								class="far fa-calendar-alt"><%=p.getCreateDate()%></i></span>
						</div>
						<div class="clearfix"></div>
						<a href="single.jsp?storyID=<%=p.getStoryId()%>"><img
							src="<%=p.getStoryImage()%>" style="height: 253px;"
							alt="<%=p.getStoryName()%>" /></a>
						<div class="top-content">
							<h5>
								<a style="color: white;"
									href="single.jsp?storyID=<%=p.getStoryId()%>"><%=p.getStoryName()%></a>
							</h5>
							<h5 style="padding: 0px; margin-top: -9px;">
								<i class="fas fa-compass" style="color: white;"><%=p.getStoryName()%></i>
							</h5>
							<h5 style="padding: 0px; margin-top: 4px;">
								<i class="fab fa-laravel"
									style="color: white; padding: 0px; margin-top: -9px;"><%=p.getStoryName()%>m<sup>2</sup></i>
							</h5>
							<%
                                        Users users = null;
                                        if (session.getAttribute("user") != null) {
                                            users = (Users) session.getAttribute("user");
                                        }
                                        if (users != null) {
                                    %>
							<div class="white">
								<%
                                            if (!cart.getCartItems().containsKey(p.getStoryId())) {
                                        %>
								<a href="CartServlet?command=plus&storyID=<%=p.getStoryId()%>"
									id="luuthongtin"
									class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">Lưu
									Thông Tin</a>
								<%
                                        } else {
                                        %>
								<a href="" style="cursor: unset; background: black;"
									id="luuthongtin"
									class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">Đã
									Lưu</a>
								<%
                                            }
                                        %>
								<p class="dollar">
									<span><%=p.getStoryName()%></span><span>Tỷ</span><span
										class="in-dollar">VNĐ</span>
								</p>
								<div class="clearfix"></div>
							</div>
							<%
                                        }
                                    %>
						</div>
					</div>
				</div>
				<%
                        }
                    %>
				<div class="clearfix"></div>
			</div>
		</div>
		<ul class="start" style="padding-top: 1em;">
			<% int i=1 ;%>
			<li><a
				href="product.jsp?category=<%=category_id%>&pages=<%=i%>"><i></i></a></li>
			<% for(i = 1;i<= (total/4)+1 ;i++){ %>
			<li class="arrow"><a
				href="product.jsp?category=<%=category_id%>&pages=<%=i%>"><%=i%></a></li>
			<% }%>
			<li><a
				href="product.jsp?category=<%=category_id%>&pages=<%=i=(total/4)+1%>"><i
					class="next"> </i></a></li>

		</ul>


	</div>
	</div>
	<!---->

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
