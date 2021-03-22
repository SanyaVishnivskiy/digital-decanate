package com.example.app.ui.schedule;

import android.widget.TextView;

import java.util.List;

public class ScheduleWithViews {
    private TextView groupId;
    private TextView subGroupId;
    private List<TextView> scheduleItems;

    public TextView getSubGroupId() {
        return subGroupId;
    }

    public void setSubGroupId(TextView subGroupId) {
        this.subGroupId = subGroupId;
    }

    public TextView getGroupId() {
        return groupId;
    }

    public void setGroupId(TextView groupId) {
        this.groupId = groupId;
    }

    public List<TextView> getScheduleItems() {
        return scheduleItems;
    }

    public void setScheduleItems(List<TextView> scheduleItems) {
        this.scheduleItems = scheduleItems;
    }

    public TextView getViewForTag(String tag) {
        for (TextView view: scheduleItems) {
            if(view.getTag().equals(tag)){
                return view;
            }
        }
        return null;
    }
}
