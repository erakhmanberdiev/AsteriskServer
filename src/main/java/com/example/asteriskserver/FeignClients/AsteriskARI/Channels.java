package com.example.asteriskserver.FeignClients.AsteriskARI;

import com.example.asteriskserver.FeignClients.AsteriskARI.Response.*;
import com.example.asteriskserver.FeignClients.configuration.FeignClientDefaultConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  17:25
 */
@FeignClient(name = "Channels",url = "${feignClient.baseUrl}/channels", configuration = FeignClientDefaultConfiguration.class)
public interface Channels {
    @GetMapping("")
    List<Channel> listChannels();

    @PostMapping("")
    Channel createChannel(@RequestParam("endpoint") String endpoint,
                          @RequestParam(value = "extension", required = false) String extension,
                          @RequestParam(value = "context", required = false) String context,
                          @RequestParam(value = "priority", required = false) Long priority,
                          @RequestParam(value = "label", required = false) String label,
                          @RequestParam(value = "app", required = false) String app,
                          @RequestParam(value = "appArgs", required = false) String appArgs,
                          @RequestParam(value = "callerId", required = false) String callerId,
                          @RequestParam(value = "timeout", defaultValue = "30") int timeout,
                          @RequestBody(required = false) String variables,
                          @RequestParam(value = "channelId", required = false) String channelId,
                          @RequestParam(value = "otherChannelId", required = false) String otherChannelId,
                          @RequestParam(value = "originator", required = false) String originator,
                          @RequestParam(value = "formats", required = false) String formats);

    @GetMapping("/{channelId}")
    Channel getChannel(@PathVariable("channelId") String channelId);

    @PostMapping("/{channelId}/continue")
    void continueInDialplan(@PathVariable("channelId") String channelId,
                            @RequestParam(value = "context", required = false) String context,
                            @RequestParam(value = "extension", required = false) String extension,
                            @RequestParam(value = "priority", required = false) Integer priority,
                            @RequestParam(value = "label", required = false) String label);

    @PostMapping("/{channelId}/move")
    void moveChannel(@PathVariable("channelId") String channelId,
                     @RequestParam("app") String app,
                     @RequestParam(value = "appArgs", required = false) String appArgs);

    @PostMapping("/{channelId}/redirect")
    void redirectChannel(@PathVariable("channelId") String channelId,
                         @RequestParam("endpoint") String endpoint);

    @PostMapping("/{channelId}/answer")
    void answerChannel(@PathVariable("channelId") String channelId);

    @PostMapping("/{channelId}/ring")
    void indicateRinging(@PathVariable("channelId") String channelId);

    @DeleteMapping("/{channelId}/ring")
    void stopRinging(@PathVariable("channelId") String channelId);

    @PostMapping("/{channelId}/dtmf")
    void sendDTMF(@PathVariable("channelId") String channelId,
                  @RequestParam("dtmf") String dtmf,
                  @RequestParam(value = "before", defaultValue = "0") int before,
                  @RequestParam(value = "between", defaultValue = "100") int between,
                  @RequestParam(value = "duration", defaultValue = "100") int duration,
                  @RequestParam(value = "after", defaultValue = "0") int after);

    @PostMapping("/{channelId}/mute")
    void muteChannel(@PathVariable("channelId") String channelId,
                     @RequestParam(value = "direction", defaultValue = "both") String direction);

    @DeleteMapping("/{channelId}/mute")
    void unmuteChannel(@PathVariable("channelId") String channelId,
                       @RequestParam(value = "direction", defaultValue = "both") String direction);

    @PostMapping("/{channelId}/hold")
    void holdChannel(@PathVariable("channelId") String channelId);

    @DeleteMapping("/channels/{channelId}/hold")
    void unholdChannel(@PathVariable("channelId") String channelId);

    @PostMapping("/{channelId}/moh")
    void startMusicOnHold(@PathVariable("channelId") String channelId,
                          @RequestParam(value = "mohClass", required = false) String mohClass);

    @DeleteMapping("/{channelId}/moh")
    void stopMusicOnHold(@PathVariable("channelId") String channelId);
    @PostMapping("/{channelId}/silence")
    void startSilence(@PathVariable("channelId") String channelId);

    @DeleteMapping("/{channelId}/silence")
    void stopSilence(@PathVariable("channelId") String channelId);

    @PostMapping("/{channelId}/play")
    Playback play(@PathVariable("channelId") String channelId,
                  @RequestParam("media") List<String> media,
                  @RequestParam(required = false) String lang,
                  @RequestParam(required = false) Integer offsetms,
                  @RequestParam(required = false, defaultValue = "3000") Integer skipms,
                  @RequestParam(required = false) String playbackId);

    @PostMapping("/{channelId}/play/{playbackId}")
    Playback playWithId(@PathVariable("channelId") String channelId,
                        @PathVariable("playbackId") String playbackId,
                        @RequestParam("media") List<String> media,
                        @RequestParam(required = false) String lang,
                        @RequestParam(required = false) Integer offsetms,
                        @RequestParam(required = false, defaultValue = "3000") Integer skipms);

    @PostMapping("/{channelId}/record")
    LiveRecording record(@PathVariable("channelId") String channelId,
                         @RequestParam String name,
                         @RequestParam String format,
                         @RequestParam(required = false, defaultValue = "0") Integer maxDurationSeconds,
                         @RequestParam(required = false, defaultValue = "0") Integer maxSilenceSeconds,
                         @RequestParam(required = false, defaultValue = "fail") String ifExists,
                         @RequestParam(required = false, defaultValue = "false") boolean beep,
                         @RequestParam(required = false, defaultValue = "none") String terminateOn);

    @GetMapping("/{channelId}/variable")
    Variable getChannelVar(@PathVariable("channelId") String channelId,
                           @RequestParam String variable);

    @PostMapping("/{channelId}/variable")
    void setChannelVar(@PathVariable("channelId") String channelId,
                       @RequestParam String variable,
                       @RequestParam(required = false) String value);

    @PostMapping("/{channelId}/snoop")
    Channel snoopChannel(@PathVariable("channelId") String channelId,
                         @RequestParam(required = false, defaultValue = "none") String spy,
                         @RequestParam(required = false, defaultValue = "none") String whisper,
                         @RequestParam String app,
                         @RequestParam(required = false) String appArgs,
                         @RequestParam(required = false) String snoopId);

    @PostMapping("/{channelId}/snoop/{snoopId}")
    Channel snoopChannelWithId(@PathVariable("channelId") String channelId,
                               @PathVariable("snoopId") String snoopId,
                               @RequestParam(required = false, defaultValue = "none") String spy,
                               @RequestParam(required = false, defaultValue = "none") String whisper,
                               @RequestParam String app, @RequestParam(required = false) String appArgs);

    @PostMapping("/{channelId}/dial")
    void dial(@PathVariable("channelId") String channelId,
              @RequestParam(required = false) String caller,
              @RequestParam(required = false, defaultValue = "0") int timeout);

    @RequestMapping(method = RequestMethod.GET, value = "/{channelId}/rtp_statistics")
    RTPstat getRtpStatistics(@PathVariable("channelId") String channelId);

    @RequestMapping(method = RequestMethod.POST, value = "/externalMedia")
    Channel startExternalMediaSession(@RequestParam(value = "channelId", required = false) String channelId,
                                      @RequestParam("app") String app,
                                      @RequestBody String variables,
                                      @RequestParam("external_host") String externalHost,
                                      @RequestParam(value = "encapsulation", defaultValue = "rtp") String encapsulation,
                                      @RequestParam(value = "transport", defaultValue = "udp") String transport,
                                      @RequestParam(value = "connection_type", defaultValue = "client") String connectionType,
                                      @RequestParam("format") String format,
                                      @RequestParam(value = "direction", defaultValue = "both") String direction,
                                      @RequestParam(value = "data", required = false) String data);
}
