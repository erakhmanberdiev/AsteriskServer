package com.example.asteriskserver.FeignClients.AsteriskARI;

import com.example.asteriskserver.FeignClients.AsteriskARI.Response.DeviceState;
import com.example.asteriskserver.FeignClients.configuration.FeignClientDefaultConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  17:33
 */
@FeignClient(name = "DeviceStates",url = "${feignClient.baseUrl}/deviceStates", configuration = FeignClientDefaultConfiguration.class)
public interface DeviceStates {
    @GetMapping("")
    List<DeviceState> list();

    @GetMapping("/{deviceName}")
    DeviceState get(@PathVariable("deviceName") String deviceName);

    @PutMapping("/{deviceName}")
    void update(@PathVariable("deviceName") String deviceName, @RequestParam("deviceState") String deviceState);

    @DeleteMapping("/{deviceName}")
    void delete(@PathVariable("deviceName") String deviceName);
}
