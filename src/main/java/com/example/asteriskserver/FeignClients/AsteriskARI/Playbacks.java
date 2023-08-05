package com.example.asteriskserver.FeignClients.AsteriskARI;

import com.example.asteriskserver.FeignClients.AsteriskARI.Response.Playback;
import com.example.asteriskserver.FeignClients.configuration.FeignClientDefaultConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  17:28
 */
@FeignClient(name = "Playbacks",url = "${feignClient.baseUrl}/playbacks", configuration = FeignClientDefaultConfiguration.class)
public interface Playbacks {
    @GetMapping("/{playbackId}")
    Playback getPlaybackDetails(@PathVariable String playbackId);

    @DeleteMapping("/{playbackId}")
    void stopPlayback(@PathVariable String playbackId);

    @PostMapping("/{playbackId}/control")
    void controlPlayback(@PathVariable String playbackId, @RequestParam String operation);
}
