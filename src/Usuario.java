public class Usuario extends Cliente implements Comparable<Cliente> {

    private String IdUsuario;
    private String clave;
    private int perfil;
    public Usuario() {
    	super();
    }
    public Usuario(String IdUsuario, String nombres, String apellidos, String clave, int perfil) {
        super(apellidos,nombres);
    	this.IdUsuario = IdUsuario;
        this.clave = clave;
        this.perfil = perfil;
    }
    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }
    public int compareTo(Usuario o) {
    	return 1;
    }
    @Override
    public String toString() {
        return IdUsuario + "|"
                + this.getNombres() + "|"
                + this.getApellidos() + "|"
                + clave + "|"
                + perfil;
    }
    
}