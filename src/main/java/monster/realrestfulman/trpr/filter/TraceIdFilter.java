package monster.realrestfulman.trpr.filter;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Robin on 2023/12/21.
 * Description :
 */

@Slf4j
@Component
public class TraceIdFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 스레드에 TRACE_ID 추가.
        String TRACE_ID = "SMT" + UUID.randomUUID().toString().substring(0, 15);
        MDC.put("TRACE_ID", TRACE_ID);
        log.info("------------------------------------------------------------------------------ TRACE_ID : {} ----------------------------------------------------------------------------------------------", TRACE_ID);
        request.setAttribute("TRACE_ID", TRACE_ID);

//        String traceInfoHeader = request.getHeader("traceInfo");
//        if (Optional.ofNullable(traceInfoHeader).isPresent()) {
//            log.info(traceInfoHeader);
//        }
        filterChain.doFilter(request, response);
        MDC.clear();
    }

}
