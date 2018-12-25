<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 작성</title>
<%@ include file="../include/header.jsp" %>
<%@ include file="../include/sessionCheck.jsp" %>
<script type="text/javascipt" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/member/resources/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
</head>
<script type="text/javascript">
    $(function(){
        //전역변수
        var obj = [];              
        //스마트에디터 프레임생성
        nhn.husky.EZCreator.createInIFrame({
            oAppRef: obj,
            elPlaceHolder: "content",
            sSkinURI: "/member/resources/smarteditor/SmartEditor2Skin.html",
            htParams : {
                // 툴바 사용 여부
                bUseToolbar : true,            
                // 입력창 크기 조절바 사용 여부
                bUseVerticalResizer : true,    
                // 모드 탭(Editor | HTML | TEXT) 사용 여부
                bUseModeChanger : true,
            }
        });
        //전송버튼
        $("#btnSave").click(function(){
            //id가 smarteditor인 textarea에 에디터에서 대입
            obj.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
            //폼 submit
            $("#frm").submit();
        });
    });
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>게시글 작성</h2>
<form name="form" id="frm" method="post" action="${path}/board/insert.do" enctype="multipart/form-data">
	<table border="1" align="center" width="800">
		<tr >
			<td>제목  </td><td><input name="title" id="title" size="30"></td>
		</tr>
		<tr align="center">
			<td></td><td><textarea name="content" id="content" rows="8" cols="60"></textarea></td>
		</tr>
		<tr>
			<td>이름 </td>
			<td><input name="userId" id="userId" value="${sessionScope.userId }" disabled></td>
		</tr>
		<tr>
			<td>파일</td>
			<td><input type="file" name="file"></td>
		</tr>
		<tr>	
			<td></td>
			<td>
				<button type="button" id="btnSave" >저장</button>
				<button type="reset">취소</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>