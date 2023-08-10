package my.day06;


class A {
	public void method1() {  
		System.out.println("A-method1()");
	}
}

class B extends A {
	
	public void method1() {  //재정의
		System.out.println("B-method1()");
	}
}

class C extends A {
	public void method1() { // 재정의 
		System.out.println("C-method1()");
	}
	public void method2() { // 자식꺼
		System.out.println("C-method2()");
	}
	
}
class D extends A {
	public void method3() { // 재정의 
		System.out.println("D-method3()");
	}
	public void method2() { // 자식꺼
		System.out.println("D-method2()");
	}
	
}


public class Example {
	public static void action(A a) { // 부모타입으로 묶을 수 있다.
		a.method1();
		if(a instanceof C c) { // 객체 확인
			//((C)a).method2(); 바로 사용하는 거
			c.method2(); // 아니면 이렇게 사용 
		}else if(a instanceof D d) {
			d.method3();
		}
	}
	public static void main(String[] args) {
		action(new A());
		action(new B());
		action(new C());
		action(new D());
		

	}

}
