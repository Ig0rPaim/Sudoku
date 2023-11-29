package Ui;

import javax.swing.JFrame;
import Ui.InterativeWindown;

public class Interface {
	public static void main(String[] args) {
		InterativeWindown janela = new InterativeWindown();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(550, 300);
		janela.setVisible(true);
	}
	
	
}
