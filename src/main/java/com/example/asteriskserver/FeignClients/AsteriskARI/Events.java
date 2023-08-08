package com.example.asteriskserver.FeignClients.AsteriskARI;

import com.example.asteriskserver.FeignClients.configuration.FeignClientDefaultConfiguration;
import feign.Headers;
import feign.RequestLine;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 05.08.2023  17:52
 */
@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Events  {
    String uri;
    String username;
    String password;
    String app;
    boolean subscribeAll;

    public void createApplication() {

        if (uri == null || username == null || app == null || uri.isEmpty() || username.isEmpty() || app.isEmpty())
            System.out.println(String.format("%s is not full", this));
//            throw new RuntimeException(String.format("%s is not full",this));


        WebSocketStompClient stompClient = new WebSocketStompClient(new StandardWebSocketClient());
        stompClient.connectAsync(new StringBuilder()
                        .append(uri)
                        .append("?")
                        .append("app=")
                        .append(app)
                        .append("&api_key=")
                        .append(username)
                        .append(":")
                        .append(password)
                        .append("&subscribeAll=")
                        .append(subscribeAll)
                        .toString()
                , new StompSessionHandler() {
                    @Override
                    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {

                    }

                    @Override
                    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
                        System.out.println(exception);
                    }

                    @Override
                    public void handleTransportError(StompSession session, Throwable exception) {

                    }

                    @Override
                    public Type getPayloadType(StompHeaders headers) {
                        return null;
                    }

                    @Override
                    public void handleFrame(StompHeaders headers, Object payload) {
                        System.out.println(payload);
                    }
                });

        stompClient.start();

    }

}
