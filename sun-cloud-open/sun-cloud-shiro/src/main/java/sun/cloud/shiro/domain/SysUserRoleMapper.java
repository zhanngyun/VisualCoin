package sun.cloud.shiro.domain;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import sun.cloud.shiro.domain.sqlprovider.SysUserRoleProvider;

import java.util.List;


/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface SysUserRoleMapper {


    @SelectProvider(type = SysUserRoleProvider.class, method = "list")
    @Results(value = {
            @Result(property = "userName", column = "user_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "roleId", column = "role_id", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class)
    })
    List<SysUserRoleDO> list(SysUserRoleDO bean);

    @InsertProvider(type = SysUserRoleProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(SysUserRoleDO bean);


    @DeleteProvider(type = SysUserRoleProvider.class, method = "remove")
    Integer remove(SysUserRoleDO bean);

}
