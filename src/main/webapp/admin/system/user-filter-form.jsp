<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="GET" action="/admin/userList.do">
  <table class="table-input">
    <colgroup>
      <col width="10%">
      <col width="40%">
      <col width="10%">
      <col width="*">
    </colgroup>
    <tbody>
    <tr>
      <th>아이디</th>
      <td><input type="text" name="user_id" class="form-control xs" value="${param.user_id}"></td>
      <th>사용자명</th>
      <td><input type="text" name="user_name" class="form-control xs" value="${param.user_name}"></td>
    </tr>
    </tbody>
  </table>

  <div class="mt-1 mb-1 txt-right">
    <button type="submit" class="btn">
      <i class="fa fa-search" aria-hidden="true"></i>
      검색하기
    </button>
  </div>

  <div class="flex-content-between mb-1">
    <div class="ft-bold">
      Total : ${count_of_users} 건
    </div>
    <div>
      <button type="button" id="btnDeleteUser" class="btn btn-danger">
        <i class="fa fa-trash-o" aria-hidden="true"></i>
        삭제하기
      </button>
      <button type="button" class="btn btn-success">
        <i class="fa fa-file-excel-o" aria-hidden="true"></i>
        Excel 다운로드
      </button>
    </div>
  </div>
</form>
