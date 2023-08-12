package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 12.08.2023  18:02
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString

public class BridgeMerged extends Event implements Serializable {
    static final long serialVersionUID = 1L;
    Bridge bridge;
    Bridge bridge_from;
}
