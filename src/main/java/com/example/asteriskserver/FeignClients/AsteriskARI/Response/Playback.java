package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  15:14
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Playback {
    String id;
    @JsonProperty("media_uri")
    String mediaUri;
    @JsonProperty("next_media_uri")
    String nextMediaUri;
    @JsonProperty("target_uri")
    String targetUri;
    String language;
    String state;
}
