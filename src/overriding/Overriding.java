package overriding;

public class Overriding {

	public static void main(String[] args) {
		P p=new P();
		System.err.println(p.s);
		System.err.println(p.x);
		p.marry();
		C c=new C();
		System.err.println(c.s);
		System.err.println(c.x);
		c.marry();
		c.abs();
		P p1=new C();
		System.err.println(p1.s);
		System.err.println(p1.x);
		
		P p2=new C();
		p2.abs1();
	}
	
}

class P{
	String s="Parent";
	int x=10;
	public void marry() {
		System.out.println("Shridevi");
	}
	
	public static void abs1() {
		System.out.println("parent abstract");
	}
}

class C extends P{
	String s="Child";
	int x=20;
	@Override
	public void marry() {
		System.out.println("Alia");
	}
	public static void abs() {
		System.out.println("child abstract");
	}
}
