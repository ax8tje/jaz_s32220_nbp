package pl.pjatk.jaz_s32220_nbp.exception;

public class ApiError {
    private int status;
    private String message;

    public ApiError(int status, String message) {
        this.status = status;
        this.message = message;
    }
    public int getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
