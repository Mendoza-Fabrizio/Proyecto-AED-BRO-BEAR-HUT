package BBH;
import java.util.*;
import BBH.POO.Cliente;
import BBH.POO.Producto;
import BBH.POO.Proveedores;
import BBH.POO.Usuario;
import BBH.tools.BSTree.BSTree;
import BBH.tools.elineales.Listas.ListLinked;
public class BroBearHubInventoryApp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BSTree<Cliente> AClientes = new BSTree<Cliente>();
		ListLinked<Producto> productos = new ListLinked<Producto>();
		BSTree<Proveedores> AProveedores = new BSTree<Proveedores>();
		BSTree<Usuario> Usuarios = new BSTree<Usuario>();
		System.out.println("Desea ingresar a la plataforma?:");
		String opcion = in.next();
		int opcion1;
		while(!(opcion.equalsIgnoreCase("No")||opcion.equalsIgnoreCase("Si"))) {
			System.out.println("Opcion incorrecta Por favor ingrese (Si/No)");
			opcion = in.next();
		}
		while(opcion.equalsIgnoreCase("No")) {
			System.out.println("<========Bienvenido al sistema BRO-BEAR-HUT=======>");
			System.out.println("Que desea hacer? Por favor ingrese una opcion \n\t1.Agregar Productos\n\t2.Agregar Usuarios\n\t3. Agregar Clientes \n\t 4. Agregar Proveedores\n\t5. Salir del sistema");
			opcion1 = in.nextInt();
			switch(opcion1) {
			case 1:
				break;
			case 2:
				break;
				Usuarios.insert(Usuario.UsuarioAgregarUsuario());
			case 3:
				break;
			case 4:
				break;
			case 5:
				System.out.println("Hasta luego, Saliendo del sistema...");
				opcion = "No";
				break;
			}
		}
	}
}
