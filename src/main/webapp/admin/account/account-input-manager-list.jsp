<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="box box-bg mt-1">
  <div class="flex-content-between">
    <div class="content-header">
      <p class="sub-title">거래처 담당자</p>
    </div>
    <div>
      <a href="/admin/account/createManager.do?account_id=${account.id}" class="btn btn-primary popup">추가</a>
      <button type="button" id="btnDeleteAccountManager" class="btn btn-danger">삭제</button>
    </div>
  </div>

  <table class="table-list full">
    <colgroup>
      <col width="50px">
      <col width="15%">
      <col width="5%">
      <col width="15%">
      <col width="15%">
      <col width="*">
    </colgroup>
    <thead>
    <tr>
      <th><input type="checkbox" name="checked_all" /></th>
      <th>담당자명</th>
      <th>직급</th>
      <th>번호</th>
      <th>이메일</th>
      <th>비고</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="manager" items="${managers}" varStatus="status">
      <tr>
        <td class="txt-center">
          <input type="checkbox" name="idx[]" value="${manager.id}" />
        </td>
        <td><a href="/admin/account/updateManager.do?id=${manager.id}" class="popup">${manager.name}</a></td>
        <td>${manager.grade}</td>
        <td>${manager.tel}</td>
        <td>${manager.email}</td>
        <td>${manager.etc}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('.popup').colorbox({
            transition: "elastic",
            speed: 150,
            opacity: 0.6,
            iframe: true,
            width: "450px",
            height: "430px",
            onClosed: function () {
              window.location.reload();
            }
        });

        $('#btnDeleteAccountManager').on('click', function (e) {
            console.log("btnDeleteAccountManager");
        });
    });

    function closePopup() {
        $('.popup').colorbox.close();

        setTimeout(function () {
            window.location.reload();
        }, 160);
    }
</script>