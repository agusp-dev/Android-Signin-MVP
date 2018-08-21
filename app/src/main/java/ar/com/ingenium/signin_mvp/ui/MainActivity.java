package ar.com.ingenium.signin_mvp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import ar.com.ingenium.signin_mvp.R;

public class MainActivity extends AppCompatActivity implements MainView {

    private EditText edUsername;
    private EditText edPassword;
    private Button btSignin;
    private ProgressBar pgrSignin;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        mainPresenter = new MainPresenterImpl(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestroy();
    }

    private void initComponents() {
        edUsername = (EditText) findViewById(R.id.edUsername);
        edPassword = (EditText) findViewById(R.id.edPassword);
        pgrSignin = (ProgressBar) findViewById(R.id.pgrSignin);
        btSignin = (Button) findViewById(R.id.btSignin);
        btSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSigninButtonClick();
            }
        });
    }

    private void onSigninButtonClick() {
        mainPresenter.handleSignin(
                edUsername.getText().toString(),
                edPassword.getText().toString());
    }

    @Override
    public void showSignProgress() {
        btSignin.setVisibility(View.GONE);
        pgrSignin.setVisibility(View.VISIBLE);
    }

    @Override
    public void showSignButton() {
        pgrSignin.setVisibility(View.GONE);
        btSignin.setVisibility(View.VISIBLE);
    }

    @Override
    public void showSigninSuccesfulMsg() {
        String msg = getString(R.string.signin_succesful_msg);
        showToastMsg(msg);
    }

    @Override
    public void showError(String err) {
        showToastMsg(err);
    }

    private void showToastMsg(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}