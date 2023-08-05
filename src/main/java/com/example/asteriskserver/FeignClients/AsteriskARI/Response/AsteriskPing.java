package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;


/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  11:37
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class AsteriskPing {
    @JsonProperty("asterisk_id")
    String asteriskId;
    String ping;
    String timestamp;

}
