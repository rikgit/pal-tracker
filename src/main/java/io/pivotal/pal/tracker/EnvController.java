package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by e037075 on 11/13/17.
 */
@RestController
public class EnvController {

    private Map<String,String> envVariables;

    public EnvController(@Value("${PORT:NOT SET}")String port,
                         @Value("${MEMORY_LIMIT: NOT SET}")String memoryLimit,
                         @Value("${CF_INSTANCE_INDEX: NOT SET}")String cfInstanceIndex,
                         @Value("${CF_INSTANCE_ADDR: NOT SET}")String cfInstanceAddr) {
        envVariables = new HashMap<String, String>();

        envVariables.put("PORT",port);
        envVariables.put("MEMORY_LIMIT",memoryLimit);
        envVariables.put("CF_INSTANCE_INDEX",cfInstanceIndex);
        envVariables.put("CF_INSTANCE_ADDR",cfInstanceAddr);
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {

        return envVariables;
    }
}
