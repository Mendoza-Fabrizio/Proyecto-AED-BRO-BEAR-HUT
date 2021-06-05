import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class Datos {

    private int maxUsu = 50;
    private int maxPro = 100;
    private int maxCli = 100;
    private Usuario misUsuarios[] = new Usuario[maxUsu];
    private Producto misProductos[] = new Producto[maxPro];
    private Cliente misClientes[] = new Cliente[maxCli];
    private int conUsu = 0;
    private int conPro = 0;
    private int conCli = 0;
    private int numFac = 0;

    public Datos() {

        // Cargamos Usuarios
        cargarUsuarios();

        // Creamos Productos
        cargarProductos();

        // Cargamos Productos
        cargarClientes();

        // Cargamos numero factura
        cargarConfiguracion();

    }
    
    public int getNumFac() {
        return numFac;
    }
    
    public void setNumFac(int numFac) {
        this.numFac = numFac;
    }

    public int numeroUsuarios() {
        return conUsu;
    }

    public int numeroProductos() {
        return conPro;
    }

    public int numeroClientes() {
        return conCli;
    }

    public Usuario[] getUsuarios() {
        return misUsuarios;
    }

    public Producto[] getProductos() {
        return misProductos;
    }

    public Cliente[] getClientes() {
        return misClientes;
    }

    public boolean validarUsuario(String usuario, String clave) {
        boolean aux = false;
        for (int i = 0; i < conUsu; i++) {
            if (misUsuarios[i].getIdUsuario().equals(usuario)
                    && misUsuarios[i].getClave().equals(clave)) {
                return true;
            }
        }
        return false;
    }

    public int getPerfil(String usuario) {
        //int aux = -1;
        for (int i = 0; i < conUsu; i++) {
            if (misUsuarios[i].getIdUsuario().equals(usuario)) {
                return misUsuarios[i].getPerfil();
            }
        }
        return -1;
    }

    public void cambioClave(String usuario, String clave) {
        //int aux = -1;
        for (int i = 0; i < conUsu; i++) {
            if (misUsuarios[i].getIdUsuario().equals(usuario)) {
                misUsuarios[i].setClave(clave);
                return;
            }
        }
    }

    public int posicionUsuario(String usuario) {
        //int aux = -1;
        for (int i = 0; i < conUsu; i++) {
            if (misUsuarios[i].getIdUsuario().equals(usuario)) {
                return i;
            }
        }
        return -1;
    }

    public int posicionProducto(String producto) {
        //int aux = -1;
        for (int i = 0; i < conPro; i++) {
            if (misProductos[i].getIdProducto().equals(producto)) {
                return i;
            }
        }
        return -1;
    }

    public int posicionCliente(String cliente) {
        //int aux = -1;
        for (int i = 0; i < conCli; i++) {
            if (misClientes[i].getIdCliente().equals(cliente)) {
                return i;
            }
        }
        return -1;
    }

    public String agregarUsuario(Usuario miUsuario) {
        if (conUsu == maxUsu) {
            return "Se ha alcanzado el numero maximo de usuarios";
        }
        misUsuarios[conUsu] = miUsuario;
        conUsu++;
        return "Usuario agregado correctamente";
    }

    public String agregarProducto(Producto miProducto) {
        if (conPro == maxPro) {
            return "Se ha alcanzado el numero maximo de productos";
        }
        misProductos[conPro] = miProducto;
        conPro++;
        return "Producto agregado correctamente";
    }

    public String agregarCliente(Cliente miCliente) {
        if (conCli == maxCli) {
            return "Se ha alcanzado el numero maximo de clientes";
        }
        misClientes[conCli] = miCliente;
        conCli++;
        return "Cliente agregado correctamente";
    }

    public String modificarUsuario(Usuario miUsuario, int pos) {
        misUsuarios[pos].setNombres(miUsuario.getNombres());
        misUsuarios[pos].setApellidos(miUsuario.getApellidos());
        misUsuarios[pos].setClave(miUsuario.getClave());
        misUsuarios[pos].setPerfil(miUsuario.getPerfil());
        return "Usuario modificado correctamente";
    }

    public String modificarProducto(Producto miProducto, int pos) {
        misProductos[pos].setDescripcion(miProducto.getDescripcion());
        misProductos[pos].setPrecio(miProducto.getPrecio());
        misProductos[pos].setIva(miProducto.getIva());
        misProductos[pos].setNota(miProducto.getNota());
        return "Producto modificado correctamente";
    }

    public String modificarCliente(Cliente miCliente, int pos) {
        misClientes[pos].setIdTipo(miCliente.getIdTipo());
        misClientes[pos].setNombres(miCliente.getNombres());
        misClientes[pos].setApellidos(miCliente.getApellidos());
        misClientes[pos].setDireccion(miCliente.getDireccion());
        misClientes[pos].setTelefono(miCliente.getTelefono());
        misClientes[pos].setIdCiudad(miCliente.getIdCiudad());
        misClientes[pos].setFechaNacimiento(miCliente.getFechaNacimiento());
        misClientes[pos].setFechaIngreso(miCliente.getFechaIngreso());
        return "Cliente modificado correctamente";
    }

    public String borrarUsuario(int pos) {
        for (int i = pos; i < conUsu - 1; i++) {
            misUsuarios[i] = misUsuarios[i + 1];
        }
        conUsu--;
        return "Usuario borrado correctamente";
    }

    public String borrarProducto(int pos) {
        for (int i = pos; i < conPro - 1; i++) {
            misProductos[i] = misProductos[i + 1];
        }
        conPro--;
        return "Producto borrado correctamente";
    }

    public String borrarCliente(int pos) {
        for (int i = pos; i < conCli - 1; i++) {
            misClientes[i] = misClientes[i + 1];
        }
        conCli--;
        return "Cliente borrado correctamente";
    }

    public void grabarTodo() {
        grabarUsuarios();
        grabarClientes();
        grabarProductos();
        grabarConfiguracion();
    }

    public void grabarUsuarios() {

        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter("Data/usuarios.txt");
            pw = new PrintWriter(fw);

            for (int i = 0; i < conUsu; i++) {
                pw.println(misUsuarios[i].toString());
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void grabarClientes() {

        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter("Data/clientes.txt");
            pw = new PrintWriter(fw);

            for (int i = 0; i < conCli; i++) {
                pw.println(misClientes[i].toString());
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public void grabarProductos() {

        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter("Data/productos.txt");
            pw = new PrintWriter(fw);

            for (int i = 0; i < conPro; i++) {
                pw.println(misProductos[i].toString());
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void grabarConfiguracion() {

        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter("Data/configuracion.ini");
            pw = new PrintWriter(fw);
            pw.println("[Generel]");
            pw.println("FacturaActual=" + numFac);
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void cargarUsuarios() {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("Data/usuarios.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            int pos;
            String aux;
            String linea;

            String IdUsuario;
            String nombres;
            String apellidos;
            String clave;
            int perfil;

            while ((linea = br.readLine()) != null) {
                //Extraer ID Usuario
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                IdUsuario = aux;
                linea = linea.substring(pos + 1);

                //Extraer Nombres
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                nombres = aux;
                linea = linea.substring(pos + 1);

                //Extraer Apellidos
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                apellidos = aux;
                linea = linea.substring(pos + 1);

                //Extraer Clave y Perfil
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                clave = aux;
                linea = linea.substring(pos + 1);

                perfil = new Integer(linea);

                Usuario miUsuario = new Usuario(
                        IdUsuario, nombres, apellidos, clave, perfil);
                misUsuarios[conUsu] = miUsuario;
                conUsu++;
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void cargarProductos() {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("Data/productos.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            int pos;
            String aux;
            String linea;

            String idProducto;
            String descripcion;
            int precio;
            int iva;
            String nota;

            while ((linea = br.readLine()) != null) {
                //Extraer ID Producto
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                idProducto = aux;
                linea = linea.substring(pos + 1);

                //Extraer Descripción
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                descripcion = aux;
                linea = linea.substring(pos + 1);

                //Extraer Precio
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                precio = new Integer(aux);
                linea = linea.substring(pos + 1);

                //Extraer Iva y nota
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                iva = new Integer(aux);
                linea = linea.substring(pos + 1);

                nota = linea;

                Producto miProducto = new Producto(
                        idProducto, descripcion, precio, iva, nota);
                misProductos[conPro] = miProducto;
                conPro++;
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void cargarClientes() {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("Data/clientes.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            int pos;
            String aux;
            String linea;

            String idCliente;
            int idTipo;
            String nombres;
            String apellidos;
            String direccion;
            String telefono;
            int idCiudad;
            Date fechaNacimiento;
            Date fechaIngreso;

            while ((linea = br.readLine()) != null) {
                //Extraer ID Cliente
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                idCliente = aux;
                linea = linea.substring(pos + 1);

                //Extraer ID Tipo
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                idTipo = new Integer(aux);
                linea = linea.substring(pos + 1);

                //Extraer Nombres
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                nombres = aux;
                linea = linea.substring(pos + 1);

                //Extraer Apellidos
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                apellidos = aux;
                linea = linea.substring(pos + 1);

                //Extraer Dirección
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                direccion = aux;
                linea = linea.substring(pos + 1);

                //Extraer Telefono
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                telefono = aux;
                linea = linea.substring(pos + 1);

                //Extraer Nombres
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                idCiudad = new Integer(aux);
                linea = linea.substring(pos + 1);

                //Extraer F.Nacimiento y F.Ingreso
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                fechaNacimiento = Utilidades.stringToDate(aux);
                linea = linea.substring(pos + 1);

                fechaIngreso = Utilidades.stringToDate(linea);

                Cliente miCliente = new Cliente(
                        idCliente, idTipo, nombres, apellidos, direccion,
                        telefono, idCiudad, fechaNacimiento, fechaIngreso);
                misClientes[conCli] = miCliente;
                conCli++;
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void cargarConfiguracion() {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("Data/configuracion.ini");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("FacturaActual=")) {
                    numFac = new Integer(linea.substring(14));
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}