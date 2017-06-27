/**
 * Created by xueshan.wei on 6/27/2017.
 */
$(document).ready(function () {
    var messageTemplate = function (message) {
        return '<div id="chat" style="width:200px; padding:3px; margin:3px; border:1px solid #0c91e5;">'
            + message
            + '</div>';
    };
    var showMessage = function (message) {
        var content = messageTemplate(message);
        $("#content").append(content);
    };
    var sendMessage = function (message) {
        stompClient.send("/app/userChat", {}, message);
    }


    var socket = new SockJS("/coordination");
    var stompClient = Stomp.over(socket);
    stompClient.connect('', '', function (frame) {
        console.info("connect success...");
        stompClient.subscribe('/userChat/chat', function (message) {
            showMessage(message);
        })
    });


    $("#send").click(function () {
        var message = $("#messageInput").val();
        console.info("要发送的信息：" + message);
        sendMessage(message);
    });
});