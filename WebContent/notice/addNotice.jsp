<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*" %>
<%@ page import="java.text.*, java.net.InetAddress" %>
<c:set var="path1" value="<%=request.getContextPath() %>" />
<%-- <c:set var="path1" value="${pageContext.request.contextPath }" />   --%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>공지사항 글쓰기</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
  </head>
  <body>
  <jsp:include page="/header.jsp" />
  <section class="section">
    <div class="container">
      <h1 class="title">공지사항 글쓰기</h1>
      <form action="${path1 }/AddNoticeCtrl.do" method="post">
		<table class="table">
		  <tbody>
		    <tr>
		      <th><label for="title">제목</label></th>
		      <td><input type="text" id="title" name="title" placeholder="제목 입력" class="input"  required></td>
		    </tr>
		    <tr>
		      <th><label for="content">내용</label></th>
		      <td><textarea class="textarea" placeholder="내용 입력" id="content" name="content" cols="100" rows="10"></textarea></td>
		    </tr>
		   </tbody>
		</table>
	<div class="buttons">
		<button type="submit" class="button is-primary is-light">등록</button>
		<button type="reset" class="button is-success is-light">취소</button>
		<a href="${path1 }/GetNoticeListCtrl.do" class="button is-success is-light">목록</a>
		</div>
	 </form>
    </div>
  </section>
  <jsp:include page="/footer.jsp"></jsp:include>
  </body>
</html>