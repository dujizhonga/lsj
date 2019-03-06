package com.yrsoft.platform;


import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.platform.entity.PAssignApply;
import com.yrsoft.platform.service.PAssignApplyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class YrsoftAppApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger("TEST");


    @Autowired
    private PAssignApplyService pAssignApplyService;

    @Test
    public void test() {
        LOGGER.info("{}", UrlContants.IpTest);
    }

    @Test
    public void test1(){
        int page = 1;
        int limit = 10;
        PAssignApply pAssignApply = new PAssignApply();
        JsonResult list = pAssignApplyService.list(page, limit, pAssignApply);
        LOGGER.info("{}",list);

    }
}

