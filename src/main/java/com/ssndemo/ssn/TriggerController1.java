package com.ssndemo.ssn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TriggerController1 {

    @Autowired
    private EventStreamController eventStreamController;

    @RequestMapping("api/checkin1")
    @CrossOrigin(origins = "*")
    public void triggerEvent() {
        //eventStreamController.streamEvents();
    }
}
