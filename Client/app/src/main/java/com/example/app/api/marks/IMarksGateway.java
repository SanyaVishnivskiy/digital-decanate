package com.example.app.api.marks;

import com.example.app.api.marks.Models.Marks;

public interface IMarksGateway {
    Marks getForGroup(String groupId);
    void addOrUpdate(Marks marks);
}
