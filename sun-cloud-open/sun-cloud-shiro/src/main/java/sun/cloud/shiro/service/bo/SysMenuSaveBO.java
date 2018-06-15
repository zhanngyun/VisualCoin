package sun.cloud.shiro.service.bo;
import java.io.Serializable;



/**
 * @author yzhang email:zhangyun23548@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class SysMenuSaveBO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields menu_id:资源Id
     */
    private Integer menuId;

    /**
     *@Fields menu_name:资源名称
     */
    private String menuName;

    /**
     *@Fields menu_type:资源类型
     */
    private String menuType;

    /**
     *@Fields menu_pid:资源的父节点
     */
    private Integer menuPid;

    /**
     *@Fields http_address:HTTP地址
     */
    private String httpAddress;

    /**
     *@Fields remark:备注
     */
    private String remark;


    public void setMenuId(Integer menuId){
        this.menuId = menuId;
    }
    public Integer getMenuId(){
        return menuId;
    }
    public void setMenuName(String menuName){
        this.menuName = menuName;
    }
    public String getMenuName(){
        return menuName;
    }
    public void setMenuType(String menuType){
        this.menuType = menuType;
    }
    public String getMenuType(){
        return menuType;
    }
    public void setMenuPid(Integer menuPid){
        this.menuPid = menuPid;
    }
    public Integer getMenuPid(){
        return menuPid;
    }
    public void setHttpAddress(String httpAddress){
        this.httpAddress = httpAddress;
    }
    public String getHttpAddress(){
        return httpAddress;
    }
    public void setRemark(String remark){
        this.remark = remark;
    }
    public String getRemark(){
        return remark;
    }
    @Override
    public String toString(){
        return "SysMenu{" +
                    "menuId='" + menuId + "\'," +
                    "menuName='" + menuName + "\'," +
                    "menuType='" + menuType + "\'," +
                    "menuPid='" + menuPid + "\'," +
                    "httpAddress='" + httpAddress + "\'," +
                    "remark='" + remark + "\'" +
                "}";
    }
}