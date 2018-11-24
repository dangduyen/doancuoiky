package vn.hcmute.onlineshop.model.response;

public class DataReturn {
    private String success;
    private String error;
    private Object data;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public DataReturn() {
    }

    public DataReturn(String success, String error, Object data) {
        this.success = success;
        this.error = error;
        this.data = data;
    }
}
