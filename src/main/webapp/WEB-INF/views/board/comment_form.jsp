<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div id="comment_write">
				<div id="comment_write_box">
					<textarea id="review_reply_content" placeholder="����� �ۼ��ϼ���"></textarea>
				</div>
				<div id="comment_write_pic">
					<img src="${pageContext.request.contextPath}/resources/images/unsplash_people/people2.jpg" id="comment_profile">
				</div>
				<input type="button" value="��� �ۼ�" onclick="review_reply_insert();">
</div>
</body>
</html>