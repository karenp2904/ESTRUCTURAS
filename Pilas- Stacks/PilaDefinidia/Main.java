package PilaDefinidia;

public class Main {
	public static void main(String[] args) {
		Stacks pila= new Stacks(67);
		
		pila.push(1);
		pila.push("holaaa!");
		pila.push(3);
		
		System.out.println(pila.peek());
		System.out.println(pila.search(3));
		System.out.println(pila.print());
		
		System.out.println("holaa");
		pila.reverse();
		System.out.println(pila.print());
	}
}
