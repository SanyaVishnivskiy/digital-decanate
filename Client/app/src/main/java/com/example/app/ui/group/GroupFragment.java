package com.example.app.ui.group;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.app.R;
import com.example.app.api.user.Models.User;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class GroupFragment extends Fragment {
    GroupViewModel groupViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        groupViewModel = new ViewModelProvider(this).get(GroupViewModel.class);
        View root = inflater.inflate(R.layout.groups_layout,container,false);

        bindSaveButton(root);
        return root;
    }

    private void bindSaveButton(View root) {
        Button button = root.findViewById(R.id.group_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(v);
            }
        });
    }
    private GroupWithViews findAllGroupView(View root){
        GroupWithViews groupWithViews = new GroupWithViews();
        groupWithViews.setHeadid(((TextView)root.findViewById(R.id.group_head)).getText().toString());
        groupWithViews.setNumber(((TextView)root.findViewById(R.id.group_number)).getText().toString());
        groupWithViews.setFaculty(((TextView)root.findViewById(R.id.group_faculty)).getText().toString());
        groupWithViews.setUsers(new ArrayList<User>());
        return groupWithViews;
    }

    public void save(View view) {
        GroupWithViews group = findAllGroupView(view.getRootView());
        groupViewModel.save(group);
    }
}
