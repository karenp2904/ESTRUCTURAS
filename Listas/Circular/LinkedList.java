package Circular;

import java.util.Iterator;
import java.util.ListIterator;




public class LinkedList<T> implements List<T> {
	
    public LinkedListNode head;
    public LinkedListNode tail;//La cola sera la bandera que me indicará cuando se dio una vuelta
    
    // Iterator.
    LinkedListNode inode=new LinkedListNode();

    Iterator iterator=iterator();// se usará el iterador para recorrer la lista
   // int cont; //contador de elementos en la lista
    
    public LinkedList() { //permite iniciar una lista sin que tenga ningun nodo
        this.head = null;
        this.tail = null;
    }
    

    public LinkedList(T object) { //Permite pasar el primer elemento
        this.head = tail = new LinkedListNode(object);
    }
    
    
    //1 Agrega un objeto al final de la lista.
    @Override
    public boolean add(T object) {
      
        boolean ack = false;
        try{
        	if(object!=null) {
        		if(isEmpty()){
            		head=new LinkedListNode(object);
            	}
        		else {
        			LinkedListNode nodo=new LinkedListNode(object);
        			nodo.next=head;
        			tail.next=nodo;
        			tail=nodo;
        		}
        		ack=true;
        	}
        	return ack;
        } catch (Exception e){
            e.printStackTrace();
        }finally{
            return ack; //retornar el valor booleano que indica si hubo una insercion o no
        }
    }
    
    
    //2 Inserta un objeto en una posición siguiente al nodo especificado.
    @Override
    public boolean add(Node node, T object) {
    	boolean agregado=false;
    	LinkedListNode nodo=(LinkedListNode)node;
    	try {
    		if(object!=null) {
    			LinkedListNode otroNodo= new LinkedListNode(object);
    			if(isEmpty()) {
    				nodo=new LinkedListNode(object);
    				nodo=head;
    				otroNodo=nodo.next;
    			}
    			else {
    				otroNodo=nodo.next;
    			}
    			agregado=true;
    		}
    		return agregado;
    	}catch (Exception e){
            e.printStackTrace();
        }finally{
            return agregado; 
        }
    }
    //3 Inserta un nodo en una posición siguiente al nodo especificado.
    @Override
    public boolean add(Node node, Node next) {
    	LinkedListNode nodoAInsertar= (LinkedListNode)node;
    	LinkedListNode nodoEspecificado=(LinkedListNode)next;
    	boolean agredado=false;
    	try {
    		if(isEmpty()) {
    			nodoEspecificado=head; 
				nodoAInsertar=nodoEspecificado.next;//el siguiente a la cabeza
				nodoAInsertar=new LinkedListNode();  
    		}else {
    			nodoAInsertar=nodoEspecificado.next;
            	nodoAInsertar=new LinkedListNode();
    		}
    		agredado=true;
    		return agredado;
    	}catch (Exception e) {
    		e.printStackTrace();
        }finally{
            return agredado; 
        }
    }

    //4. Agrega todos los objetos de un array al final de la lista.
    @Override
    public boolean add(T[] objects) {
    	boolean agregado=false;
    	try {
    		if(objects!=null) {
    			for (int i = 0; i < objects.length; i++) {
					add(objects[i]);
				}
    			agregado=true;
    		}
    		return agregado;
    	}catch (Exception e) {
    		e.printStackTrace();
        }finally{
            return agregado; 
        }
        
    }

    //5. Inserta todos los objetos de un array desde el nodo especificado.
    @Override
    public boolean add(Node node, T[] objects) {
    	LinkedListNode nodo=(LinkedListNode)node;
    	boolean agredado=false;
    	try {
    		if(objects!=null) {
    			if(isEmpty()) {
    				for (int i = 0; i < objects.length; i++) {
						addFirst(objects[i]);
					}
    			}
    			else {
    				for (int i = 0; i < objects.length; i++) {
						add(nodo, objects[i]);
					}
    			}
    			agredado=true;
    		}	
    		return agredado;
    	}catch (Exception e) {
    		e.printStackTrace();
        }finally{
            return agredado; 
        }
    }

    // 6. Inserta el objeto especificado al inicio de la lista.
    @Override
    public boolean addFirst(T object) {
    	boolean agregado=false;
    	try {
    		if(object!=null) {
    			if(isEmpty()) {
    				add(object);
    			}else {
    				LinkedListNode nuevoNodo= new LinkedListNode<T>(object);
    				nuevoNodo=head;
    				tail.next=nuevoNodo;
    				tail=nuevoNodo;
    			}
    			agregado=true;
    		}
    		return agregado;
    	}catch (Exception e) {
    		e.printStackTrace();
        }finally{
            return agregado; 
        }
    }

    // 7. Agrega todos los objetos de un array al inicio de la lista.
    @Override
    public boolean addFirst(T[] objects) {
    	boolean agregado=false;
    	try {
    		if(objects!=null) {
    			for (int i = 0; i < objects.length; i++) {
    				addFirst(objects[i]);
    			}
    			agregado=true;
    		}	
    		return agregado;
    	}catch (Exception e) {
    		e.printStackTrace();
        }finally{
            return agregado; 
        }
    }

    //8. Inserta el objeto especificado al final de la lista.
    @Override
    public boolean addLast(T object) {
    	boolean agregado=false;
    	try {
    		if(object!=null) {
    			if(isEmpty()) {
    				add(object);
    			}else {
    				add(object);
    			}
    			agregado=true;
    		}
    		return agregado;
    	}catch (Exception e) {
    		  e.printStackTrace();
		}finally{
			return agregado;
		}
    	 
    }

    //9. Agrega todos los objetos de un array al final de la lista.
    @Override
    public boolean addLast(T[] objects) {
    	boolean agregado=false;
    	try {
    		if(objects!=null) {
    			for (int i = 0; i < objects.length; i++) {
    				add(objects[i]);
    			}
    			agregado=true;
    		}
    		return agregado;
    	}catch (Exception e) {
    		e.printStackTrace();
		}finally{
			return agregado;
		}
    }

    //  10. Elimina todos los elementos de la lista.
    @Override
    public boolean clear() {
      head=null; tail=null;
      return true;
    }

    //11. Retorna una instacia nueva de la lista.
    @Override
    public List clone() {
    	LinkedList nuevaLista=new LinkedList();
    	try {
    		if(isEmpty()) {
    			return nuevaLista;
    		}
    		else {
    			LinkedListNode nodoAux=head;
        		for (int i = 0; i < size(); i++) {
    				nuevaLista.add(nodoAux.getObject());
    				nodoAux=nodoAux.next;
    			}
        	    return nuevaLista;
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
    		return null;
		}
    }
    //12. Retorna verdadero si contiene el objeto.
    @Override
    public boolean contains(T object) {
    	boolean objetoEncontrado=false;
    	try {
    		if(object!=null) {
    			if(isEmpty()) {
    				return objetoEncontrado;
    			}
    			else {
    				while(iterator.hasNext()) {
    					if(iterator.next().toString().contentEquals(object.toString())) {
    						objetoEncontrado=true;
    					}
    				}
    				return objetoEncontrado;
    			}
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
		}finally {
			return objetoEncontrado;
		}
        
    }

    // 13. Retorna verdadero si contiene todos los objetos.
    @Override
    public boolean contains(T[] objects) {
    	boolean objetoEncontrados=false; int contenedor=0;
    	try {
    		if(objects!=null) {
    			if(isEmpty()) {
    				return objetoEncontrados;
    			}
    			else {
    				while(iterator.hasNext()) {//el iterador verifica que exista un nodo siguiente pero se hara hasta que vuelva a la cabeza es decir tail.next
    					if(iterator.next()!=tail.next) {//aqui se recorrera la lista por cada elemento del arreglo
    						for (int i = 0; i < objects.length; i++) {
        						if(iterator.equals(objects[i])) {
            						contenedor++;// el contenedor sera un acumulador que aumentara si encuentra un objeto
            					}
    						}
    					}
    				}
    				if(contenedor==objects.length) {//si el contenedor es igual al tamaño del arreglo todos los objetos fueron encontrados
    					objetoEncontrados=true;
    				}
    				return objetoEncontrados;//se retorna
    			}
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
		}finally {
			return objetoEncontrados;
		}
    }

    //15. Retorna el nodo del objeto especificado, o null si no contiene el objeto.
    @SuppressWarnings("finally")//Por que aparece?? Buscar :( -RTA : the compiler will ignore warnings if any for that piece of code
	@Override
    public Node nodeOf(T object) {
    	boolean nodoEncontrado=false;
    	LinkedListNode nodoAux = new LinkedListNode();
    	try {
    		while (iterator.hasNext()) {
    			nodoAux= (LinkedListNode) iterator.next();// el nodoAux se usara para poder accedeer al objeto y poder comparar 
    			if(nodoAux.getObject().equals(object)) { //cuando se encuentre el aux se comparara
    				nodoEncontrado=true;
    				return nodoAux; 
        		}
			}
		}catch (Exception e) {
    		e.printStackTrace();
    		return null;
		}finally{
			if(nodoEncontrado=true) {// si encuentra al objeto retorna el nodo 
				return nodoAux;
			}
			else {
				return null;// si nodoEncontrado es falso, no encontro nada, retorna null
			}
		}
		
    }
    

    //16. Retorna verdadero si no contiene elementos.
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    // 17. Retorna el objeto del último nodo insertado.
    @Override
    public T get() {
    	return (T) tail.getObject(); //se torna la cola jsksk
    }

    // 18. Retorna un objeto de la posición del nodo especificado.
    @Override
    public T get(Node node) {
    	LinkedListNode nodoNuevo = (LinkedListNode) node;
    	boolean objetoEn=false;
    	//T objeto=null;
    	try {
    		return (T) nodoNuevo.next.getObject(); //retorna el objeto del siguiente nodo con el cast
          
    	}catch (Exception e) {
    		e.printStackTrace();
    		return null;//no encontro nada
		}
    }

    //19. Retorna un objeto de la posición previa al nodo especificado.
    @Override
    public T getPrevious(Node node) {
    	Object temporal=null;// el temporal lo hice para ponerlo en el finally y que siempre retornara algo
    	try {
    		if(node!=null) {
    			LinkedListNode nodoEspecificado=(LinkedListNode)node;
        		LinkedListNode nodoObjeto= new LinkedListNode();// en este nodo se guardara el nodo que se itera y asi se podra obtener el objeto
        		while(iterator.hasNext()) {
        			nodoObjeto=(LinkedListNode) iterator.next();
        			if(nodoObjeto.next==nodoEspecificado) {
        				temporal= (T) nodoObjeto.getObject();// el temporal se modifica solo cuando encuentra al nodo previo
        				return (T) temporal;
        			}
        		}
    		}
		}catch (Exception e) {
    		e.printStackTrace();
    		return null;
		}finally {
			return (T) temporal;//siempre dara nulooooo :((
		}
    }

    //20. Retorna un objeto de la posición siguinete al nodo especificado.
    @Override
    public T getNext(Node node) {
    	LinkedListNode nodoEspecificado=(LinkedListNode)node;
    	try {
    		return (T) nodoEspecificado.next.getObject();// el nodo especificad.next es el siguiente se obtiene el objeto
    	}catch (Exception e) {
    		e.printStackTrace();
        }finally{
            return null;
        }
        
    }

    //21. Retorna el objeto al inicio de esta lista.
    @Override
    public T getFirst() {
    	return (T) head.getObject(); // la cabeza sera el inicio de la lista
    
    }

    //22. Retorna un array de n objetos desde inicio de esta lista.
    @Override
    public T[] getFirst(int n) {
    	Object [] arrayObjeto=new Object[n];
    	try {
    		if(isEmpty()) {
    			arrayObjeto=null;		       
    			return (T[]) arrayObjeto;
    		}
    		else{
    			while(iterator.hasNext()) {
    				for (int i = 0; i < n; i++) {
    					LinkedListNode nodoObjeto=(LinkedListNode) iterator.next();// se crea un nodo en el que se guardara el nodo que retorna el iterador
    					arrayObjeto[i]= nodoObjeto.getObject();// con el nodo creado se obtiene el objeto y se guarda en el array
    				}
    			}
    			return (T[]) arrayObjeto;
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
        }finally{
            return (T[]) arrayObjeto;
        }
    }

    //23. Retorna el objeto al final de esta lista.
    @Override
    public T getLast() {
       return (T) tail.getObject();// el objeto al final de la lista sigue siendo la cola
    }
   
    // 24. Retorna un array de n objetos previos al final de esta lista.
    @Override
    public T[] getLast(int n) {
    	Object [] arrayObjeto=new Object[n];
    	try {
    		if(isEmpty()||n<0) {
    			arrayObjeto=null;		       
    			return (T[]) arrayObjeto;
    		}
    		else{
    			while(iterator.hasNext()) {
    				for (int i = 0; i < size(); i++) {//el arreglo tendra todos los elementos de la lista
    					LinkedListNode nodoObjeto=(LinkedListNode) iterator.next();// se crea un nodo en el que se guardara el nodo que retorna el iterador
    					arrayObjeto[i]= nodoObjeto.getObject();// con el nodo creado se obtiene el objeto y se guarda en el array
    				}
    			}
    			return (T[]) arrayObjeto;
    		}	
    	}catch (Exception e) {
    		e.printStackTrace();
        }finally{
            return (T[]) arrayObjeto;
        }
    }

    //25. Retorna el objeto al final de esta lista y lo elimina. 
	@Override
    public T pop() {
		Object objectTail=null;
		try {
			while(iterator.hasNext()) {
				LinkedListNode temporal=(LinkedListNode) iterator.next();
				if(temporal.next==tail) {// aqui se tendra la posicion previa a la cola
					objectTail=tail.getObject();
					tail.setObject(null);
					temporal.next=tail.next;
					  return (T) objectTail;
				}
			}
		}catch (Exception e) {
    		e.printStackTrace();
        }finally{
            return (T) objectTail;
        }
    }

    //26. Elimina el nodo en la lista.
    @Override
    public boolean remove(T object) {
    	boolean remover=false;
    	try {
    		if(isEmpty()||object==null) {
    			return remover;
    		}
    		else {
    			while(iterator.hasNext()) {
    				LinkedListNode nodoRemover=(LinkedListNode) iterator.next();
    				if(nodoRemover.next.getObject()==object) {// el nodo anterior al nodo donde se encuentra el objeto
    					nodoRemover=nodoRemover.next.next;//el nodo sera el nodo que le sigue dos veces?
    					nodoRemover.next=null;
    					remover=true;
    				}
				}
    		}
    		return remover;
    	}catch (Exception e) {
    		e.printStackTrace();
        }finally{
            return remover;
        }
    }

    //27. Elimina el nodo en la lista.
    @Override
    public boolean remove(Node node) {
    	LinkedListNode nodoEliminado=(LinkedListNode)node;
    	boolean remover=false;
    	try {
    		if(isEmpty()||nodoEliminado==null) {
    			return remover;
    		}
    		else {
    			while(iterator.hasNext()) {
    				LinkedListNode nodoAnterior=(LinkedListNode) iterator.next();// el nodo anterior tendra el nodo que recibe el iterador
    				if(nodoAnterior.next==nodoEliminado) {// el nodo anterior al nodo donde se encuentra el objeto
    					nodoAnterior=nodoEliminado.next;//el nodo anterior tendra siguiente al nodoeliminado.next
    					nodoEliminado=null;//se elimina
    					remover=true;
    				}
				}
    		}
    		return remover;
       }catch (Exception e) {
    	   e.printStackTrace();
		}finally {
			return remover;
		}
    }

    //28. Elimina de esta lista todos los nodos de los objetos que están contenidos en la colección especificada
    @Override
    public boolean removeAll(T[] objects) {
    	boolean removidos=false;
    	try {
    		if(objects!=null||isEmpty()) {
    			return removidos;
    		}else {
    			while(iterator.hasNext()) {
    				for (int i = 0; i < objects.length; i++) {
    					LinkedListNode nodoAux=(LinkedListNode)iterator.next();
						if(nodoAux.next.getObject()==objects[i]) {//se tiene la poscion sigueinte pero con el aux estando en el anterior
							nodoAux=nodoAux.next.next;// el anterior se conecta al siguiente del nodo donde se encuentra el objeto
						}
					}
    			}
    			removidos=true;
    		}
    		return removidos;
        }catch (Exception e) {
     	   e.printStackTrace();
 		}finally {
 			return removidos;
 		}  
    }

    // 29. Conserva solo los objetos del array
    @Override
    public boolean retainAll(T[] objects) {
    	boolean conserva=false;
    	Object[] objetosGuardados= new Object[size()];
    	try {
    		if(objects!=null||isEmpty()) {
    			return conserva;
    		}else {
    			while(iterator.hasNext()) {
    				for (int i = 0; i < objects.length; i++) {
    					LinkedListNode nodoAux=(LinkedListNode)iterator.next();
    					if(nodoAux.getObject()==objects[i]) {	
    						objetosGuardados[i]=nodoAux.getObject();
    					}
					}
    			}
    			head=(LinkedListNode) objetosGuardados[0];
    			for (int i = 1; i <= objetosGuardados.length; i++) {
					LinkedListNode nodoItera= (LinkedListNode) iterator.next();
					nodoItera=(LinkedListNode) objetosGuardados[i];
					if(i==objetosGuardados.length) {
						tail=(LinkedListNode) objetosGuardados[i];
						nodoItera=tail;
					}
				}
    			conserva=true;
    		}
    		return conserva;
        }catch (Exception e) {
        	e.printStackTrace();
		}finally {
			return conserva;
		}
    }

    //30. Reemplaza el objeto en la posición del nodo especificado.
    @Override
    public boolean set(Node node, T object) {
    	boolean reemplazar=false;
    	LinkedListNode nodoEsp=(LinkedListNode)node;
        try {
        	nodoEsp.setObject(object);
        	reemplazar=true;
        	return reemplazar;
        }catch (Exception e) {
        	e.printStackTrace();
		}finally {
			return reemplazar;
		}
    }

    //31. Retorna el número de nodos de esta lista.
    @Override
    public int size() {
    	int contador=0;
        try {
        	while(iterator.hasNext()) {
        		contador++;
        	}
        	return contador;
        }catch (Exception e) {
        	e.printStackTrace();
		}finally {
			return contador;
		}
    }
       

    //32. Retorna una sub lista de la lista.
    @Override
    public List subList(Node from, Node to) {
       LinkedListNode nodoFrom=(LinkedListNode)from;
       LinkedListNode nodoTo=(LinkedListNode)to;
       LinkedList nuevaLista= new LinkedList();
       try {
    	   nodoFrom= new LinkedListNode();
		   nodoTo= new LinkedListNode();
    	   if(isEmpty()) {
    		   nuevaLista.head=nodoFrom;
    		   nuevaLista.tail=nodoTo;
    	   }else {
    		   nuevaLista.head=nodoFrom;
    		   nuevaLista.tail=nodoTo;
    	   }
 	    return nuevaLista;
       }catch (Exception e) {
       	e.printStackTrace();
		}finally {
			return nuevaLista;
		}
    }

   // 33. Retorna un array que contiene todos los elementos de esta lista.
    @Override
    public T[] toArray() {
    	try {
    		if(!isEmpty()) {
    			Object[] elements = new Object[size()];
        		LinkedListNode nodoAux;
        		int i=0;
        		while(iterator.hasNext()) {
        				nodoAux=(LinkedListNode) iterator.next();
        				elements[i]=nodoAux.getObject();
        				i++;
        			}
        		}
    	}catch (Exception e) {
           	e.printStackTrace();
    		}finally {
    			return null;
    		}
    }

    //34. Ordenar lista por un criterio.
    @Override
    public boolean orderBy(char c) {
    	
    	 boolean ordenado = false;

         try {
             LinkedListNode nodoIteradorNodo = head;
             int contador = 0;

             //se recorre la lista
             while (nodoIteradorNodo != null) {
                 contador++;
                 nodoIteradorNodo = nodoIteradorNodo.next;
             }

             //Se busca el valor maximo o minimo
             for (int i = 0; i < contador-1; i++) {
                 nodoIteradorNodo = head;

                 LinkedListNode nodoAuxiliar = nodoIteradorNodo;

                 //Recorre los nodos de la lista 
                 for (int j = i; j < contador-1; j++) {
                     nodoIteradorNodo = nodoIteradorNodo.next;

                     //En este ciclo se comparan c y a a=ascendente ¿?
                     if (c == 'a') {
                         if (nodoIteradorNodo.getObject().toString().compareTo(nodoAuxiliar.getObject().toString()) < 0) {
                             nodoAuxiliar = nodoIteradorNodo;
                         }
                     } else {
                         if (nodoIteradorNodo.getObject().toString().compareTo(nodoAuxiliar.getObject().toString()) > 0) {
                             nodoAuxiliar = nodoIteradorNodo;
                         }
                     }
                 }

                 Object objetoA = head.getObject();
                 head.setObject(nodoAuxiliar.getObject());
                 nodoAuxiliar.setObject(objetoA);
                 head = head.next;
                 ordenado=true;
             }
             return ordenado;

         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             return ordenado;
         }
    	
    }

    
    //Imprimir en consola el contenido de la lista.
    @Override
    public void print() {
       try {
    	   if(!isEmpty()) {
    		   LinkedListNode nodoAux=head.next;
    		   System.out.print("LinkedList Circular[ " );
    		   System.out.print("Head= " + head.getObject()+ "----> ");
    		   while(nodoAux!=tail.next) {//para que solo se imprima una vuelta
    			   System.out.print("Next-> "+nodoAux.getObject()+"----> ");
    			   nodoAux=nodoAux.next;
    		   }
    		   System.out.print("Head again= "+ head.getObject()+"----> ");
    		   System.out.println(" ]");
    	   }
       }catch (Exception e) {
           e.printStackTrace();
       }
    }

   
    @Override
    public Iterator<Node> iterator() {
      inode= head;
      return new Iterator<>() {
    	  boolean confirmado=false;
    	  public boolean hasNext() {
    		  if(!confirmado) {
    			  return inode!=tail.next; //tail.next sera la cabeza, entonces si vuelve a llegar a la cabeza ya se recorrio la lista
    		  }
    		  else {
    			  confirmado=true;
    		  }
    		  return confirmado;
    		
    	  }
    	  public Node next() {
    		  Node temp= inode;
    		  inode=inode.next;
    		  return temp;
    	  }
    	  
      };
       
    }
    

    @Override
	public String toString() {
    	print();
		return "-";
	}
    
}
