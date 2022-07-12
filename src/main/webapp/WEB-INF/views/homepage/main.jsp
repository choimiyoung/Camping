<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



    
<!DOCTYPE html>
<html>
<head>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/resources/main.css">

	
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">

#review2{
	height	:	1200px;
}
/* #carpool_market{
	height	:	1200px;
} */

</style>


</head>




<body style="margin: 0">
<%@include file="nav.jsp" %>
	<div class="wrap_1">
		
		<div class="intro_bg">
			<div class="intro_text">
				<h1> CAMP US 🏕 </h1>
			</div>
			<div class= "search_area">
			  <form>
				<input type="search" placeholder="Search">
				<span><i class="bi-search"></i></span>
			  </form>
			<ul class="hashtag">
				<li><a href="#">#캠핑</a></li>
				<li><a href="#">#카라반</a></li>
				<li><a href="#">#캠핑추천</a></li>
				<li><a href="#">#카풀</a></li>
				<li><a href="#">#같이갈사람</a></li>
			</ul>
			</div>
		</div>
	</div>
	
<div class="slidebox">
	<input type="radio" name="slide" id="slide1" checked="checked">
	<input type="radio" name="slide" id="slide2" >
	<input type="radio" name="slide" id="slide3">
	<input type="radio" name="slide" id="slide4">
	<ul class="slidelist">
	  <li class="slideitem">
		<div>
			<label for="slide4" class="left"></label>
			<label for="slide2" class="right"></label>
			<a><img src="${ pageContext.request.contextPath }/resources/images/slideimg01.jpg"></a>
			
		</div>
	  </li>
	  <li class="slideitem">
		<div>
			<label for="slide1" class="left"></label>
			<label for="slide3" class="right"></label>
			<a><img src="${ pageContext.request.contextPath }/resources/images/slideimg02.jpg"></a>
		</div>
	  </li>
	  <li class="slideitem">
		<div>
			<label for="slide2" class="left"></label>
			<label for="slide4" class="right"></label>
			<a><img src="${ pageContext.request.contextPath }/resources/images/slideimg03.jpg"></a>
		</div>
	  </li>
	  <li class="slideitem">
		<div>
			<label for="slide3" class="left"></label>
			<label for="slide1" class="right"></label>
			<a><img src="${ pageContext.request.contextPath }/resources/images/slideimg04.jpg"></a>
		</div>
	  </li>
	</ul>
</div>

<div id="review2">
	<%@include file="review2.jsp" %>
</div>

<div id="carpool_market">
	<%@include file="carpool_market.jsp" %>
</div>

<div id="footer">
	<%@include file ="footer.jsp" %>
</div>

<div>
	<%@include file ="../board/carpool_board.jsp" %>
</div>

</body>
</html>