package sun.cloud.core.base;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by xuebj on 2017/1/16.
 */
public class BaseDynaSqlProvider {

    public static String getField(final String[] fields){
        return getField(fields,null);
    }

    public static final String SPECIFIC_CHARS = "_,%,*,$,^";

    public static String getField(final String[] srcFields, String aliasName){
        String[] fields = ArrayUtils.clone(srcFields);
        if(StringUtils.isNotBlank(aliasName)){
            for (int i = 0; i < fields.length; i++) {
                fields[i] = aliasName +"." + fields[i] + " as " + fields[i];
            }
        }
        return  StringUtils.join(fields,",");
    }

    /**
     * 校验是否存在通配符注入风险
     * @param params
     * @return
     */
    public static String getSpecificCharsArrFlag(String params){
        String[] paramArr = BaseDynaSqlProvider.SPECIFIC_CHARS.split(",");
        for(int i = 0; i < paramArr.length; i++){
            if(params.trim().indexOf(paramArr[i]) != -1){
                params.replaceAll(paramArr[i],"/"+paramArr[i]);
            }
        }
        return params;
    }

    public static String getLikeWhere(String field, String likeParam){
        if(StringUtils.isBlank(likeParam)){
            return field + " like '%' ";
        }

        String _likeParam = likeParam.trim();
        _likeParam = _likeParam.replaceAll("'", "\\\\'");
        _likeParam = _likeParam.replaceAll("/", "//");
        _likeParam = _likeParam.replaceAll("_", "/_");
        _likeParam = _likeParam.replaceAll("%", "/%");
        return field + " like '%" + _likeParam + "%' ESCAPE '/' ";
    }

    public String getSelectSQL(String columns, String table){
        return this.getSelectSQL(columns, table, null, null);
    }

    public String getSelectSQL(String columns, String table,
            List<String> conditionList){
        return this.getSelectSQL(columns, table, conditionList, null);
    }

    public String getSelectSQL(final String columns, final String table,
            final List<String> conditionList, final String sort){
        return new SQL(){{
            SELECT(columns);
            FROM(table);
            if(null != conditionList){
                for (String condition : conditionList){
                    WHERE(condition);
                }
            }
            if (null != sort){
                ORDER_BY(sort);
            }
        }}.toString();
    }

    public void checkOderBy(String[] fields, String sort){
        String excepMsg = "排序字段不合法";

        String[] sort1s = sort.split(",");
        for(String sort1 : sort1s){
            String[] sort2s = sort1.trim().replaceAll("\\s+", " ").split(" ");
            Assert.isTrue(sort2s.length<3, excepMsg);

            boolean columnFlag = false;
            for(String field : fields){
                String _field = field.toLowerCase();
                if(sort2s[0].toLowerCase().contains(_field)
                        || _field.contains(sort2s[0])){
                    columnFlag = true;
                    break;
                }
            }
            Assert.isTrue(columnFlag, excepMsg);

            if(sort2s.length == 2){
                if(!"asc".equalsIgnoreCase(sort2s[1]) &&
                        !"desc".equalsIgnoreCase(sort2s[1])){
                    throw new IllegalArgumentException(excepMsg);
                }
            }
        }
    }

    public void checkGroupBy(String[] fields, String groupBy){
        String excepMsg = "分组字段不合法";

        String[] groupBys = groupBy.split(",");
        for(String gb : groupBys){
            String _gb = gb.trim();

            boolean columnFlag = false;
            for(String field : fields){
                if(field.equalsIgnoreCase(_gb)){
                    columnFlag = true;
                    break;
                }
            }
            Assert.isTrue(columnFlag, excepMsg);
        }
    }
}
