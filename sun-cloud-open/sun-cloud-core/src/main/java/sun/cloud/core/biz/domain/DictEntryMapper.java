package sun.cloud.core.biz.domain;

import sun.cloud.core.biz.domain.sqlprovider.DictEntryProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;


@Mapper
public interface DictEntryMapper {

    @SelectProvider(type = DictEntryProvider.class, method = "get")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "entryCode", column = "entry_code", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "entryName", column = "entry_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    DictEntryDO get(Long id);

    @SelectProvider(type = DictEntryProvider.class, method = "list")
    @Results(value= {
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class), 
            @Result(property = "entryCode", column = "entry_code", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "entryName", column = "entry_name", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "remark", column = "remark", jdbcType = JdbcType.VARCHAR, javaType = String.class), 
            @Result(property = "gmtCreate", column = "gmt_create", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class), 
            @Result(property = "gmtModified", column = "gmt_modified", jdbcType = JdbcType.TIMESTAMP, javaType = Date.class)
            })
    List<DictEntryDO> list(DictEntryDO bean);

    @InsertProvider(type = DictEntryProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    Integer save(DictEntryDO bean);

    @UpdateProvider(type = DictEntryProvider.class, method = "update")
    Integer update(DictEntryDO bean);

    @DeleteProvider(type = DictEntryProvider.class, method = "remove")
    Integer remove(DictEntryDO bean);

    @DeleteProvider(type = DictEntryProvider.class, method = "delete")
    Integer delete(Long id);

    @DeleteProvider(type = DictEntryProvider.class,method = "batchDelete")
    Integer batchDelete1(List<DictEntryDO> list);

    @Insert("<script>"+
            "insert into users(userid, username, password) "
            + "values "
            + "<foreach collection =\"list\" item=\"userInfo\" index= \"index\"  separator =\",\"> "
            + "(#{userInfo.userId},#{userInfo.userName},#{userInfo.password}) "
            + "</foreach > "
            + "</script>")
    Integer batchInsert(@Param("list") List<UserInfoDO> list);

    @Update("<script>"+
            "<foreach collection =\"list\" item=\"userInfo\" index= \"index\"  separator =\";\"> "
            +"update  users "
            + "set userid = #{userInfo.userId},username=#{userInfo.userName} where password=#{userInfo.password} "
            + "</foreach > "
            + "</script>")
    Integer batchUpdate(@Param("list") List<UserInfoDO> list);
}
