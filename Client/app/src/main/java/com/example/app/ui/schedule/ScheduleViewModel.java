package com.example.app.ui.schedule;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.app.api.groups.GroupGatewayFactory;
import com.example.app.api.groups.IGroupsGateway;
import com.example.app.api.groups.Models.Group;
import com.example.app.api.schedule.IScheduleGateway;
import com.example.app.api.schedule.Models.Schedule;
import com.example.app.api.schedule.ScheduleGatewayFactory;
import com.example.app.logic.user.UserContext;

public class ScheduleViewModel extends ViewModel {
    private IScheduleGateway _gateway;
    private IGroupsGateway _groupGateway;
    private MutableLiveData<Schedule> _schedule;

    public ScheduleViewModel() {
        _gateway = new ScheduleGatewayFactory().create();
        _groupGateway = new GroupGatewayFactory().createGroupListGateway();
        _schedule = new MutableLiveData<>();
    }

    public LiveData<Schedule> getSchedule() {
        String groupId = UserContext.getInstance().getCurrentUser().getGroupId();
        Schedule schedule = _gateway.getForGroup(groupId);

        _schedule.setValue(schedule);
        return _schedule;
    }

    public LiveData<Schedule> getSchedule(String groupName) {
        Group group = _groupGateway.getByName(groupName);
        Schedule schedule = _gateway.getForGroup(group.getId());

        _schedule.setValue(schedule);
        return _schedule;
    }

    public void save(Schedule schedule) {
        Group group = _groupGateway.getByName(schedule.getGroupId());
        schedule.setGroupId(group.getId());
        _gateway.addOrUpdate(schedule);
    }

    public LiveData<Schedule> getLiveData() {
        return _schedule;
    }
}