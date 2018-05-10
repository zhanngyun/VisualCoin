package sun.cloud.core.biz.domain;

import sun.cloud.core.base.BaseQueryEntity;

import java.io.Serializable;
import java.util.Date;


public class DictEntryDO extends BaseQueryEntity implements Serializable {

private static final long serialVersionUID = 1L;

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

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setEntryCode(String entryCode){
        this.entryCode = entryCode;
    }
    public String getEntryCode(){
        return entryCode;
    }
    public void setEntryName(String entryName){
        this.entryName = entryName;
    }
    public String getEntryName(){
        return entryName;
    }
    public void setRemark(String remark){
        this.remark = remark;
    }
    public String getRemark(){
        return remark;
    }
    public void setGmtCreate(Date gmtCreate){
        this.gmtCreate = gmtCreate;
    }
    public Date getGmtCreate(){
        return gmtCreate;
    }
    public void setGmtModified(Date gmtModified){
        this.gmtModified = gmtModified;
    }
    public Date getGmtModified(){
        return gmtModified;
    }
    @Override
    public String toString(){
        return "SysDictEntryDO{" +
                    "id='" + id + "\'," +
                    "entryCode='" + entryCode + "\'," +
                    "entryName='" + entryName + "\'," +
                    "remark='" + remark + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
		}