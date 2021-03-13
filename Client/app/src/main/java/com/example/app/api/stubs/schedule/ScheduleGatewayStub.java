package com.example.app.api.stubs.schedule;

import com.example.app.api.schedule.IScheduleGateway;
import com.example.app.api.schedule.Models.Schedule;

public class ScheduleGatewayStub implements IScheduleGateway {
    @Override
    public Schedule getForGroup(String groupId) {
        return null;
    }

    @Override
    public void addOrUpdate(Schedule schedule) {

    }
}
