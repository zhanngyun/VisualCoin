package sun.cloud.shiro.domain;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import sun.cloud.shiro.domain.sqlprovider.SysUserProvider;

import java.util.List;


/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface SysUserMapper {

    @SelectProvider(type = SysUserProvider.class, method = "get")
    @Results(value = {
            @Result(property = "userName", column = "user_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "password", column = "password", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "realName", column = "real_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "sex", column = "sex", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "mobile", column = "mobile", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "userStatus", column = "user_status", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "userType", column = "user_type", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "deptCode", column = "dept_code", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "isAdmin", column = "is_admin", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class)
    })
    SysUserDO get(String user_name);

    @SelectProvider(type = SysUserProvider.class, method = "list")
    @Results(value = {
            @Result(property = "userName", column = "user_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "password", column = "password", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "realName", column = "real_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "sex", column = "sex", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "mobile", column = "mobile", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "userStatus", column = "user_status", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "userType", column = "user_type", jdbcType = JdbcType.CHAR, javaType = String.class),
            @Result(property = "deptCode", column = "dept_code", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "isAdmin", column = "is_admin", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class)
    })
    List<SysUserDO> list(SysUserDO bean);

    @InsertProvider(type = SysUserProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(SysUserDO bean);

    @UpdateProvider(type = SysUserProvider.class, method = "update")
    Integer update(SysUserDO bean);

    @DeleteProvider(type = SysUserProvider.class, method = "remove")
    Integer remove(SysUserDO bean);

    @DeleteProvider(type = SysUserProvider.class, method = "delete")
    Integer delete(Long user_name);
}
