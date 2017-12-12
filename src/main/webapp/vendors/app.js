var appModule = (function () {


    function load(url, data, container, error) {
        $.ajax({
            url: url,
            type: 'post',
            data: data,  // post时请求体
            dataType: 'html',
            success: function (html) {
                $("#" + container).empty().append(html);
            }, error: function () {
                if (null != error) {
                    error();
                } else {
                    alert("error");
                }
            }

        });
    }


    function pagination(url, param) {
        $.ajax({
            url: url,
            method: "get",
            data: param,
            success: function (data) {
            }, error: function () {
            }
        });
    }

    function post(url, param, success, error, type) {
        $.ajax({
            url: url,
            method: "post",
            data: param,
            dataType: type || "json",
            success: function (data) {
                if (null != success) {
                    success(data);
                }
            }, error: function () {
                alert("error");
            }
        });
    }

    function open(url, param, container) {
        $.ajax({
            url: url,
            method: "post",
            data: param,
            dataType: "html",
            success: function (html) {
                $("#" + container).empty().append(html);
            }, error: function () {
                alert("error");
            }
        });
    }
    
    function jump(url,param) {
        $.ajax({
            url: url,
            method: "post",
            data: param,
            success: function (data) {
                alert("success")
            }, error: function () {
                alert("error");
            }
        });
    }

    function alert(message) {
        window.alert(message);
    }

    return {
        load: load,
        post: post,
        open: open,
        alert: alert,
        pagination:pagination

    }
})();