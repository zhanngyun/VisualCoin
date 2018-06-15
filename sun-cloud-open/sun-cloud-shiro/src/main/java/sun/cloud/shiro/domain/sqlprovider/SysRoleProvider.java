package sun.cloud.shiro.domain.sqlprovider;

import org.apache.ibatis.jdbc.SQL;
import sun.cloud.core.base.BaseDynaSqlProvider;
import sun.cloud.shiro.domain.SysRoleDO;


/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysRoleProvider extends BaseDynaSqlProvider {

    //alias
    public static final String TABLE_ALIAS = "t_sys_role";

    public static final String[] Fields = {"role_id", "role_name", "role_flag", "remark"};

    /**
     * 获取单个结果集
     */
    public String get(final String role_id) {
        return new SQL() {{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("role_id=#{role_id}");
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String list(final SysRoleDO bean) {
        return new SQL() {{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean) {
                if (bean.getRoleId() != null) {
                    WHERE("role_id=#{roleId}");
                }
                if (bean.getRoleName() != null) {
                    WHERE("role_name=#{roleName}");
                }
                if (bean.getRoleFlag() != null) {
                    WHERE("role_flag=#{roleFlag}");
                }
                if (bean.getRemark() != null) {
                    WHERE("remark=#{remark}");
                }
                if (bean.getSort() != null) {
                    ORDER_BY(bean.getSort());
                }
            }

        }}.toString();
    }

    /**
     * 保存单个对象
     */
    public String save(final SysRoleDO bean) {
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getRoleId() != null) {
                VALUES("role_id", "#{roleId}");
            }
            if (bean.getRoleName() != null) {
                VALUES("role_name", "#{roleName}");
            }
            if (bean.getRoleFlag() != null) {
                VALUES("role_flag", "#{roleFlag}");
            }
            if (bean.getRemark() != null) {
                VALUES("remark", "#{remark}");
            }
        }}.toString();
    }

    /**
     * 更新对象
     */
    public String update(final SysRoleDO bean) {
        return new SQL() {{
            UPDATE(TABLE_ALIAS);
            if (bean.getRoleName() != null) {
                SET("role_name=#{roleName}");
            }
            if (bean.getRoleFlag() != null) {
                SET("role_flag=#{roleFlag}");
            }
            if (bean.getRemark() != null) {
                SET("remark=#{remark}");
            }
            WHERE("role_id = #{role_id}");
        }}.toString();
    }


    /**
     * 按条件移除对象
     */
    public String remove(final SysRoleDO bean) {
        return new SQL() {{
            DELETE_FROM(TABLE_ALIAS);
            if (bean.getRoleId() != null) {
                WHERE("role_id=#{roleId}");
            }
            if (bean.getRoleName() != null) {
                WHERE("role_name=#{roleName}");
            }
            if (bean.getRoleFlag() != null) {
                WHERE("role_flag=#{roleFlag}");
            }
            if (bean.getRemark() != null) {
                WHERE("remark=#{remark}");
            }
        }}.toString();
    }

    /**
     * 删除单个对象
     */
    public String delete(final Long role_id) {
        return new SQL() {{
            DELETE_FROM(TABLE_ALIAS);
            WHERE("role_id=#{role_id}");
        }}.toString();
    }


}