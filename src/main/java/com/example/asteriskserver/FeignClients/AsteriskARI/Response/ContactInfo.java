package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 12.08.2023  18:38
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ContactInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    String aor;
    String contact_status;
    String roundtrip_usec;
    String uri;
}
