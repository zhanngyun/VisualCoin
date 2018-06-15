package sun.cloud.core.utils;

/**
 * JSON格式数据返回对象,封装controller 返回的对象
 * <p>
 * 系统版本: v1.0.0
 * </p>
 * <br>
 * 作者: xuebj07252 邮箱:xuebj07252@hundsun.com <br>
 * 创建时间:14-3-27 下午3:50<br>
 * 修改记录: 修改日期 修改人员 修改说明 <br>
 * ======== ======= ============================================
 * <p/>
 * ======== ======= ============================================
 */

public class JsonObject {

	/**
	 * 标示请求结果为成功
	 */
	private Boolean success = Boolean.TRUE;

	/**
	 * controller 方法返回数据对象
	 */
	private Object data;

	public JsonObject(Object data) {
		this.data = data;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
