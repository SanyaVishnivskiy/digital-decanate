package com.example.app.api.marks.Models;

import java.util.List;

public class Marks {
    private String id;
    private String groupId;
    private List<MarksItem> marksItems;

    public Marks(String id, String groupId, List<MarksItem> marksItems) {
        this.id = id;
        this.groupId = groupId;
        this.marksItems = marksItems;
    }

    public String getId() {
        return id;
    }

    public String getGroupId() {
        return groupId;
    }

    public List<MarksItem> getMarksItems() {
        return marksItems;
    }
}
