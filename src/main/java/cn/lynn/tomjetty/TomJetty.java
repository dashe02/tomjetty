package cn.lynn.tomjetty;

import javax.print.DocFlavor;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: ThinkPad
 * Date: 14-6-6
 * Time: 下午9:09
 * To change this template use File | Settings | File Templates.
 * http://m.bianceng.cn/a/2013/1118/38214_3.htm
 */
public class TomJetty extends Thread{
    private static ServerSocket server;
    private Socket socket;

    public TomJetty(Socket socket){
        this.socket=socket;
    }
    public static void openServer() throws Exception{
        server=new ServerSocket(Integer.parseInt(TomJettyUtil.getValue("tomjetty.port")));
        while(true){
            new TomJetty(server.accept()).start();
        }
    }
    public static void closeServer() throws Exception{
        if(server!=null){
            if(!server.isClosed()){
                server.close();
            }
        }
    }
    public void run(){
        InputStream in =null;
        OutputStream out=null;
        FileInputStream fin=null;
        try{
          in=socket.getInputStream();
          out=socket.getOutputStream();
          byte[] b=new byte[1024*1024];
          in.read(b);
          String txt=new String(b).trim();
          IRequestHeaderParser parser=(IRequestHeaderParser)Class.forName(TomJettyUtil.getValue("tomjetty.requestheader.class")).newInstance();
          RequestHeader header=parser.parse(txt);
            System.out.println(header);
        /*    File html=new File(TomJettyUtil.getValue("tomjetty.webapps"),header.getUrl());
            fin=new FileInputStream(html);
            byte[] buf=new byte[(int)html.length()];
            fin.read(buf);
            out.write(buf);*/
            //添加参数
            Request request=new Request();
            request.setParameter(header.getParameter());
            request.setHeader(header);
            //添加动态页面请求功能
            Response res=new Response();
            if(WebUtil.getValue(header.getUrl())!=null){
              try{
                int x=header.getUrl().indexOf("?");
                String className=WebUtil.getValue(header.getUrl().substring(0,x));
                IServlet servlet=(IServlet)Class.forName(className).newInstance();
                res.setOut(new PrintWriter(out));
                servlet.doPost(request,res);
              }catch(Exception e){
                  File file=new File(TomJettyUtil.getValue("tomjetty.webapps"),"500.html");
                  fin=new FileInputStream(file);
                  byte[] buf=new byte[(int)file.length()];
                  fin.read(buf);
                  out.write(buf);
              }
            }else{
                File file=new File(TomJettyUtil.getValue("tomjetty.webapps"),header.getUrl());
                if(!file.exists()){
                    file=new File(TomJettyUtil.getValue("tomjetty.webapps"),"404.html");
                }
                fin=new FileInputStream(file);
                byte[] buf=new byte[(int)file.length()];
                fin.read(buf);
                out.write(buf);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(fin!=null){
                    fin.close();
                }
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
                if(socket!=null){
                    socket.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
