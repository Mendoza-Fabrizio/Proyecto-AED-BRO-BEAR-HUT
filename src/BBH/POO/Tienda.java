package BBH.POO;

import BBH.tools.elineales.Listas.ListLinked;

public class Tienda {
	int idTienda;
	String NombreTienda;
	ListLinked<Producto> producto;
	private int TProducto;
	public String ObtenerTipoProducto(){
		if(TProducto == 1) {
			return "Viveres";
		}
		if(TProducto == 2) {
			return "Higiene";
		}
		if(TProducto == 3) {
			return "Alimentos";
		}
		return null;
	}
}
