package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;


/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  11:55
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LogChannel {
    String channel;
    String type;
    String status;
    String configuration;
}
