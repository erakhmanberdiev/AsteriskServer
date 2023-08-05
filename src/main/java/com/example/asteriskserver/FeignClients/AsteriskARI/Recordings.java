package com.example.asteriskserver.FeignClients.AsteriskARI;

import com.example.asteriskserver.FeignClients.AsteriskARI.Response.LiveRecording;
import com.example.asteriskserver.FeignClients.AsteriskARI.Response.StoredRecording;
import com.example.asteriskserver.FeignClients.configuration.FeignClientDefaultConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  17:27
 */

@FeignClient(name = "Recordings",url = "${feignClient.baseUrl}/recordings", configuration = FeignClientDefaultConfiguration.class)
public interface Recordings {
    @GetMapping("/stored")
    List<StoredRecording> listStored();

    @GetMapping("/stored/{recordingName}")
    StoredRecording getStored(@PathVariable String recordingName);

    @DeleteMapping("/stored/{recordingName}")
    void deleteStored(@PathVariable String recordingName);

    @GetMapping("/stored/{recordingName}/file")
    byte[] getStoredFile(@PathVariable String recordingName);

    @PostMapping("/stored/{recordingName}/copy")
    StoredRecording copyStored(@PathVariable String recordingName,
                               @RequestParam("destinationRecordingName") String destinationRecordingName);

    @GetMapping("/live/{recordingName}")
    LiveRecording getLive(@PathVariable String recordingName);

    @DeleteMapping("/live/{recordingName}")
    void cancel(@PathVariable String recordingName);

    @PostMapping("/live/{recordingName}/stop")
    void stop(@PathVariable String recordingName);

    @PostMapping("/live/{recordingName}/pause")
    void pause(@PathVariable String recordingName);

    @DeleteMapping("/live/{recordingName}/pause")
    void unpause(@PathVariable String recordingName);

    @PostMapping("/live/{recordingName}/mute")
    void mute(@PathVariable String recordingName);

    @DeleteMapping("/live/{recordingName}/mute")
    void unmute(@PathVariable String recordingName);
}
