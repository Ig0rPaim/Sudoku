package interfaceTriangulo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterativeWindown  extends JFrame{
	JLabel nome;
	JTextField fieldNome;
	JLabel telefone;
	JTextField fieldTelefone;
	JButton salvarButton;
    JButton fecharButton;
    JMenuItem contatoSalvar;
	JMenuItem contatoNovo;
	
	public InterativeWindown() {
		super("Agenda telefónica");
		CriarMenu();
		CriarFormulario();
	}
	
	private void CriarFormulario()
	{
		setLayout(new BorderLayout());

		JPanel tituloPanel = new JPanel();
		JLabel titulo = new JLabel();
		titulo.setFont(new Font("verdana", Font.PLAIN, 16));
		tituloPanel.add(titulo);
		
		JPanel cadastroPanel = new JPanel();
		cadastroPanel.setLayout(new FlowLayout());
		nome = new JLabel("Nome");
		fieldNome = new JTextField(40);
		telefone = new JLabel("Telefone");
		fieldTelefone = new JTextField(40);
		cadastroPanel.add(nome);
		cadastroPanel.add(fieldNome);
		cadastroPanel.add(telefone);
		cadastroPanel.add(fieldTelefone);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());
	    salvarButton = new JButton("Salvar");
	    salvarButton.addActionListener(new SalvarEvent());
	    fecharButton = new JButton("Fechar");
	    fecharButton.addActionListener(new FecharEvent());
	    buttonsPanel.add(salvarButton);
	    buttonsPanel.add(fecharButton);
	    
	    add(tituloPanel, BorderLayout.NORTH);
	    add(cadastroPanel, BorderLayout.CENTER);
	    add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	private void CriarMenu() 
	{
		JMenu contato = new JMenu("Contato");
		contatoSalvar = new JMenuItem("Salvar");
		contatoSalvar.addActionListener(new SalvarEvent());
		contatoNovo = new JMenuItem("Novo");
		contatoNovo.addActionListener(new NovoEvent());
		contato.add(contatoSalvar);
		contato.add(contatoNovo);
		
		JMenu ajuda = new JMenu("Ajuda");
		JMenuItem ajudaSobre = new JMenuItem("Sobre ...");
		ajudaSobre.addActionListener(new SobreEvent());
		ajuda.add(ajudaSobre);
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(contato);
		bar.add(ajuda);
	}
	
	private class NovoEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			fieldNome.setText("");
			fieldTelefone.setText("");
		}
		
	}
	
	private class FecharEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			System.exit(0);
		}
		
	}
	
	private class SalvarEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			JOptionPane.showMessageDialog(
					null,
					"Cadastro feito com sucesso",
					"Salvo!",
					JOptionPane.PLAIN_MESSAGE
			);
		}
		
	}
	
	private class SobreEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			JOptionPane.showMessageDialog(
					null,
					"Programa teste",
					"Opa!",
					JOptionPane.PLAIN_MESSAGE
			);
		}
		
	}
	
	
}
