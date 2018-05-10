package sun.cloud.api.controller.vo;

import sun.cloud.core.base.BaseVO;

import java.util.Date;

/**
 * @Author: yzhang
 * @Date: 2018/4/15 22:28
 * @Desc: 数据字典返回
 */
public class DictEntryVO extends BaseVO {

    /**
     *@Fields id:
     */
    private Long id;
    /**
     *@Fields entry_code:字典条目
     */
    private String entryCode;
    /**
     *@Fields entry_name:字典条目名称
     */
    private String entryName;
    /**
     *@Fields remark:备注
     */
    private String remark;
    /**
     *@Fields gmt_create:
     */
    private Date gmtCreate;
    /**
     *@Fields gmt_modified:
     */
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntryCode() {
        return entryCode;
    }

    public void setEntryCode(String entryCode) {
        this.entryCode = entryCode;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
