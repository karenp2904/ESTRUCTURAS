package ListasSimples;

import java.util.Iterator;
import java.util.ListIterator;


public class LinkedList<T> implements List<T> {
	
	//REVISAR METODOS CON ARREGLOS???? - Arreglo de objetos 
	//REVISTAR EL RETORNAR UN TIPO "T" CHECK - Use cast
	//METODO 24- REVISAR COMO RETORNAR Y DESPUES HACER UN PROCESO -Use temporales
	
	//REVISAR T[] getLast(int n) ¿COMO AGREGAR LOS OBJETOS AL FINA???? - no se :(

    public LinkedListNode head; //Es una referencia, una dirección de memoria
    public LinkedListNode tail;
    
    // Iterator.
    LinkedListNode inode=new LinkedListNode();

    int cont; //contador de elementos en la lista
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
            if(object != null){
               if(isEmpty()){
                this.head = tail = new LinkedListNode(object);        
            }else{
                   tail.next = new LinkedListNode(object);
                   tail = tail.next;
               }
               cont++;//contador
               ack=true;
               System.out.println("AÑADIR " + object);
               return ack;
               
            }

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
    	try {
    		if(object!=null) {
    			LinkedListNode nuevoNodo=(LinkedListNode)node;
        		if(isEmpty()) {
        			head=nuevoNodo;
        			nuevoNodo=new LinkedListNode(object);
        		}
        		if(nuevoNodo==tail) {
        			tail.next= new LinkedListNode(object);
        			tail=tail.next;
        		}
        		else {    			
        			inode=new LinkedListNode(object);
                	inode=nuevoNodo.next;
                	nuevoNodo.next=inode;
        		}
        		cont++; agregado=true;
            	return agregado;
    		}
    	}catch (Exception e){
            e.printStackTrace();
        }finally{
            return agregado; //retornar el valor booleano que indica si hubo una insercion o no
        }
    }
    	
    
    //3 Inserta un nodo en una posición siguiente al nodo especificado.
    @Override
    public boolean add(Node node, Node next) {
    	LinkedListNode nodoAInsertar= (LinkedListNode)node;
    	LinkedListNode nodoEspecificado=(LinkedListNode)next;
    	boolean agredado=false;
    	try {
    		if(nodoAInsertar!=null) {
    			if(isEmpty()){//si la lista esta vacia
    				head=nodoEspecificado; 
    				nodoAInsertar=head.next;//el siguiente a la cabeza
    				nodoAInsertar=new LinkedListNode();  
    				agredado=true;
                    }
    			else {
                	nodoAInsertar=nodoEspecificado.next;
                	nodoAInsertar=new LinkedListNode();
                	agredado=true;
                	}
    			return agredado;
    			}	
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
    		if(nodo!=null) {
    			if(objects!=null) {
    				for (int i = 0; i < objects.length; i++) {
    					if(isEmpty()){
            				addFirst(objects[i]);
                            }
            			else {
                        	add(nodo,objects[i]);
                        	nodo=nodo.next;  
                        	}
					}
    				agredado=true;
        			return agredado;
    			}
    			
    		}	
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
            		head=tail= new LinkedListNode(object,head);// apunta al siguiente nodo - Constructor de la clase de nodos
            	}
            	else {
            		head= new LinkedListNode(object,head);
            	}
            	System.out.println("Añadir Objeto Inicio " + object);
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
    		}		
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
    	 try{
             if(object != null){
                if(isEmpty()){
                 this.head = tail = new LinkedListNode(object);        
             }else{
            	  tail.next = new LinkedListNode(object);
                  tail = tail.next;
                }
                cont++;//contador
                agregado=true;
                System.out.println("AÑADIR " + object);
                return agregado;
             }
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
    		return agregado;
    	}}catch (Exception e) {
    		e.printStackTrace();
		}finally{
			return agregado;
		}
    }

    //  10. Elimina todos los elementos de la lista.
    @Override
    public boolean clear() {
       tail=null; head=null;
       return true;
    }

    //11. Retorna una instacia nueva de la lista.
    @Override
    public List clone() { //arreglar
        LinkedList nuevaLista=new LinkedList();
        nuevaLista.head=head;
        nuevaLista.tail=tail;
      //REVISAR
        return nuevaLista;
    }

    //12. Retorna verdadero si contiene el objeto.
    @Override
    public boolean contains(T object) {
    	boolean objetoEncontrado=false;
    	try {
    		if(object==null) {
    			return objetoEncontrado;
    		}
    		else{
            while(objetoEncontrado!=true) {
            	Iterator iterador=iterator();
            	while( iterador.hasNext()) {
            		if(iterador.next().equals(object)) {
            			objetoEncontrado=true;
                		//System.out.println("Se ha encontradon el nodo");
                		System.out.println("Contiene al objeto "+ object);
            			}
    				}
            	}
            }
    		return objetoEncontrado;
    		
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
    		for (int j = 0; j < objects.length; j++) {
    	    	//REVISAR
    			Iterator iterador=iterator();
            	while( iterador.hasNext()) {
            		LinkedListNode nodoAux=(LinkedListNode) iterador.next();
            		if(nodoAux.getObject().equals(objects[j].toString())) {
            				contenedor++;
            			}
    				}
            	}
    	        	if(contenedor==objects.length) {
    	        		objetoEncontrados=true;
    	        	}
    	        	else {
    	        		objetoEncontrados=false;
    	        	}
    			return objetoEncontrados;
    	}catch (Exception e) {
    		e.printStackTrace();
		}finally {
			return objetoEncontrados;
		}
    }

    //15. Retorna el nodo del objeto especificado, o null si no contiene el objeto.
    @Override
    public Node nodeOf(T object) {
    	boolean nodoEncontrado=false;
    	try {
    		 inode=head; 
    	        while(nodoEncontrado!=true|| inode!=tail.next) {
    	        	if(object.equals(inode.getObject())) {
    	        		nodoEncontrado=true;
    	        		//System.out.println("Se ha encontradon el nodo");
    	        	}
    	        	else if(nodoEncontrado!=true){
    	        		inode=inode.next;//el nodo iterador ayuda a recorrer la lista
    	        	}
    	        }
    			if(nodoEncontrado) {
    				return inode;
    			}
    			else {
    				return null;
    			}
       
    	}catch (Exception e) {
    		e.printStackTrace();
    		return null;
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
    	return (T) tail.getObject();
    }

    // 18. Retorna un objeto de la posición del nodo especificado.
    @Override
    public T get(Node node) {
    	LinkedListNode nodoNuevo = (LinkedListNode) node;
    	//boolean objetoEn=false;
    	//T objeto;
    	try {
    		return (T) nodoNuevo.getObject();
    		
    	}catch (Exception e) {
    		e.printStackTrace();
    		return null;
		}
    }

    //19. Retorna un objeto de la posición previa al nodo especificado.
    @Override
    public T getPrevious(Node node) {
    	try {
    		LinkedListNode nodoEspecificado=(LinkedListNode)node;
    		if(isEmpty()) {
    			return null;
    		}
    		else {
    			LinkedListNode anterior;
    			anterior=head;
    			inode=head.next;
    			while(nodoEspecificado!=inode) {
    				anterior=anterior.next;
    				inode=inode.next;
    				//inode.getObject();
    			}
    			return (T) anterior.getObject();	
    		}
		}catch (Exception e) {
    		e.printStackTrace();
    		return null;
		}
    }

    //20. Retorna un objeto de la posición siguiente al nodo especificado.
    @Override
    public T getNext(Node node) {
    	
    	LinkedListNode nodoEspecificado=(LinkedListNode)node;
    	try {
    		if(nodoEspecificado!=null) {
    				nodoEspecificado=new LinkedListNode();
    				return (T)nodoEspecificado.next.getObject();
    			}	
    	}catch (Exception e) {
    		e.printStackTrace();
    		return null;
        }finally{
        	if(nodoEspecificado==null) {
        		return null;
        	}
        	else {
        		return (T)nodoEspecificado.next.getObject();
        	}
        }
		
        
    }

    //21. Retorna el objeto al inicio de esta lista.
    @Override
    public T getFirst() {
    	return (T) head.getObject();
    
    }

    //22. Retorna un array de n objetos desde inicio de esta lista.
    @Override
    public T[] getFirst(int n) {
    	try {
    		Object [] arrayObjeto=new Object[n];
    		if(isEmpty()) {
    			arrayObjeto=null;		       
    			return (T[]) arrayObjeto;
    		}
    		else{
    			LinkedListNode inode=head;
    			for (int i = 0; i < n; i++) {
					arrayObjeto[i]= (T) inode.getObject();
					inode=inode.next;
				}
    				return (T[]) arrayObjeto;
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
    		return null;
        }
    }

    //23. Retorna el objeto al final de esta lista.
    @Override
    public T getLast() {
       return (T) tail.getObject();
    }
   

    // 24. Retorna un array de n objetos previos al final de esta lista.
    @Override
    public T[] getLast(int n) { //REVISAR
    	try {
    		Object [] arrayObjetos=new Object[n];
    		if(isEmpty()) {
    			arrayObjetos=null;
    			return (T[]) arrayObjetos;
    		}
    		else{
    			inode=head;
    			for (int i = 0; i < size(); i++) {
					arrayObjetos[i]=(T) inode.getObject();
					inode=inode.next;
				}
    			int tamaño= arrayObjetos.length;
    			for (int i = 0; i < n; i++) {
					//arrayObjetos[i]= ;
					tamaño--;
				}
    			return (T[]) arrayObjetos;
    		}
    		
    	}catch (Exception e) {
    		e.printStackTrace();
    		 return null;
        }
    }

    //25. Retorna el objeto al final de esta lista y lo elimina. 
	@Override
    public T pop() {
		 boolean fns = false;
	        try {
	            //Comprobar si la cabeza esta vacia
	            if (head == null) {
	                return null;
	            }
	            //Se instancian los nodos
	            LinkedListNode nvoNodo = head; //Se crea para avanzar en la lista
	            LinkedListNode nodoPrevio = null; //Se crea para guardar el nodo anterior

	            //Recorre la lista hasta llegar al ultimo nodo
	            while (nvoNodo.next != null) {
	                nodoPrevio = nvoNodo;
	                nvoNodo = nvoNodo.next;
	            }
	            //Elimina el ultimo nodo de la lista enlazada
	            if (nodoPrevio == null) {
	                head = null;
	            } else {
	                nodoPrevio.next = null;
	            }
	            return (T) nvoNodo.getObject();
		}catch (Exception e) {
    		e.printStackTrace();
    		return null;
        }
		
    }

    //26. Elimina el nodo en la lista.
    @Override
    public boolean remove(T object) {
    	boolean removido=false;
    	try {
    	
    		if(!isEmpty()) {
    	      	   if(head==tail&&object==head.getObject()) {
    	      		   head=tail=null;
    	      	   }
	              else {
    	      		   if(object==head.getObject()){
    	      			   head=head.next;
    	      		   }
    	      		   else {
    	      			   LinkedListNode anterior,temp;//nodos para acceder a la lista
    	      			   anterior=head;//se paunta al primer nodo
    	      			   temp=head.next;//se apunta al siguiente nodo
    	      			   
    	      			   //mientras sea diferente del dato que se necesita y no llegue al final
    	      			   while(temp.getObject()!=object) {
    	      				   anterior=anterior.next;
    	      				   temp=temp.next;
    	      				   //se recorren las listas hasta que encunetre el elemento
    	      			   }
    	      			   if(temp!=null) {
    	      				   anterior.next=temp.next;
    	      			   }
    	      				if(temp==tail) {//si llego al final de la lista
    	      					   tail=anterior;//si el temporal llego hasta el ultimo ese se elimina
    	      				   }
    	      			   }
    	      		   }
 
    	      	    removido=true;
    	         }
    	}catch (Exception e) {
    		e.printStackTrace();
        }finally{
            return removido;
        }
 	 
    }

    //27. Elimina el nodo en la lista.
    @Override
    public boolean remove(Node node) {
    	LinkedListNode nodoEliminado=(LinkedListNode)node;
    	boolean removidoo=false;
       try {
    	   if(!isEmpty()) {
        	   
        	   if(head==tail&&nodoEliminado==head.getObject()) {
        		   head=tail=null;
        	   }
                else {
        		   if(nodoEliminado==head.getObject()){
        			   head=head.next;
        		   }
        		   else {
        			   LinkedListNode anterior,temp;//nodos para acceder a la lista
        			   anterior=head;//se paunta al primer nodo
        			   temp=head.next;//se apunta al siguiente nodo
        			   
        			   //mientras sea diferente del dato que se necesita y no llegue al final
        			   while(temp!=nodoEliminado) {
        				   anterior=anterior.next;
        				   temp=temp.next;
        				   //se recorren las listas hasta que encunetre el elemento
        			   }
        			   if(temp!=null) {
        				   anterior.next=temp.next;
        			   }
    				   if(temp==tail) {//si llego al final de la lista
					    tail=anterior;//si el temporal llego hasta el ultimo ese se elimina
    				   	}
        		   }
        		   
        	   }
        	   removidoo=true;
        	   return removidoo;
           } 
    	return removidoo;
       }catch (Exception e) {
    	   e.printStackTrace();
		}finally {
			return removidoo;
		}
    }

    //28. Elimina de esta lista todos los nodos de los objetos que están contenidos en la colección especificada
    @Override
    public boolean removeAll(T[] objects) {
    	boolean remover=false;
    	try {
		    	for (int i = 0; i < objects.length; i++) {
    		    	remove(objects[i]);	
		    	}
    		    		
			remover=true;
        }catch (Exception e) {
     	   e.printStackTrace();
 		}finally {
 			return remover;
 		} 
    }

    // 29. Conserva solo los objetos del array
    @Override
    public boolean retainAll(T[] objects) {
    	boolean conserva=false;
        try {
        	if(objects!=null) {
        		LinkedListNode inode=head;
        		head=null;
        		tail=null;	
        		for (int i = 0; i < objects.length; i++) {
        			inode=new LinkedListNode(objects[i]);
        			inode=inode.next;
        			System.out.println("La lista contiene solo "+ objects[i]);
				}
        		cont=1;//solo habra un nodo??
        		return conserva;
        	}
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
        try {
        	if(isEmpty()) {
        		return reemplazar;
        	}
        	else {
        		if(object!=null) {
        			LinkedListNode nodoEspecificado=(LinkedListNode)node;
            		nodoEspecificado=new LinkedListNode();
            		nodoEspecificado.setObject(object);
            		reemplazar=true;
            		return reemplazar;
        		}
        	}	
        }catch (Exception e) {
        	e.printStackTrace();
		}finally {
			return reemplazar;
		}
    }

    //31. Retorna el número de nodos de esta lista.
    @Override
    public int size() {
    	int temporalContador=0;
    	if(isEmpty()) {
    		return temporalContador;
    	}
    	else {
    		inode=head; 
    		while(inode!=null) {
    			inode=inode.next;
    			temporalContador++;
    		}
    	}
    	return temporalContador;
    }
       

    //32. Retorna una sub lista de la lista.
    @Override
    public List subList(Node from, Node to) {
       LinkedListNode nodoFrom=(LinkedListNode)from;
       LinkedListNode nodoTo=(LinkedListNode)to;
       
       try {
	   if(nodoFrom!=null && nodoTo!=null) {
    		   LinkedList nuevaLista= new LinkedList();
    		   nodoFrom= new LinkedListNode();
    		   nodoTo= new LinkedListNode();
    	   if(isEmpty()) {
    		   nuevaLista.head=nodoFrom;
    		   nuevaLista.tail=nodoTo;
    		   return nuevaLista;
    		   }
    	   else{
    		   nuevaLista.head=nodoFrom;
    		   nuevaLista.tail=nodoTo;
    		  
    		   return nuevaLista;
    		   }
    	   } 	   
       }catch (Exception e) {
       	e.printStackTrace();
		}finally {
			return null;
		}
    }

   // 33. Retorna un array que contiene todos los elementos de esta lista.
    @Override
    public T[] toArray() {
    	try {
    		if(!isEmpty()) {
    			Object[] elements = new Object[size()];
        		LinkedListNode inode=head;
        		//elements[0]=inode;
        		for (int i = 0; i <=size(); i++) {
    				elements[i]=inode.getObject();
    				inode=inode.next;
    				 return (T[]) elements;
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
       Iterator<Node> it=this.iterator();
       while(it.hasNext()) {
    	   System.out.print(it.next().getObject().toString()+"");
       }
    }

   
    @Override
    public Iterator<Node> iterator() {
      inode= head;
      return new Iterator<>() {
    	  public boolean hasNext() {
    		  return inode!=null;
    	  }
    	  public Node next() {
    		  Node temp= inode;
    		  inode=inode.next;
    		  return temp;
    	  }
    	  
      };
       
    }

    //35. Retorna un string con el contenido de la lista.
    @Override
    public String toString() {
        return "LinkedList{" + "head=" + head + ", tail=" + tail + '}';
    }
    
}
