<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


 <form:form modelAttribute="item">
    <form:errors />

    <p>
        <label><spring:message code="item.itemName" />:<br>
        <form:input path="itemName" />
        <form:errors path="itemName"/>
        </label>
    </p>
    <p>
        <label><spring:message code="item.itemDetail" />:<br>
        <form:input path="itemDetail" />
        <form:errors path="itemDetail"/>
        </label>
    </p>
     <p>
        <label><spring:message code="item.price" />:<br>
        <form:input path="price" />
        <form:errors path="price"/>
        </label>
    </p>
     <p>
        <label><spring:message code="item.stock" />:<br>
        <form:input path="stock" />
        <form:errors path="stock"/>
        </label>
    </p>

    <input type="submit" value="<spring:message code="item.btn" />">
    </form:form> 
</body>
</html>