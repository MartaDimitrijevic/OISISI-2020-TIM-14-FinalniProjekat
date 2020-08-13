package gui;

import java.awt.Dimension;

import javax.swing.JDialog;

public class LogIn extends JDialog {

	public static void main(String[] args) {
		try {
			LogIn logInDialog = new LogIn();
			logInDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			logInDialog.setMinimumSize(new Dimension(450, 350));
			logInDialog.setVisible(true);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
