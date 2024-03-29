package cn.lynn.tomjetty;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: ThinkPad
 * Date: 14-6-6
 * Time: 下午9:19
 * To change this template use File | Settings | File Templates.
 * 封装请求头
 */
public class RequestHeader {
    private String method;
    private String url;
    private String protocal;
    private String accept;
    private String accept_language;
    private String user_agent;
    private String accept_encoding;
    private String ip;
    private String port;
    private String connection;
    private String cookie;
    //存放请求头键值对
    private HashMap<String,String> map;
    //存放请求头文本
    private String text;

    private String parameter;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProtocal() {
        return protocal;
    }

    public void setProtocal(String protocal) {
        this.protocal = protocal;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getAccept_language() {
        return accept_language;
    }

    public void setAccept_language(String accept_language) {
        this.accept_language = accept_language;
    }

    public String getAccept_encoding() {
        return accept_encoding;
    }

    public void setAccept_encoding(String accept_encoding) {
        this.accept_encoding = accept_encoding;
    }

    public String getUser_agent() {
        return user_agent;
    }

    public void setUser_agent(String user_agent) {
        this.user_agent = user_agent;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String toString(){
        return "RequestHeader["+"\n"
         +method+""+""+url+""+protocal+"\n"
         +"Accept:"+accept+"\n"
         +"Accept-Language:"+accept_language
         +"User-Agent:"+user_agent+"\n"
         +"Accept-Encoding:"+accept_encoding+"\n"
         +"Host:"+ip+":"+port+"\n"
         +"Connection:"+connection+"\n"
         +"Cookie:"+cookie+"\n"
         +"Parameter:"+parameter+"\n"
         +"]";
    }



}
