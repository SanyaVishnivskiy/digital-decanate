package com.example.app.api.schedule;

import com.example.app.api.stubs.schedule.ScheduleGatewayStub;

public class ScheduleGatewayFactory {
    public IScheduleGateway create() {
        return new ScheduleGatewayStub();
    }
}
