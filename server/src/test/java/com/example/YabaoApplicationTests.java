package com.example;

import com.example.domain.Cookbook;
import com.example.domain.User;
import com.example.repository.CookbookRepository;
import com.example.repository.UserRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void test_() {
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
}
