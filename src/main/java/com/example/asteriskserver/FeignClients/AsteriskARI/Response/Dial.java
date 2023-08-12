package com.example.asteriskserver.FeignClients.AsteriskARI.Response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 12.08.2023  18:41
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Dial extends Event implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    Channel caller;
    String dialstatus;
    String dialstring;
    String forward;
    Channel forwarded;
    Channel peer;
}
