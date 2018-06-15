package sun.cloud.shiro.domain;
import sun.cloud.shiro.domain.sqlprovider.SysMenuProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;


/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

@Mapper
public interface SysMenuMapper {

    @SelectProvider(type = SysMenuProvider.class, method = "get")
    @Results(value = {
            @Result(property = "menuId", column = "menu_id", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "menuName", column = "menu_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "menuType", column = "menu_type", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "menuPid", column = "menu_pid", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "httpAddress", column = "http_address", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class)
            })
    SysMenuDO get(Long menu_id);

    @SelectProvider(type = SysMenuProvider.class, method = "list")
    @Results(value= {
            @Result(property = "menuId", column = "menu_id", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "menuName", column = "menu_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "menuType", column = "menu_type", jdbcType = JdbcType.CHAR, javaType = String.class), 
            @Result(property = "menuPid", column = "menu_pid", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "httpAddress", column = "http_address", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class)
            })
    List<SysMenuDO> list(SysMenuDO bean);

    @InsertProvider(type = SysMenuProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(SysMenuDO bean);

    @UpdateProvider(type = SysMenuProvider.class, method = "update")
    Integer update(SysMenuDO bean);

    @DeleteProvider(type = SysMenuProvider.class, method = "remove")
    Integer remove(SysMenuDO bean);

    @DeleteProvider(type = SysMenuProvider.class, method = "delete")
    Integer delete(Long menu_id);
}
