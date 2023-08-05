package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  14:13
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class DialplanCEP {
    String context;
    String exten;
    Long priority;
    @JsonProperty("app_name")
    String appName;
    @JsonProperty("app_data")
    String appData;
}
