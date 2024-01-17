package monster.realrestfulman.trpr.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by Robin on 2023/12/21.
 * Description :
 */

@Slf4j
@Component
public class TraceIdFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String traceInfoHeader = request.getHeader("traceInfo");
        if (Optional.ofNullable(traceInfoHeader).isPresent()) {
            log.info(traceInfoHeader);
        }
        filterChain.doFilter(request, response);
    }
}
