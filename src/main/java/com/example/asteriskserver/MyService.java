package com.example.asteriskserver;

import ch.loway.oss.ari4java.ARI;
import ch.loway.oss.ari4java.tools.ARIException;
import com.example.asteriskserver.FeignClients.AsteriskARI.Applications;
import com.example.asteriskserver.FeignClients.AsteriskARI.Asterisk;
import com.example.asteriskserver.FeignClients.AsteriskARI.Bridges;
import com.example.asteriskserver.FeignClients.AsteriskARI.Events;
import com.example.asteriskserver.FeignClients.ws.AriWebSocket;
import jakarta.annotation.PostConstruct;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.DeploymentException;
import jakarta.websocket.WebSocketContainer;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;

@Service
public class MyService {
    private ARI ari;
    private final Applications applications;
    private final Asterisk asterisk;
    private final Bridges bridges;


    public MyService(Applications applications, Asterisk asterisk, Bridges bridges) {
        this.applications = applications;
        this.asterisk = asterisk;
        this.bridges = bridges;

    }

    // Метод, который будет выполнен автоматически после инициализации бина
    @PostConstruct
    public void initialize() throws ARIException, DeploymentException, IOException {
        Events events = Events.builder()
                .app("hello2")
                .uri("ws://localhost:8088/ari/events")
                .password("ren3434")
                .username("ren")
                .build();
        events.createApplication();
        events.setApp("CCID");
        events.setSubscribeAll(true);
        events.createApplication();
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        container.setDefaultMaxBinaryMessageBufferSize(1024 * 1024); // Установите размер буфера по вашему выбору
        container.setDefaultMaxTextMessageBufferSize(1024 * 1024);  // Установите размер буфера по вашему выбору

        container.connectToServer(AriWebSocket.class, URI.create("ws://localhost:8088/ari/events?app=ATC&subscribeAll=true&api_key=ren:ren3434"));

    }
}
