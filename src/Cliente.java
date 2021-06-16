import java.util.Date;

public class Cliente extends Persona implements Comparable<Cliente>{
	private int IdCliente;
    private int idTipo;
    private String direccion;
    private String telefono;
    private int idCiudad;
    private Date fechaNacimiento;
    private Date fechaIngreso;
    public Cliente() {
    	
    }
    public Cliente(int idCliente, int idTipo, String nombres,String sexo,
            String apellidos, String direccion, String telefono, 
            int idCiudad, Date fechaNacimiento, Date fechaIngreso) {
    	super(idCliente,apellidos,nombres,sexo);
        this.idTipo = idTipo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idCiudad = idCiudad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
    }
    public Cliente(String nombres, String apellidos) {
    	super(apellidos,nombres);
    }

    public Cliente(int idCliente, int idTipo2, String nombres, String apellidos, String direccion2, String telefono2,
			int idCiudad2, Date fechaNacimiento2, Date fechaIngreso2) {
		// TODO Auto-generated constructor stub
    	super(nombres,apellidos);
    	idCliente = IdCliente;
    	this.idTipo = idTipo2;
    	this.direccion = direccion2;
    	this.telefono = telefono2;
    	this.idCiudad = idCiudad2;
    	this.fechaNacimiento = fechaNacimiento2;
    	this.fechaIngreso = fechaIngreso2;
	}
	public int getIdTipo() {
		return this.idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    public int getIdCliente() {
		return IdCliente;
	}
	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}
	public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public int compareTo(Cliente o) {
    	if (this.getDni() > o.getDni()) {
    		return 1;
    	}
    	if (this.getDni() == o.getDni()) {
    		return 0;
    	}
    	else {
    		return -1;
    	}
    }
    public Cliente ingresar() {
    	Cliente res = null;
    	return res;
    }
    @Override
    public String toString() {
        return this.getDni() + "|"
                + idTipo + "|"
                + this.getNombres() + "|"
                + this.getApellidos() + "|"
                + direccion + "|"
                + telefono + "|"
                + idCiudad + "|"
                + Utilidades.formatDate(fechaNacimiento) + "|"
                + Utilidades.formatDate(fechaIngreso);
    }
    
}