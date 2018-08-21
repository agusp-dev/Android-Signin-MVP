package ar.com.ingenium.signin_mvp.ui;

import ar.com.ingenium.signin_mvp.domain.MainInteractor;
import ar.com.ingenium.signin_mvp.domain.MainInteractorImpl;
import ar.com.ingenium.signin_mvp.event.SigninEvent;

public class MainPresenterImpl implements MainPresenter,
        MainInteractor.SigninProcessEvent {

    private MainView mainView;
    private MainInteractor mainInteractor;

    public MainPresenterImpl(MainView mv) {
        mainView = mv;
        mainInteractor = new MainInteractorImpl(this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void handleSignin(String username, String password) {
        if (mainView != null) {
            mainView.showSignProgress();
            mainInteractor.signinProcess(username, password);
        }
    }


    @Override
    public void onSigninProcessEvent(SigninEvent event) {
        if (mainView != null) {
            switch (event.getResult()) {
                case SigninEvent.ON_SIGNIN_SUCCESFUL:
                    onSigninSuccesful();
                    break;
                case SigninEvent.ON_SIGNIN_ERROR:
                    onSigninError(event.getError());
                    break;
            }
        }
    }

    private void onSigninSuccesful() {
        mainView.showSignButton();
        mainView.showSigninSuccesfulMsg();
    }

    private void onSigninError(String err) {
        mainView.showSignButton();
        mainView.showError(err);
    }
}