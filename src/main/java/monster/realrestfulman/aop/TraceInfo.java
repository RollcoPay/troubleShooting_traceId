package monster.realrestfulman.aop;

import java.lang.annotation.*;

/**
 * Created by Robin on 2023/12/22.
 * Description :
 */
@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface TraceInfo {

}
