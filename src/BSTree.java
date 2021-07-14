import java.util.*;
public class BSTree<E extends Comparable<E>> {
	class Node{
		protected E data;
		protected Node left, right;
		public Node(E data) {
			this(data,null,null);
		}
		public Node(E data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	private Node root;
	private int AreaArbol;
	public BSTree() {this.root = null;}
	public boolean isEmpty() {return this.root == null;}
	public void insert(E x) throws ItemDuplicated{
		this.root =insertRec(x,this.root);
	}
	public E search(E x) throws ItemNoFound{
		Node resp = searchRec(x,this.root);
		if(resp == null)
			throw new ItemNoFound("El dato"+x+"no fue encontrado....");
		return resp.data;
		
	}
	public void remove(E x)throws ItemNoFound{
		this.root = removeRec(x,this.root);
	}
	public Node searchRec(E x, Node actual)throws ItemNoFound{
		if(actual == null)
			return null;
		else {
			int resC = actual.data.compareTo(x);
			if (resC < 0) return searchRec(x,actual.right);
			else if (resC > 0) return searchRec(x,actual.left);
			else return actual;
		}
	}
	protected Node insertRec(E x, Node actual) throws ItemDuplicated{
		Node res = actual;
		if(actual == null)
			res = new Node(x);
		else {
			int resC = actual.data.compareTo(x);
			if( resC == 0) throw new ItemDuplicated("el elemento "+x+" ya existe en el arbol");
			if( resC < 0) res.right = insertRec(x,actual.right);
			else res.left = insertRec(x,actual.left);
		}
		return res;
	}
	protected Node removeRec(E x, Node actual) throws ItemNoFound{
		Node res = actual;
		if(actual == null) 
			throw new ItemNoFound("El dato "+ x + " no fue encontrado...." );
		int resC = actual.data.compareTo(x);
		if (resC < 0) res.right = removeRec(x,actual.right);
		else if(resC > 0) res.left = removeRec(x,actual.left);
		if(actual.left != null && actual.right != null)
			System.out.println("eliminacion caso 3");
		else
			res = (actual.left !=null) ? actual.left :actual.right;
		return res;
	}
	public String toString() {
		return "hola";
	}
	public void inOrden() {
		if (this.isEmpty())
			System.out.println("Arbol esta vacio....");
		else
			inOrden(this.root); 
		System.out.println();	
	}
	protected void inOrden(Node actual) {
		if(actual.left != null) inOrden(actual.left);
		System.out.print(actual.data.toString()+", ");
		if(actual.right !=null) inOrden(actual.right);
	}
	public int NodosNoHojas(){
		return this.CuentaNodos()-CuentaHojas();
	}
	public int CuentaHojas() {
		return CuentaHojasRec(this.root);
	}
	public int CuentaHojasRec(Node nod) {
		int hojas = 0;
		if (nod.left == null && nod.right == null)
			return ++hojas;//No hay nodos, es una hoja
		else if (nod.left != null && nod.right != null)
			return CuentaHojasRec(nod.right) + CuentaHojasRec(nod.left);
		else if (nod.left != null && nod.right == null)
			return CuentaHojasRec(nod.left);
		else
			return CuentaHojasRec(nod.right);
	}
	public int Altura(E x) throws ItemNoFound{
		return AlturaRec(this.searchRec(x,this.root));
	}
	public int AlturaRec(Node node) 
	{
		// compara la profundidad maxima maxima entre los nodos de la izquierda y la derecha
	    if (node == null)
	    {
	        return 0;//si es que el nodo es nulo la altura devuelve 0
	    }
	    else
	    {
	        return 1 + Math.max(AlturaRec(node.left),AlturaRec(node.right)); //La funcion math ayuda a simplificar el proceso
	        
	    }
	}
	public void PreOrden() {
		PreOrden(this.root);
	}
	public void PreOrden(Node nod) {
		
		if(nod == null) return;
		Stack<Node> s= new Stack<>();
		while(s.isEmpty()||nod!=null) {
			while(nod != null) {
				System.out.print(nod.data+",");
				s.push(nod);
				nod = nod.left;
			}
			if (!s.isEmpty()) {
				Node t = s.pop();
				if(t.right == null && t.left == null) {// por si este elemento no tiene hijos
					if(!s.isEmpty()){
						t = s.pop();
					}
				}
				nod = t.right;
			}
		}
	}
	public int CuentaNodos() {
		return CuentaNodosRec(this.root);
	}
	public int CuentaNodosRec(Node nod) {
		int contador = 1;
		if(nod.left!= null) {
			contador +=CuentaNodosRec(nod.left);
		}
		if(nod.right !=null) {
			contador +=CuentaNodosRec(nod.right);
		}
		return contador;
	}
	public int getArea() throws ItemNoFound{
		if (this.root == null)
			throw new ItemNoFound("El arbol esta vacio") ;
		else {
			AreaArbol = this.CuentaHojas()*this.Altura(this.root.data);
			return AreaArbol;
		}	
	}
	/*public LinkedList<E> esHoja() {
		return esHojaP(this.root);
	}*/
	/*public LinkedList<E> esHojaP(Node nod) {
		LinkedList<E> a = new LinkedList<E>();
		if (nod.left == null && nod.right == null) {
			a.add(nod.data);
			return a;//No hay nodos, es una hoja
		}
		else if (nod.left != null && nod.right != null) {
			esHojaP(nod.left);
			esHojaP(nod.right);
		}
		else if (nod.left != null && nod.right == null)
			return esHojaP(nod.left);
		else
			return esHojaP(nod.right);
	}*/
	/*public String descendientes(E x) throws ItemNoFound{
		return this.descendientesP(this.searchRec(x,this.root));
	}*/
	/*public String descendientesP(Node nod) {
		String a = "";
		if (nod != null) {
			descendientesP(nod.left);
			if (nod != this.root) {
				a = a+nod.data+","; 
			}
			inOrden(nod.right);
		}
		return a;
	}*/
}

