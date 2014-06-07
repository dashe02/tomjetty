package cn.lynn.tomjetty;




/**
 * Created with IntelliJ IDEA.
 * User: ThinkPad
 * Date: 14-6-6
 * Time: 下午10:49
 * To change this template use File | Settings | File Templates.
 */
public interface IServlet {
    public void service(Request req,Response res);
    public void doPost(Request req,Response res);
    public void doGet(Request req,Response res);
}
