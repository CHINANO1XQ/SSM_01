<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>你好</h1>${sex}

${sname}
<s:form action="/ssm01/yy/index" method="post" modelAttribute="stu">
  <s:input path="sname"/><s:errors path="sname"/>
    <s:password path="password"/>
    <s:select path="hobby" items="${map}"/>
    <s:button type="submit">提交</s:button>

</s:form>


</body>
</html>
