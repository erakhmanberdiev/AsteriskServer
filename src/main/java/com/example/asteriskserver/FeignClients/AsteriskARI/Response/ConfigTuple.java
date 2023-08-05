package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;


import java.io.Serializable;
import java.lang.String;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ConfigTuple implements Serializable {
    String attribute;
    String value;
}
