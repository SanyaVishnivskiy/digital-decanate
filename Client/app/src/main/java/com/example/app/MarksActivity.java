package com.example.app;

import android.os.Bundle;

import com.example.app.api.marks.IMarksGateway;
import com.example.app.api.marks.MarksGatewayFactory;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MarksActivity extends AppCompatActivity {
    IMarksGateway _gateway;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marks_layout);

        _gateway = new MarksGatewayFactory().create();
    }
}
