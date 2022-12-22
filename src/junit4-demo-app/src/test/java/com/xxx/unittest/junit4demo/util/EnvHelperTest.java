package com.xxx.unittest.junit4demo.util;

import com.xxx.unittest.junit4demo.mockadapter.SystemWrapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.script.*", "javax.management.*"})
@PrepareForTest({EnvHelper.class, SystemWrapper.class})
public class EnvHelperTest {

    @Test
    public void test(){
        PowerMockito.mockStatic(System.class);
        PowerMockito.when(System.getProperty("zookeeper.host")).thenReturn("staging");

        String zkHost =  EnvHelper.getZkHost();
        Assert.assertEquals("staging", zkHost);
        Assert.assertTrue(EnvHelper.isStZk());
    }
}
