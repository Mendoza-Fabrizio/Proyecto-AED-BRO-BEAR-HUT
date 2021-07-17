package BBH.tools.Hashing;
import java.util.*;
import java.math.*;
public class HashC<E extends Comparable <E>>{
	protected class Element{
		public int mark;
		Register<E> reg;
		public Element(int mark, Register<E> reg) {
			this.mark = mark;
			this.reg = reg;
		}
	}
	//protected ArrayList<Element> table;
	protected ArrayList<LinkedList<Element>> table;
	protected int m;
	/*public HashC(int n) {
		this.m = (int) (BuscarPrimoCercano(n)+0.4*n);
		this.table = new ArrayList<Element> (m);
		for(int i = 0; i<m;i++)
			this.table.add(new Element(0,null));
	}*/
	/*public HashC(int n) {
		this.m = n;
		this.table = new ArrayList<Element> (m);
		for(int i = 0; i<m;i++)
			this.table.add(new Element(0,null));
	}*/
	public HashC(int n) {
		this.m = n;
		this.table = new ArrayList<LinkedList<Element>> (m);
		
		for(int i = 0; i<m;i++) {
			LinkedList<Element> a = new LinkedList<Element>();
			a.add(new Element(0,null));
			if(i == 0)
				this.table.add(a);
			else {
				this.table.add(a);
			}
		}
		for(int i = 0; i<m;i++)
			this.table.get(i).add(new Element(0,null));
	}
	private int functionHash(int key) {
		return key%m;
	}
	private int BuscarPrimoCercano(int n) {
		while(true) {
			if(Esprimo(n)) {
				return n;
			}
			n = n-1;
		}
	}
	private boolean Esprimo(int key) {
		for(int i = 2;i<key;i++) {
			if(key%i==0) {
				return true;
			}
		}
		return false;
	}
	/*private int functionCuadraticaHash(int key) {
		key = (int) Math.pow((double) key,2);
		String res = "";
		res = res+key;
		int posicion = res.length()/2;
		int i = 0;
		int aux=0;
		while(key>0) {
			
			
			if(posicion%2 == 0) {
				if(i==posicion-1) {
					aux = key%10;
				}
				else if(i == posicion) {
					aux = aux+((key%10)*10);
				}
				}
			else {
				if(i==posicion+1) {
					aux = key%10;
				}
			}
			key = key /10;
			i++;
		}
		return aux;
	}*/
	/*
	@SuppressWarnings("unused")
	private int funcionhashPliegue(int key) {
		String res = "";
		res = res+key;
		char ch[];
		ch = res.toCharArray();
		int largo = res.length();
		int i, sum;
		for(sum =0,i=0;i<largo;i++) {
			sum += ch[i];
		}
		return sum%m;
	}*/
	/*public void funcionAyuda(int key) {
		System.out.println(this.functionCuadraticaHash(key));//funcion implementada con fines de invocar y probar la funcion cuadratica hash
	}*/
	/*public void funcionAyuda2(int key) {
		System.out.println(this.funcionhashPliegue(key));//funcion implementada con fines de invocar y probar la funcion por pliegue hash
	}*/
	/*@SuppressWarnings("unused")
	private int linearProbing(int dressHash, int key) {
		int posInit = dressHash;
		do {
			if(table.get(dressHash).mark == 0)
				return dressHash;
			if(table.get(dressHash).mark == 1 && table.get(dressHash).reg.equals(new Register<E>(key,(E) "")))
				return -2;
			dressHash = (dressHash +1) % m;
		} while(dressHash != posInit);
		return -1;
	}
	private int BusquedaLineal(int dressHash,int key) {
		int posInit = dressHash;
		do {
			if(table.get(dressHash).mark == 0)
				return -1;
			if(table.get(dressHash).mark == 1 && table.get(dressHash).reg.equals(new Register<E>(key,(E) "")))
				return dressHash;
			dressHash = (dressHash +1) % m;
		} while(dressHash != posInit);
		return -1;
	}*/
	
	/*@SuppressWarnings({ "unused", "unlikely-arg-type", "unchecked" })
	private int CuadraticProbing(int dressHash, int key) {
		int res=dressHash;
		int i = 0;
		do {
			if(table.get(dressHash).mark == 0)
				return dressHash;
			if(table.get(dressHash).mark == 1 && table.get(dressHash).reg.equals(new Register<E>(key,(E) "")))
				return -2;
			dressHash = (res +(int) Math.pow((int) i,2)) % m;
			i++;
		} while(true);
	}*/
	/*@SuppressWarnings("unchecked")
	private int BusquedaCuadratica(int dressHash, int key) {
		int res=dressHash;
		int i = 0;
		do {
			if(table.get(dressHash).mark == 0)
				return -1;
			if(table.get(dressHash).mark == 1 && table.get(dressHash).reg.equals(new Register<E>(key,(E) "")))
				return dressHash;
			dressHash = (res +(int) Math.pow((int) i,2)) % m;
			i++;
		} while(true);
	}*/
	/*public void insert(int key, E reg) {
		int dressHash = functionHash(key);
		dressHash = linearProbing(dressHash,key);
		if(dressHash == -1) {
			System.out.println("Key table hash is full.... ");
			return;
		}
		else if(dressHash == -2) {
			System.out.println("Key is duplicated");
			return;
		}
		else {
			Element aux = new Element(1,new Register<E>(key,reg));
			table.set(dressHash, aux);
		}
	}*/
	/*public void insert(int key, E reg) {
		int dressHash = functionHash(key);
		dressHash = CuadraticProbing(dressHash,key);
		if(dressHash == -2) {
			System.out.println("Key is duplicated... ");
			return;
		}
		else if(dressHash == -1) {
			System.out.println("Hash table is full... ");
			return;
		}
		else {
			
			Element aux = new Element(1,new Register<E>(key,reg));
			table.set(dressHash, aux);
		}
	}*/
	public void insertarEncadenamiento(int key,E reg) {
		int dressHash = functionHash(key);
		if(table.get(dressHash).getFirst().reg==null) {
			Element aux = new Element(1,new Register<E>(key,reg));
			table.get(dressHash).set(0,aux);
		}
		else if(table.get(dressHash).get(0).reg.equals(new Register<E>(key,reg))) {
			System.out.println("elemento duplicado");
		}
		else {
			Element aux = new Element(1,new Register<E>(key,reg));
			table.get(dressHash).add(aux);
		}
	}
	/*@SuppressWarnings("unused")
	private int LongitudBusqueda(int dressHash, int key) {
		int res=dressHash;
		int i = 0;
		do {
			i++;
			if(table.get(dressHash).mark == 0)
				return -1;
			if(table.get(dressHash).mark == 1 && table.get(dressHash).reg.equals(new Register<E>(key,(E) "")))
				return i;
			dressHash = (res +(int) Math.pow((int) i,2)) % m;
		} while(true);
	}*/
	
	
	/*@SuppressWarnings("unchecked")
	public E search(int key) {
		Integer i=0;
		int dressHash = this.functionHash(key);
		dressHash = BusquedaCuadratica(dressHash,key);
		if(dressHash == -1) {
			return (E) "elemento no encontrado";
		}
		else {
			return (E) ("elemmento encontrado: "+table.get(dressHash).reg+" en la posicion: "+dressHash+" con longitud de busqueda:"+this.LongitudBusqueda(this.functionHash(key), key));
		}
	}*/
	/*@SuppressWarnings("unchecked")
	public E remove(int key) {
		Integer i = 0;
		if(search(key)== null) {
			return (E) "elemento no existe";
		}
		else {
			i = (Integer) search(key)-1;
			table.get(i).mark = 0;
			System.out.println("elemento eliminado: "+table.get(i).reg);
			return null;
		}
	}*/
	/*public String toString() {
		String s = "D.Real\tD.Hash\tRegister\n";
		int i = 0;
		for(Element item: table) {
			s+= (i++) + "-->\t";
			if(item.mark == 1)
				s+= functionHash(item.reg.key)+"\t"+ item.reg+"\n";
			else
				s+= "empty\n";
		}
		return s;
	}*/
	public String toString() {
		String s = "D.Real\tD.Hash\tRegister\n";
		for(int i = 0;i<m;i++) {
			s+= i + "-->\t";
			if(table.get(i).get(0).mark == 1) {
				s+= functionHash(table.get(i).get(0).reg.key)+"\t"+ table.get(i).get(0).reg;
				if(table.get(i).size()>=2) {
					for(int i1 = 1; i1 < table.get(i).size();i1++) {
						if(table.get(i).get(i1).mark == 1)
							s+= "\t"+ "-->\t"+table.get(i).get(i1).reg;
					}
				}
				s+="\n";
			}
			else
				s+= "empty\n";
		}
		return s;
	}
}
