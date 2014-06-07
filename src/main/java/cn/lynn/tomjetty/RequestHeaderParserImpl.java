package cn.lynn.tomjetty;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: ThinkPad
 * Date: 14-6-6
 * Time: 下午9:31
 * To change this template use File | Settings | File Templates.
 */
public class RequestHeaderParserImpl implements IRequestHeaderParser{
    //以IE浏览器为例,其他的浏览器请求头的参数顺序会有变动
    //解析HTTP请求头
    @Override
    public RequestHeader parse(String txt) throws Exception {
        RequestHeader header=new RequestHeader();
        header.setText(txt);
        //截取请求头第一行
        String firstLine=txt.substring(0,txt.indexOf("\n"));
        String method=firstLine.substring(0,firstLine.indexOf(" "));
        String url=firstLine.substring(firstLine.indexOf(" ")+1,firstLine.lastIndexOf(" "));
        String protocal=firstLine.substring(firstLine.lastIndexOf(" ")+1,firstLine.length());
        String parameter=null;
        header.setMethod(method);
        header.setUrl(url);
        header.setProtocal(protocal);
        String[] lines=txt.split("\n");
        HashMap<String,String> map=new HashMap<String, String>();
        //从请求头第二行开始分隔,因为第一行没有冒号
        for(int i=1;i<lines.length;i++){
            String[] result=lines[i].split(":");
            if(result.length==2){
            map.put(result[0],(result.length<=1)?"":result[1].replace("\n","").trim()) ;
            }else if(result.length==3){
            map.put(result[0],result[1]+":"+result[2]);
            }
            }
         header.setMap(map);
         header.setAccept(map.get("Accept"));
         header.setAccept_language(map.get("Accept-Language"));
         header.setUser_agent(map.get("User-Agent"));
         header.setAccept_encoding(map.get("Accept_Encoding"));
         header.setIp(map.get("Host").split(":")[0]);
         header.setPort(map.get("Host").split(":")[1]);
         header.setConnection(map.get("Connection"));
         header.setCookie(map.get("Cookie"));
         try{
             if(method.equalsIgnoreCase("post")){
                 parameter=txt.substring(txt.lastIndexOf("\n")+1,txt.length());
             }else if(method.equalsIgnoreCase("get")){
                 parameter=url.substring(url.indexOf("?")+1,url.length());
                 url=url.substring(0,url.indexOf("?"));
             }
         }catch(Exception e){
             e.printStackTrace();
         }
        header.setParameter(parameter);
         return header;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
