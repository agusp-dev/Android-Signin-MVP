package ar.com.ingenium.signin_mvp.api;

public class SigninApiImpl implements SigninApi {

    private SigninCallback signinCallback;

    public SigninApiImpl(SigninCallback callback) {
        signinCallback = callback;
    }

    @Override
    public void consumeApi(String username, String password) {
        //todo api implementation
        signinCallback.onSigninSuccesful();
    }
}