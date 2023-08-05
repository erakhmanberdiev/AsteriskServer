package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;


/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  11:50
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Module {
    String name;
    String description;
    @JsonProperty("use_count")
    Integer useCount;
    String status;
    @JsonProperty("support_level")
    String supportLevel;
}
