package com.example;

import com.alibaba.fastjson.JSON;
import com.example.domain.Cookbook;
import com.example.domain.User;
import com.example.domain.UserDishes;
import com.example.repository.CookbookRepository;
import com.example.repository.UserDishesRepository;
import com.example.repository.UserRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class YabaoApplicationTests {

    @Resource
    private UserRepository userRepository;

    @Resource
    private CookbookRepository cookbookRepository;

    @Resource
    private UserDishesRepository userDishesRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void test() throws Exception {
        // 创建三个User，并验证User总数
        userRepository.save(new User(1L, "didi"));
        userRepository.save(new User(2L, "mama"));
        userRepository.save(new User(3L, "kaka"));
        Assert.assertEquals(3, userRepository.findAll().size());
        // 删除一个User，再验证User总数
        User u = userRepository.findOne(1L);
        userRepository.delete(u);
        Assert.assertEquals(2, userRepository.findAll().size());
        // 删除一个User，再验证User总数
        u = userRepository.findByName("mama");
        log.info("u:{}", u.toString());
        userRepository.delete(u);
        Assert.assertEquals(1, userRepository.findAll().size());
    }

    @Test
    public void test_save() {
        User user = new User("测试的名称");
        userRepository.save(user);
        System.out.println(user.getId());
    }

    @Test
    public void test_saveWithoutId() {
        Cookbook cookbook = new Cookbook();
        cookbook.setBuyNum(11);
        cookbook.setName("caishi");
        cookbookRepository.save(cookbook);
        System.out.println(cookbook.getId());
    }


    @Test
    public void test_initCookBookData() {
        cookbookRepository.deleteAll();
        Cookbook cookbook1 = new Cookbook("鱼香茄子", 10, 20);
        Cookbook cookbook2 = new Cookbook("番茄炒蛋", 8, 18);
        Cookbook cookbook3 = new Cookbook("扬州炒饭", 7, 10);
        cookbookRepository.save(cookbook1);
        cookbookRepository.save(cookbook2);
        cookbookRepository.save(cookbook3);
        log.info("result:{}", JSON.toJSONString(cookbookRepository.findAll()));
    }


    @Test
    public void test_initDishesData() {

        userDishesRepository.deleteAll();
        UserDishes userDishes1 = new UserDishes("小明", "麻婆豆腐", LocalDate.now(), 1000);
        UserDishes userDishes2 = new UserDishes("小二", "扬州炒饭", LocalDate.now(), 1000);

        userDishesRepository.save(userDishes1);
        userDishesRepository.save(userDishes2);
        log.info("result:{}", JSON.toJSONString(userDishesRepository.findAll()));
    }

    @Test
    public void test_findBy() {
        log.info("result:{}", JSON.toJSONString(cookbookRepository.findByName("caishi")));
    }
}
