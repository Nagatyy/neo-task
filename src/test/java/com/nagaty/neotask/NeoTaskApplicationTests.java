package com.nagaty.neotask;

import com.nagaty.neotask.controllers.CheckoutController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class NeoTaskApplicationTests {
    @Autowired
    CheckoutController controller;


    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
