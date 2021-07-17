package BBH.POO;
public class Usuario extends Persona implements Comparable<Usuario> {

    private int IdUsuario;
    private String nomUsu;
    private String clave;
    private int perfil;
    public Usuario() {
    	super();
    }
    public Usuario(int IdUsuario, String nomUsu, String nombres, String apellidos, String clave, int perfil) {
        super(apellidos,nombres);
        this.nomUsu=nomUsu;
        this.IdUsuario = IdUsuario;
        this.clave = clave;
        this.perfil = perfil;
    }
    public Usuario(String nomUsu) {
        super(" "," ");
        this.nomUsu=nomUsu;
        
    }
    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }
    public String getnomUsu() {
        return nomUsu;
    }

    public void setnomUsu(String nomUsu) {
        this.nomUsu=nomUsu;
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
    	return this.nomUsu.compareTo(o.getnomUsu());
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