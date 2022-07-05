<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="kopo.poly.util.CmmUtil" %>
<%
    String msg = (String)request.getAttribute("msg");
    String url = (String)request.getAttribute("url");
%>
<!DOCTYPE html>
<html>
<head>
    <script>
        alert("<%=msg%>")
        location.href = "<%=url%>"
    </script>
    <meta charset="utf-8">
    <title>웹 페이지 제목</title>
</head>
<body class="container">
 <div class ="jumbotron">
  <h1>Form</h1>
  <p>폼을 통해 데이터 전송해봅시다.</p>
 </div>
 <form action="/getInsertNotice" method="get">
     <div class="form-group">
         <label>작성자</label>
         <input name ="reg_id" type ="text" class ="form-control"/>
     </div>
     <div class = "form-group">
         <label>게시판 제목</label>
         <input name = "title" type = "text" class = "form-control"/>
     </div>
     <div class = "form-group">
         <label>게시판 내용</label>
         <textarea name ="contents" class ="form-control" style="..."></textarea>
     </div>
     <button type = "submit" class ="btn btn-primary">전송</button>
 </form>

</body>
</html>
    