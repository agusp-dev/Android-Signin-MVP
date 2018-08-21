package ar.com.ingenium.signin_mvp.api;

public interface SigninCallback {

    void onSigninSuccesful();
    void onSigninFailure(String error);
}