package com.example.asteriskserver;

import ch.loway.oss.ari4java.ARI;
import ch.loway.oss.ari4java.tools.ARIException;
import com.example.asteriskserver.FeignClients.AsteriskARI.Applications;
import com.example.asteriskserver.FeignClients.AsteriskARI.Asterisk;
import com.example.asteriskserver.FeignClients.AsteriskARI.Bridges;
import com.example.asteriskserver.FeignClients.ws.AriWebSocket;
import jakarta.annotation.PostConstruct;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.DeploymentException;
import jakarta.websocket.WebSocketContainer;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;

@Service
public class MyService {
    private ARI ari;
    private final Applications applications;
    private final Asterisk asterisk;
    private final Bridges bridges;
    private AriWebSocket webSocket;


    public MyService(Applications applications, Asterisk asterisk, Bridges bridges, AriWebSocket webSocket) {
        this.applications = applications;
        this.asterisk = asterisk;
        this.bridges = bridges;

        this.webSocket = webSocket;
    }

    // Метод, который будет выполнен автоматически после инициализации бина
    @PostConstruct
    public void initialize() throws ARIException, DeploymentException, IOException {
//        Events events = Events.builder()
//                .app("hello2")
//                .uri("ws://localhost:8088/ari/events")
//                .password("ren3434")
//                .username("ren")
//                .build();
//        events.createApplication();
//        events.setApp("CCID");
//        events.setSubscribeAll(true);
//        events.createApplication();
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        container.setDefaultMaxBinaryMessageBufferSize(1024 * 1024); // Установите размер буфера по вашему выбору
        container.setDefaultMaxTextMessageBufferSize(1024 * 1024);  // Установите размер буфера по вашему выбору

        container.connectToServer(webSocket, URI.create("ws://localhost:8088/ari/events?app=hello&subscribeAll=false&api_key=ren:ren3434"));

    }
}
