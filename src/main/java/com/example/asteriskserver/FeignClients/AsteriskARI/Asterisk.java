package com.example.asteriskserver.FeignClients.AsteriskARI;

import com.example.asteriskserver.FeignClients.AsteriskARI.Response.*;
import com.example.asteriskserver.FeignClients.AsteriskARI.Response.Module;
import com.example.asteriskserver.FeignClients.configuration.FeignClientDefaultConfiguration;
import jakarta.annotation.Nullable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  17:24
 */


@FeignClient(name = "Asterisk", url = "${feignClient.baseUrl}/asterisk", configuration = FeignClientDefaultConfiguration.class)
public interface Asterisk {
    @GetMapping("/config/dynamic/{configClass}/{objectType}/{id}")
    List<ConfigTuple> getConfigTuple(@PathVariable String configClass,
                                     @PathVariable String objectType,
                                     @PathVariable String id);

    @PutMapping("/config/dynamic/{configClass}/{objectType}/{id}")
    List<ConfigTuple> putConfigTuple(@PathVariable String configClass,
                                     @PathVariable String objectType,
                                     @PathVariable String id,
                                     @RequestBody List<ConfigTuple> body);

    @DeleteMapping("/config/dynamic/{configClass}/{objectType}/{id}")
    void deleteConfigTuple(@PathVariable String configClass,
                           @PathVariable String objectType,
                           @PathVariable String id);

    @GetMapping("/info")
    AsterIskInfo getInfo(@Nullable
                         @RequestParam(required = false) String only);

    @GetMapping("/info")
    AsterIskInfo getInfo();

    @GetMapping("/ping")
    AsteriskPing getPing();

    @GetMapping("/modules")
    List<Module> getModules();

    @GetMapping("/modules/{moduleName}")
    Module getModule(@PathVariable String moduleName);

    @PostMapping("/modules/{moduleName}")
    void loadModule(@PathVariable String moduleName);

    @DeleteMapping("/modules/{moduleName}")
    void unloadModule(@PathVariable String moduleName);

    @PutMapping("/modules/{moduleName}")
    void reloadModule(@PathVariable String moduleName);

    @GetMapping("/logging")
    List<LogChannel> getLogChannels();

    @PostMapping("/logging/{logChannelName}")
    void addLogChannel(@PathVariable String logChannelName,
                       @RequestParam String configuration);

    @DeleteMapping("/logging/{logChannelName}")
    void deleteLogChannel(@PathVariable String logChannelName);

    @PutMapping("/logging/{logChannelName}/rotate")
    void rotateLogChannel(@PathVariable String logChannelName);

    @GetMapping("/variable")
    Variable getGlobalVar(@RequestParam String variable);

    @PostMapping("/variable")
    void setGlobalVar(@RequestParam String variable,
                      @RequestParam String value);
}
