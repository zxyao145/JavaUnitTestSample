package com.xxx.unittest.junit5demo.util;

import com.xxx.unittest.junit5demo.mockadapter.SystemWrapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mockStatic;


@ExtendWith(MockitoExtension.class)
public class EnvHelperTest {

    @Test
    public void test(){

        // powermockito 无法在junit5 中使用
        // Mockito 3.4.0 后支持静态方法的模拟，
        // 但是禁止模拟 System 和 Thread 的静态方法
        MockedStatic<SystemWrapper> mockStatic = mockStatic(SystemWrapper.class);
        mockStatic.when(() -> SystemWrapper.getProperty("zookeeper.host"))
                        .thenReturn("staging");
        String zkHost =  EnvHelper.getZkHost();
        System.out.println(zkHost);
        Assertions.assertEquals("staging", zkHost);
        Assertions.assertTrue(EnvHelper.isStZk());
    }

    @Test
    public void test2(){
        System.setProperty("zookeeper.host", "staging");
        String zkHost =  EnvHelper.getZkHost();
        System.out.println(zkHost);
        Assertions.assertEquals("staging", zkHost);
        Assertions.assertTrue(EnvHelper.isStZk());
    }
}
