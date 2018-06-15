package sun.cloud.shiro.domain.sqlprovider;

import org.apache.ibatis.jdbc.SQL;
import sun.cloud.core.base.BaseDynaSqlProvider;
import sun.cloud.shiro.domain.SysUserDO;


/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysUserProvider extends BaseDynaSqlProvider {

    //alias
    public static final String TABLE_ALIAS = "t_sys_user";

    public static final String[] Fields = {"user_name", "password", "real_name", "sex", "mobile", "email", "user_status", "user_type", "dept_code","is_admin", "remark"};

    /**
     * 获取单个结果集
     */
    public String get(final String user_name) {
        return new SQL() {{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            WHERE("user_name=#{user_name}");
        }}.toString();
    }

    /**
     * 查询多个结果集
     */
    public String list(final SysUserDO bean) {
        return new SQL() {{
            SELECT(getField(Fields));
            FROM(TABLE_ALIAS);
            if (null != bean) {
                if (bean.getUserName() != null) {
                    WHERE("user_name=#{userName}");
                }
                if (bean.getPassword() != null) {
                    WHERE("password=#{password}");
                }
                if (bean.getRealName() != null) {
                    WHERE("real_name=#{realName}");
                }
                if (bean.getSex() != null) {
                    WHERE("sex=#{sex}");
                }
                if (bean.getMobile() != null) {
                    WHERE("mobile=#{mobile}");
                }
                if (bean.getEmail() != null) {
                    WHERE("email=#{email}");
                }
                if (bean.getUserStatus() != null) {
                    WHERE("user_status=#{userStatus}");
                }
                if (bean.getUserType() != null) {
                    WHERE("user_type=#{userType}");
                }
                if (bean.getDeptCode() != null) {
                    WHERE("dept_code=#{deptCode}");
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
    public String save(final SysUserDO bean) {
        return new SQL() {{
            INSERT_INTO(TABLE_ALIAS);
            if (bean.getUserName() != null) {
                VALUES("user_name", "#{userName}");
            }
            if (bean.getPassword() != null) {
                VALUES("password", "#{password}");
            }
            if (bean.getRealName() != null) {
                VALUES("real_name", "#{realName}");
            }
            if (bean.getSex() != null) {
                VALUES("sex", "#{sex}");
            }
            if (bean.getMobile() != null) {
                VALUES("mobile", "#{mobile}");
            }
            if (bean.getEmail() != null) {
                VALUES("email", "#{email}");
            }
            if (bean.getUserStatus() != null) {
                VALUES("user_status", "#{userStatus}");
            }
            if (bean.getUserType() != null) {
                VALUES("user_type", "#{userType}");
            }
            if (bean.getDeptCode() != null) {
                VALUES("dept_code", "#{deptCode}");
            }
            if (bean.getRemark() != null) {
                VALUES("remark", "#{remark}");
            }
        }}.toString();
    }

    /**
     * 更新对象
     */
    public String update(final SysUserDO bean) {
        return new SQL() {{
            UPDATE(TABLE_ALIAS);
            if (bean.getUserName() != null) {
                SET("user_name=#{userName}");
            }
            if (bean.getPassword() != null) {
                SET("password=#{password}");
            }
            if (bean.getRealName() != null) {
                SET("real_name=#{realName}");
            }
            if (bean.getSex() != null) {
                SET("sex=#{sex}");
            }
            if (bean.getMobile() != null) {
                SET("mobile=#{mobile}");
            }
            if (bean.getEmail() != null) {
                SET("email=#{email}");
            }
            if (bean.getUserStatus() != null) {
                SET("user_status=#{userStatus}");
            }
            if (bean.getUserType() != null) {
                SET("user_type=#{userType}");
            }
            if (bean.getDeptCode() != null) {
                SET("dept_code=#{deptCode}");
            }
            if (bean.getRemark() != null) {
                SET("remark=#{remark}");
            }
            WHERE("user_name = #{user_name}");
        }}.toString();
    }


    /**
     * 按条件移除对象
     */
    public String remove(final SysUserDO bean) {
        return new SQL() {{
            DELETE_FROM(TABLE_ALIAS);
            if (bean.getUserName() != null) {
                WHERE("user_name=#{userName}");
            }
            if (bean.getPassword() != null) {
                WHERE("password=#{password}");
            }
            if (bean.getRealName() != null) {
                WHERE("real_name=#{realName}");
            }
            if (bean.getSex() != null) {
                WHERE("sex=#{sex}");
            }
            if (bean.getMobile() != null) {
                WHERE("mobile=#{mobile}");
            }
            if (bean.getEmail() != null) {
                WHERE("email=#{email}");
            }
            if (bean.getUserStatus() != null) {
                WHERE("user_status=#{userStatus}");
            }
            if (bean.getUserType() != null) {
                WHERE("user_type=#{userType}");
            }
            if (bean.getDeptCode() != null) {
                WHERE("dept_code=#{deptCode}");
            }
            if (bean.getRemark() != null) {
                WHERE("remark=#{remark}");
            }
        }}.toString();
    }

    /**
     * 删除单个对象
     */
    public String delete(final Long user_name) {
        return new SQL() {{
            DELETE_FROM(TABLE_ALIAS);
            WHERE("user_name=#{user_name}");
        }}.toString();
    }


}