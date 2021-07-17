import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import BBH.POO.Usuario;
import BBH.tools.BSTree.BSTree;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {
	
	private JFrame frame;
	private JTextField textUsuario;
	private JTextField textClave;

	/**
	 * Launch the application.
	 * @throws BBH.tools.BSTree.ItemDuplicated 
	 */
	public static void main(String[] args) throws BBH.tools.BSTree.ItemDuplicated, ItemDuplicated  {
		BSTree<Usuario> users=new BSTree<Usuario>();
		users.insert(new Usuario(1,"dy0111","Dyanyra","Estrada","123",2));
		users.insert(new Usuario(2,"fer2608","Fernanda","Diaz","124",2));
		users.insert(new Usuario(3,"pauleon","Paul","Zapata","126",2));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login(users);
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
	public Login(BSTree<Usuario> users) {
		initialize(users);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(BSTree<Usuario> users) {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(224, 255, 255));
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bro Bear Hut");
		lblNewLabel.setBounds(0, 11, 434, 31);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblUsuario.setBounds(31, 86, 79, 14);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblClave = new JLabel("Contrase\u00F1a:");
		lblClave.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblClave.setBounds(31, 136, 102, 14);
		frame.getContentPane().add(lblClave);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(143, 83, 185, 20);
		frame.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
		
		textClave = new JPasswordField();
		textClave.setBounds(143, 133, 185, 20);
		frame.getContentPane().add(textClave);
		
		JButton btnIngresar = new JButton("Ingresa");
		btnIngresar.setBackground(new Color(224, 255, 255));
		btnIngresar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		Object d=this;
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=textUsuario.getText();
				char[] clave=((JPasswordField) textClave).getPassword();
				String contra=textClave.getText();
				System.out.println(contra+clave);
				System.out.println(user);
				try {
					Usuario u1=users.search(new Usuario(user));
					//((JFrame) e.getSource()).dispose();
					frame.dispose();
					JOptionPane.showMessageDialog(null, "Bienvenido a Bro Bear Hut");	
					Principal p= new Principal(null,null,null);
					p.frame.setVisible(true);
				} catch (BBH.tools.BSTree.ItemNoFound e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}		
		});
		btnIngresar.setBounds(205, 211, 89, 23);
		frame.getContentPane().add(btnIngresar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(224, 255, 255));
		btnCancelar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnCancelar.setBounds(321, 211, 89, 23);
		frame.getContentPane().add(btnCancelar);
	}
}
