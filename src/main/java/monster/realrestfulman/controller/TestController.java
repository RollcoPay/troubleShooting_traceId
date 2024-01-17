package monster.realrestfulman.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Robin on 2023/12/12.
 * Description :
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping()
    public String test(@RequestParam String traceId) {
        log.info("Begin::POST:/test");
        log.info("traceId is {}", traceId);
        log.info("End::POST:/test");
        return "123123";
    }

    @GetMapping("/{traceId}")
    public String testGet(@PathVariable("traceId") String traceId) {
        log.info("Begin::GET:/test");
        log.info("traceId is {}", traceId);
        log.info("End::GET:/test");
        return "123321";
    }
}
