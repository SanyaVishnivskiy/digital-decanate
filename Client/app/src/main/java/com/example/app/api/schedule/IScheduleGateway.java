package com.example.app.api.schedule;

import com.example.app.api.schedule.Models.Schedule;

public interface IScheduleGateway {
    Schedule getForGroup(String groupId);
    void addOrUpdate(Schedule schedule);
}
