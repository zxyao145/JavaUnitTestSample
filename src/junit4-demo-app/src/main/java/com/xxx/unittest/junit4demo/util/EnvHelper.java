package com.xxx.unittest.junit4demo.util;


import com.xxx.unittest.junit4demo.mockadapter.SystemWrapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnvHelper {
    final static Logger logger = LoggerFactory.getLogger(EnvHelper.class);

    public final static String STAGING = "staging";
    public final static String ONEBOX = "onebox";

    EnvHelper(){

    }


    public static String getZkHost() {
        String zkHost = SystemWrapper.getProperty("zookeeper.host");
        return zkHost;
    }

    public static String getClusterEnv() {
        String env = SystemWrapper.getenv("env");
        logger.info("EnvHelper get env: " + env);

        if(StringUtils.isBlank(env)){
            env = SystemWrapper.getenv("CUR_CLUSTER");
            logger.info("EnvHelper get env from CUR_CLUSTER: " + env);
        }

        return env;
    }


    //region zkHost judge

    public static Boolean isStZk() {
        return isStZk(getZkHost());
    }

    public static Boolean isStZk(String zkHost) {
        if (StringUtils.isBlank(zkHost)) {
            return false;
        }
        return zkHost.equalsIgnoreCase(STAGING);
    }

    public static Boolean isOneBoxZk() {
        return isOneBoxZk(getZkHost());
    }

    public static Boolean isOneBoxZk(String zkHost) {
        if (StringUtils.isBlank(zkHost)) {
            return false;
        }
        return zkHost.equalsIgnoreCase(ONEBOX);
    }

    //endregion


    //region environment variable judge

    public static Boolean isStEnv() {
        String env = getClusterEnv();
        if (StringUtils.isBlank(env)) {
            return false;
        }
        return env.equalsIgnoreCase(STAGING);
    }


    public static Boolean isAtEnv() {
        String env = getClusterEnv();
        if (StringUtils.isBlank(env)) {
            return false;
        }
        return env.equalsIgnoreCase(ONEBOX);
    }

    //endregion
}
