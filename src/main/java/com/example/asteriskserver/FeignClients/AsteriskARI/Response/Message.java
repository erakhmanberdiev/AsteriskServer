package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;


/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  12:03
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Message {
    String type;
    @JsonProperty("channel_id")
    String channelID;
}
