package com.example.app.ui.common;

import android.widget.TextView;

public class ValidationError {
    public ValidationError(String error, TextView view) {
        Error = error;
        this.view = view;
    }

    public String getError() {
        return Error;
    }

    public TextView getView() {
        return view;
    }

    private String Error;
    private TextView view;
}
