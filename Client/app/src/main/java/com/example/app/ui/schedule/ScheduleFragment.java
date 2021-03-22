package com.example.app.ui.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.app.R;
import com.example.app.api.groups.Models.Group;
import com.example.app.api.schedule.Models.Schedule;
import com.example.app.api.schedule.Models.ScheduleItem;
import com.example.app.api.user.Models.User;
import com.example.app.api.user.Models.UserWithChangePasswordModel;
import com.example.app.logic.user.RolesConstants;
import com.example.app.logic.user.UserContext;
import com.example.app.ui.common.ValidationError;
import com.example.app.ui.user.UserModelWithViews;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {
    private ScheduleViewModel viewModel;
    private ScheduleConverter converter;
    private int[] scheduleItemsIds = new int[]{
            R.id.schedule_Mon_1, R.id.schedule_Mon_2, R.id.schedule_Mon_3,
            R.id.schedule_Mon_4, R.id.schedule_Mon_5, R.id.schedule_Mon_6,
            R.id.schedule_Tue_1, R.id.schedule_Tue_2, R.id.schedule_Tue_3,
            R.id.schedule_Tue_4, R.id.schedule_Tue_5, R.id.schedule_Tue_6,
            R.id.schedule_Wed_1, R.id.schedule_Wed_2, R.id.schedule_Wed_3,
            R.id.schedule_Wed_4, R.id.schedule_Wed_5, R.id.schedule_Wed_6,
            R.id.schedule_Thu_1, R.id.schedule_Thu_2, R.id.schedule_Thu_3,
            R.id.schedule_Thu_4, R.id.schedule_Thu_5, R.id.schedule_Thu_6,
            R.id.schedule_Fri_1, R.id.schedule_Fri_2, R.id.schedule_Fri_3,
            R.id.schedule_Fri_4, R.id.schedule_Fri_5, R.id.schedule_Fri_6,
    };
    private Schedule lastFetchedSchedule;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(ScheduleViewModel.class);
        View root = inflater.inflate(R.layout.schedule_layout, container, false);
        converter = new ScheduleConverter();

        bindFetchingSchedule(root);
        bindSearchButton(root);
        bindSaveButton(root);
        initialSearch(root);

        return root;
    }

    private void bindSearchButton(View root) {
        Button button = root.findViewById(R.id.schedule_search_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search(v);
            }
        });
    }

    private void search(View v) {
        View root = v.getRootView();
        TextView group = root.findViewById(R.id.schedule_group);

        viewModel.getSchedule(String.valueOf(group.getText()));
    }

    private void initialSearch(View root) {
        TextView groupView = root.findViewById(R.id.schedule_group);
        TextView subgroupView = root.findViewById(R.id.schedule_subGroup);

        Group group = UserContext.getInstance().getCurrentUserGroup();
        viewModel.getSchedule();

        groupView.setText(group.getNumber());
        subgroupView.setText("1");
    }

    private LiveData<Schedule> getLiveData(){
        try {
            return viewModel.getLiveData();
        } catch(Exception e) {
            return null;
        }
    }

    private void bindSaveButton(View root) {
        Button button = root.findViewById(R.id.schedule_save_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(v);
            }
        });
    }

    private void bindFetchingSchedule(View root) {
        ScheduleWithViews schedule = findAllScheduleItems(root);

        getLiveData().observe(getViewLifecycleOwner(), new Observer<Schedule>() {
            @Override
            public void onChanged(@Nullable Schedule s) {
                disableInputs(schedule);

                if (s == null) {
                    for (TextView item: schedule.getScheduleItems()) {
                        item.setText("");
                    }
                    lastFetchedSchedule = new Schedule("", "", new ArrayList<>());
                    return;
                }

                String subGroup = String.valueOf(schedule.getSubGroupId().getText());

                for (ScheduleItem item: s.getScheduleItemsForSubGroup(subGroup)) {
                    String tag = buildTagFromScheduleItem(item);
                    TextView view = schedule.getViewForTag(tag);
                    if (view != null) {
                        view.setText(scheduleAsText(item));
                    }
                }
                lastFetchedSchedule = s;
            }
        });
    }

    private String buildTagFromScheduleItem(ScheduleItem item) {
        return "schedule_"
                + item.getDay().substring(0, 3) + "_"
                + item.getLessonNumber();
    }

    private String scheduleAsText(ScheduleItem item) {
        return item.getSubjectName() + "\n" +
            item.getRoom() + "\n" +
            item.getType() + "\n" +
            item.getTeacher();
    }

    private ScheduleWithViews findAllScheduleItems(View root) {
        ScheduleWithViews schedule = new ScheduleWithViews();
        schedule.setGroupId(root.findViewById(R.id.schedule_group));
        schedule.setSubGroupId(root.findViewById(R.id.schedule_subGroup));

        List<TextView> items = new ArrayList<>();
        for (int id: scheduleItemsIds) {
            items.add(root.findViewById(id));
        }
        schedule.setScheduleItems(items);

        return schedule;
    }

    private void disableInputs(ScheduleWithViews schedule) {
        String role  = UserContext.getInstance().getCurrentUser().getRole();
        if (!role.equals(RolesConstants.Admin)){
            schedule.getGroupId().setEnabled(false);
            for (TextView view: schedule.getScheduleItems()) {
                view.setEnabled(false);
            }
        }
    }

    public void save(View view) {
        ScheduleWithViews schedule = findAllScheduleItems(view.getRootView());
        Schedule converted = converter.convert(schedule, lastFetchedSchedule);
        saveSafely(converted);
    }

    private void saveSafely(Schedule schedule) {
        try {
            viewModel.save(schedule);
        }
        catch (Exception e) {
            disableError(e.getMessage());
        }
    }

    private void disableError(String message) {
        //TODO: display error somewhere
    }

    private void displayError(ValidationError error) {
        disableError(error.getError());
    }
}
