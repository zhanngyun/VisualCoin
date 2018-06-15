package sun.cloud.shiro.domain;
import sun.cloud.shiro.domain.sqlprovider.SysRoleMenuProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;


/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface SysRoleMenuMapper {


    @SelectProvider(type = SysRoleMenuProvider.class, method = "list")
    @Results(value= {
            @Result(property = "roleId", column = "role_id", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "menuId", column = "menu_id", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class)
            })
    List<SysRoleMenuDO> list(SysRoleMenuDO bean);

    @InsertProvider(type = SysRoleMenuProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(SysRoleMenuDO bean);


    @DeleteProvider(type = SysRoleMenuProvider.class, method = "remove")
    Integer remove(SysRoleMenuDO bean);

}
