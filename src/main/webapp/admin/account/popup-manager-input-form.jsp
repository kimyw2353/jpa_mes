<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="../layout/top.jsp">
  <jsp:param name="title" value="${URLEncoder.encode(manager == null ? \"거래처 담당자 등록하기\" : \"거래처 담당자 수정하기\")}" />
</jsp:include>

<div class="box box-bg">
  <div class="content-header">
    <p class="title">${manager == null ? '거래처 담당자 등록하기' : '거래처 담당자 수정하기'}</p>
  </div>

  <form name="manager-form" method="POST" action="${manager == null ? '/admin/account/createManagerProc.do' : '/admin/account/updateManagerProc.do'}">
    <c:if test="${manager == null}">
      <input type="hidden" name="account_id" value="${param.account_id}">
    </c:if>
    <c:if test="${manager != null}">
      <input type="hidden" name="id" value="${manager.id}">
      <input type="hidden" name="account_id" value="${manager.account.id}">
    </c:if>

    <table class="table-input xs">
      <colgroup>
        <col width="150px">
        <col width="*">
      </colgroup>
      <tbody>
      <tr>
        <th>담당자명</th>
        <td><input type="text" name="name" class="form-control xs" value="${manager.name}"></td>
      </tr>
      <tr>
        <th>직급</th>
        <td><input type="text" name="grade" class="form-control xs" value="${manager.grade}"></td>
      </tr>
      <tr>
        <th>번호</th>
        <td><input type="text" name="tel" class="form-control xs" value="${manager.tel}"></td>
      </tr>
      <tr>
        <th>이메일</th>
        <td><input type="email" name="email" class="form-control xs" value="${manager.email}"></td>
      </tr>
      <tr>
        <th>비고</th>
        <td>
          <textarea name="textarea" id="" cols="30" rows="5" class="form-control"></textarea>
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

<script type="text/javascript">
    $(document).ready(function () {
        $('form[name="manager-form"]').validate({
            rules: {
                name: "required",
            }, messages: {
                name: "담당자명을 입력해 주세요.",
            }, submitHandler: function(form) {
                form.submit();
            }
        });
    });
</script>

<jsp:include page="../layout/bottom.jsp" />