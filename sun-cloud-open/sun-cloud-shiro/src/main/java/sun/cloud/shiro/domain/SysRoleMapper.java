package sun.cloud.shiro.domain;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import sun.cloud.shiro.domain.sqlprovider.SysRoleProvider;

import java.util.List;


/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface SysRoleMapper {

    @SelectProvider(type = SysRoleProvider.class, method = "get")
    @Results(value = {
            @Result(property = "roleId", column = "role_id", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "roleName", column = "role_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "roleFlag", column = "role_flag", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class)
            })
    SysRoleDO get(String role_id);

    @SelectProvider(type = SysRoleProvider.class, method = "list")
    @Results(value= {
            @Result(property = "roleId", column = "role_id", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "roleName", column = "role_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "roleFlag", column = "role_flag", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class)
            })
    List<SysRoleDO> list(SysRoleDO bean);

    @InsertProvider(type = SysRoleProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(SysRoleDO bean);

    @UpdateProvider(type = SysRoleProvider.class, method = "update")
    Integer update(SysRoleDO bean);

    @DeleteProvider(type = SysRoleProvider.class, method = "remove")
    Integer remove(SysRoleDO bean);

    @DeleteProvider(type = SysRoleProvider.class, method = "delete")
    Integer delete(Long role_id);
}
