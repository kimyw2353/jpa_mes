<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="../layout/top.jsp">
  <jsp:param name="title" value="${URLEncoder.encode(\"시스템 코드 관리\")}" />
</jsp:include>

<div class="wrapper">
  <jsp:include page="../layout/sidebar.jsp">
    <jsp:param name="active" value="system-code-list" />
  </jsp:include>

  <div class="container">
    <jsp:include page="../layout/header.jsp" />

    <div id="content">
      <jsp:include page="../layout/content-header.jsp" />

      <div class="box box-bg">
        <jsp:include page="system-code-filter-form.jsp" />

        <table class="table-list full">
          <colgroup>
            <col width="50px">
            <col width="30%">
            <col width="30%">
            <col width="*">
          </colgroup>
          <thead>
          <tr>
            <th><input type="checkbox" name="checked_all" /></th>
            <th>구분</th>
            <th>코드명</th>
            <th>비고</th>
          </tr>
          </thead>
          <tbody>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>

<jsp:include page="../layout/bottom.jsp" />