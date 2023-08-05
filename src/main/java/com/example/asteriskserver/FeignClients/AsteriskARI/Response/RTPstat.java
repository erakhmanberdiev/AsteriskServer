package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  14:24
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class RTPstat {
    Integer txcount;
    Integer rxcount;
    Double txjitter;
    Double rxjitter;
    @JsonProperty("remote_maxjitter")
    Double remoteMaxJitter;
    @JsonProperty("remote_minjitter")
    Double remoteMinJitter;
    @JsonProperty("remote_normdevjitter")
    Double remoteNormDevJitter;
    @JsonProperty("remote_stdevjitter")
    Double remoteStDevJitter;
    @JsonProperty("local_maxjitter")
    Double localMaxJitter;
    @JsonProperty("local_minjitter")
    Double localMinJitter;
    @JsonProperty("local_normdevjitter")
    Double localNormDevJitter;
    @JsonProperty("local_stdevjitter")
    Double localStDevJitter;
    Integer txploss;
    Integer rxploss;
    @JsonProperty("remote_maxrxploss")
    Double remoteMaxRXploss;
    @JsonProperty("remote_minrxploss")
    Double remoteMinrXPloss;
    @JsonProperty("remote_normdevrxploss")
    Double remoteNormDevRXploss;
    @JsonProperty("remote_stdevrxploss")
    Double remoteStDevRXploss;
    @JsonProperty("local_maxrxploss")
    Double localMaxRXploss;
    @JsonProperty("local_minrxploss")
    Double localMinrXPloss;
    @JsonProperty("local_normdevrxploss")
    Double localSormDevRXploss;
    @JsonProperty("local_stdevrxploss")
    Double localStDevRXploss;
    Double rtt;
    Double maxrtt;
    Double minrtt;
    Double normdevrtt;
    Double stdevrtt;
    @JsonProperty("local_ssrc")
    Integer localSsrc;
    @JsonProperty("remote_ssrc")
    Integer remoteSsrc;
    Integer txoctetcount;
    Integer rxoctetcount;
    @JsonProperty("channel_uniqueid")
    String channelUniqueId;
}
