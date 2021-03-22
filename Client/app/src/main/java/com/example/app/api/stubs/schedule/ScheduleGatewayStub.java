package com.example.app.api.stubs.schedule;

import com.example.app.api.schedule.IScheduleGateway;
import com.example.app.api.schedule.Models.Schedule;

public class ScheduleGatewayStub implements IScheduleGateway {
    @Override
    public Schedule getForGroup(String groupId) {
        return ScheduleCollection.getInstance().getForGroup(groupId);
    }

    @Override
    public void addOrUpdate(Schedule schedule) {
        ScheduleCollection.getInstance().addOrUpdate(schedule);
    }
}
