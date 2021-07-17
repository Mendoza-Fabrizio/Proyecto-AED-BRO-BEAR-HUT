package BBH.tools.elineales.Listas;

public class ListLinked <T> implements TDAList<T> {
	private Node <T> first;
	private int count;
	
	public ListLinked() {
		this.first = null;
		this.count = 0;
	}
	
	public boolean isEmptyList() {
		return this.first == null;	
	}
	
	public int length() {
		return this.count;	
	}
	
	public void destroyList() {
		while(this.first != null)
			this.first = this.first.getNext();
		this.count = 0;
	}
	
	public int search(T x) {
		Node <T> aux = this.first;
		for(int i = 0; aux != null; aux = aux.getNext(), i++)
			if(aux.getData().equals(x))
				return i;
		return -1;			
	}

	public int search(String nombre) {
		Node <T> aux = this.first;
		for(int i = 0; aux != null; aux = aux.getNext(), i++)
			if(aux.getData().equals(nombre))
				return i;
		return -1;
	}
	
	public void insertLast(T x) {
		if(this.isEmptyList())
			this.insertFirst(x);
		else {
			Node <T> lastNode = getLastNode();
			lastNode.setNext(new Node <T> (x));
			this.count++;
		}
	}
	
	//PreCondition: List is not empty
	public Node <T> getLastNode(){
		Node <T> aux = this.first;
		while(aux.getNext() != null)
			aux = aux.getNext();
		return aux;
	}
	
	public void insertFirst(T x) {
		this.first = new Node <T> (x, this.first);
		this.count++;
	}

	@Override
	public void remove(T x) {
		int pos = this.search(x);
		Node<T> head = this.first;
		Node<T> current = null;

		if (pos != 1) {
			Node<T> atNode = getNodeAt(pos);
			if (atNode == this.first){
				current = this.first;
				this.first = this.first.getNext();
				current = null;
			} else {
				while (head.getNext() != atNode) {
					head = head.getNext();
				}
				current = head.getNext();
				head.setNext(current.getNext());
				current = null;
			}
			this.count--;
		} else {
			System.out.println("Elemento no encontrado");
		}
	}

	public Node<T> getNodeAt(int index) {
		Node<T> aux = this.first;
		int cont = 0;
		while (aux != null) {
			if (cont == index)
				break;
			cont++;
			aux = aux.getNext();
		}
		return aux;
	}

	public String toString() {
		String str = "";
		Node <T> aux = this.first;
		for(int i = 0; aux != null; aux = aux.getNext(), i++)
			str += "["+i+"] = " +aux.getData()+"\n";
		return str;
		
	}
}
