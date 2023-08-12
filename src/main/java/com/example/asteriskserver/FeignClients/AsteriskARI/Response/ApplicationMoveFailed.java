package com.example.asteriskserver.FeignClients.AsteriskARI.Response;

import ch.loway.oss.ari4java.generated.models.Channel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 12.08.2023  14:31
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ApplicationMoveFailed extends Event implements Serializable {
    static final long serialVersionUID = 1L;
    List<String> args;
    Channel channel;
    String destination;

}
