<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>${title}</title>
	<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$.ajax({
				url : "/getBoardList",
				dataType : "json",
				type : "get",
				//data : [],
				success : function(data){
					console.log(data);

					/* jquery */
					
	 				if (data) {
						$("#boardList").html("");
						
						data.forEach(function(value, index) {
							
							var trTag = $("<tr>");
							
							trTag.append($("<td>", {text : value.num}));
							trTag.append($("<td>", {text : value.title}));
							trTag.append($("<td>", {text : value.createUser}));
							trTag.append($("<td>", {text : value.createDate}));
							
							$("#boardList").append(trTag);
						});
					}
					
					/* js */
					/* data.forEach(function(value, index) {
							
						var trTag = document.createElement("tr");
							
						var numTag = document.createElement("td");
						numTag.innerText = value.num;
						trTag.append(numTag);
						
						var titleTag = document.createElement("td");
						titleTag.innerText = value.title;
						trTag.append(titleTag);
						
						var createUserTag = document.createElement("td");
						createUserTag.innerText = value.createUser;
						trTag.append(createUserTag);
						
						var createDateTgg = document.createElement("td");
						createDateTgg.innerText = value.createDate;
						trTag.append(createDateTgg);
						
						document.getElementById("boardList").append(trTag);
					}); */
					
					/* 옛날방식 String 으로 묶어서 사용하는방식
					let str = "";
					$.each(data,function(i){
						str += "<tr>"
						str += "<td>" + data[i].num + "</td>"
						str += "<td>" + data[i].title + "</td>"
						str += "<td>" + data[i].createUser + "</td>"
						str += "<td>" + data[i].createDate + "</td>"
						str += "</tr>"
					});
					$("#boardList").append(str); 
					*/
					
					
	 				$.ajax({
	 					url : "/getBoardListDB",
	 					type : "GET",
	 				    dataType : "json",
	 				    contentType: "application/json; charset=utf-8",
	 					success : function(data){
	 						console.log("getBoardListDB", data);
	 						
	 						if(data) {
	 							$("#boardListDB").html("");
	 							data.forEach(function(value, index){
	 								
	 								let boardList = $("<tr>")
	 								
	 								boardList.append($("<td>", {text : value.NUM}))
	 								boardList.append($("<td>", {text : value.TITLE}))
	 								boardList.append($("<td>", {text : value.CREATEUSER}))
	 								boardList.append($("<td>", {text : value.CREATEDATE}))
	 								
		 							$("#boardListDB").append(boardList)
	 							})
	 						}
	 					},
	 					error : function(e){
	 						console.log(e);
	 					}
	 				});
					
				},
				error : function(e){
					console.log(e);
				}
			});	
		});
		
		function addBoardView() {
			location.href = "/addBoardView"
		}
	</script>
</head>
<body>
	<div>
		<h1>${menuName}</h1>
		<div>
			<!-- <a href="/addBoardView">add view</a> -->
			<button onclick="addBoardView()">add</button>
		</div>
	</div>
	<div>
		<table>
			<thead>
				<tr>
					<th>No</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${list}" varStatus="status">
			    	<tr>
						<td>${item.NUM}</td>
						<td>${item.TITLE}</td>
						<td>${item.CREATEUSER}</td>
						<td>${item.CREATEDATE}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div>
		<h1>Json Response</h1>
	</div>
	<div>
		<table>
			<thead>
				<tr>
					<th>No</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody id="boardList"></tbody>
		</table>
	</div>

	<div>
		<h1>json Response (DB)</h1>
	</div>
	<div>
		<table>
			<thead>
				<tr>
					<th>No</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody id="boardListDB"></tbody>
		</table>
	</div>
</body>
</html>
