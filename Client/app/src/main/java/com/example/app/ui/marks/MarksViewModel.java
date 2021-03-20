package com.example.app.ui.marks;

import com.example.app.api.marks.IMarksGateway;
import com.example.app.api.marks.MarksGatewayFactory;
import com.example.app.api.marks.Models.Marks;
import com.example.app.api.user.Models.User;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MarksViewModel extends ViewModel {
    private final IMarksGateway _gateway;
    private MutableLiveData<Marks> _marks;
    public  MarksViewModel(){
        _gateway = new MarksGatewayFactory().create();
        _marks = new MutableLiveData<>();
    }
    public LiveData<Marks> getMarks(){
        Marks marks = _gateway.getForGroup("1");
        _marks.setValue(marks);
        return _marks;
    }
}
