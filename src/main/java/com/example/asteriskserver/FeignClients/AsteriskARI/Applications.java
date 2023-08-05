package com.example.asteriskserver.FeignClients.AsteriskARI;


import com.example.asteriskserver.FeignClients.AsteriskARI.Response.Application;
import com.example.asteriskserver.FeignClients.configuration.FeignClientDefaultConfiguration;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "StasisApplication", url = "${feignClient.baseUrl}/applications", configuration = FeignClientDefaultConfiguration.class)
public interface Applications {
    @GetMapping
    List<Application> listApplications();

    @GetMapping("/{applicationName}")
    Application getApplication(@PathVariable String applicationName);

    @PostMapping("/{applicationName}/subscription")
    Application subscribeToEventSource(@PathVariable String applicationName, @RequestParam List<String> eventSource);

    @DeleteMapping("/{applicationName}/subscription")
    Application unsubscribeFromEventSource(@PathVariable String applicationName, @RequestParam List<String> eventSource);

    @PutMapping("/{applicationName}/eventFilter")
    Application filterApplicationEvents(@PathVariable String applicationName, @RequestBody String filter);
}