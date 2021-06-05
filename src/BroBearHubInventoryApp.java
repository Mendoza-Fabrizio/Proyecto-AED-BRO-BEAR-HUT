public class BroBearHubInventoryApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Datos misDatos = new Datos();
        //Llamar a la interfaz de Login
        FrmLogin miLogin = new FrmLogin();
        miLogin.setDatos(misDatos);
        miLogin.setLocationRelativeTo(null);
        miLogin.setVisible(true);*/
		Usuario a = new Usuario();
		BSTree<Cliente> b = new BSTree<Cliente>();
		BSTree<Producto> b1 = new BSTree<Producto>();
		try {
			b.insert(new Usuario());
			b1.insert(new Producto("1","Cuaderno",100,20,"Cuaderno layconsa A4"));
			b1.insert(new Producto("2","Altavoces",140,20,"Altavoces"));
			b1.inOrden();
			comparar(b1.search(new Producto("1","Cuaderno",100,20,"Cuaderno layconsa A4")),
			b1.search(new Producto("2","Altavoces",140,20,"Altavoces")));
		}
		catch (Exception y) {
			System.out.println(y.getMessage());
		}
	}
	public static void comparar(Producto a1, Producto a2) throws ItemNoFound{
		if(a1.compareTo(a2) == -1) {
			System.out.println("El producto"+a1.getDescripcion()+" tiene mayor precio que "+a2.getDescripcion());
		}
		else {
			System.out.println("El producto"+a1.getDescripcion()+" tiene menor precio que "+a2.getDescripcion());
		}
	}

}
