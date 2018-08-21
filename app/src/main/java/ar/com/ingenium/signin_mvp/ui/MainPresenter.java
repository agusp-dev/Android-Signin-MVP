package ar.com.ingenium.signin_mvp.ui;

public interface MainPresenter {

    void onDestroy();

    void handleSignin(String username, String password);
}