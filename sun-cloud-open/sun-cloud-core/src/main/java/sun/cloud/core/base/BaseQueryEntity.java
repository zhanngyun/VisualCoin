package sun.cloud.core.base;

public class BaseQueryEntity extends TraceBean{

    /**
     * 排序列及字段 如 user asc,name desc
     */
    private String sort;

    /**
     * 分组字段
     */
    private String groupBy;

    /**
     * 页大小
     */
    private Integer pageSize = 10;
    /**
     * 第几页
     */
    private Integer page = 1;

    private Long id;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseQueryEntity{" +
                "sort='" + sort + '\'' +
                ", pageSize=" + pageSize +
                ", page=" + page +
                ", id=" + id +
                '}';
    }
}
