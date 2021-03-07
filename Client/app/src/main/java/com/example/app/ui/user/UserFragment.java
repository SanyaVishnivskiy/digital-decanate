package com.example.app.ui.user;

import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.app.R;
import com.example.app.api.user.User;
import com.example.app.ui.gallery.GalleryViewModel;

import java.util.concurrent.ExecutionException;

public class UserFragment extends Fragment {
    private UserViewModel userViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        View root = inflater.inflate(R.layout.user_profile_layout, container, false);

        bindFetchingUser(root);

        return root;
    }

    private void bindFetchingUser(View root) {
        final TextView id = root.findViewById(R.id.user_id);
        final TextView name = root.findViewById(R.id.user_name);
        final TextView lastName = root.findViewById(R.id.user_lastName);
        final TextView role = root.findViewById(R.id.user_role);

        getUser().observe(getViewLifecycleOwner(), new Observer<User>() {
            @Override
            public void onChanged(@Nullable User s) {
                if (s == null)
                    return;

                id.setText(s.getId());
                name.setText(s.getName());
                lastName.setText(s.getLastName());
                role.setText(s.getRole());

                disableInputs(s, id, name, lastName, role);
            }
        });
    }

    private void disableInputs(User s, TextView id, TextView name, TextView lastName, TextView role) {
        id.setEnabled(false);
        if (s.getRole() != "Admin"){
            name.setEnabled(false);
            lastName.setEnabled(false);
            role.setEnabled(false);
        }
    }

    private LiveData<User> getUser() {
        try {
            return userViewModel.getUser();
        } catch(Exception e) {
            return null;
        }
    }
}
