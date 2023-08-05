package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  15:09
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Sound {
    String id;
    String text;
    List<Object> formats;
}
