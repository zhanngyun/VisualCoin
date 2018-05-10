package sun.cloud.core.biz.domain;

import sun.cloud.core.biz.domain.sqlprovider.DictItemProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;


@Mapper
public interface DictItemMapper {

    @SelectProvider(type = DictItemProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "itemCode", column = "item_code", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "itemName", column = "item_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "entryCode", column = "entry_code", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "entryId", column = "entry_id", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "itemOrder", column = "item_order", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    DictItemDO get(Long id);

    @SelectProvider(type = DictItemProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "itemCode", column = "item_code", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "itemName", column = "item_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "entryCode", column = "entry_code", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "entryId", column = "entry_id", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "itemOrder", column = "item_order", jdbcType = JdbcType.INTEGER, javaType = Integer.class), 
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<DictItemDO> list(DictItemDO bean);

    @InsertProvider(type = DictItemProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(DictItemDO bean);

    @UpdateProvider(type = DictItemProvider.class, method = "update")
    Integer update(DictItemDO bean);

    @DeleteProvider(type = DictItemProvider.class, method = "remove")
    Integer remove(DictItemDO bean);

    @DeleteProvider(type = DictItemProvider.class, method = "delete")
    Integer delete(Long id);
}
