package monster.realrestfulman.trpr.aop;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Created by Robin on 2023/12/22.
 * Description :
 */
@Configuration
@RequiredArgsConstructor
public class WebResolverConfig implements WebMvcConfigurer {
    private final TraceIdArgumentResolver traceIdArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(traceIdArgumentResolver);
    }



}
