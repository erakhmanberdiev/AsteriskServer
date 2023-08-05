package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.util.Date;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  11:33
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class StatusInfo {
    @JsonProperty("startup_time")
    Date startupTime;
    @JsonProperty("last_reload_time")
    Date lastReloadTime;
}
