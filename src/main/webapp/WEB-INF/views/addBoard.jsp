<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function addBoard() {
	if(confirm("글을 저장하시겠습니까?")) {
		let title = document.getElementById('title').value;
		let content = document.getElementById('content').value;;
		let create_user = document.getElementById('createUser').value;
		
    	document.getElementById('addBoardForm').submit();
    	history.back()
	}
}
</script>
</head>
<body>
	<form id="addBoardForm" name="boardForm" action="/addBoard" method="post">
		<div>
			<div>
			
				<label></label>
				<input type="text" id="title" name="title" />
			</div>
			<div>
				<label></label>
				<input type="text" id="content" name="content" />
			</div>
			<div>
				<label></label>
				<input type="text" id="createUser" name="createUser" />
			</div>
			<!-- <input type="text" id="create_date" name="create_date" />
			<input type="text" id="update_date" name="update_date" /> -->
		</div>
		<div>
			<button onclick="addBoard()">저장하기</button>
			<button onclick="history.back()">뒤로가기</button>
		</div>
	</form>
</body>
</html>