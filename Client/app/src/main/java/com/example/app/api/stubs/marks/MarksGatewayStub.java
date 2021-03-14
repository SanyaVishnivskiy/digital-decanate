package com.example.app.api.stubs.marks;

import com.example.app.api.marks.IMarksGateway;
import com.example.app.api.marks.Models.Marks;

public class MarksGatewayStub implements IMarksGateway {
    @Override
    public Marks getForGroup(String groupId) {
        return null;
    }

    @Override
    public void addOrUpdate(Marks marks) {

    }
}
