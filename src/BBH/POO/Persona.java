package BBH.POO;
public abstract class Persona {
	String Apellidos;
	String Nombres;
	String Sexo;
	public Persona() {
		
	}
	public Persona(String Apellidos, String Nombre, String Sexo){
		this.Apellidos = Apellidos;
		this.Nombres = Nombre;
		this.Sexo = Sexo;
	}
	public Persona(String Apellidos, String Nombres){
		this.Apellidos = Apellidos;
		this.Nombres = Nombres;
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
