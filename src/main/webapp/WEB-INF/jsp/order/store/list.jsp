<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <tr>
        <td>三号店</td>
        <td>旗舰店</td>
        <td>江苏省</td>
        <td>12401701225</td>
        <td>03 170625 001</td>
        <td class="footable-editing" style="display: table-cell;">
            <div class="btn-group btn-group-xs" role="group">
                <button type="button" class="btn btn-default footable-edit"
                        data-toggle="modal" data-target="#exampleModal">
                                                            <span class="fooicon fooicon-pencil"
                                                                  aria-hidden="true"></span>
                </button>
                <button type="button" class="btn btn-default footable-edit"
                        data-toggle="modal" data-target="#exampleModalSelect">
                    <i class="fa ti-search" style="color: #2879ff;"></i>
                </button>
                <button type="button" class="btn btn-default footable-delete"
                        data-toggle="modal" data-target=".bs-example-modal-lg">
                                                            <span class="fooicon fooicon-trash"
                                                                  aria-hidden="true"></span>
                </button>
            </div>
        </td>
    </tr>


    </tbody>
</table>
