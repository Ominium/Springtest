<%@ page import="kopo.poly.dto.NoticeDTO" %>
<%@ page import="kopo.poly.util.CmmUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    NoticeDTO rDTO = (NoticeDTO) request.getAttribute("rDTO");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">


    <title></title>
</head>
<body class="container">
<div class="jumbotron">
    <h1>Form</h1>
    <p>폼을 통해 데이터 전송해봅시다.</p>
</div>
<form>
    <div class="form-group">
        <label>게시판 제목</label>
        <input name="title" type="text" class="form-control" value="<%=rDTO.getTitle()%>"/>
    </div>
    <div class = "form-group">
        <label>작성자</label>
        <input name = "reg_id" type="text" class = "form-control" value="<%=rDTO.getReg_id()%>"/>
    </div>
    <div class="form-group">
        <label>게시판 내용</label>
        <textarea name="contents" class="form-control" style="height: 500px" value="<%=rDTO.getContents()%>"></textarea>
    </div>
    <div class = "form-group">
        <label>게시판 번호</label>
        <input name = "notice_seq" class = "form-control" value="<%=rDTO.getNotice_seq()%>"/>
    </div>
    <button type="submit">전송</button>
    <button onclick="location.href='getNoticeList'">뒤로</button>
</form>

<!-- Optional JavaScript -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>