package sun.cloud.core.base;

import sun.cloud.core.constants.HttpResultCode;


public class BaseController {

    public BaseController() {
    }

    protected static final String SUCCESS = HttpResultCode.SUCCESS.msg();

    protected static final String FAILURE = HttpResultCode.FAILURE.msg();

    protected <T> ResponseModel<T> success(T data) {
        return new ResponseModel(data);
    }

    protected <T> ResponseModel<T> error(T data) {
        return new ResponseModel(Boolean.FALSE, data);
    }


}