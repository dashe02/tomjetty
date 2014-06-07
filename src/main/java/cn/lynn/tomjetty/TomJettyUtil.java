package cn.lynn.tomjetty;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: zhuzhenhua
 * Date: 14-6-6
 * Time: 下午9:05
 * To change this template use File | Settings | File Templates.
 * 用于程序读取服务器配置参数值
 */
public class TomJettyUtil {
      private static Properties pros=new Properties();
      static{
          try{
             pros.load(new FileInputStream("tomjetty.config"));
          }catch(IOException e){
              e.printStackTrace();
              System.exit(0);
          }
      }
     public static String getValue(String key){
         return pros.getProperty(key);
     }
}
