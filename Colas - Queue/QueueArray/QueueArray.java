package QueueArray;

import java.util.Arrays;

public class QueueArray implements QueueInterface {
	 int size;
    Object[] arrayQueue;
    int top;

    public QueueArray(int size) {
        this.top = -1;
        if (size > 0) {
        	arrayQueue = new Object[size];
        }else {
        	arrayQueue = new Object[1];
        }
    }
    
    public boolean insert(Object object) {
        boolean insertado = false;
        try {
        	if(size()!=arrayQueue.length ) {
        		arrayQueue[top]=object;
        		top=(top+1)%arrayQueue.length;
        		size++;
        	}else {
        		System.out.println("La cola ya esta llena");
        	}
            
        } catch (Exception e) {
            System.out.println(e);
            insertado = false;
        }
        return insertado;
    }
    
    @Override
    public void clear() {
        try {
            if (!isEmpty()){
            	arrayQueue=null;
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public boolean isEmpty() {
      if(size != -1){
          return false;
      }else {
          return true;
      }
    }
    
    @Override
    public Object extract() {
        Object pop = arrayQueue[0];
        try {
            if(!isEmpty()){
                for (int i = 0; i < arrayQueue.length - 1; i++) {
                	arrayQueue[i] = arrayQueue[i + 1];
                }
                arrayQueue[top] = null;
                this.size--;
            }
        }catch (Exception e){
            System.out.println( "\nextract "+ e);

        }
        return pop;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    
    @Override
    public boolean search(Object object) {
        try {

            for (int i = 0; i < size; i++) {
                if (arrayQueue[i] == object) {
                    return true;
                }
            }
            return false;

        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public void sort() {
        try {
            if (!isEmpty()){
                
                QueueArray cola1 = new QueueArray(size);
                QueueArray cola2 = new QueueArray(size);
                int tamaño = size;
                for (int i = 0; i < tamaño  ; i++) {
                    Object objeto = extract();
                    if (objeto != null) {
                        if (objeto instanceof String) {
                            cola1.insert(objeto);
                        } else {
                            cola2.insert(objeto);
                        }
                    }
                }

                for (int i = 0; i < tamaño -1 ; i++) {
                	arrayQueue[i] = cola1.extract();
                    if (cola1.isEmpty()) {
                    	arrayQueue[i] = cola2.extract();
                    }
                }
            }
        }catch (Exception e){
            System.out.println("sort " + e);
        }
    }
    
    @Override
    public void reverse() {

        try {
            int j = 0;
            Object [] temp = new Object[size];
            for (int i = size -1 ; i >= 0; i--) {
                temp[j] =arrayQueue[i];
                j++;
            }
            for (int i = 0; i < size; i++) {
            	arrayQueue[i]= temp[i];
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    

    public String toString() {
        String stringR="";
        if(isEmpty()){
            System.out.println("Lista vacía " + size);
        }else{
            Object[] array2 = Arrays.copyOf(arrayQueue, size);
            stringR=Arrays.toString(array2);
        }
        return stringR;
    }
    
    public void print(){

        QueueArray cola = new QueueArray(arrayQueue.length);

        for (int i = 0; i < arrayQueue.length; i++) {
            cola.insert(arrayQueue[i]);
            this.size = cola.size;
        }
        System.out.println(cola);
    }

}
