<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title><spring:message code="login.title" /></title>
</head>

<body>
<p>관리자 로그인</p>
    <form:form modelAttribute="loginCommand">
    <form:errors />
    <p>
        <label><spring:message code="memberid" />:<br>
        <form:input path="memberid" />
        <form:errors path="memberid"/>
        </label>
    </p>
    <p>
        <label><spring:message code="password" />:<br>
        <form:password path="password" />
        <form:errors path="password"/>
        </label>
    </p>
    <p>
        <label><spring:message code="rememberId" />:
        <form:checkbox path="rememberId"/> 
        </label>
    </p>
    <input type="submit" value="<spring:message code="login.btn" />">
    </form:form>
</body>
</html>
