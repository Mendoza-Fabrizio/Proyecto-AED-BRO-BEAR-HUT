
public class Proveedores extends Persona implements Comparable<Proveedores> {
	Proveedores(int idProveedores, String Apellidos, String Nombres, String Sexo){
		super(idProveedores,Apellidos,Nombres,Sexo);
	}
	public int compareTo(Proveedores o) {
		if(this.getDni()> o.getDni()) {
			return 1;
		}
		if(this.getDni()== o.getDni()) {
			return 0;
		}
		else{
			return -1;
		}
	}
}
