package com.openkey.utils;

import io.cucumber.plugin.Plugin;

import com.openkey.setups.CapabilitiesManager;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.*;

import java.io.IOException;


public class LogsHandler implements Plugin {

  private static Logger logger =LogManager.getLogger();

    public static void infoLogs (String msg)
  {
      logger.info(msg);

  }

    public static void warnLogs (String msg)
    {
        logger.warn(msg);

    }

    public static void errorLogs (String msg)
    {
        logger.error(msg);

    }

    public static void fatalLogs (String msg)
    {
        logger.fatal(msg);

    }


    public static void debugLogs (String msg)
    {
        logger.debug(msg);

    }


}
