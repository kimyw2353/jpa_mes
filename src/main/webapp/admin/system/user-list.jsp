<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="../layout/top.jsp">
  <jsp:param name="title" value="${URLEncoder.encode(\"사용자 관리\")}" />
</jsp:include>

<div class="wrapper">
  <jsp:include page="../layout/sidebar.jsp">
    <jsp:param name="active" value="user-list" />
  </jsp:include>

  <div class="container">
    <jsp:include page="../layout/header.jsp" />

    <div id="content">
      <jsp:include page="../layout/content-header.jsp" />

      <div class="box box-bg">
        <jsp:include page="user-filter-form.jsp" />

        <table class="table-list full">
          <colgroup>
            <col width="50px">
            <col width="200px">
            <col width="200px">
            <col width="100px">
            <col width="100px">
            <col width="150px">
            <col width="*">
          </colgroup>
          <thead>
          <tr>
            <th><input type="checkbox" name="checked_all" /></th>
            <th>아이디</th>
            <th>사용자명</th>
            <th>부서</th>
            <th>직위</th>
            <th>전화번호</th>
            <th>비고</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="user" items="${users}" varStatus="status">
            <tr>
              <td class="txt-center">
                <input type="checkbox" name="idx[]" value="${user.id}" />
              </td>
              <td><a href="/admin/updateUser.do?id=${user.id}" class="user-update-popup">${user.userId}</a></td>
              <td>${user.name}</td>
              <td>${user.department}</td>
              <td>${user.position}</td>
              <td>${user.tel}</td>
              <td>${user.etc}</td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('.user-update-popup').colorbox({
            transition: "elastic",
            speed: 150,
            opacity: 0.6,
            iframe: true,
            width: "450px",
            height: "430px",
        });

        $('input:checkbox[name="checked_all"]').on('change', function (e) {
            $('input:checkbox[name="idx[]"]').prop('checked', $(this).prop('checked'));
        });

        $('input:checkbox[name="idx[]"]').on('change', function (e) {
            var totalCount = $('input:checkbox[name="idx[]"]').length;
            var totalCheckedCount = $('input:checkbox[name="idx[]"]:checked').length;

            $('input:checkbox[name="checked_all"]').prop('checked', (totalCount === totalCheckedCount));
        });

        $('#btnDeleteUser').on('click', function (e) {
            console.log("btnDeleteUser");
        });
    });

    function closePopup() {
        $('.user-update-popup').colorbox.close();

        setTimeout(function () {
            window.location.reload();
        }, 160);
    }
</script>

<jsp:include page="../layout/bottom.jsp" />