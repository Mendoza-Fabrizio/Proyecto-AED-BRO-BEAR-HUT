package BBH.POO;
public class Proveedores extends Persona implements Comparable<Proveedores> {
	int idProveedor;
	Proveedores(int idProveedor, String Apellidos, String Nombres, String Sexo){
		super(Apellidos,Nombres,Sexo);
		this.idProveedor = idProveedor;
	}
	public int compareTo(Proveedores o) {
		if(this.idProveedor> o.idProveedor) {
			return 1;
		}
		if(this.idProveedor== o.idProveedor) {
			return 0;
		}
		else{
			return -1;
		}
	}
}
