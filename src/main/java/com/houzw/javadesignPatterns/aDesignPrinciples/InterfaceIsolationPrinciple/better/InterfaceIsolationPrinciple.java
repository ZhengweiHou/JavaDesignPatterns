package com.houzw.javadesignPatterns.aDesignPrinciples.InterfaceIsolationPrinciple.better;

	
interface Interface1{
	void fun1();
}

interface Interface2{
	void fun2();
	void fun3();
}

interface Interface3{
	void fun4();
	void fun5();
}

class C implements Interface1,Interface2{

	public void fun1() {
		System.out.println("C.fun1");
	}
	public void fun2() {
		System.out.println("C.fun2");
	}
	public void fun3() {
		System.out.println("C.fun3");
	}
	
}

class D implements Interface1,Interface3{

	public void fun1() {
		System.out.println("D.fun1");
	}
	public void fun4() {
		System.out.println("D.fun4");
	}
	public void fun5() {
		System.out.println("D.fun5");
	}
}


class A {
	public void depend1(Interface1 i) {
		i.fun1();
	}
	public void depend2(Interface2 i) {
		i.fun2();
	}
	public void depend3(Interface2 i) {
		i.fun3();
	}
}

class B {
	public void depend1(Interface1 i) {
		i.fun1();
	}
	public void depend4(Interface3 i) {
		i.fun4();
	}
	public void depend5(Interface3 i) {
		i.fun5();
	}
}


public class InterfaceIsolationPrinciple {
	public static void main(String[] args) {
		A a = new A();
		a.depend1(new C());
		a.depend2(new C());
		a.depend3(new C());
		
		B b = new B();
		b.depend1(new D());
		b.depend4(new D());
		b.depend5(new D());
	}
	
	
}
