package java8Feature;
@FunctionalInterface
interface A{
	public void m1();
	public default void print() {
		System.out.println("A interface");
	}
}

@FunctionalInterface
interface B{
	public void m2();
	public default void print() {
		System.out.println("B interface");
	}
}
public class DefailtInterface implements A,B {

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m1() {
		
	}

	@Override
	public void print() {
		B.super.print();
	}

}
