package com.example.asteriskserver.FeignClients.AsteriskARI;

import com.example.asteriskserver.FeignClients.configuration.FeignClientDefaultConfiguration;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 05.08.2023  17:52
 */
@FeignClient(name = "StasisApplication", url = "ws://localhost:8088/ari/events", configuration = FeignClientDefaultConfiguration.class)

public interface Events {
    @RequestLine("GET")
    @Headers("Upgrade: websocket")
    void connect();

    @RequestLine("SEND")
    void send(String message);

    @RequestLine("CLOSE")
    void close();
}
