package com.lsq.partjob.websocket.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.lsq.message.domain.MyMessages;
import com.lsq.message.service.IMessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
@ServerEndpoint("/websocket/{id}")
@Component
/**

 * @Description:    java类作用描述

 * @Author:         lvsiqi

 * @CreateDate:     2019/5/11 23:45
 
 */
public class WebSocketServer {
    @Autowired
    private IMessageService messageService;
    private static int onlineCount = 0;
    private static ConcurrentHashMap<String, WebSocketServer> webSocketSet = new ConcurrentHashMap<>();
    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     **/

    private Session session;
    private static Logger log = LogManager.getLogger(WebSocketServer.class);
    private String id = "";
    /**
     * 连接建立成功调用的方法
     * */
    @OnOpen
    public void onOpen(@PathParam(value = "id") String id, Session session) {
        this.session = session;
        /**
         * 接收到发送消息的人员编号加入set中
         */
        this.id = id;
        webSocketSet.put(id, this);
        /**
         * 在线数加1
         */
        addOnlineCount();
        log.info("用户"+id+"加入！当前在线人数为" + getOnlineCount());
        /*try {
           sendMessage("连接成功");
        } catch (IOException e) {
            log.error("websocket IO异常");
        }*/
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this.id);
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
       /* log.info("来自客户端的消息:" + message);
        MyMessages messages = JSON.parseObject(message,new TypeReference<MyMessages>(){});
        messageService.add(messages);*/
      /*  String sendMessage = message.split("[|]")[0];
        String sendUserId = message.split("[|]")[1];
        try {
            if(sendUserId.equals("0")){
                sendtoAll(sendMessage);
            }
            else {
                sendtoUser(sendMessage, sendUserId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }


    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 发送信息给指定ID用户，如果用户不在线则返回不在线信息给自己
     * @param message
     * @throws IOException
     */
    public static void sendInfo(MyMessages message)  {
        if (webSocketSet.get(message.getAcceptAccount()) != null) {
            try {
                webSocketSet.get(message.getAcceptAccount()).sendMessage(JSON.toJSONString(message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
