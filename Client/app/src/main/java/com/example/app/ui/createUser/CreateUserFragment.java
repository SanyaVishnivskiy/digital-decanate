package com.example.app.ui.createUser;

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
import com.example.app.api.user.Models.User;
import com.example.app.api.user.Models.UserWithChangePasswordModel;
import com.example.app.api.user.Models.UserWithPassword;
import com.example.app.logic.user.RolesConstants;
import com.example.app.ui.common.ValidationError;
import com.example.app.ui.user.UserConverter;
import com.example.app.ui.user.UserModelWithViews;
import com.example.app.ui.user.UserValidator;
import com.example.app.ui.user.UserViewModel;

public class CreateUserFragment extends Fragment {
    private CreateUserViewModel userViewModel;
    private UserConverter converter;
    private UserValidator validator;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(this).get(CreateUserViewModel.class);
        View root = inflater.inflate(R.layout.create_user_layout, container, false);
        converter = new UserConverter();
        validator = new UserValidator();

        bindSaveButton(root);

        return root;
    }

    private void bindSaveButton(View root) {
        Button button = root.findViewById(R.id.create_user_save_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(v);
            }
        });
    }

    private CreateUserModelWithViews findAllUserViews(View root) {
        CreateUserModelWithViews user = new CreateUserModelWithViews();
        user.setId(root.findViewById(R.id.create_user_id));
        user.setName(root.findViewById(R.id.create_user_name));
        user.setLastName(root.findViewById(R.id.create_user_lastName));
        user.setFaculty(root.findViewById(R.id.create_user_faculty));
        user.setGroupName(root.findViewById(R.id.create_user_group));
        user.setCourse(root.findViewById(R.id.create_user_course));
        user.setStudentTicket(root.findViewById(R.id.create_user_student_ticket));
        user.setEmail(root.findViewById(R.id.create_user_email));
        user.setPhoneNumber(root.findViewById(R.id.create_user_phone));
        user.setRole(root.findViewById(R.id.create_user_role));
        user.setPassword(root.findViewById(R.id.create_user_password));

        return user;
    }

    public void save(View view) {
        CreateUserModelWithViews user = findAllUserViews(view.getRootView());
        ValidationError error = validator.validate(user);
        if (error != null) {
           displayError(error); 
        }

        UserWithPassword converted = converter.convert(user);
        saveSafely(converted);
    }

    private void saveSafely(UserWithPassword user) {
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
