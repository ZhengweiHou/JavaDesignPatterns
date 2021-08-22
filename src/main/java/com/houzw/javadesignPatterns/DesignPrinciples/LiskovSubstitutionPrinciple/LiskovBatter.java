package com.houzw.javadesignPatterns.DesignPrinciples.LiskovSubstitutionPrinciple;

public class LiskovBatter {
    public static void main(String[] args) {
        Base c = new C();
        System.out.println("2-2=" + c.func1(2,2));

        Base d = new D();
        // 开发人员在开发会阅读此处的func1时，就不会认为此处的func1就是固定的减法或加法逻辑
        System.out.println("2+2=" + d.func1(2,2));
        // 此处D实现的func2并不是父类的方法，所以在引用时无法通过Base类调用D类的func2方法，
        // 必须通过类似与强转成子类的方式来引用
        D dd = (D) d;
        System.out.println("2-2=" + dd.func2(2,2));
    }
}
abstract class Base {
    abstract public int func1(int x, int y);
}
class C extends Base{
    public int func1(int x, int y){
        return  x - y;
    }
}
class D extends Base{
    C c = new C();
    public int func1(int x, int y){
        return x + y;
    }
    public int func2(int x, int y) {
        return c.func1(x,y);
    }
}