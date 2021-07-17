package BBH.tools.elineales.Stacks;

public class LinkedStack <E> implements Stack<E> {
	private Node<E> tope;
	
	public LinkedStack()
	{
		this.tope = null;
	}
	
	public void push(E x) 
	{
		this.tope = new Node<E>(x, this.tope);
	}
	public E pop() throws ExceptionIsEmpty
	{
		if(this.isEmpty())
		{
			throw new ExceptionIsEmpty("El inventario esta vacio. \nIntente con otro o recargue la ventana.");
		}
		else
		{
			E aux = this.tope.getData();
			this.tope =  this.tope.getNext();
			return aux;
		}
	}
	public E top() throws ExceptionIsEmpty
	{
		if(this.isEmpty())
		{
			throw new ExceptionIsEmpty("El inventario esta vacio. \nIntente con otro o recargue la ventana.");
		}
		else
		{
			return this.tope.getData();
		}
	}
	public boolean isEmpty()
	{
		return this.tope == null;
	}
	
	public String toString()
	{
		String src = "";
		Node papa = this.tope;
		while (papa != null)
		{
			return "- " + papa.getNext();
		}
		return "";
	}
	
}
