package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.api.auth.AuthGatewayFactory;
import com.example.app.api.auth.IAuthGateway;
import com.example.app.api.auth.Models.AuthModel;
import com.example.app.logic.user.UserContext;

public class AuthActivity extends AppCompatActivity {
    IAuthGateway _gateway;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_layout);

        _gateway = new AuthGatewayFactory().create();

        //TODO: comment, did to test without need to login every time
        disableLogin();
    }

    private void disableLogin() {
        EditText view = findViewById(R.id.auth_email_input);
        view.setText("a@m.c");
        login(null);
    }

    public void login(View view) {
        AuthModel model = createAuthModel();
        String token = null;
        try {
             token = _gateway.authenticate(model);
        } catch (Exception e){
            displayError(e.getMessage());
            token = null;
        }

        if (token == null || token.isEmpty()) {
            displayError("Email or password is not valid");
            return;
        }

        UserContext.getInstance().setToken(token);
        redirectToMainActivity();
    }

    protected void displayError(String message) {
        //TODO:
    }

    private AuthModel createAuthModel() {
        TextView email = findViewById(R.id.auth_email_input);
        TextView password = findViewById(R.id.auth_password_input);

        return new AuthModel(
                String.valueOf(email.getText()),
                String.valueOf(password.getText()));
    }

    private void redirectToMainActivity() {
        Intent functionTab = new Intent(
                this.getApplicationContext(),
                MainActivity.class);

        startActivity(functionTab);
    }

}
