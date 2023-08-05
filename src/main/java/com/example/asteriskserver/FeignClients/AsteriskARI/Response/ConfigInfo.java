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
public class ConfigInfo {
    String name;
    @JsonProperty("default_language")
    String defaultLanguage;
    @JsonProperty("max_channels")
    Integer axChannels;
    @JsonProperty("max_open_files")
    Integer maxOpenFiles;
    @JsonProperty("max_load")
    Double maxLoad;
    @JsonProperty("setid")
    SetId setId;



    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @ToString
    public static class SetId{
        String user;
        String group;
    }
}
