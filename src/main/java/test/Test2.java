package test;

/**
 * Created by think on 2018/7/17.
 */
public class Test2 {
    public static String stringToAscii(String value)
    {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i != chars.length - 1)
            {
                sbu.append((int)chars[i]).append(",");
            }
            else {
                sbu.append((int)chars[i]);
            }
        }
        return sbu.toString();

    }

    public static void main(String[] args) {
       int k = 10;
       switch (k){
           default:
               System.out.println("defalult");
               break;
           case 2:
               System.out.println("10");
               break;
       }
    }

}
class A{
    public void me(){
        System.out.println("a");
    }
}
class B extends A{
    public void me(B b){
        System.out.println("B");
    }
}

class C extends B{
    public void me(){
        System.out.println("c");
    }
}