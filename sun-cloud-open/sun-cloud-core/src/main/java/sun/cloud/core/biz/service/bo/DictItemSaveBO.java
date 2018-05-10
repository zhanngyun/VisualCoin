package sun.cloud.core.biz.service.bo;

import java.io.Serializable;



public class DictItemSaveBO implements Serializable{
    private static final long serialVersionUID = 1L;


    /**
     *@Fields item_code:子项
     */
    private String itemCode;

    /**
     *@Fields item_name:子项名称
     */
    private String itemName;

    /**
     *@Fields entry_code:字典条目代码
     */
    private String entryCode;

    /**
     *@Fields entry_id:字典条目id
     */
    private String entryId;

    /**
     *@Fields item_order:排序
     */
    private Integer itemOrder;

    /**
     *@Fields remark:备注
     */
    private String remark;


    public void setItemCode(String itemCode){
        this.itemCode = itemCode;
    }
    public String getItemCode(){
        return itemCode;
    }
    public void setItemName(String itemName){
        this.itemName = itemName;
    }
    public String getItemName(){
        return itemName;
    }
    public void setEntryCode(String entryCode){
        this.entryCode = entryCode;
    }
    public String getEntryCode(){
        return entryCode;
    }
    public void setEntryId(String entryId){
        this.entryId = entryId;
    }
    public String getEntryId(){
        return entryId;
    }
    public void setItemOrder(Integer itemOrder){
        this.itemOrder = itemOrder;
    }
    public Integer getItemOrder(){
        return itemOrder;
    }
    public void setRemark(String remark){
        this.remark = remark;
    }
    public String getRemark(){
        return remark;
    }
    @Override
    public String toString(){
        return "SysDictItem{" +
                    "itemCode='" + itemCode + "\'," +
                    "itemName='" + itemName + "\'," +
                    "entryCode='" + entryCode + "\'," +
                    "entryId='" + entryId + "\'," +
                    "itemOrder='" + itemOrder + "\'," +
                    "remark='" + remark + "\'," +
                "}";
    }
}