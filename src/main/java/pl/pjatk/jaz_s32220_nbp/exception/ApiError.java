package pl.pjatk.jaz_s32220_nbp.exception;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ApiError {
    private int status;
    private String message;
    @Id
    private Long id;

    public ApiError(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ApiError() {

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
