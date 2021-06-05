import Interfacez.FrmLogin;
public class BroBearHubInventoryApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Datos misDatos = new Datos();
        //Llamar a la interfaz de Login
        FrmLogin miLogin = new FrmLogin();
        miLogin.setDatos(misDatos);
        miLogin.setLocationRelativeTo(null);
        miLogin.setVisible(true);
	}

}
