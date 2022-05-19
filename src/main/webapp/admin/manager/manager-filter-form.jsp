<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="GET" action="/admin/managerList.do">
  <table class="table-input">
    <colgroup>
      <col width="10%">
      <col width="40%">
      <col width="10%">
      <col width="*">
    </colgroup>
    <tbody>
    <tr>
      <th>거래처명</th>
      <td><input type="text" name="account_name" class="form-control xs" value="${param.account_name}"></td>
      <th>담당자명</th>
      <td><input type="text" name="manager_name" class="form-control xs" value="${param.manager_name}"></td>
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
      Total : ${count_of_manager} 건
    </div>
    <div>
      <button type="button" id="btnDeleteManager" class="btn btn-danger">
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
