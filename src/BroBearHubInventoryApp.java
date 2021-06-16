import java.util.*;
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
	public static void comparar(Producto a1, Producto a2) throws ItemNoFound{
		if(a1.compareTo(a2) == 1) {
			System.out.println("El producto"+a1.getDescripcion()+" tiene mayor precio que "+a2.getDescripcion());
		}
		else if(a1.compareTo(a2) == -1) {
			System.out.println("El producto"+a1.getDescripcion()+" tiene menor precio que "+a2.getDescripcion());
		}
		else {
			System.out.println("son iguales");
		}
	}

}
