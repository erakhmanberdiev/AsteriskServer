package com.example.asteriskserver;

import com.example.asteriskserver.FeignClients.AsteriskARI.Applications;
import com.example.asteriskserver.FeignClients.AsteriskARI.Asterisk;
import com.example.asteriskserver.FeignClients.AsteriskARI.Bridges;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private final Applications applications;
    private final Asterisk asterisk;
    private final Bridges bridges;

    public MyService(Applications applications, Asterisk asterisk, Bridges bridges) {
        this.applications = applications;
        this.asterisk = asterisk;
        this.bridges = bridges;
    }






    // Метод, который будет выполнен автоматически после инициализации бина
    @PostConstruct
    public void initialize() {
        System.out.println(asterisk.getInfo());
        System.out.println(applications.listApplications());
//        System.out.println(bridges.createBridge());
    }
}
