<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*" %>
<%@ page import="java.text.*, java.net.InetAddress" %>
  <c:set var="path1" value="${request.getContextPath() }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/head.jsp" />
  <jsp:include page="/header.jsp" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
<title>군산 문화 관광</title>
</head>
<body>
	<h2>hello 군산 world~! ${user }님~!</h2>
</body>
</html>