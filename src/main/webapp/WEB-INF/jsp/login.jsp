<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <style>
        .validate{
            font-size: 12px;
            color: red;
        }
    </style>
</head>
<body>
<a href="/SSM_01/changeLanguage"><s:message code="buttonzh.label"/></a><br>
<form:form action="/SSM_01/dologin" method="post" modelAttribute="user">
    <s:message code="aczh.label"/>:<form:input path="username" name="username"/>
    <form:errors cssClass="validate" path="username"/><br>
    <s:message code="pwzh.label"/>:<form:password path="password" name="password"/>
    <form:errors cssClass="validate" path="password"/><br>
    <s:message code="emzh.label"/>:<form:input path="email" name="email"/>
    <form:errors cssClass="validate" path="email"/><br>
    <input type="submit" value="<s:message code='subzh.label'/>"/>
    <div>
        <img src="images/3.jpg">
    </div>
</form:form>
</body>
</html>
