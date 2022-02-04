import java.util.*;
// Static > Instance> Constructor> Method
class Hou{
    Hou(){
        System.out.println("Constructor");
    }
    public void myMethod(){
        System.out.println("My method");
    }
    {
        System.out.println("Instance");
    }
    
    static{
        System.out.println("Static");
    }
}

class ExecOrder{
    public static void main (String[] args) {
        Hou h=new Hou();
        h.myMethod();
    }
}