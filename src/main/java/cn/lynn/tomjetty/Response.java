package cn.lynn.tomjetty;

import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: ThinkPad
 * Date: 14-6-7
 * Time: 上午9:49
 * To change this template use File | Settings | File Templates.
 */
public class Response {
    public PrintWriter out;

    public PrintWriter getOut() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }
}
