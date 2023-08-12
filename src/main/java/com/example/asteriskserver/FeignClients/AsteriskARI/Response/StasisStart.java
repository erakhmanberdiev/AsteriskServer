package com.example.asteriskserver.FeignClients.AsteriskARI.Response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 12.08.2023  14:47
 */

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Getter
@Setter
public class StasisStart extends Event implements Serializable {
    static final long serialVersionUID = 1L;
    List<String> args;
    Channel channel;
    Channel replace_channel;


}
