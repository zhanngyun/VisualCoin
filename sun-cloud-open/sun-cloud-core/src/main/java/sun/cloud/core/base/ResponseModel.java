package sun.cloud.core.base;

/**
 * @Author: yzhang
 * @Date: 2018/4/15 22:10
 * @Desc: 返回同一格式
 */
public class ResponseModel<T> {

    private Boolean success;
    private T data;

    public ResponseModel() {
    }

    public ResponseModel(T data) {
        this.success = Boolean.TRUE;
        this.data = data;
    }

    public ResponseModel(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
