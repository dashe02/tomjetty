package cn.lynn.tomjetty;

/**
 * Created with IntelliJ IDEA.
 * User: ThinkPad
 * Date: 14-6-6
 * Time: 下午9:30
 * To change this template use File | Settings | File Templates.
 */
public interface IRequestHeaderParser {
     public RequestHeader parse(String txt)throws Exception;
}
