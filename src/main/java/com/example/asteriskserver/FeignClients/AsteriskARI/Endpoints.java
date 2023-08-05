package com.example.asteriskserver.FeignClients.AsteriskARI;

import com.example.asteriskserver.FeignClients.AsteriskARI.Response.Endpoint;
import com.example.asteriskserver.FeignClients.configuration.FeignClientDefaultConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  17:24
 */

@FeignClient(name = "Endpoints",url = "${feignClient.baseUrl}/endpoints", configuration = FeignClientDefaultConfiguration.class)
public interface Endpoints {
    @GetMapping("")
    List<Endpoint> listEndpoints();

    @PutMapping("/sendMessage")
    void sendMessage(@RequestParam String to,
                     @RequestParam String from,
                     @RequestParam(required = false) String body,
                     @RequestBody(required = false) String  variables);

    @GetMapping("/{tech}")
    List<Endpoint> listEndpointsByTech(@PathVariable String tech);

    @GetMapping("/{tech}/{resource}")
    Endpoint getEndpoint(@PathVariable String tech, @PathVariable String resource);

    @PutMapping("/{tech}/{resource}/sendMessage")
    void sendMessageToEndpoint(@PathVariable String tech,
                               @PathVariable String resource,
                               @RequestParam String from,
                               @RequestParam(required = false) String body,
                               @RequestBody(required = false) String variables);

}
