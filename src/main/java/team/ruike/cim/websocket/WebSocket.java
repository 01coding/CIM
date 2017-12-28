package team.ruike.cim.websocket;

import com.alibaba.fastjson.JSONArray;
import org.springframework.web.socket.*;
import team.ruike.cim.pojo.User;

import java.io.IOException;
import java.util.*;

public class WebSocket implements WebSocketHandler {
    /**
     * 用来存储所有用户的连接
     */
    private static final Map<User,WebSocketSession> webSockSession=new HashMap<User,WebSocketSession>();
    private static List<User> users=new ArrayList<User>();
    /**
     * 连接成功方法
     * @param Session Session客户端唯一
     * @throws Exception 处理错误
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession Session) throws Exception {
        User user = (User) Session.getAttributes().get("user");
        users.add(user);
        System.out.println("连接成功！！");
        webSockSession.put(user, Session);
        //发送上线通知
        MessageUtils messageUtils=new MessageUtils();
        messageUtils.setDate("3:50");
        messageUtils.setType(3);
        messageUtils.setUserId(0);
        messageUtils.setSenderUserId(0);
        messageUtils.setMessage(JSONArray.toJSONString(users));
        sendMessageToUsers(new TextMessage(JSONArray.toJSONString(messageUtils)));
    }

    /**
     * 接收消息处理方法
     * @param webSocketSession Session客户端唯一
     * @param webSocketMessage webSocketMessage
     * @throws Exception 处理错误
     */
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
//        sendMessageToUsers(new TextMessage(webSocketMessage.getPayload() + ""));
    }

    /**
     * 出现错误调用方法
     * @param webSocketSession Session客户端唯一
     * @param throwable 错误对象
     * @throws Exception 处理错误
     */
    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        System.out.println("错误");
        if (webSocketSession.isOpen()) {//如果连接打开则关闭
            webSocketSession.close();
        }
    }

    /**
     * 关闭连接调用方法
     * @param webSocketSession 连接对象
     * @param closeStatus 状态
     * @throws Exception 处理错误
     */
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        System.out.println("链接关闭......" + closeStatus.toString());
        User user = (User) webSocketSession.getAttributes().get("user");
        users.remove(user);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
    /**
     * 给所有在线用户发送消息
     * @param message 消息
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession socketSession : webSockSession.values()) {
            try {
                if (socketSession.isOpen()) {
                    socketSession.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 给某个用户发送消息
     * @param userId 用户id
     * @param message 消息
     */
    public void sendMessageToUser(Integer userId, TextMessage message) {
        for (WebSocketSession socketSession : webSockSession.values()) {
            User user = (User) socketSession.getAttributes().get("user");
            if (user!=null&&user.getUserId()==userId) {
                try {
                    if (socketSession.isOpen()) {
                        socketSession.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
