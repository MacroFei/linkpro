package com.xlccc.springbootmybatisannotation;

import com.xlccc.mapper.UserMapper;
import com.xlccc.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisAnnotationApplicationTests {

    @Autowired
    UserMapper userMapper;
//	@Test
//	void contextLoads() {
//	}

    @Test
    void getAll() {
        System.out.println(userMapper.findAll());
    }

    @Test
    void add() {
        User user = new User();
        user.setName("demo");
        userMapper.save(user);
    }
    @Test
    void test(){
        User user = new User();
        user.setId(5);
        user.setName("test");
        userMapper.save(user);

        System.out.println(userMapper.findAll());

        user.setName("testUpdate");
        userMapper.update(user);

        System.out.println(userMapper.findAll());

        userMapper.delete(user.getId());
        System.out.println(userMapper.findAll());


    }
}
