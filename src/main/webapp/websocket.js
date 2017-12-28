var websocket = null;
//判断当前浏览器是否支持WebSocket
// if ('WebSocket' in window) {
//     websocket = new WebSocket("ws://localhost:/echo");
// }
if ('WebSocket' in window) {
    var url = 'ws://' + window.location.host + '/websocket.cl';
    websocket = new WebSocket(url);
    //websocket = new WebSocket("ws://127.0.0.1:8080/SSMTest/echo");
} else if ('MozWebSocket' in window) {
    websocket = new MozWebSocket("ws://websocket.cl");
} else {
    websocket = new SockJS("http://127.0.0.1/sockjs/websocket.cl");
}
//连接发生错误的回调方法
websocket.onerror = function () {
    setMessageInnerHTML("WebSocket连接发生错误");
};
//连接成功建立的回调方法
websocket.onopen = function () {
    setMessageInnerHTML("WebSocket连接成功");
}
//接收到消息的回调方法
websocket.onmessage = function (event) {
    // setMessageInnerHTML(event.data);
    var data=event.data;
    var testJson = $.parseJSON(data);
    if(testJson.type==3){
        var $chat = $("#us");
        $chat.html("");
        var parseJSON = $.parseJSON(testJson.message);
        $.each( parseJSON, function(index, content){
            $chat.append($('<a href="javascript:void(0)">' +
                '<div class="sl-item unread-message">' +
                '<div class="sl-avatar avatar avatar-sm avatar-circle">' +
                '<img class="img-responsive img-circle" src="../../dist/img/user.png"' +
                'alt="avatar"/>' +
                '</div>' +
                '<div class="sl-content">' +
                '<span class="inline-block capitalize-font   pull-left message-per">'+content.userName+'</span>' +
                '<span class="inline-block font-11  pull-right message-time"></span>' +
                '<div class="clearfix"></div>' +
                '<span class=" truncate message-subject">'+content.roles[0].roleName+'</span>' +
                '<p class="txt-grey truncate"></p>' +
                '</div></div></a>'));
        })
    }
}
//连接关闭的回调方法
websocket.onclose = function () {
    setMessageInnerHTML("WebSocket连接关闭");
}
//将消息显示在网页上
function setMessageInnerHTML(innerHTML) {
    alert(innerHTML);
}

//关闭WebSocket连接
function closeWebSocket() {
    websocket.close();
}