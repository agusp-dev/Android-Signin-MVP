package ar.com.ingenium.signin_mvp.ui;

public interface MainView {

    void showSignProgress();
    void showSignButton();

    void showSigninSuccesfulMsg();
    void showError(String err);
}