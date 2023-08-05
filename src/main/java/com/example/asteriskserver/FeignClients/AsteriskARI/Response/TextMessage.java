package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  16:24
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class TextMessage {
    String body;
    String from;
    String to;
    Object variables;
}
