package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.bean.Filme;
import model.dao.FilmeDAO;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class JFListarFilmes extends JFrame {
	
	private JPanel contentPane;
	private JTable jtFilme;	
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarFilmes frame = new JFListarFilmes();
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
	public JFListarFilmes() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				readJtable();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel asd = new JLabel("Listar Filme");
		asd.setFont(new Font("Tahoma", Font.BOLD, 14));
		asd.setBounds(10, 10, 106, 21);
		contentPane.add(asd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 41, 454, 149);
		contentPane.add(scrollPane);
		
		jtFilme = new JTable();
		jtFilme.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id","t\u00EDtulo", "categoria",  "tempo"
			}
		));
		scrollPane.setViewportView(jtFilme);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jtFilme.getSelectedRow() != -1) {
					JFAtualizarFilme af = new JFAtualizarFilme((int)jtFilme.getValueAt(jtFilme.getSelectedRow(), 0 ));
					af.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Selecione uma linha");
				}
				readJtable();
			}
		});
		btnAlterar.setBounds(20, 224, 106, 29);
		contentPane.add(btnAlterar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setAction(action_1);
		btnCancelar.setBounds(368, 224, 106, 29);
		contentPane.add(btnCancelar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setAction(action);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jtFilme.getSelectedRow() != -1) {
					
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja deletar o filme selecionado", "Deletar", JOptionPane.YES_NO_OPTION);
					
					if(opcao == 0) {
						FilmeDAO dao = new FilmeDAO();
						Filme f = new Filme();
						f.setIdFilme((int) jtFilme.getValueAt(jtFilme.getSelectedRow(), 0));
						dao.delete(f);
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Selecione uma linha");
				}
				readJtable();
			}
		});
		
		
		btnDeletar.setBounds(136, 224, 106, 29);
		contentPane.add(btnDeletar);
		
		readJtable();
	}
	
	public void readJtable() {
		DefaultTableModel modelo =(DefaultTableModel) jtFilme.getModel();
		modelo.setNumRows(0);
		FilmeDAO fdao = new FilmeDAO();
		for(Filme f: fdao.read()) {
			modelo.addRow(new Object[] {
					f.getIdFilme(),
					f.getTitulo(),
					f.getCategoria(),
					f.getTempo()
			});
		}
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Deletar");
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
}

