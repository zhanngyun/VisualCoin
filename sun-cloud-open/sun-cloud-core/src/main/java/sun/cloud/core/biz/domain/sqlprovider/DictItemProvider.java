package sun.cloud.core.biz.domain.sqlprovider;

import sun.cloud.core.base.BaseDynaSqlProvider;
import sun.cloud.core.biz.domain.DictItemDO;
import org.apache.ibatis.jdbc.SQL;



public class DictItemProvider extends BaseDynaSqlProvider {

    //alias
    public static final String TABLE_ALIAS = "t_dict_item";

    public static final String[] Fields={"id","item_code","item_name","entry_code","entry_id","item_order","remark","gmt_create","gmt_modified"};

    /**
     * 获取单个结果集
     */
    public String get(final Long id){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("id="+id);
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String list(final DictItemDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getId()!=null){
                    WHERE("id=#{id}");
                }
                if(bean.getItemCode()!=null){
                    WHERE("item_code=#{itemCode}");
                }
                if(bean.getItemName()!=null){
                    WHERE("item_name=#{itemName}");
                }
                if(bean.getEntryCode()!=null){
                    WHERE("entry_code=#{entryCode}");
                }
                if(bean.getEntryId()!=null){
                    WHERE("entry_id=#{entryId}");
                }
                if(bean.getItemOrder()!=null){
                    WHERE("item_order=#{itemOrder}");
                }
                if(bean.getRemark()!=null){
                    WHERE("remark=#{remark}");
                }
                if(bean.getGmtCreate()!=null){
                    WHERE("gmt_create=#{gmtCreate}");
                }
                if(bean.getGmtModified()!=null){
                    WHERE("gmt_modified=#{gmtModified}");
                }
                if(bean.getSort() != null){
                    checkOderBy(Fields, bean.getSort());
                    ORDER_BY(bean.getSort());
                }else{
                    ORDER_BY(" item_order ASC");
                }
            }

        }}.toString();
    }

    /**
     *  保存单个对象
     */
    public String save(final DictItemDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getItemCode() != null) {
                VALUES("item_code", "#{itemCode}");
            }
            if (bean.getItemName() != null) {
                VALUES("item_name", "#{itemName}");
            }
            if (bean.getEntryCode() != null) {
                VALUES("entry_code", "#{entryCode}");
            }
            if (bean.getEntryId() != null) {
                VALUES("entry_id", "#{entryId}");
            }
            if (bean.getItemOrder() != null) {
                VALUES("item_order", "#{itemOrder}");
            }
            if (bean.getRemark() != null) {
                VALUES("remark", "#{remark}");
            }
            if (bean.getGmtCreate() != null) {
                VALUES("gmt_create", "#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                VALUES("gmt_modified", "#{gmtModified}");
            }
        }}.toString();
    }

    /**
     * 更新对象
     */
    public String update(final DictItemDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getItemCode() != null) {
                SET("item_code=#{itemCode}");
            }
            if (bean.getItemName() != null) {
                SET("item_name=#{itemName}");
            }
            if (bean.getEntryCode() != null) {
                SET("entry_code=#{entryCode}");
            }
            if (bean.getEntryId() != null) {
                SET("entry_id=#{entryId}");
            }
            if (bean.getItemOrder() != null) {
                SET("item_order=#{itemOrder}");
            }
            if (bean.getRemark() != null) {
                SET("remark=#{remark}");
            }
            if (bean.getGmtCreate() != null) {
                SET("gmt_create=#{gmtCreate}");
            }
            if (bean.getGmtModified() != null) {
                SET("gmt_modified=#{gmtModified}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }


    /**
     * 按条件移除对象
     */
    public String remove(final DictItemDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getId()!=null){
                WHERE("id=#{id}");
            }
            if(bean.getItemCode()!=null){
                WHERE("item_code=#{itemCode}");
            }
            if(bean.getItemName()!=null){
                WHERE("item_name=#{itemName}");
            }
            if(bean.getEntryCode()!=null){
                WHERE("entry_code=#{entryCode}");
            }
            if(bean.getEntryId()!=null){
                WHERE("entry_id=#{entryId}");
            }
            if(bean.getItemOrder()!=null){
                WHERE("item_order=#{itemOrder}");
            }
            if(bean.getRemark()!=null){
                WHERE("remark=#{remark}");
            }
            if(bean.getGmtCreate()!=null){
                WHERE("gmt_create=#{gmtCreate}");
            }
            if(bean.getGmtModified()!=null){
                WHERE("gmt_modified=#{gmtModified}");
            }
            }}.toString();
    }

    /**
     * 删除单个对象
     */
    public String delete(final Long id){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            WHERE("id=" + id);
        }}.toString();
    }


}