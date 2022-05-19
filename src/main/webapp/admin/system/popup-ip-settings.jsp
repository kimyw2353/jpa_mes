<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="../layout/top.jsp">
  <jsp:param name="title" value="${URLEncoder.encode(\"IP 설정\")}" />
</jsp:include>

<div class="box box-bg">
  <div class="content-header">
    <p class="title">IP 설정</p>
  </div>

  <form name="ip-form" method="POST">
    <table class="table-input xs">
      <colgroup>
        <col width="150px">
        <col width="*">
      </colgroup>
      <tbody>
      <tr>
        <th>IP</th>
        <td>
          <input type="text" class="form-control xs w-50">
          <input type="text" class="form-control xs w-50">
          <input type="text" class="form-control xs w-50">
          <input type="text" class="form-control xs w-50">
        </td>
      </tr>
      </tbody>
    </table>

    <div class="mt-1 txt-right">
      <button type="submit" class="btn btn-primary">
        <i class="fa fa-pencil" aria-hidden="true"></i>
        저장하기
      </button>
    </div>
  </form>
</div>

<jsp:include page="../layout/bottom.jsp" />