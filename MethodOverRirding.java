class A {
    public void  meth1(){
        System.out.println("I am method 1 of class A");
    }
}
class B extends A{
    @Override // this annotation in used to tell if overriding is happening or not for clear understanding it shows error if overriding is not happening
    public void  meth1(){
        System.out.println("I am method 1 of class B");
    }
    public void meth2(){
        System.out.println("I am method 2 of class B");
    }
}
public class MethodOverRirding {
    public static void main(String[] args) {
        // A a=new A();
        // a.meth1();
        B b=new B();
        b.meth1();
    }
}
