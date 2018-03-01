package top.fkxuexi.modules.activity.controller;

import common.entity.ActivityRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import top.fkxuexi.modules.activity.service.ActivityRuleService;

import javax.swing.*;

import static org.junit.Assert.*;

/**
 * @version v1.0.0
 * @Author fkxuexi
 * @Date 2018/3/1 23:12
 * @QQ群 570980002
 * @Description :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:config/spring-context-*.xml"})
public class ActivityRuleControllerTest {


    @Autowired
    private ActivityRuleService ruleService;

    @Test
    public void testGet(){
        ActivityRule activityRule = ruleService.get(1);
        System.out.println(activityRule);
    }


}