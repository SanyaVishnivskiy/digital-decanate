package com.example.app.api.schedule.Models;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private String id;

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

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

    public List<ScheduleItem> getScheduleItemsForSubGroup(String subGroup) {
        List<ScheduleItem> items = new ArrayList<>();
        for (ScheduleItem i: scheduleItems) {
            if (String.valueOf(i.getSubgroup()).equals(subGroup)) {
                items.add(i);
            }
        }

        return items;
    }

    public void removeForSubGroup(String subGroup) {
        List<ScheduleItem> itemsToRemove = new ArrayList<>();
        for (ScheduleItem i: scheduleItems) {
            if (String.valueOf(i.getSubgroup()).equals(subGroup)) {
                itemsToRemove.add(i);
            }
        }

        scheduleItems.removeAll(itemsToRemove);
    }
}
