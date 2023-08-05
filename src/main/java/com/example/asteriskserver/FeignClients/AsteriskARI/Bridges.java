package com.example.asteriskserver.FeignClients.AsteriskARI;

import com.example.asteriskserver.FeignClients.AsteriskARI.Response.Bridge;
import com.example.asteriskserver.FeignClients.AsteriskARI.Response.LiveRecording;
import com.example.asteriskserver.FeignClients.AsteriskARI.Response.Playback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  17:26
 */


@FeignClient(name = "asteriskARI", url = "${feignClient.baseUrl}/bridges")
public interface Bridges {
    @GetMapping("")
    List<Bridge> listBridges();

    @PostMapping("")
    Bridge createBridge(@RequestParam(value = "type", required = false) String type,
                        @RequestParam(value = "bridgeId", required = false) String bridgeId,
                        @RequestParam(value = "name", required = false) String name);

    @PostMapping("/{bridgeId}")
    Bridge createBridgeWithId(@PathVariable("bridgeId") String bridgeId,
                              @RequestParam(value = "type", required = false) String type,
                              @RequestParam(value = "name", required = false) String name);

    @GetMapping("/{bridgeId}")
    Bridge getBridge(@PathVariable("bridgeId") String bridgeId);

    @DeleteMapping("/{bridgeId}")
    void destroyBridge(@PathVariable("bridgeId") String bridgeId);

    @PostMapping("/{bridgeId}/addChannel")
    void addChannelToBridge(@PathVariable("bridgeId") String bridgeId,
                            @RequestParam("channel") List<String> channel,
                            @RequestParam(value = "role", required = false) String role,
                            @RequestParam(value = "absorbDTMF", defaultValue = "false") boolean absorbDTMF,
                            @RequestParam(value = "mute", defaultValue = "false") boolean mute,
                            @RequestParam(value = "inhibitConnectedLineUpdates", defaultValue = "false") boolean inhibitConnectedLineUpdates);

    @PostMapping("/{bridgeId}/removeChannel")
    void removeChannelFromBridge(@PathVariable("bridgeId") String bridgeId,
                                 @RequestParam("channel") List<String> channel);

    @PostMapping("/{bridgeId}/videoSource/{channelId}")
    void setVideoSource(@PathVariable("bridgeId") String bridgeId,
                        @PathVariable("channelId") String channelId);

    @DeleteMapping("/{bridgeId}/videoSource")
    void clearVideoSource(@PathVariable("bridgeId") String bridgeId);

    @PostMapping("/{bridgeId}/moh")
    void startMoh(@PathVariable("bridgeId") String bridgeId,
                  @RequestParam(value = "mohClass", required = false) String mohClass);

    @DeleteMapping("/{bridgeId}/moh")
    void stopMoh(@PathVariable("bridgeId") String bridgeId);

    @PostMapping("/{bridgeId}/play")
    Playback play(@PathVariable("bridgeId") String bridgeId,
                  @RequestParam("media") List<String> media,
                  @RequestParam(value = "lang", required = false) String lang,
                  @RequestParam(value = "offsetms", defaultValue = "0") int offsetms,
                  @RequestParam(value = "skipms", defaultValue = "3000") int skipms,
                  @RequestParam(value = "playbackId", required = false) String playbackId);

    @PostMapping("/{bridgeId}/play/{playbackId}")
    Playback playWithId(@PathVariable("bridgeId") String bridgeId,
                        @PathVariable("playbackId") String playbackId,
                        @RequestParam("media") List<String> media,
                        @RequestParam(value = "lang", required = false) String lang,
                        @RequestParam(value = "offsetms", defaultValue = "0") int offsetms,
                        @RequestParam(value = "skipms", defaultValue = "3000") int skipms);

    @PostMapping("/{bridgeId}/record")
    LiveRecording record(@PathVariable("bridgeId") String bridgeId,
                         @RequestParam("name") String name,
                         @RequestParam("format") String format,
                         @RequestParam(value = "maxDurationSeconds", defaultValue = "0") int maxDurationSeconds,
                         @RequestParam(value = "maxSilenceSeconds", defaultValue = "0") int maxSilenceSeconds,
                         @RequestParam(value = "ifExists", defaultValue = "fail") String ifExists,
                         @RequestParam(value = "beep", defaultValue = "false") boolean beep,
                         @RequestParam(value = "terminateOn", defaultValue = "none") String terminateOn);

}
