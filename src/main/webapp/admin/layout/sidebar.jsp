<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="sidebar">
    <div class="brand">
        <a href="/admin/main.do">MES Solution</a>
    </div>

    <ul class="sidebar-nav">
        <li class="sidebar-item">
            <label>기초 자료 관리</label>
            <nav>
                <a href="/admin/systemCodeList.do" class="sidebar-link ${param.active == 'system-code-list' ? 'active' : ''}">시스템 코드 관리</a>
                <a href="/admin/codeList.do" class="sidebar-link ${param.active == 'code-list' ? 'active' : ''}">코드 리스트 조회</a>
            </nav>
        </li>
        <li class="sidebar-item">
            <label>거래처 관리</label>
            <nav>
                <a href="/admin/accountList.do" class="sidebar-link ${param.active == 'account-list' ? 'active' : ''}">거래처 정보 관리</a>
                <a href="/admin/managerList.do" class="sidebar-link ${param.active == 'manager-list' ? 'active' : ''}">거래처 담당 관리</a>
            </nav>
        </li>
        <li class="sidebar-item">
            <label>원자재 관리</label>
            <nav>
                <a href="javascript:void(0)" class="sidebar-link">원자재 정보 관리</a>
                <a href="javascript:void(0)" class="sidebar-link">원자재 발주 관리</a>
                <a href="javascript:void(0)" class="sidebar-link">원자재 입고 관리</a>
                <a href="javascript:void(0)" class="sidebar-link">원자재 자가 처리 관리</a>
                <a href="javascript:void(0)" class="sidebar-link">원자재 재고 조회</a>
                <a href="javascript:void(0)" class="sidebar-link">원자재 입고 일별 현황</a>
                <a href="javascript:void(0)" class="sidebar-link">원자재 입고 월별 현황</a>
                <a href="javascript:void(0)" class="sidebar-link">원자재 출고 일별 현황</a>
                <a href="javascript:void(0)" class="sidebar-link">원자재 출고 월별 현황</a>
                <a href="javascript:void(0)" class="sidebar-link">원자재 자재 입고현황</a>
                <a href="javascript:void(0)" class="sidebar-link">발주원자재 입고현황</a>
            </nav>
        </li>
        <li class="sidebar-item">
            <label>시스템 관리</label>
            <nav>
                <a href="javascript:void(0)" class="sidebar-link">회사 정보 관리</a>
                <a href="/admin/userList.do" class="sidebar-link ${param.active == 'user-list' ? 'active' : ''}">사용자 관리</a>
                <a href="/admin/ipSettings.do" id="ipSettingsPopup" class="sidebar-link">IP 설정</a>
            </nav>
        </li>
    </ul>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#ipSettingsPopup').colorbox({
            transition: "elastic",
            speed: 150,
            opacity: 0.6,
            iframe: true,
            width: "450px",
            height: "200px",
        });
    });
</script>