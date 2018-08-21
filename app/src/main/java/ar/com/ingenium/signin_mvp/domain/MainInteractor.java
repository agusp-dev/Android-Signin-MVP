package ar.com.ingenium.signin_mvp.domain;

import ar.com.ingenium.signin_mvp.event.SigninEvent;

public interface MainInteractor {

    void signinProcess(String username, String password);

    interface SigninProcessEvent {
        void onSigninProcessEvent(SigninEvent event);
    }
}