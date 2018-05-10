package sun.cloud.core.dictionary.exception;


import sun.cloud.core.exception.BizException;
import sun.cloud.core.exception.builder.ErrorBuilder;

/**
 * 数据字典未找到的异常
 * Created by xuebj07252 on 2015/1/31.
 */
public class DictNotFundException extends BizException {

    /**
     * errorCode 传入无效,推荐直接使用DictNotFundException() 无参构造器
     * @param errorMessage
     */
    public DictNotFundException(String errorMessage) {
        super(ErrorBuilder.buildBizError(errorMessage));
    }

}
