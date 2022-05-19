<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="GET" action="/admin/codeList.do">
  <table class="table-input">
    <colgroup>
      <col width="10%">
      <col width="40%">
      <col width="10%">
      <col width="*">
    </colgroup>
    <tbody>
    <tr>
      <th>구분</th>
      <td><input type="text" class="form-control xs"></td>
      <th>코드명</th>
      <td><input type="text" class="form-control xs"></td>
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
      Total : 0 건
    </div>
    <div>
      <button type="button" class="btn btn-success">
        <i class="fa fa-file-excel-o" aria-hidden="true"></i>
        Excel 다운로드
      </button>
    </div>
  </div>
</form>
