package com.example.asteriskserver.FeignClients.AsteriskARI;

import com.example.asteriskserver.FeignClients.AsteriskARI.Response.Sound;
import com.example.asteriskserver.FeignClients.configuration.FeignClientDefaultConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  17:28
 */
@FeignClient(name = "Sounds", url = "${feignClient.baseUrl}/sounds", configuration = FeignClientDefaultConfiguration.class)
public interface Sounds {
    @GetMapping("")
    List<Sound> list(@RequestParam(value = "lang", required = false) String lang,
                     @RequestParam(value = "format", required = false) String format);

    @GetMapping("/{soundId}")
    Sound get(@PathVariable("soundId") String soundId);

}
