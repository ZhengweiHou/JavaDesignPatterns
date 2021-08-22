package com.houzw.javadesignPatterns.DesignPrinciples.LiskovSubstitutionPrinciple;

public class LiskovBad {
    public static void main(String[] args) {
        // 实际使用处都通过父类来引用,对父类同名非抽象方法的使用缺导致不同的结果，这是不符合里氏替换原则的
        A a = new A();
        System.out.println("2-2=" + a.func1(2,2));

        A b = new B();
        // 因为A中的func1中的逻辑是减法且此处通过IDEA点入方法时显示的也是减法逻辑，
        // 很容易在开发时开发人员认为此处的逻辑依然是减法，但实际上B重写了父类该方法且
        // 逻辑进行了修改，此时就会产生非预估的结果
        System.out.println("2-2=" + b.func1(2,2));
    }
}
class A{
    public int func1(int x, int y){
        return  x - y;
    }
}
class B extends A{
    // （不符合原则的方式）P的子类A重写了父类的非抽象方法,并修改的逻辑
    public int func1(int x, int y){
        return x + y;
    }
}