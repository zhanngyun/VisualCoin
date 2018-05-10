package sun.cloud.core.biz.service.query;

import sun.cloud.core.base.BaseQueryEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;



public class DictEntryQUERY extends BaseQueryEntity implements Serializable{
    private static final long serialVersionUID = 1L;


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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    /**
     *@Fields gmt_modified:
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;


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
        return "SysDictEntry{" +
                    "entryCode='" + entryCode + "\'," +
                    "entryName='" + entryName + "\'," +
                    "remark='" + remark + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
}