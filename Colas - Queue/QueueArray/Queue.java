package QueueArray;

import java.util.Arrays;

public class Queue implements QueueInterface {
	 int size;
    Object[] colaArr;
    int top;

    public Queue(int size) {
        this.top = -1;
        if (size > 0) {
            colaArr = new Object[size];
        }else {
            colaArr = new Object[1];
        }
    }
    
    public boolean insert(Object object) {
        boolean ack = false;
        try {
            if ( top == colaArr.length -1) {
                System.out.println("Cola llena");
            } else {
                    top++;
                    colaArr[top] = object;
                    ack = true;
                    this.size++;
            }
        } catch (Exception e) {
            System.out.println(e);
            ack = false;
        }
        return ack;
    }
    
    @Override
    public void clear() {
        try {
            if (!isEmpty()){
                colaArr=null;
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
        Object pop = colaArr[0];
        try {
            if(!isEmpty()){
                for (int i = 0; i < colaArr.length - 1; i++) {
                    colaArr[i] = colaArr[i + 1];
                }
                colaArr[top] = null;
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
                if (colaArr[i] == object) {
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
                
                Queue cola1 = new Queue(size);
                Queue cola2 = new Queue(size);
                int tam = size;
                for (int i = 0; i < tam  ; i++) {
                    Object objt = extract();
                    if (objt != null) {
                        if (objt instanceof String) {
                            cola1.insert(objt);
                        } else {
                            cola2.insert(objt);
                        }
                    }
                }

                for (int i = 0; i < tam -1 ; i++) {
                    colaArr[i] = cola1.extract();
                    if (cola1.isEmpty()) {
                        colaArr[i] = cola2.extract();
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
                temp[j] =colaArr[i];
                j++;
            }
            for (int i = 0; i < size; i++) {
               colaArr[i]= temp[i];
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
            Object[] array2 = Arrays.copyOf(colaArr, size);
            stringR=Arrays.toString(array2);
        }
        return stringR;
    }
    
    public void print(){

        Queue cola = new Queue(colaArr.length);

        for (int i = 0; i < colaArr.length; i++) {
            cola.insert(colaArr[i]);
            this.size = cola.size;
        }
        System.out.println(cola);
    }

}
