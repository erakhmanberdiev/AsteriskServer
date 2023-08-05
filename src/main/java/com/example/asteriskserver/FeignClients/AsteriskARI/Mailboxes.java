package com.example.asteriskserver.FeignClients.AsteriskARI;

import com.example.asteriskserver.FeignClients.AsteriskARI.Response.Mailbox;
import com.example.asteriskserver.FeignClients.configuration.FeignClientDefaultConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  17:34
 */

@FeignClient(name = "Mailboxes",url = "${feignClient.baseUrl}/mailboxes", configuration = FeignClientDefaultConfiguration.class)
public interface Mailboxes {
    @GetMapping
    List<Mailbox> listMailboxes();

    @GetMapping("/{mailboxName}")
    Mailbox getMailbox(@PathVariable String mailboxName);

    @PutMapping("/{mailboxName}")
    void updateMailbox(@PathVariable String mailboxName, @RequestParam int oldMessages, @RequestParam int newMessages);

    @DeleteMapping("/{mailboxName}")
    void deleteMailbox(@PathVariable String mailboxName);
}
