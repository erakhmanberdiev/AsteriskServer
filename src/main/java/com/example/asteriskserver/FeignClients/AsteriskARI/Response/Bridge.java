package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  14:52
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Bridge {
    String id;
    String technology;
    @JsonProperty("bridge_type")
    String bridgeType;
    @JsonProperty("bridge_class")
    String bridgeClass;
    String creator;
    String name;
    List<String> channels;
    @JsonProperty("video_mode")
    String videoMode;
    @JsonProperty("video_source_id")
    String videoSourceId;
    Date creationtime;
}
