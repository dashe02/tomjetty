package cn.lynn.tomjetty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: ThinkPad
 * Date: 14-6-7
 * Time: 上午9:53
 * To change this template use File | Settings | File Templates.
 */
public class WebUtil {
    private  static Properties pros=new Properties();
    static {
        try {
            pros.load(new FileInputStream(".//webapps//web.config"));
        }catch(IOException e){
            e.printStackTrace();
            System.exit(0);
        }
    }
    public static String getValue(String key){
        return pros.getProperty(key);
    }






}
