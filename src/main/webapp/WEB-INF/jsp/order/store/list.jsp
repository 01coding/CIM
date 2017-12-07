<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    var storeList= (function () {

        function toEdit(id) {
            var fd = {storeId:id};
            appModule.open('/store/toEdit.do',fd,'exampleModalUpdate');
        };

        function toView(id) {
            var fd = {storeId:id};
            appModule.open('/store/toView.do',fd,'exampleModalSelect')
        };

        function toDel(id) {
            $("#storeDel").attr("data-delid",id);
        }

        function del(ts) {
            var fd = {storeId:$(ts).data("delid")};
            appModule.post('/store/delete.do',fd,function (data) {
                appModule.alert(data);
                storeModule.list();
            });
        }
        return{
            toEdit:toEdit,
            toView:toView,
            toDel:toDel,
            del:del
        };

    })();
</script>

<table id="example" class="table table-hover display  pb-30">

    <thead>
    <tr>
        <th>用户/门店名称</th>
        <th>门店/用户类别</th>
        <th>地址</th>
        <th>电话</th>
        <th>门店编号</th>
        <th>ACTIONS</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th>用户/门店名称</th>
        <th>门店/用户类别</th>
        <th>地址</th>
        <th>电话</th>
        <th>门店编号</th>
        <th>ACTIONS</th>
    </tr>
    </tfoot>
    <tbody>

    <c:forEach var="store" items="${pager.list}">
        <tr>
            <td>${store.storeName}</td>
            <td>
                <c:choose>
                <c:when test="${store.storeType==1}">
                    合同用户
                </c:when>
                <c:when test="${store.storeType==2}">
                    散户
                </c:when>
                </c:choose>
            </td>
            <td>${store.storeAddress}</td>
            <td>${store.storePhone}</td>
            <td>${store.storeNo}</td>
            <td class="footable-editing" style="display: table-cell;width: 100px">
                <div class="btn-group btn-group-xs" role="group">
                    <button type="button" class="btn btn-default footable-edit" data-toggle="modal" data-target="#exampleModal" onclick="storeList.toEdit(${store.storeId})">
                        <span class="fooicon fooicon-pencil" aria-hidden="true"></span>
                    </button>
                    <button type="button" class="btn btn-default footable-edit" data-toggle="modal" data-target="#exampleModalSelect" onclick="storeList.toView(${store.storeId})">
                        <i class="fa ti-search" style="color: #2879ff;"></i>
                    </button>
                    <button type="button" class="btn btn-default footable-delete"  data-toggle="modal" data-target=".bs-example-modal-lg" onclick="storeList.toDel(${store.storeId})">
                        <span class="fooicon fooicon-trash" aria-hidden="true"></span>
                    </button>
                </div>
            </td>
        </tr>
    </c:forEach>

    </tbody>

</table>