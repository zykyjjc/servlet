<%--
  Created by IntelliJ IDEA.
  User: 不器
  Date: 2018/12/28
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
<%-- this is jsp comment --%>
<%! String name,uri; %>
request uri is <%=request.getRequestURI()%>
<br/>
<%
    String password="666";
    name="aha";
    uri=request.getRequestURI();
    out.println("uri="+uri+"\n");
    out.println("name="+name+"\n");
    out.println("password="+password);
%>

</body>
</html>
