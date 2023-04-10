package ListasSimples;

public class Main_Listas {
	public static <T> void main(String[] args) {
		LinkedList list = new LinkedList(1);
        
        list.addFirst(4);
        
        list.addFirst("Holaa");
        list.add(3);
        list.add("k");
        list.pop();

        Integer lista[]= {0, 1, 2, 3};
        System.out.println("La lista contiene el objeto " + list.contains(4));
        System.out.println("Se ha agregado el elemento " + list.add(5));
        System.out.println("Se ha agregado el elemento " + list.add(null));
        System.out.println("Se ha agregado el Array a la lista " + list.addLast(lista));
        System.out.println("Se ha agregado al inicio de la lista "+ list.addFirst(67));
        System.out.println("Tamaño de la lista " + list.size());
        
        System.out.println(list.toString());
	}
 

}
