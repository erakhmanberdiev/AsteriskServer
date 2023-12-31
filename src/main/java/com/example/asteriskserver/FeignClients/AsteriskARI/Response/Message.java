package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;


/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  12:03
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    String type;
    @JsonProperty("asterisk_id")
    String asteriskID;
}