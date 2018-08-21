package ar.com.ingenium.signin_mvp.event;

public class SigninEvent {

    public final static int ON_SIGNIN_SUCCESFUL = 0;
    public final static int ON_SIGNIN_ERROR = 1;

    private int result;
    private String error;

    public SigninEvent() {}

    public int getResult() {
        return result;
    }

    public String getError() {
        return error;
    }

    public void setResult(int re) {
        result = re;
    }

    public void setError(String er) {
        error = er;
    }
}