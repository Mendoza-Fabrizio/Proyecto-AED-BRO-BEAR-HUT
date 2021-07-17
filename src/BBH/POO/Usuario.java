package BBH.POO;

import java.util.Scanner;

public class Usuario extends Persona implements Comparable<Usuario> {

    private int IdUsuario;
    private String nomUsu;
    private String clave;
    private int perfil;
    public static int contador = 0;
    public Usuario() {
    	super();
    }
    public Usuario(String nomUsu, String clave) {
        super();
        this.nomUsu=nomUsu;
        contador++;
        this.clave = clave;
        this.perfil = perfil;
        this.IdUsuario = contador;
    }
    public static Usuario AgregarUsuario() {
    	Scanner s = new Scanner(System.in);
    	System.out.println("<=======NUEVO USUARIO=======>");
    	System.out.println("Ingrese un nombre de usuario");
    	String Nombre= s.next();
    	System.out.println("Ingrese clave");
    	String password = s.next();
    	return new Usuario(Nombre,password);
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