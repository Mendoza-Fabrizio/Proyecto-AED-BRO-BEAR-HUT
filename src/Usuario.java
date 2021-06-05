package Clases;

public class Usuario {

    private String IdUsuario;
    private String nombres;
    private String apellidos;
    private String clave;
    private int perfil;

    public Usuario(String IdUsuario, String nombres, String apellidos, String clave, int perfil) {
        this.IdUsuario = IdUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.clave = clave;
        this.perfil = perfil;
    }

    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String IdUsuario) {
        this.IdUsuario = IdUsuario;
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

    @Override
    public String toString() {
        return IdUsuario + "|"
                + nombres + "|"
                + apellidos + "|"
                + clave + "|"
                + perfil;
    }

}