var appModule=(function () {


    function load(url,data,container,error){
        $.ajax({
            url: url,
            type: 'post',
            data: data,  // post时请求体
            dataType: 'html',
            success:function (html) {
                $("#" + container).empty().append(html);
            },error:function() {
                if (null != error) {
                    error();
                } else {
                    alert("error");
                }
            }

        });
    }



    function alert(message) {
        window.alert(message);
    }

    return{
        load:load
    }
})();