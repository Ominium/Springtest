<%@ page import="kopo.poly.dto.NoticeDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<NoticeDTO> rList = (List<NoticeDTO>)request.getAttribute("rList");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>게시판 제목</title>
</head>
<body>
<div style="margin: auto; width: 800px;">
    <table>
        <tr>
            <td>순번</td>
            <td>제목</td>
            <td>게시자</td>
            <td>등록일</td>
        </tr>
        <% for(int i=0; i<rList.size();i++) { %>
        <tr>
            <td><%=rList.get(i).getNotice_seq() %></td>
            <td><a href ="NoticeDetail?no=<%=rList.get(i).getNotice_seq()%>"><%=rList.get(i).getTitle()%></a></td>
            <td><%=rList.get(i).getContents() %></td>
            <td><%=rList.get(i).getReg_id() %></td>

        </tr>
        <%}%>
    </table>
    <div style="width: 100%; text-align: right; margin-top: 5px">
        <button type="button" onclick="location.href ='noticeInfo'">새글</button>
    </div>
</div>
</body>
</html>