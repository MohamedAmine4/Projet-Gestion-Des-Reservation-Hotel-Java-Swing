package Login;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ajouter_Reservation_1.Ajouter_RES;
import Connexion.Connexion;
import Main.Frame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
    private Frame f=new Frame();
    JButton btnNewButton,btnNewButton_1;
	Connexion connecter=new Connexion();
	public Login() {
		f.setVisible(true);
		f.setBounds(360, 160, 699, 460);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 204, 102));
		panel.setBounds(0, 0, 391, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Form");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(130, 0, 209, 69);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 251, 424, -198);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 51));
		panel_2.setBounds(0, 69, 391, 352);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Connecter");
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setBounds(198, 284, 151, 44);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quitter");
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(42, 284, 134, 44);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(21, 156, 89, 44);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(21, 51, 89, 44);
		panel_2.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(Color.GRAY);
		textField.setSelectedTextColor(Color.LIGHT_GRAY);
		textField.setBounds(120, 59, 229, 33);
		panel_2.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.GRAY);
		passwordField.setBounds(120, 164, 229, 33);
		panel_2.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/image/1.png.png")));
		lblNewLabel_3.setBounds(401,0, 282, 421);
		contentPane.add(lblNewLabel_3);
		
		ImageIcon im=new ImageIcon(Login.class.getResource("/image/1.png.png"));
		lblNewLabel_3.setBackground(Color.GRAY);
		f.add(panel);
		f.add(panel_2);
	f.add(lblNewLabel_3);
		f.add(panel_1);
		
		 btnNewButton_1 .addActionListener(this ::quitter);
		 btnNewButton.addActionListener(this ::connecter);
	}	
	
	
	
    public JTextField getTextField() {
		return textField;
	}



	public JPasswordField getPasswordField() {
		return passwordField;
	}



	public void connecter(ActionEvent e) {
	    Object s = e.getSource();
	    String us = textField.getText();
	    char[] pwd = passwordField.getPassword();

	    if(us.isEmpty() ||  pwd.length == 0 ) {
	        JOptionPane.showMessageDialog(null, "Veuillez saisir un nom d'utilisateur et un mot de passe");
	    } else {
	        String pwdStr = new String(pwd);
	        if(us.equals("Agent") && pwdStr.equals("agent123")) {
	            JOptionPane.showMessageDialog(null, "agent");
	        } else if(us.equals("Admin") && pwdStr.equals("admin123")) {
	            JOptionPane.showMessageDialog(null, "admin");
	        } else {
	            JOptionPane.showMessageDialog(null, "votre mot de passe ou votre identifiant est incorrect");
	        }
	    }
	}
    public void quitter(ActionEvent e) {
    
    	    	int r=JOptionPane.showConfirmDialog(null,"Souhaitez-vous quitter ?","",JOptionPane.YES_NO_OPTION);
    	    	if(r==JOptionPane.OK_OPTION) {
    	    	System.exit(0);
    	    	}
    	    
    }
    }

