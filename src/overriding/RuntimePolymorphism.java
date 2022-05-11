package overriding;

public class RuntimePolymorphism {

	public static void main(String[] args) {
		Parent p= new Child1();
		p.m1();
	}
}

class Parent{
	void m1() {
		System.err.println("P:");
	}
}

class Child extends Parent{
	void   m1() {
		System.err.println("C:");
	}
}
class Child1 extends Child{
	void   m1() {
		System.err.println("C1:");
	}
}