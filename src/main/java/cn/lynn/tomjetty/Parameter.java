package cn.lynn.tomjetty;

/**
 * Created with IntelliJ IDEA.
 * User: ThinkPad
 * Date: 14-6-6
 * Time: 下午10:42
 * To change this template use File | Settings | File Templates.
 */
public class Parameter {
    private String key;

    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public int hashCode(){
        final int prime=31;
        int result=1;
        result=prime*result+((key==null)?0:key.hashCode());
        result=prime*result+((value==null)?0:value.hashCode());
        return result;
    }
    public boolean equals(Object obj){
        if(this==obj)
            return true;
        if(obj==null)
            return false;
        if(getClass()!=obj.getClass())
            return false;
        final Parameter other=(Parameter)obj;
        if(key==null){
            if(other.key!=null)
                return false;
        }else if(!key.equals(other.key))
            return false;
        if(value==null){
            if(other.value!=null)
                return false;
        }else if(!value.equals(other.value))
            return false;
        return true;
    }
}
