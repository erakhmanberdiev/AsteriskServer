package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  14:09
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Channel {
    String  id ;
    @JsonProperty("protocol_id")
    String  protocolID ;
    String  name ;
    String  state ;
    CallerID caller;
    CallerID connected;
    String accountcode;
    DialplanCEP dialplan;
    Date creationtime;
    String language;
    Object channelvars;
}
