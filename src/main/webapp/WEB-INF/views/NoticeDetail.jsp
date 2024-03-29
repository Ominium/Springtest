<%@ page import="kopo.poly.dto.NoticeDTO" %>
<%@ page import="kopo.poly.util.CmmUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    NoticeDTO rDTO = (NoticeDTO) request.getAttribute("rDTO");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>웹 페이지 제목</title>
</head>
<body>
    <div style="...">
        <h4><%=CmmUtil.nvl(rDTO.getReg_id())%></h4>
        <hr>
        <div style="...">작성자 : <%=CmmUtil.nvl(rDTO.getReg_id())%></div>
        <div>
            <p>
                <%=CmmUtil.nvl(rDTO.getContents())%>
            </p>
        </div>
    </div>
    <hr>
    <div style="...">
        <button onclick="location.href='getNoticeList'">뒤로</button>
    </div>
    <div style="...">
        <button onclick = "location.href = 'NoticeDelete?no=<%=rDTO.getNotice_seq()%>'">삭제</button>
    </div>
    <div style="...">
        <button onclick="location.href = 'NoticeChange?no=<%=rDTO.getNotice_seq()%>'">수정</button>
    </div>
</body>
</html>
    