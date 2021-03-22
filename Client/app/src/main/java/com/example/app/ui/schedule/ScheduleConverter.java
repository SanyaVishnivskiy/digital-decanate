package com.example.app.ui.schedule;

import android.widget.TextView;

import com.example.app.api.schedule.Models.Schedule;
import com.example.app.api.schedule.Models.ScheduleItem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ScheduleConverter {
    public Schedule convert(ScheduleWithViews schedule, Schedule lastFetchedSchedule) {
        String subGroup = String.valueOf(schedule.getSubGroupId().getText());

        lastFetchedSchedule.removeForSubGroup(subGroup);
        lastFetchedSchedule.getScheduleItems().addAll(
            convertItems(
                schedule.getScheduleItems(),
                subGroup
        ));

        return new Schedule(
            "",
            String.valueOf(schedule.getGroupId().getText()),
            lastFetchedSchedule.getScheduleItems()
        );
    }

    private List<ScheduleItem> convertItems(List<TextView> scheduleItems, String subGroupId) {
        List<ScheduleItem> items = new ArrayList<>();
        for (TextView view: scheduleItems) {
            String text = String.valueOf(view.getText());
            if (text.equals(""))
            {
                continue;
            }

            items.add(parseItem(view, text, subGroupId));
        }
        return items;
    }

    private ScheduleItem parseItem(TextView view, String text, String subGroupId) {

        String[] chunks = text.split("\n");
        String[] lessonTime = String.valueOf(view.getTag())
                .split("_");
        return new ScheduleItem(
                "",
                Array.get(chunks,3).toString(),
                Array.get(chunks,0).toString(),
                Array.get(chunks,2).toString(),
                Array.get(lessonTime, 2).toString(),
                Array.get(lessonTime,1).toString(),
                Integer.parseInt(subGroupId),
                Array.get(chunks, 1).toString()
        );
    }
}
