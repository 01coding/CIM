<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>

    temporaryOrderList= (function () {

        function toView(id) {

            var fd =new Array();
            fd.push({name: "temporaryOrderId", value: id});
            debugger;
            appModule.open('/temporary/order/toView.do',fd,'exampleModalSelect')
        };

        function nextPage(ts) {
            var addStore = $("#conditionTemporary").serializeArray();
            var fd = {name: "pager.currentPage", value: $(ts).data("nextid")};
            addStore.push(fd);
            appModule.load('/temporary/order/list.do',addStore,"temporaryTable");
        }
        function previousPage(ts) {
            var addStore = $("#conditionTemporary").serializeArray();
            var fd = {name: "pager.currentPage", value: $(ts).data("previouspage")};
            addStore.push(fd);
            appModule.load('/temporary/order/list.do',addStore,"temporaryTable");
        }
        function currentPage(ts) {
            var addStore = $("#conditionTemporary").serializeArray();
            var fd = {name: "pager.currentPage", value: $(ts).data("currentpage")};
            addStore.push(fd);
            appModule.load('/temporary/order/list.do',addStore,"temporaryTable");
        }

        return{
            toView:toView,
            nextPage:nextPage,
            previousPage:previousPage,
            currentPage:currentPage
        }
    })();
</script>

<table id="example" class="table table-hover display  pb-30">
    <thead>
    <tr>
        <th>订单编号</th>
        <th>日期</th>
        <th>门店/客户编号</th>
        <th>门店/客户名称</th>
        <th>菜品编号&名称</th>
        <th>数量</th>
        <th>交付时间</th>
        <th>产品批次编号</th>
        <th>备注</th>
        <th>ACTIONS</th>
    </tr>
    </thead>
    <tfoot>
        <tr>
        <th>订单编号</th>
        <th>下单日期</th>
        <th>门店/客户编号</th>
        <th>门店/客户名称</th>
        <th>菜品编号&名称</th>
        <th>数量</th>
        <th>交付时间</th>
        <th>产品批次编号</th>
        <th>备注</th>
        <th>ACTIONS</th>
    </tr>
    </tfoot>
    <tbody>
<c:forEach var="temporaryOrder" items="${pager.list}">
    <c:forEach var="temporaryOrderTerm" items="${temporaryOrder.temporaryOrderTerms}">
     <c:if test="${temporaryOrderTerm.temporaryOrder.temporaryOrderId==temporaryOrder.temporaryOrderId}">
        <tr>
        <td>${temporaryOrder.temporaryOrderNo}</td>
        <td><fmt:formatDate value="${temporaryOrder.temporaryOrderStartDate}" pattern="yyyy-MM-dd"/></td>
        <td>${temporaryOrder.store.storeNo}</td>
        <td>${temporaryOrder.store.storeName}</td>
        <td>${temporaryOrderTerm.menu.menuName}</td>
        <td>${temporaryOrderTerm.menuNumber}</td>
        <td><fmt:formatDate value="${temporaryOrder.temporaryOrderEndDate}" pattern="yyyy-MM-dd"/></td>
        <td>${temporaryOrderTerm.productBatch}</td>
        <td>${temporaryOrder.temporaryOrderRemarks}</td>
        <td class="footable-editing" style="display: table-cell;">
            <div class="btn-group btn-group-xs" role="group">

                <button type="button" class="btn btn-default footable-edit"
                        data-toggle="modal" data-target="#exampleModalSelect" onclick="temporaryOrderList.toView(${temporaryOrder.temporaryOrderId})">
                    <i class="fa ti-search" style="color: #2879ff;"></i>
                </button>

            </div>
        </td>
        </tr>
    </c:if>
    </c:forEach>
</c:forEach>

    </tbody>
</table>

<div style="float: right">
       <input type="hidden" id="thisPage" value="${pager.currentPage}">
    <ul class="pagination pagination-split">

        <li
                <c:if test="${pager.currentPage==pager.startIndex}" > class="disabled"</c:if>
        ><a data-previouspage="${pager.previousPage}" onclick="temporaryOrderList.previousPage(this)"><i class="fa fa-angle-left"></i></a></li>

        <c:forEach items="${pager.pageBar}" var="pb">
            <li<c:if test="${pb==pager.currentPage}"> class="active"</c:if>
            ><a data-currentpage="${pb}" onclick="temporaryOrderList.currentPage(this)">${pb}</a></li>
        </c:forEach>

        <li
                <c:if test="${pager.currentPage==pager.endIndex}" > class="disabled"</c:if>
        ><a data-nextid="${pager.nextPage}" onclick="temporaryOrderList.nextPage(this)"><i class="fa fa-angle-right"></i></a></li>

    </ul>

</div>