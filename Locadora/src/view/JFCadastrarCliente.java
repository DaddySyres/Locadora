package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import model.bean.Cliente;
import model.dao.ClienteDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class JFCadastrarCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_cName;
	private JTextField txt_cSurname;
	private JTextField txt_cEmail;
	private JTextField txt_cAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarCliente frame = new JFCadastrarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public JFCadastrarCliente() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar cliente ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 199, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 58, 74, 21);
		contentPane.add(lblNewLabel_1);
		
		txt_cName = new JTextField();
		txt_cName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_cName.setBounds(10, 89, 170, 19);
		contentPane.add(txt_cName);
		txt_cName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sobrenome");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(190, 58, 123, 21);
		contentPane.add(lblNewLabel_2);
		
		txt_cSurname = new JTextField();
		txt_cSurname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_cSurname.setBounds(190, 89, 476, 19);
		contentPane.add(txt_cSurname);
		txt_cSurname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 138, 74, 21);
		contentPane.add(lblNewLabel_1_1);
		
		MaskFormatter mf1 = new MaskFormatter("(##) #####-####");
	    mf1.setPlaceholderCharacter('_');
		JFormattedTextField txt_cPhone = new JFormattedTextField();
		txt_cPhone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_cPhone.setToolTipText("");
		txt_cPhone.setBounds(445, 169, 221, 19);
		contentPane.add(txt_cPhone);
		
		
		txt_cEmail = new JTextField();
		txt_cEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_cEmail.setColumns(10);
		txt_cEmail.setBounds(10, 169, 425, 19);
		contentPane.add(txt_cEmail);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Endere\u00E7o");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 214, 80, 21);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Telefone");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(445, 138, 74, 21);
		contentPane.add(lblNewLabel_1_1_2);
		
		txt_cAddress = new JTextField();
		txt_cAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_cAddress.setBounds(10, 245, 656, 19);
		contentPane.add(txt_cAddress);
		txt_cAddress.setColumns(10);
		
		JButton btnSubmit = new JButton("Confirmar");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = new Cliente();
				ClienteDAO cDAO = new ClienteDAO();
				c.setcName(txt_cName.getText());
				c.setcSurname(txt_cSurname.getText());
				c.setcEmail(txt_cEmail.getText());
				c.setcPhone(txt_cPhone.getText());
				c.setcAddress(txt_cAddress.getText());
				c.setcAddress(txt_cAddress.getText()); 
				cDAO.create(c);
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(10, 340, 111, 33);
		contentPane.add(btnSubmit);
		
		JButton btnClear = new JButton("Limpar");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClear.setBounds(434, 340, 111, 33);
		contentPane.add(btnClear);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(555, 340, 111, 33);
		contentPane.add(btnCancel);
	}
}
