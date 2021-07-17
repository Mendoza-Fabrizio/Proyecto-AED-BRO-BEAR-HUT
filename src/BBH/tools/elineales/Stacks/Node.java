package BBH.tools.elineales.Stacks;
public class Node<T>{
	private	T data;
	private Node<T> next;

   	public Node(T data){
		this (data, null);    
    }
   	public Node(T data, Node<T> next){
		this.data = data;
		this.next = next;    
    }
   	public T getData() {return this.data;}
   	public Node<T> getNext() {return this.next;}
   	public void setData(T data) { this.data = data; }
   	public void setNext(Node<T> next) { this.next = next; }

	//Function to returns the information stored in the node
	//Postcondition: Returns info.
   	public String toString(){
		return this.data.toString();
   	}

}
