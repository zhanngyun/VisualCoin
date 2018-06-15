package sun.cloud.shiro.domain.sqlprovider;
import sun.cloud.shiro.domain.SysMenuDO;
import org.apache.ibatis.jdbc.SQL;
import sun.cloud.core.base.BaseDynaSqlProvider;


/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysMenuProvider extends BaseDynaSqlProvider{

    //alias
    public static final String TABLE_ALIAS = "t_sys_menu";

    public static final String[] Fields={"menu_id","menu_name","menu_type","menu_pid","http_address","remark"};

    /**
     * 获取单个结果集
     */
    public String get(final Long menu_id){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("menu_id=#{menu_id}");
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String list(final SysMenuDO bean){
        return new SQL(){{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean){
                if(bean.getMenuId()!=null){
                    WHERE("menu_id=#{menuId}");
                }
                if(bean.getMenuName()!=null){
                    WHERE("menu_name=#{menuName}");
                }
                if(bean.getMenuType()!=null){
                    WHERE("menu_type=#{menuType}");
                }
                if(bean.getMenuPid()!=null){
                    WHERE("menu_pid=#{menuPid}");
                }
                if(bean.getHttpAddress()!=null){
                    WHERE("http_address=#{httpAddress}");
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
    public String save(final SysMenuDO bean){
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getMenuId() != null) {
                VALUES("menu_id", "#{menuId}");
            }
            if (bean.getMenuName() != null) {
                VALUES("menu_name", "#{menuName}");
            }
            if (bean.getMenuType() != null) {
                VALUES("menu_type", "#{menuType}");
            }
            if (bean.getMenuPid() != null) {
                VALUES("menu_pid", "#{menuPid}");
            }
            if (bean.getHttpAddress() != null) {
                VALUES("http_address", "#{httpAddress}");
            }
            if (bean.getRemark() != null) {
                VALUES("remark", "#{remark}");
            }
        }}.toString();
    }

    /**
     * 更新对象
     */
    public String update(final SysMenuDO bean){
        return new SQL(){{
            UPDATE(TABLE_ALIAS);
            if (bean.getMenuId() != null) {
                SET("menu_id=#{menuId}");
            }
            if (bean.getMenuName() != null) {
                SET("menu_name=#{menuName}");
            }
            if (bean.getMenuType() != null) {
                SET("menu_type=#{menuType}");
            }
            if (bean.getMenuPid() != null) {
                SET("menu_pid=#{menuPid}");
            }
            if (bean.getHttpAddress() != null) {
                SET("http_address=#{httpAddress}");
            }
            if (bean.getRemark() != null) {
                SET("remark=#{remark}");
            }
            WHERE("menu_id = #{menu_id}");
        }}.toString();
    }


    /**
     * 按条件移除对象
     */
    public String remove(final SysMenuDO bean){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            if(bean.getMenuId()!=null){
                WHERE("menu_id=#{menuId}");
            }
            if(bean.getMenuName()!=null){
                WHERE("menu_name=#{menuName}");
            }
            if(bean.getMenuType()!=null){
                WHERE("menu_type=#{menuType}");
            }
            if(bean.getMenuPid()!=null){
                WHERE("menu_pid=#{menuPid}");
            }
            if(bean.getHttpAddress()!=null){
                WHERE("http_address=#{httpAddress}");
            }
            if(bean.getRemark()!=null){
                WHERE("remark=#{remark}");
            }
            }}.toString();
    }

    /**
     * 删除单个对象
     */
    public String delete(final Long id){
        return new SQL(){{
            DELETE_FROM(TABLE_ALIAS);
            WHERE("menu_id=#{menu_id}");
        }}.toString();
    }


}