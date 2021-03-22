package com.example.app.api.marks;

import com.example.app.api.stubs.marks.MarksGatewayStub;

public class MarksGatewayFactory {
    public IMarksGateway create() {
        return new MarksGatewayStub();
    }
}
