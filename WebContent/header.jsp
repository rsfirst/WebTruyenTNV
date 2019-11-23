<%@page import="model.Item"%>
<%@page import="java.util.Map"%>
<%@page import="model.Cart"%>
<%@page import="dao.PostMuaDAO"%>
<%@page import="model.PostMua"%>
<%@page import="model.Users"%>
<%@page import="model.Category"%>
<%@page import="dao.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <meta name="viewport" content="width=device-width,height=device-height,user-scalable=yes, initial-scale=1, minimum-scale=1.0, maximum-scale=3.0" >
        <link href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>

        <script>(function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id))
                    return;
                js = d.createElement(s);
                js.id = id;
                js.src = 'https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v3.2&appId=271903206793496&autoLogAppEvents=1';
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));
        </script>
        <script>
            window.fbAsyncInit = function () {
                FB.init({
                    appId: '{your-app-id}',
                    cookie: true,
                    xfbml: true,
                    version: '{api-version}'
                });

                FB.AppEvents.logPageView();

            };

            (function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id)) {
                    return;
                }
                js = d.createElement(s);
                js.id = id;
                js.src = "https://connect.facebook.net/en_US/sdk.js";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));
        </script>
        
        <script type="text/javascript">

            jQuery(document).ready(function ($)
            {
                $(".scroll").click(function (event)
                {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>
        <script>
            $(function ()
            {
                $("#slider1").responsiveSlides
                        ({
                            auto: true,
                            speed: 100,
                            namespace: "callbacks",
                            pager: true,
                        });
            });
        </script>
        <script>
            $(document).ready(function (c)
            {
                $('.alert-close').on('click', function (c)
                {
                    $('.message').fadeOut('slow', function (c)
                    {
                        $('.message').remove();
                    });
                });
            });
        </script>
        <script>
            $(document).ready(function (c)
            {
                $('.alert-close1').on('click', function (c)
                {
                    $('.message1').fadeOut('slow', function (c)
                    {
                        $('.message1').remove();
                    });
                });
            });
        </script>
        <style>
            #menu
            {
                color:white;
            }
            #s:hover
            {
                border : 1px solid #00c6d7;
                box-shadow: 0 10px 6px -6px #777;
                color: #00c6d7;
                background:#00c6d7;
            }
        </style>
    </head>
    <body >
        <%
            CategoryDAO categoryDAO = new CategoryDAO();
            Users users = null;
            if (session.getAttribute("user") != null) {
                users = (Users) session.getAttribute("user");
            }
            Cart cart = (Cart) session.getAttribute("cart");

            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
        %>

        <div class="header">
            <div class="header-top" style="background: rgba(0,0,0,0.4);">
                <div class="container">	
                    <div class="header-top-in">			
                        <div class="logo">
                            <a href="index.jsp"><i class="fas fa-home"></i></a>
                        </div>
                        <div class="header-in">
                            <ul class="icon1 sub-icon1">
                                <%
                                    if (users != null) {
                                %>
                                <li ><a href="index.jsp">Xin Chào,Bạn <%=users.getHovaten()%></a> </li>

                                <li ><a href="#">Tài Khoản Của Tôi</a></li>
                                <li  > <a href="ThongTinNhaDaLuu.jsp" style="    border-top: 3px solid black;border-left:3px solid black;border-bottom: 3px solid black;height: 43px;">Thông Tin Nhà Đã Lưu</a></li>
                                <li ><div class="cart" style="border-right: 3px solid black;border-top:3px solid black;border-bottom: 3px solid black;">
                                        <a href="#" class="cart-in"></a>
                                        <span><% cart.countItem(); %></span>
                                    </div>
                                    <ul class="sub-icon1 list" style="width:319px;top:46px;background:rgba(0,0,0,0.4)">
                                        <h3 style="color:#fdfaf9;border-bottom: 2px solid white;">Thông Tin Nhà Đã Lưu</h3>
                                        <div class="shopping_cart">
                                            <%
                                                for (Map.Entry<Long, Item> list : cart.getCartItems().entrySet()) {
                                            %>
                                            <div class="cart_box">
                                                <div class="message">
                                                    <div class="alert-close"> </div> 
                                                    <div class="list_img" style="width: 98px;height:81px;"><img style="width:100%;height:100%;" src="<%=list.getValue().getProduct().getProductImage()%>" class="img-responsive" alt=""></div>
                                                    <div class="list_desc"><h4><a href="single.jsp?productID=<%=list.getValue().getProduct().getProductID()%>" style="border-bottom: 2px solid white"><label style="color:white"><%=list.getValue().getProduct().getProductName()%></label></a></h4>
                                                    </div>
                                                    <div class="list_desc"><h4><a style="color:red;" href="CartServlet?command=remove&productID=<%=list.getValue().getProduct().getProductID()%>"><label style="color:white;cursor:pointer">Xóa</label></a></h4></div>
                                                    <div class="clearfix"></div>
                                                </div>
                                            </div>
                                            <%
                                                }
                                            %>
                                        </div>
                                        <div class="login_buttons">
                                            <%--<div class="check_button"><a href="#"></a></div> --%>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="clearfix"></div>
                                    </ul>
                                </li>
                                <% }%>
                                <li><a href="PostBan.jsp">Đăng Tin Bán</a></li>
                                <li><a href="chothue.jsp">Đăng Tin Thuê</a></li>

                                <% if (users != null) { %><li><a href="DangXuat">Thoát Tài Khoản</a></li><% }%>
                                <ul class="sub-icon1 list">
                                    <div class="clearfix"></div>
                                    </div>
                                    </div>
                                    </div>
                                    </div>
                                    </div>
                                    <div class="clearfix"></div>
                                </ul>
                                </li>
                            </ul>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
            </div>
            <div class="header-bottom">
                <div class="container">
                    <div class="h_menu4">
                        <a  class="toggleMenu" href="#" >Menu</a>
                        <ul class="nav">
                            <li id="s" class="active" style="background:rgba(0,0,0,0.4)" ><a href="index.jsp" id="menu" ><i> </i>Home</a></li>
                            <li id="s" class="active" style="background:rgba(0,0,0,0.4)" ><a id="menu" href="#" >NHÀ ĐẤT BÁN</a>
                                <ul class="drop" style="background:rgba(0,0,0,0.4);">
                                    <%
                                        for (Category c : categoryDAO.getListCategory()) {
                                    %>
                                    <li id="s" style="background:rgba(0,0,0,0.4);"><a id="menu" href="product.jsp?category=<%=c.getCategoryID()%>&pages=1"><%=c.getCategoryName()%></a></li>
                                        <%
                                            }
                                        %>            
                                </ul>
                            </li> 						
                            <li id="s" style="background:rgba(0,0,0,0.4);color:white;"><a id="menu" href="#"  >Nhà Đất Cho Thuê</a>
                                <ul class="drop" style="background:rgba(0,0,0,0.4);">
                                    <%
                                        for (Category c : categoryDAO.getListCategoryChoThue()) {
                                    %>
                                    <li id="s" style="background:rgba(0,0,0,0.4);"><a id="menu" href="product_chothue.jsp?category=<%=c.getCategoryID()%>"><%=c.getCategoryName()%></a></li>
                                        <%
                                            }
                                        %>            
                                </ul>
                            </li> 						  				 
                            <li id="s" class="active" style="background:rgba(0,0,0,0.4)" ><a id="menu" href="#" >Tin Tức</a></li>
                            <li id="s" style="background:rgba(0,0,0,0.4);color:white;"><a id="menu" href="xaydung_kientruc.jsp"  >Xây Dựng Kiến Trúc </a></li>
                            <li id="s" class="active" style="background:rgba(0,0,0,0.4)" ><a id="menu" href="noi_ngoaithat.jsp" >Nội-Ngoại Thất</a></li>
                            <li id="s" style="background:rgba(0,0,0,0.4);color:white;"><a id="menu" href="phongthuy.jsp" >Phong Thủy</a></li>
                            <li id="s" class="active" style="background:rgba(0,0,0,0.4)" ><a  id="menu" href="lienhe.jsp">Liên Hệ</a></li>
                        </ul>
                        <script type="text/javascript" src="js/nav.js"></script>
                    </div>
                </div>
            </div>
            <div class="header-bottom-in" style="background: rgba(0,0,0,0.4);">
                <div class="container">
                    <%
                        if (users == null) {
                    %>
                    <div class="header-bottom-on">
                        <p class="wel" style="color:#white;" ><span style="color:white;">Xin Chào,Bạn Nên Đăng Nhập Để Hiển Thị Chức Năng <i class="fas fa-sign-in-alt"></i></span><a href="login.jsp" style="color: #white;"><span style="color:aqua;">Đăng Nhập</span></a><span style="color:white;"> Hoặc </span><i class="fas fa-sign-in-alt"></i><a href="register.jsp" style="color: #white;"><span style="color:aqua;">Tạo Tài Khoản Mới.</span></a></p>

                        <div class="header-can">
                            <ul class="social-in">
                                <li><a href="#"><i> </i></a></li>
                                <li><a href="#"><i class="facebook"> </i></a></li>
                                <li><a href="#"><i class="twitter"></i></a></li>					
                                <li><a href="#"><i class="skype"> </i></a></li>
                            </ul>
                            <%
                                }
                            %>
                            <div class="search">
                                <form action="timkiem.jsp?page=1" method="get">
                                    <input type="text" value="Tìm Kiếm" name="tim" onfocus="this.value = '';" onblur="if (this.value == '')
                                            {
                                                this.value = 'Tìm Kiếm';
                                            }" >
                                    <input type="submit" value="">
                                </form>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="header-bottom-on">
                        <% String err = (String) request.getAttribute("dangbaiban");
                            if (err != null) {
                        %>
                        <p class="on" style="margin:6px auto;margin-left:450px;background:url(images/back1.png) no-repeat;" ><%out.print(err); %></p>
                        <div class="clearfix"></div>
                        <%
                            }
                        %>

                        <% String chothue = (String) request.getAttribute("chothue");
                            if (chothue != null) {
                        %>
                        <p class="on" style="margin:6px auto;margin-left:450px;background:rgba(0,0,0,0);" ><i class="fas fa-male" style="color:white;"></i><%out.print(chothue); %></p>
                        <div class="clearfix"></div>
                        <%
                            }
                        %>
                        <style>
                            @-webkit-keyframes my {
                                0% { color: red;  } 
                                50% { color: white;  }
                                100% { color: red;  }  
                            }
                            @-moz-keyframes my { 
                                0% { color: red;  } 
                                50% { color: white;  }
                                100% { color: red;  }  
                            }
                            @-o-keyframes my { 
                                0% { color: red;  } 
                                50% { color: white;  }
                                100% { color: red;  }  
                            }
                            @keyframes my { 
                                0% { color: red;  } 
                                50% { color: white;  }
                                100% { color: red;  } 
                            } 
                            .on
                            {
                                -webkit-animation: my 1000ms infinite;
                                -moz-animation: my 1000ms infinite; 
                                -o-animation: my 1000ms infinite; 
                                animation: my 1000ms infinite;
                            }

                        </style>
                    </div>    
                </div>
            </div>
        </div>
    </body>
</html>
