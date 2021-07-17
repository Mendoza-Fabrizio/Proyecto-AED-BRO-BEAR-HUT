package BBH.POO;

import java.util.Scanner;

import BBH.tools.elineales.Listas.ListLinked;

public class Tienda {
	int idTienda;
	String NombreTienda;
	ListLinked<Producto> producto;
	
	public Tienda(String NombreTienda) {
		this.NombreTienda = NombreTienda;
	}
	
	public static Tienda IngresarTienda() {
		Scanner s = new Scanner(System.in);
		System.out.println("<=======\tNUEVA TIENDA\t=======>");
		System.out.println("Ingrese nombre de la tienda");
		String NombreTienda = s.next();
		return new Tienda(NombreTienda);
	}
	public boolean equals(Object o) {
		if(o instanceof Tienda) {
			Tienda a = (Tienda) o;
			return this.idTienda==a.idTienda;
		}
		return false;
	}

	public int compareTo(Tienda t1) {
		// TODO Auto-generated method stub
		if(this.idTienda ==t1.idTienda)
			return 1;
		else if(this.idTienda >t1.idTienda){
			return 1;
		}
		else
			return -1;
	}

	public int compareTo(String t1) {
		// TODO Auto-generated method stub
		return 0;
	}
}
