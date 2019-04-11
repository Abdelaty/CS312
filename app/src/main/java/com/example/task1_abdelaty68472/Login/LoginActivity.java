package com.example.task1_abdelaty68472.Login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.task1_abdelaty68472.R;
import com.example.task1_abdelaty68472.Welcome.WelcomeActivity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.forget_pass)
    TextView forgetPass_tv;
    @BindView(R.id.login_btn)
    TextView loginButton;
    @BindView(R.id.register_btn)
    TextView registerButton;
    @BindView(R.id.pass_input)
    TextView passInput;
    @BindView(R.id.user_input)
    TextView userInput;
    LoginPresenter loginPresenter = new LoginPresenter();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        intent = new Intent(this, WelcomeActivity.class);

        loginButton.setOnClickListener(v ->
        {
            showToasts();
        });
        registerButton.setOnClickListener(v ->
        {
            Toasty.info(this, "Call Your Admin").show();
        });
    }

    private void showToasts() {
        if (loginPresenter.auth(userInput.getText().toString(), passInput.getText().toString())) {
            Toasty.success(this, "Login Success").show();
            startActivity(intent);

        } else {
            Toasty.warning(this, "Login Failed, Please contact admin").show();
        }
    }
}