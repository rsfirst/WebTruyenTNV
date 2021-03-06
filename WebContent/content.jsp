

<%@page import="dao.ChoThueDAO"%>
<%@page import="model.ChoThue"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.Item"%>
<%@page import="java.util.Map"%>
<%@page import="model.Users"%>
<%@page import="model.Cart"%>
<%@page import="dao.PostMuaDAO"%>
<%@page import="model.PostMua"%>
<%@page import="model.Story"%>
<%@page import="dao.StoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>content</title>
<script type="text/javascript" src="js/jquery.flexisel.js"></script>
<style>
.col-md:hover {
	border: 1px solid #00c6d7;
	box-shadow: 2px 2px 16px 0px violet;
}

ul.callbacks_tabs.callbacks1_tabs {
	left: 45%;
}

.col-md {
	transition: 1s all ease;
	perspective: 600px;
}

.col-md_img {
	overflow: hidden;
}

.col-md a img {
	transition: 2s all ease;
}

.col-md:hover {
	transform: rotate(5deg);
	box-shadow: 2px 2px 16px 0px violet !important;
}

.col-md:hover a img {
	transform: scale(1.2);
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		$("#luuthongtin").click(function() {

			$("#luuthongtin").html("Đã Lưu");
			$("#luuthongtin").css('cursor', 'unset');
		});
	});
</script>
</head>
<body>


	<!---->
	<%
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		StoryDAO storyDao = new StoryDAO();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
	%>
	<div class="container" style="margin-top: 60px;">
		<div class="content" style="background: white; border-radius: 1em">
			<div class="content-top">
				<h3 class="future"
					style="padding-top: 0.5em; color: #6b9876; font-size: 30px";>Truyện
					Top</h3>
				<div class="content-top-in" style="padding-top: 0px">
					<%
						request.setCharacterEncoding("UTF-8");
						response.setCharacterEncoding("UTF-8");
						for (Story p : storyDao.getListStory()) {
					%>
					<div class="col-md-3 md-col" style="margin-top: 30px">
						<div class="col-md"
							style="background: rgba(0, 0, 0, 0.4); box-shadow: 2px 2px 16px 0px black">
							<div>
								<i class="fas fa-book" style="color: white;"><%=p.getCategoryName()%></i><span><i
									style="float: right; color: white;" class="far fa-calendar-alt"><%=p.getCreateDate()%></i></span>
							</div>
							<div class="clearfix"></div>
							<div class="col-md_img">
								<a href="single.jsp?storyID=<%=p.getStoryId()%>"> <img
									src="<%=p.getStoryImage()%>" style="height: 253px;"
									alt="<%=p.getStoryName()%>" />
								</a>
							</div>
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
									<a
										href="CartServlet?command=plus&storyID=<%=p.getStoryId()%>"
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
		</div>
		<ul class="start" style="padding-top: 1em;">
			<li><a href="#"><i></i></a></li>
			<li><span>1</span></li>
			<li><a href="#"><i class="next"> </i></a></li>
		</ul>
	</div>

	<div class="container">
		<div class="content" style="background: white; border-radius: 1em">
			<div class="content-top">
				<h3 class="future"
					style="padding-top: 0.5em; color: #6b9876; font-size: 30px";>Truyện
					mới</h3>
				<div class="content-top-in" style="padding-top: 3px;">
					<%
						request.setCharacterEncoding("UTF-8");
						response.setCharacterEncoding("UTF-8");
						for (ChoThue c : ChoThueDAO.getListChoThueByChapNhan()) {
					%>
					<div class="col-md-3 md-col" style="margin-top: 30px;">
						<div class="col-md" style="background: rgba(0, 0, 0, 0.4)">
							<div>
								<i class="fas fa-home" style="color: white;"><%=c.getChothue_loainhadat()%></i><span><i
									style="padding-left: 53px; float: right; color: white;"
									class="far fa-calendar-alt"><%=c.getChothue_ngaydang()%></i></span>
							</div>
							<div class="clearfix"></div>
							<a href="singleChoThue.jsp?ChoThueID=<%=c.getChothue_id()%>"><img
								src="<%=c.getChothue_hinhanh()%>" style="height: 253px;"
								alt="<%=c.getChothue_tieude()%>" /></a>
							<div class="top-content">
								<h5>
									<a style="color: white;"
										href="single.jsp?ChoThueID=<%=c.getChothue_id()%>"><%=c.getChothue_tieude()%></a>
								</h5>
								<h5 style="padding: 0px; margin-top: -9px;">
									<i class="fas fa-compass" style="color: white;"><%=c.getChothue_diadiem()%></i>
								</h5>
								<h5 style="padding: 0px; margin-top: 4px;">
									<i class="fab fa-laravel"
										style="color: white; padding: 0px; margin-top: -9px;"><%=c.getChothue_dientich()%>m<sup>2</sup></i>
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
										if (!cart.getCartItems().containsKey(c.getChothue_id())) {
									%>
									<a href="#" id="luuthongtinchothue"
										class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">Lưu
										Thông Tin</a>
									<%
										} else {
									%>
									<a href="#" style="cursor: unset; background: black;"
										id="luuthongtin"
										class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">Đã
										Lưu</a>
									<%
										}
									%>
									<p class="dollar">
										<span><%=c.getChothue_gia()%></span><span>Tỷ</span><span
											class="in-dollar">VNĐ</span>
									</p>
									<div class="clearfix"></div>
								</div>
								<%
									}
								%>
								<script type="text/javascript">
									$(function() {
										$("#luuthongtinchothue")
												.click(
														function() {
															if (confirm("Chức năng Lưu ở mục Cho Thuê này tạm thời khóa")) {
																window.location
																		.reload(true);
															}
														});
									});
								</script>
							</div>
						</div>
					</div>
					<%
						}
					%>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<ul class="start" style="padding-top: 1em;">
			<li><a href="#"><i></i></a></li>
			<li><span>1</span></li>
			<li><a href="#"><i class="next"> </i></a></li>
		</ul>
	</div>


</body>
</html>
