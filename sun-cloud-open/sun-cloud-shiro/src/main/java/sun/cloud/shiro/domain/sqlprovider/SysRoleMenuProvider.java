package sun.cloud.shiro.domain.sqlprovider;

import org.apache.ibatis.jdbc.SQL;
import sun.cloud.core.base.BaseDynaSqlProvider;
import sun.cloud.shiro.domain.SysRoleMenuDO;


/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysRoleMenuProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_sys_role_menu";

    public static final String[] Fields={"role_id","menu_id","remark"};


    /**
     * 查询多个结果集
     */
    public String list(final SysRoleMenuDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getRoleId()!=null){
                    WHERE("role_id=#{roleId}");
                }
                if(bean.getMenuId()!=null){
                    WHERE("menu_id=#{menuId}");
                }
                if(bean.getRemark()!=null){
                    WHERE("remark=#{remark}");
                }
                if(bean.getSort() != null){
                    ORDER_BY(bean.getSort());
                }
            }

        }}.toString();
    }

    /**
     *  保存单个对象
     */
    public String save(final SysRoleMenuDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getRoleId() != null) {
                VALUES("role_id", "#{roleId}");
            }
            if (bean.getMenuId() != null) {
                VALUES("menu_id", "#{menuId}");
            }
            if (bean.getRemark() != null) {
                VALUES("remark", "#{remark}");
            }
        }}.toString();
    }


    /**
     * 按条件移除对象
     */
    public String remove(final SysRoleMenuDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getRoleId()!=null){
                WHERE("role_id=#{roleId}");
            }
            if(bean.getMenuId()!=null){
                WHERE("menu_id=#{menuId}");
            }
            if(bean.getRemark()!=null){
                WHERE("remark=#{remark}");
            }
            }}.toString();
    }



}