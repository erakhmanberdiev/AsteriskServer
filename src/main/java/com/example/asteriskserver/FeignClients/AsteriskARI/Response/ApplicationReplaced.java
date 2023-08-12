package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 12.08.2023  14:35
 */
@Getter
@Setter

@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ApplicationReplaced extends Event implements Serializable {
    static final long serialVersionUID = 1L;

    public ApplicationReplaced(String application, Date timestamp) {
        super(application, timestamp);
    }

    public ApplicationReplaced() {
    }
}
