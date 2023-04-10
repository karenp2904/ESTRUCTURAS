package PilaDefinidia;

public class Stacks implements StackInterface{
	private Object[] stackArray;// Array de pila
    private int top; // espacios utilizados
    private int Limit; //Limite

    public Stacks(int capacity)  {
        this.stackArray = new Object[capacity]; 
        this.top = -1; 
        this.Limit = capacity; // Establece la capacidad maxima ya que es un array
    }
    
   // 1. // Limpiar
    @Override
    public void clear()  {
        stackArray = new Object[Limit]; // Incializa de nuevo el array
        top = -1; //vuelve al indice inicial
    }
    
    //2 Verifica si la lista esta vacia
    @Override
    public boolean isEmpty() {
    	if(top==-1) {
    		return true;//si es igual a -1
    	}else {
    		return false;
    	}
    }

    //3 Retorna el ultimo elemento de la pila
    @Override
    public Object peek(){
        if (!isEmpty()) {//si no esta vacia
        	return stackArray[top];
        }
        else{
            return null; // si la pila esta vacia retorna null
        }
    }

    //4 Retorna el ultimo objeto y lo elimina
    @Override
    public Object pop(){
        Object temp=null;
        if (!isEmpty()){
        	 temp =  this.stackArray[top]; 
             this.stackArray[top--] = null; // Vuelve nulo el objeto y resta en el top
             return temp;
        
        }
        else{
        	 return temp;// si la pila esta vacia temp será null
        }
    }
    
    
    //5 Agrega a la cima un elemento
    @Override
    public boolean push(Object object) // Agrega
    {
        try{
        	if(object!=null) {
        		  this.stackArray[++top] = object; // el top aumentará 
                  return true;
        	}else {
        		return false;
        	}
        }
        catch (Exception e){
            return false;
        }
    }

    //6 Indica el tamaño del array
    @Override
    public int size(){
        return top+1;// Retorna el tamaño
    }

    @Override
    public boolean search(Object object){
    	boolean encontrado=false;
    	if(object!=null) {
    		for(int i = 0;i<stackArray.length; i++){
                if(stackArray[i] == object){// si el array contiene el objeto
                    System.out.print("El objeto se encuentra en la posición: "+ i ); //Dice en que posiicon esta el objeto
                    encontrado= true; //encontrado cambiara a true por la accion realizada
                }
            }
            if(encontrado!=true) {//cuando no se encuentre el objeto, el boolean seguirá siendo false
            	 System.out.print("El objeto no fue encontrado");
            }
            return encontrado;
    	}else {
    		return encontrado;//encontrado sera false
    	}
        
    }

    @Override
    public void sort(){
        for (int i = 0; i < top- 1; i++){
            for (int j = 0; j < top - i - 1; j++) {
                if (((Comparable) stackArray[j]).compareTo(stackArray[j + 1]) > 0){
                    Object temp = stackArray[j];
                    stackArray[j] = stackArray[j + 1];
                    stackArray[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void reverse() {
    	
        Object[] temporal = new Object[stackArray.length];
        
        for (int i =  temporal.length-1,k=0; i>=0; i--, k++) {
			temporal[k]=stackArray[i];

		}
        stackArray=temporal;
        
        /*for (int i = 0; i <= size()/2; i++)
        {
        	Object temporal=stackArray[i];
        	stackArray[i]=stackArray[stackArray.length-1-i];
        	stackArray[stackArray.length-1-i]=temporal;
        
        }
        */
    }
    
    public String print() {
    	String print="StackArray[ ";
    	for (int i = 0; i < size(); i++) {
			print+=" {"+ stackArray[i]+"} Next-->";
		}
    	return print+="]";
    	
    }
    

    public String tooString()
    {
       print();
       return ".";
    }

}
