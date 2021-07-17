package BBH;
import java.util.*;
import BBH.POO.Cliente;
import BBH.POO.Producto;
import BBH.POO.Proveedores;
import BBH.tools.BSTree.BSTree;
public class BroBearHubInventoryApp {

	public static void main(String[] args) {
		BSTree<Cliente> b = new BSTree<Cliente>();
		BSTree<Producto> b1 = new BSTree<Producto>();
		BSTree<Proveedores> b2 = new BSTree<Proveedores>();
		try {
			Menu.MostrarMenu();
		}
		catch (Exception y) {
			System.out.println(y.getMessage());
		}
	}

}
