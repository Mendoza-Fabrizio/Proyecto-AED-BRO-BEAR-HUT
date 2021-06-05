
public class Persona {
	int dni;
	String Apellidos;
	String Nombres;
	String Sexo;
	public Persona(int dni,String Apellidos, String Nombre, String Sexo){
		setDni(dni);
		this.Apellidos = Apellidos;
		this.Nombres = Nombre;
		this.Sexo = Sexo;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		if(dni>=10000000&&dni<=99999999) {
			this.dni= dni; 
		}
		else {
			this.dni = 0;
			System.out.println("Ingresa un dni valido");
		}
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getNombres() {
		return Nombres;
	}
	public void setNombres(String nombres) {
		Nombres = nombres;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	
}
