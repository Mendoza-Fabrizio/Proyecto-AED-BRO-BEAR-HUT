import java.util.ArrayList;

public class HashC<E extends Comparable <E>> {
	protected class Element{
		int mark;
		Register <E> reg;
		public Element(int mark, Register<E> reg) {
			this.mark = mark;
			this.reg = reg;
		}
	}
	protected ArrayList<Element> table;
	protected int m;
	public  HashC (int n) {
		this.m = n;
		this.table = new ArrayList<Element>(m);
		for(int i = 0; i<m;i++) {
			this.table.add(new Element (0,null));
		}
	}
	private int functionHash(int key) {
		return key % m;
	}
	private int functionHashim(int key) {
		float ma = (float) (m + (m*0.4));
		int x  = Math.round(ma);
		int y = x;
		int cont = 1;
		while (!esPrimo(y-cont)) {
			cont= cont+1;
		}
		return key % y;
	}
	private int linearProbing(int dressHash, int key) {
		int posInit = dressHash;
		do {
			if(table.get(dressHash).mark == 0) 
				return dressHash;
			if(table.get(dressHash).mark == 1 && table.get(dressHash).reg.getKey() == key)
				return dressHash * -m;
			dressHash = (dressHash + 1) % m;
			}while (dressHash != posInit);
		return -1;
		}
	public void insert(int key, E reg) {
		int dressHash = functionHash(key);
		dressHash = linearProbing(dressHash, key);
		if(dressHash == -1) {
			System.out.println("Key table hash is full");
			return ;
		}
		else if(dressHash <-1) {
			System.out.println("Key is duplicated");
			return;
		}
		else {
			Element aux = new Element(1,new Register<E>(key,reg));
			table.set(dressHash, aux);
		}
		}
	public E search (int key) {
		int dressHash = functionHash(key);
		dressHash = linearProbing(dressHash, key);
		if(dressHash < -1) {
			dressHash = dressHash / -m;
			System.out.println("Se encontro el elemento");
			return table.get(dressHash).reg.getvalue();
		}
		return null;
	}
	public String toString() {
		String s = "D.real\tD.table\tRegister\n";
		int i =0;
		for (Element item : table){
			s+=(i++)+"--->\t";
			if(item.mark == 1)
				s+=functionHash(item.reg.getKey())+"\t"+item.reg.toString()+"\n";
			else
				s+="Empty \n";
		}
		return s;
		}
	private int Metodocuadratico(int dressHash, int key) {
		int cont = 1;
		do {
			if(table.get(dressHash).mark == 0) 
				return dressHash;
			if(table.get(dressHash).mark == 1 && table.get(dressHash).reg.getKey() == key)
				return dressHash * -m;
			cont=cont+1;
			dressHash = (dressHash + (cont*cont))%m;
			}while (dressHash < m);
		return -1;
		}
	public static boolean esPrimo(int numero){
		  int contador = 2;
		  boolean primo=true;
		  while ((primo) && (contador!=numero)){
		    if (numero % contador == 0)
		      primo = false;
		    contador++;
		  }
		  return primo;
		}
	
	}


