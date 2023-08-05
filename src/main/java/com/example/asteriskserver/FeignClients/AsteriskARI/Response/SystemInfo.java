package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;


/**
 * created by  :  erakhmanberdiev
 * created date: 04.08.2023
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class SystemInfo {
    String version;
    @JsonProperty("entity_id")
    String entityId;
}
