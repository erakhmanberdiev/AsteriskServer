package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 12.08.2023  14:20
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Event extends Message implements Serializable {
    static final long serialVersionUID = 1L;
    String application;
    Date timestamp;

}
