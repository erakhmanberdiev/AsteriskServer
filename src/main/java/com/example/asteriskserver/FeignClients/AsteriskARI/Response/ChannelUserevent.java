package com.example.asteriskserver.FeignClients.AsteriskARI.Response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 12.08.2023  18:31
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString

public class ChannelUserevent extends Event implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    Channel channel;
    Bridge bridge;
    Endpoint endpoint;
    String eventname;
    Object userevent;

}