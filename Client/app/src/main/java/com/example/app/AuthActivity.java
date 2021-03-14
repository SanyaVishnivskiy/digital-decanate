package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    }

    public void login(View view) {
        AuthModel model = createAuthModel();
        String token = null;
        try {
             token = _gateway.authenticate(model);
        } catch(Exception e){
            e.getMessage();
        }

        if (token == null || token.isEmpty()) {
            displayError();
            return;
        }

        UserContext.getInstance().setToken(token);
        redirectToMainActivity();
    }

    private void displayError() {
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
