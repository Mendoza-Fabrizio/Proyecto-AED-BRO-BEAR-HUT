import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import BBH.POO.Producto;

import javax.swing.JComboBox;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Principal {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList<String> tnd=new ArrayList<String>();
		ArrayList<Producto> prod=new ArrayList<Producto>();
		ArrayList<String> nomp=new ArrayList<String>();
		tnd.add("Plaza vea");
		tnd.add("Tottus");
		tnd.add("Wong");
		prod.add(new Producto("Inka kola",6,"Wong"));
		prod.add(new Producto("Inka kola",7,"Tottus"));
		prod.add(new Producto("Inka kola",5,"Plaza Vea"));
		prod.add(new Producto("Agua Cielo",2,"Wong"));
		prod.add(new Producto("Agua Cielo",4,"Tottus"));
		prod.add(new Producto("Agua Cielo",3,"Plaza Vea"));
		prod.add(new Producto("Pilsen",12,"Wong"));
		prod.add(new Producto("Pilsen",11,"Tottus"));
		prod.add(new Producto("Pilsen",10,"Plaza Vea"));
		nomp.add("Inka Kola");
		nomp.add("Agua Cielo");
		nomp.add("Pilsen");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal(tnd, prod,nomp);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal(ArrayList<String> tnd,ArrayList<Producto> prod,ArrayList<String> nomp) {
		initialize(tnd,prod,nomp);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<String> tnd, ArrayList<Producto> prod,ArrayList<String> nomp ) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTienda1 = new JLabel("Tienda 1");
		lblTienda1.setBounds(79, 66, 58, 14);
		frame.getContentPane().add(lblTienda1);
		
		JLabel lblTienda2 = new JLabel("Tienda 2");
		lblTienda2.setBounds(283, 66, 62, 14);
		frame.getContentPane().add(lblTienda2);
		
		JComboBox tienda1 = new JComboBox();
		tienda1.setModel(new DefaultComboBoxModel(new String[] {"Wong", "Tottus", "Plaza vea"}));
		tienda1.setBackground(Color.WHITE);
		tienda1.setBounds(46, 100, 108, 22);
		frame.getContentPane().add(tienda1);
		
		JComboBox tienda2 = new JComboBox();
		tienda2.setModel(new DefaultComboBoxModel(tnd.toArray()));		
		tienda2.setBounds(248, 100, 112, 22);
		frame.getContentPane().add(tienda2);
		
		JLabel lblProducto1 = new JLabel("Producto 1");
		lblProducto1.setBounds(79, 149, 75, 14);
		frame.getContentPane().add(lblProducto1);
		
		JLabel lblProducto2 = new JLabel("Producto 2");
		lblProducto2.setBounds(283, 149, 77, 14);
		frame.getContentPane().add(lblProducto2);
		
		JComboBox producto1 = new JComboBox();
		producto1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		producto1.setModel(new DefaultComboBoxModel(nomp.toArray()));			
		producto1.setBounds(46, 173, 108, 22);
		frame.getContentPane().add(producto1);
		
		JComboBox producto2 = new JComboBox();		
		producto2.setModel(new DefaultComboBoxModel(nomp.toArray()));	
		producto2.setBounds(248, 173, 112, 22);
		frame.getContentPane().add(producto2);
		
		JLabel Titulo = new JLabel("Comparador de precios");
		Titulo.setForeground(Color.WHITE);
		Titulo.setFont(new Font("Edwardian Script ITC", Font.BOLD, 30));
		Titulo.setBounds(101, 11, 244, 44);
		frame.getContentPane().add(Titulo);
		
		JButton btnComp = new JButton("Comparar");
		btnComp.setBounds(163, 227, 89, 23);
		frame.getContentPane().add(btnComp);
		
		JLabel lblComp = new JLabel("New label");
		lblComp.setBounds(185, 195, 46, 14);
		frame.getContentPane().add(lblComp);
	}
}

