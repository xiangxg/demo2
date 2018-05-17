package test;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by think on 2018/4/27.
 */
@XmlRootElement

public class Test {
    public static void main(String[] args){

    }
    @XmlElementRef
    private String str;

}
