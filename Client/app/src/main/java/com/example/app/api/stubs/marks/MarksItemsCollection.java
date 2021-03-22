package com.example.app.api.stubs.marks;

import com.example.app.api.groups.Models.Group;
import com.example.app.api.marks.Models.MarksItem;
import com.example.app.api.stubs.groups.GroupsCollection;
import com.example.app.api.stubs.user.UsersCollection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MarksItemsCollection {
    private List<MarksItem> marksitems = new ArrayList<MarksItem>();

    private static MarksItemsCollection instance = new MarksItemsCollection();

    public static MarksItemsCollection getInstance() {
        return instance;
    }

    private MarksItemsCollection() {
        Init();
    }

    private void Init(){

    }

    public MarksItem getById(String id) {
        return marksitems.get(Byte.valueOf(id));
    }

    public void Add(MarksItem item) {
        marksitems.add(item);
    }

    public List<MarksItem> getAll(){
        return marksitems;
    }
}
