package com.example.app.ui.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.app.R;
import com.example.app.api.user.Models.UserWithChangePasswordModel;
import com.example.app.api.user.Models.UserWithPassword;
import com.example.app.logic.user.RolesConstants;
import com.example.app.ui.common.ValidationError;
import com.example.app.api.user.Models.User;

public class UserFragment extends Fragment {
    private UserViewModel userViewModel;
    private UserConverter converter;
    private UserValidator validator;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        View root = inflater.inflate(R.layout.user_profile_layout, container, false);
        converter = new UserConverter();
        validator = new UserValidator();

        bindFetchingUser(root);
        bindSaveButton(root);

        return root;
    }

    private void bindSaveButton(View root) {
        Button button = root.findViewById(R.id.user_save_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(v);
            }
        });
    }

    private void bindFetchingUser(View root) {
        UserModelWithViews user = findAllUserViews(root);

        getUser().observe(getViewLifecycleOwner(), new Observer<User>() {
            @Override
            public void onChanged(@Nullable User s) {
                if (s == null)
                    return;

                user.getId().setText(s.getId());
                user.getName().setText(s.getName());
                user.getLastName().setText(s.getLastName());
                user.getFaculty().setText(s.getFaculty());
                user.getGroupName().setText(s.getGroupId());
                user.getCourse().setText(s.getCourse() + "");
                user.getStudentTicket().setText(s.getStudentTicket());
                user.getEmail().setText(s.getEmail());
                user.getPhoneNumber().setText(s.getPhoneNumber());
                user.getRole().setText(s.getRole());

                disableInputs(s, user);
            }
        });
    }

    private UserModelWithViews findAllUserViews(View root) {
        UserModelWithViews user = new UserModelWithViews();
        user.setId(root.findViewById(R.id.user_id));
        user.setName(root.findViewById(R.id.user_name));
        user.setLastName(root.findViewById(R.id.user_lastName));
        user.setFaculty(root.findViewById(R.id.user_faculty));
        user.setGroupName(root.findViewById(R.id.user_group));
        user.setCourse(root.findViewById(R.id.user_course));
        user.setStudentTicket(root.findViewById(R.id.user_student_ticket));
        user.setEmail(root.findViewById(R.id.user_email));
        user.setPhoneNumber(root.findViewById(R.id.user_phone));
        user.setRole(root.findViewById(R.id.user_role));

        user.setOldPassword(root.findViewById(R.id.user_oldPass));
        user.setNewPassword(root.findViewById(R.id.user_newPass));
        user.setConfirmPassword(root.findViewById(R.id.user_confirmPass));
        return user;
    }

    private void disableInputs(User s, UserModelWithViews user) {
        user.getId().setEnabled(false);
        if (!s.getRole().equals(RolesConstants.Admin)) {
            user.getRole().setEnabled(false);
            user.getName().setEnabled(false);
            user.getLastName().setEnabled(false);
            user.getFaculty().setEnabled(false);
            user.getGroupName().setEnabled(false);
            user.getCourse().setEnabled(false);
            user.getStudentTicket().setEnabled(false);
            user.getPhoneNumber().setEnabled(false);
            user.getEmail().setEnabled(false);
        }
    }

    private LiveData<User> getUser() {
        try {
            return userViewModel.getUser();
        } catch(Exception e) {
            return null;
        }
    }

    public void save(View view) {
        UserModelWithViews user = findAllUserViews(view.getRootView());
        ValidationError error = validator.validate(user);
        if (error != null) {
           displayError(error); 
        }

        UserWithChangePasswordModel converted = converter.convert(user);
        saveSafely(converted);
    }

    private void saveSafely(UserWithChangePasswordModel user) {
        try {
            userViewModel.save(user);
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
