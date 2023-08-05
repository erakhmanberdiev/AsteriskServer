package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  15:02
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class LiveRecording{
    String name;
    String format;
    @JsonProperty("target_uri")
    String targetUri;
    Integer state;
    Integer duration;
    @JsonProperty("talking_duration")
    Integer talkingDuration;
    @JsonProperty("silence_duration")
    Integer silenceDuration;
    String cause;
}
