package com.example.asteriskserver.FeignClients.ws;

import jakarta.websocket.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 08.08.2023  12:26
 */

@ClientEndpoint

public class AriWebSocket {
    private static Set<Session> sessions = new HashSet<>();
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("WebSocket opened: " + session.getId());
        sessions.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Stock information received: " + message + " from " + session.getId());
        try {

            session.getBasicRemote().sendObject(message.getBytes());
        } catch (IOException | EncodeException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("WebSocket error for " + session.getId() + " " + throwable.getMessage());
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("WebSocket closed for " + session.getId()
                + " with reason " + closeReason.getCloseCode());
        sessions.remove(session);
    }



}
