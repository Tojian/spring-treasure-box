package com.taojian.shiro.start;

/**
 * @description:
 * @author: taojian
 * @create: 2019-01-03 14:54
 **/
@Component
public class SimpleService {

    private static Logger log = LoggerFactory.getLogger(SimpleService.class);

    @RequiresPermissions("write")
    public void writeRestrictedCall() {
        log.info("executing method that requires the 'write' permission");
    }

    @RequiresPermissions("read")
    public void readRestrictedCall() {
        log.info("executing method that requires the 'read' permission");
    }
}
