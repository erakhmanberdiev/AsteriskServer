package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  15:22
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Application {
    String name;
    @JsonProperty("channel_ids")
    List<String> channelIDs;
    @JsonProperty("bridge_ids")
    List<String> bridgeIDs;
    @JsonProperty("endpoint_ids")
    List<String> endpointIDs;
    @JsonProperty("device_names")
    List<String> deviceNames;
    @JsonProperty("events_allowed")
    List<Object> eventsAllowed;
    @JsonProperty("events_disallowed")
    List<Object> eventsDisallowed;
}
