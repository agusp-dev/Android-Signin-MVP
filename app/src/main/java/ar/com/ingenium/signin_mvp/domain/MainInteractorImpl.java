package ar.com.ingenium.signin_mvp.domain;

import android.os.Handler;
import ar.com.ingenium.signin_mvp.api.SigninApi;
import ar.com.ingenium.signin_mvp.api.SigninApiImpl;
import ar.com.ingenium.signin_mvp.api.SigninCallback;
import ar.com.ingenium.signin_mvp.event.SigninEvent;

public class MainInteractorImpl implements MainInteractor, SigninCallback {

    private Handler handler;
    private SigninApi signinApi;
    private SigninProcessEvent signinProcessEvent;

    public MainInteractorImpl(SigninProcessEvent spe) {
        handler = new Handler();
        signinApi = new SigninApiImpl(this);
        signinProcessEvent = spe;
    }

    @Override
    public void signinProcess(final String username, final String password) {
        new Thread() {
            public void run() {

                //thread sleep 2 seconds
                try {
                    sleep(2000);
                } catch (Exception e) {}

                signinApi.consumeApi(username, password);
            }
        }.start();
    }

    @Override
    public void onSigninSuccesful() {
        SigninEvent signinEvent = new SigninEvent();
        signinEvent.setResult(SigninEvent.ON_SIGNIN_SUCCESFUL);
        postSignProcessEvent(signinEvent);
    }

    @Override
    public void onSigninFailure(String error) {
        SigninEvent signinEvent = new SigninEvent();
        signinEvent.setResult(SigninEvent.ON_SIGNIN_ERROR);
        signinEvent.setError(error);
        postSignProcessEvent(signinEvent);
    }

    private void postSignProcessEvent(final SigninEvent event) {
        if (handler != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                     signinProcessEvent.onSigninProcessEvent(event);
                }
            });
        }
    }
}