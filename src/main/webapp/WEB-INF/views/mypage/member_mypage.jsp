<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

   #header{
      
      width   :   1700px;
      height   :   100px;
      border   :   1px solid red;
      margin   :   auto;
   }
   
   #content{
      width   :   1700px;
      height   :   1000px;
      border   :   1px solid blue; 
      margin   :   auto;
      
   }
   
   #footer{
   
      width   :   1700px;
      height   :   150px;
      border   :   1px solid green; 
      margin   :   auto;
   
   }

#mem_profile{

	width: 300px;
	height: 300px;
	/* display: inline-block; */
	margin-left: 150px;
	margin-top: 170px;
	border-radius: 70%;
	overflow: hidden;
	float: left;
	
}

#mem_profile>img{

	width: 100%;
	height:100%;
	
	display: inline-block;
	object-fit: cover;
	float: left;
}

.table_mypage{
	border: 1px solid red;
	width: 50%;
	height: 360px;
	
	
}
.mypage_form{
		width: 250px;
		border: none;
	    border-radius: 10px 10px 10px 10px;
	    box-shadow: 1px 1px 1px 1px #D9D9D9 ;
		height: 30px;



}
.mypage_form_re{
		width: 250px;
		border: none;
	    border-radius: 10px 10px 10px 10px;
	
		height: 30px;



}

#member_form{
	margin-top:140px;
	margin-left:400px;
	text-align:left;
  	width: 50%;
  /* height: 500px; */
  display: inline-block;
  
    float: left;  

 
}

#mem_profile_text{

   
	float: left;
	margin-left: 180px;

 	text-align: center;
	border:  1px solid red; 
  
	/*   display: inline-block; */
	  
}

.button{

	margin-top: 210px;
	text-align: center;
	border: none;
	margin-left: 50px;
	
	/* border-bottom: 1px solid gray; */
}


</style>
</head>
<body>
	<!--네이게이션 bar 부분  -->
	<div id="header"></div>

	<div id="content">
	<!-- 이미지 -->  
		<div id="mem_profile" >
			<img alt="이미지 없음" src="../img/member_profile.png">
		
		</div>
		
		
		<!-- 개인정보 수정 -->
		<div id="member_form">
			<table class="table_mypage" >
			<tr>
				<td colspan="2" ><input id="grade_icon" class="mypage_form_re" value="grade" readonly="readonly"></td>
			</tr>
			<tr>
				<td colspan="2" ><input class="mypage_form_re"  id="mem_email" value="email" readonly="readonly"></td>
			</tr>
			<tr>
				<td style="width:100px; " >pwd</td>
				<td><input type="password"  class="mypage_form"  name="mem_pwd" id="mem_pwd"></td>
			</tr>
			<tr>
				<td>pwdcheck</td>
				<td><input type="password" class="mypage_form"  name="mem_pwd" id="mem_pwd"></td>
			</tr>
			
			
			<tr>
				
				<td colspan="2"><input type="text" class="mypage_form_re"  name="mem_regdate" id="mem_regdate" value="2022.07.04"></td>
			</tr>
			
			
			</table>
		
		</div>
	 	<!--자기소개 text box  -->
	 	
		<div id="mem_profile_text"	>
			<span >주원님</span><br>
			<textarea rows="3" cols="25">반갑습니다</textarea><br>
			 <input type="submit" value="Submit">
		</div> 
		
		
			<input class="button" type="text" value="수정">
			<input class="button" type="text" value="취소">
			<input class="button" type="text" value="삭제">
		
		
	
		
		
		
	</div>
		
		

	<div  id="footer"	>
		
	</div>


</body>
</html>