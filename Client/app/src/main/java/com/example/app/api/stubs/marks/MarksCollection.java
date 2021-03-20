package com.example.app.api.stubs.marks;

import com.example.app.api.marks.Models.Marks;
import com.example.app.api.marks.Models.MarksItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarksCollection {
    private List<Marks> marks = new ArrayList<Marks>();

    private static MarksCollection instance = new MarksCollection();

    public static MarksCollection getInstance() {
        return instance;
    }

    private MarksCollection() {
        Init();
    }

    private void Init(){
        marks.add(new Marks("1","1",MarksItemsCollection.getInstance().getAll()));
        }

    public Marks getByGroupId(String id) {
        return marks.get(Byte.valueOf(id));
    }

    public void Add(Marks marks) {
        this.marks.add(marks);
    }

    public List<Marks> getAll(){
        return marks;
    }
}
