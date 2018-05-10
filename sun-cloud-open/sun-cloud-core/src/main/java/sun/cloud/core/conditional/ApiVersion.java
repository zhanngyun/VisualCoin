package sun.cloud.core.conditional;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * Project ： SPRING_CLOUD_EUREKA_DEMO
 * PackageName ： com.hs.web.app.core.conditional
 * Author ： caijl
 * Date ： 2018/1/5
 * Time ： 14:21
 * Description :
 * 系统版本 ： 1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {
    /**
     * 版本号
     * @return
     */
    int value();
}
