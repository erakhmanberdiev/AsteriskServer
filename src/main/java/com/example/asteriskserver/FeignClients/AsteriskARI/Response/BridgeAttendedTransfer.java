package com.example.asteriskserver.FeignClients.AsteriskARI.Response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 12.08.2023  14:38
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class BridgeAttendedTransfer extends Event implements Serializable {
    static final long serialVersionUID = 1L;
    String destination_application;
    String destination_bridge;
    Channel destination_link_first_leg;
    Channel destination_link_second_leg;
    Bridge destination_threeway_bridge;
    Channel destination_threeway_channel;
    String destination_type;
    Boolean is_external;
    Channel replace_channel;
    String result;
    Channel transferer_first_leg;
    Channel transferer_second_leg;
    Bridge transferer_second_leg_bridge;

}
