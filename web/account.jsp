<%@ page import="logic.POJOS.Product" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2018/5/23
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
    <link href="css/bootstrap-3.1.1.min.css" rel='stylesheet' type='text/css' />
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <!--theme-style-->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!--//theme-style-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <link href='https://fonts.googleapis.com/css?family=Poiret+One' rel='stylesheet' type='text/css'>
    <!-- start menu -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/simpleCart.min.js"> </script>
    <!-- slide -->
    <script src="js/responsiveslides.min.js"></script>
    <script>
        $(function () {
            $("#slider").responsiveSlides({
                auto: true,
                speed: 500,
                namespace: "callbacks",
                pager: true,
            });
        });
    </script>
</head>
<%
    Date date = new Date();
    Product product = (Product)session.getAttribute("product");
    String orderForm_ID = date.getTime()+product.getProductID();
    String orderForm_ProductInformation = "Type: "+product.getProductType()+",Color: "+product.getProductColor()+",Size: "+product.getProductSize();
    String orderForm_ProductNum = product.getProductNum();
    Float total = Float.parseFloat(product.getProductUnitPrice())*Integer.parseInt(orderForm_ProductNum);
    String orderForm_Total = total.toString();
%>
<body>

<!--header-->
<div class="header">
    <div class="header-top">
        <div class="container">
            <div class="col-sm-4 logo animated wow fadeInLeft" data-wow-delay=".5s">
                <h1><a href="index.html">Young <span>Fashion</span></a></h1>
            </div>
            <div class="col-sm-4 world animated wow fadeInRight" data-wow-delay=".5s">
                <div class="cart box_1">

                </div>
            </div>
            <div class="col-sm-2 number animated wow fadeInRight" data-wow-delay=".5s">
                <span><i class="glyphicon glyphicon-phone"></i>085 596 234</span>
                <p>客服电话</p>
            </div>
        </div>
    </div>
</div>
<div class="account">
    <div class="container">
        <h2>Account Information</h2>
        <div class="account_grid">
            <div class="col-md-6 login-right">

                <form action="/updateOperation.form" method="post">

                    订单编号: <input type="text" name="orderForm_ID" value="<%=orderForm_ID%>" readonly="true"><br>
                    商品信息: <input type="text" name="orderForm_ProductInformation" value="<%=orderForm_ProductInformation%>" readonly="true"><br>
                    购买数量: <input type="text" name="orderForm_ProductNum" value="<%=orderForm_ProductNum%>" readonly="true"><br>
                    收货地址: <input type="text" name="orderForm_DeliveryAddress" ><br>
                    买家留言: <input type="text" name="orderForm_BuyerMessage" ><br>
                    订单总额: <input type="text" name="orderForm_Total" value="<%=orderForm_Total%>" readonly="true">
                    <div class="word-in">
                        <input type="submit" value="提交订单">
                    </div>

                </form>

            </div>

        </div>
    </div>
</div>

<!--footer-->

<div class="footer">
    <div class="footer-bottom">
        <div class="container">
            <div class="col-md-3 footer-bottom-cate animated wow fadeInLeft" data-wow-delay=".5s">
                <h6>Categories</h6>
                <ul>
                    <li><a href="">Shopping Online</a></li>
                    <li><a href="">Shopping Online</a></li>
                    <li><a href="">Shopping Online</a></li>
                    <li><a href="">Shopping Online</a></li>
                    <li><a href="">Shopping Online</a></li>

                </ul>
            </div>
            <div class="col-md-3 footer-bottom-cate animated wow fadeInLeft" data-wow-delay=".5s">
                <h6>Feature Projects</h6>
                <ul>
                    <li><a href="">Shopping Online</a></li>
                    <li><a href="">Shopping Online</a></li>
                    <li><a href="">Shopping Online</a></li>
                    <li><a href="">Shopping Online</a></li>
                    <li><a href="">Shopping Online</a></li>
                    <li><a href="">Shopping Online</a></li>
                </ul>
            </div>
            <div class="col-md-3 footer-bottom-cate animated wow fadeInRight" data-wow-delay=".5s">
                <h6>Top Brands</h6>
                <ul>
                    <li><a href="">Shopping Online</a></li>
                    <li><a href="">Shopping Online</a></li>
                    <li><a href="">Shopping Online</a></li>
                    <li><a href="">Shopping Online</a></li>
                    <li><a href="">Shopping Online</a></li>
                    <li><a href="">Shopping Online</a></li>

                </ul>
            </div>
            <div class="col-md-3 footer-bottom-cate cate-bottom animated wow fadeInRight" data-wow-delay=".5s">
                <h6>Our Address</h6>
                <ul>
                    <li><i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i>地址 : HarBin HeiDa <span>HeiLong</span></li>
                    <li><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i>邮箱 : <a href="https://mail.163.com/.com">@163.com</a></li>
                    <li><i class="glyphicon glyphicon-earphone" aria-hidden="true"></i>电话 : +1234 567 567</li>
                </ul>
            </div>
            <div class="clearfix"> </div>
            <p class="footer-class animated wow fadeInUp animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">Copyright &copy; 2018.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="MSS Home">MSS Home</a> - Collect from <a href="http://www.cssmoban.com/" title="MssHome" target="_blank">Mss Home</a></p>
        </div>
    </div>
</div>
<!--footer-->
</body>
</html>
