<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%
    String msg = (String)request.getAttribute("msg");
    String url = (String)request.getAttribute("url");
%>
<html>
<head>

    <meta charset="utf-8">
    <title>웹 페이지 제목</title>
</head>
<body>
  <form action="/getInsertUser" method="get">
      <div class = "form-group">
          <label>ID를 입력하세요</label>
          <input name = "user_id" type = "text" class="form-control"/>
      </div>
      <div class="form-group">
          <label>PASSWORD를 입력하세요</label>
          <input name = "user_pwd" type="password" class="form-control"/>
      </div>
      <div class="form-group">
          <label>EMAIL을 입력하세요</label>
          <input name = "user_email" type="email" class="form-control"/>
      </div>
      <div class="form-group">
          <label>NAME을 입력하세요</label>
          <input name = "user_name" type="text" class="form-control"/>
      </div>
      <button type = "submit" class="btn btn-primary">가입하기</button>
  </form>

</body>
</html>
    