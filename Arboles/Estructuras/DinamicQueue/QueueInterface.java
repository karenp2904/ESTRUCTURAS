package Estructuras.DinamicQueue;

public interface QueueInterface<T> {
	public void clear();
	public boolean isEmpty();
	public Object extract();
	public boolean insert(Object object);
	public int size();
	public boolean search(Object object);
	public void sort();
	public void reverse();
	public String toString();
}
