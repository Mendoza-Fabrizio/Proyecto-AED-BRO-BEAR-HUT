import java.util.Date;

public class Cliente extends Persona implements Comparable<Cliente>{

    private String idCliente;
    private int idTipo;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private int idCiudad;
    private Date fechaNacimiento;
    private Date fechaIngreso;

    public Cliente(String idCliente, int idTipo, String nombres,
            String apellidos, String direccion, String telefono, 
            int idCiudad, Date fechaNacimiento, Date fechaIngreso) {
        this.idCliente = idCliente;
        this.idTipo = idTipo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idCiudad = idCiudad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public int compareTo(Cliente o) {
    	if (id Cliente) {
    		
    	}
    }
    @Override
    public String toString() {
        return idCliente + "|"
                + idTipo + "|"
                + nombres + "|"
                + apellidos + "|"
                + direccion + "|"
                + telefono + "|"
                + idCiudad + "|"
                + Utilidades.formatDate(fechaNacimiento) + "|"
                + Utilidades.formatDate(fechaIngreso);
    }
    
}