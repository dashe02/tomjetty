package cn.lynn.servlet;

import cn.lynn.tomjetty.HttpServletImpl;
import cn.lynn.tomjetty.Request;
import cn.lynn.tomjetty.Response;


/**
 * Created with IntelliJ IDEA.
 * User: ThinkPad
 * Date: 14-6-7
 * Time: 上午9:44
 * To change this template use File | Settings | File Templates.
 */
public class LoginServlet extends HttpServletImpl{

    @Override
    public void doGet(Request req, Response res) {
    String username=req.getParameterValue("username");
    String password=req.getParameterValue("password");
    if(username.equals("admin")&&password.equals("admin")){
        res.out.print("Hello,"+username+"<br>");
    }
        res.out.close();
    }

    @Override
    public void doPost(Request req, Response res) {
       String username=req.getParameterValue("username");
       String password=req.getParameterValue("password");
        if(username.equals("admin")&&password.equals("admin")){
            res.out.print("Hello,"+username+"<br>");
        }
        res.out.close();
    }
    }

