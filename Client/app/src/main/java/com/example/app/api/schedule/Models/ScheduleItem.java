package com.example.app.api.schedule.Models;

public class ScheduleItem {
    private String id;
    private String teacher;
    private String subjectName;
    private String room;
    private String lessonNumber;
    private String day;
    private int subgroup;
    private String type;

    public ScheduleItem(String id, String teacher, String subjectName, String room, String lessonNumber, String day, int subgroup, String type) {
        this.id = id;
        this.teacher = teacher;
        this.subjectName = subjectName;
        this.room = room;
        this.lessonNumber = lessonNumber;
        this.day = day;
        this.subgroup = subgroup;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getRoom() {
        return room;
    }

    public String getLessonNumber() {
        return lessonNumber;
    }

    public String getDay() {
        return day;
    }

    public int getSubgroup() {
        return subgroup;
    }

    public String getType() {
        return type;
    }
}
