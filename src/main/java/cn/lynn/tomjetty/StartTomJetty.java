package cn.lynn.tomjetty;

/**
 * Created with IntelliJ IDEA.
 * User: ThinkPad
 * Date: 14-6-6
 * Time: 下午9:13
 * To change this template use File | Settings | File Templates.
 */
public class StartTomJetty {
    public static void main(String[] args){
        try{
           TomJetty.openServer();
        }catch(Exception e){
            try{
                TomJetty.closeServer();
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }
}
