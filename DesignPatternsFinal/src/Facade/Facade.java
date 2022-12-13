package Facade;

//外观类
public class Facade {

    Connect a;
    InitializeMap b;
    Check c;

    //外观设计模式创建新的过程
    public Facade() {
        a = new Connect();
        b = new InitializeMap();
        c = new Check();
    }

    //提供给外部访问的方法
    public void method_Connect() {
        this.a.dosomething();
    }

    public void method_InitializeMap() {
        this.b.dosomething();
    }

    public void method_Check() {
        this.c.dosomething();
    }
    
    //外观设计的四个method
    public void method() {
        method_Connect();
        method_InitializeMap();
        method_Check();
    }
}
