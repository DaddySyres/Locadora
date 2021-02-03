package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.bean.Cliente;
import model.dao.ClienteDAO;
import model.dao.ClienteDAO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class JFListarCliente extends JFrame {

	private JPanel contentPane;
	private JTable jtCliente;
	private JButton btnLimpar;
	private JButton btnCancelar;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarCliente frame = new JFListarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFListarCliente() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				readJtable();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 115, 23);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 31, 541, 289);
		contentPane.add(scrollPane);
		
		jtCliente = new JTable();
		jtCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "CPF", "Email", "Telefone","Endereço"
			}
		));
		scrollPane.setViewportView(jtCliente);
		
		btnLimpar = new JButton("Atualizar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jtCliente.getSelectedRow() != -1) {
					JFAtualizarCliente ac = new JFAtualizarCliente((int)jtCliente.getValueAt(jtCliente.getSelectedRow(), 0 ));
					ac.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Selecione uma linha");
				}
				readJtable();
			}
		});
		btnLimpar.setBounds(113, 330, 93, 26);
		contentPane.add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setAction(action_1);
		btnCancelar.setBounds(458, 330, 93, 26);
		contentPane.add(btnCancelar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setAction(action_2);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jtCliente.getSelectedRow() != -1) {	
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja deletar o Cliente selecionado", "Deletar", JOptionPane.YES_NO_OPTION);
					if(opcao == 0) {
						ClienteDAO dao = new ClienteDAO();
						Cliente c = new Cliente();
						c.setcId((int) jtCliente.getValueAt(jtCliente.getSelectedRow(), 0));
						dao.delete(c);
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Selecione uma linha");
				}
				readJtable();
				
			}
		});
		btnDeletar.setBounds(10, 330, 93, 26);
		contentPane.add(btnDeletar);
		
		readJtable();
	}
	
	
	public void readJtable() {
		DefaultTableModel modelo = (DefaultTableModel) jtCliente.getModel();
		modelo.setNumRows(0);
		ClienteDAO cDAO = new ClienteDAO();
		for(Cliente c: cDAO.read()) {
			modelo.addRow(new Object[] {
					c.getcId(),
					c.getcNome(),
					c.getcCPF(),
					c.getcEmail(),
					c.getcTelefone(),
					c.getcEndereco()
			});
		}
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Cancelar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Deletar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
