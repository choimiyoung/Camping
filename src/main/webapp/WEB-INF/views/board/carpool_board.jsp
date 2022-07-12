<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${ pageContext.request.contextPath }/resources/carpool_board.css" rel="stylesheet" type="text/css">

<script type="text/javascript">


function search() {
	
	var search = $("#search").val();
	var search_text = $("#searchText").val().trim();
	
	//전체검색이 아닌경우
	if(search != 'all' && search_text == ''){
		alert('검색어를 입력하세요!!');
		$("#searchText").val('');
		$("#searchText").focus();
		return;
	}
	
	location.href="list.do?search=" + search + "&search_text=" + encodeURIComponent(search_text);
	
	
	
}


</script>




</head>
<body>

<h3 id="title">Carpool</h3>
<div><a href="">사진리뷰만 보이게 하는 게시판으로 가는 링크</a></div><br>
<div class="top">
	<form method="post" name="search" action="">
		<table class="table_option">
			<tr>
				<td><select class="form-control" id="search" name="searchField" style="font-size:16px;">
						<option>전체</option>
						<option>제목</option>
						<option>내용</option>
						<option>작성자</option>
				</select></td>
				<td>
				  <input type="text" class="form-control" id="searchText"
					     placeholder="검색어 입력" name="searchText" maxlength="100" value="${ param.search_text }" >
				</td>
				<td>
				  <button type="submit" class="btn-search" value="검색" onclick="search();">검색</button>
				</td>
			</tr>

		</table>
	</form>
  <input class="btn" type="button" value="글쓰기"
		 onclick="location.href='../homepage/main.do'">
  
</div>
<table  class="table_list">
<colgroup>
<col width="60px">
<col width="*">
<col width="100px">
<col width="150px">
<col width="200px">
</colgroup>
<thead>
<tr>
  <th>번호</th>
  <th>제목</th>
  <th>조회수</th>
  <th>좋아요</th>
  <th>작성자</th>
  <th>작성일</th>
</tr>
</thead>

<tbody>
	<c:forEach var="vo" items="${ list }">
		<tr>
			<td>${ vo.carpool_idx }</td>
			<td class="subject"><a href="#">${ vo.carpool_title }</td>
			<td>${ vo.carpool_hit_count }</td>
			<td>${ vo.carpool_like_count }</td>
			<td>${ vo.mem_nickname }</td>
			<td>${ fn:substring(vo.carpool_regdate,0,10) }</td>
		</tr>
	</c:forEach>
</table>
<div class="page_wrap">
   <div class="page_nation">
      <a class="first" href="#"></a>
      <a class="prev" href="#"></a>
      <a href="#" class="active">1</a>
      <a href="#">2</a>
      <a href="#">3</a>
      <a href="#">4</a>
      <a href="#">5</a>
      <a href="#">6</a>
      <a href="#">7</a>
      <a href="#">8</a>
      <a href="#">9</a>
      <a href="#">10</a>
      <a class="next" href="#"></a>
      <a class="last" href="#"></a>
   </div>
	
</div>
</body>
</html>