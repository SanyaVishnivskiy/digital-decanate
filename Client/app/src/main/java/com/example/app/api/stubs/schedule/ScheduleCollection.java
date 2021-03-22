package com.example.app.api.stubs.schedule;

import com.example.app.api.schedule.Models.Schedule;

import java.util.HashMap;
import java.util.List;

public class ScheduleCollection {
    private HashMap<String, Schedule> schedules = new HashMap<>();

    private static ScheduleCollection instance = new ScheduleCollection();

    public static ScheduleCollection getInstance() {
        return instance;
    }

    public void init(List<Schedule> schedules){
        for (Schedule s: schedules) {
            addOrUpdate(s);
        }
    }

    public Schedule getForGroup(String groupId) {
        return schedules.get(groupId);
    }

    public void addOrUpdate(Schedule s) {
        schedules.put(s.getGroupId(), s);
    }
}
