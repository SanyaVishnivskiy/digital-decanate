package com.example.app.api.schedule.Models;

import java.util.List;

public class Schedule {
    private String id;
    private String groupId;
    private List<ScheduleItem> scheduleItems;

    public Schedule(String id, String groupId, List<ScheduleItem> scheduleItems) {
        this.id = id;
        this.groupId = groupId;
        this.scheduleItems = scheduleItems;
    }

    public String getId() {
        return id;
    }

    public String getGroupId() {
        return groupId;
    }

    public List<ScheduleItem> getScheduleItems() {
        return scheduleItems;
    }
}
