package utility;

import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import Login.login;

public class Main {

	public static void main(String[] args) throws HeadlessException, IOException {
		int dialogButtonOptions = JOptionPane.YES_NO_OPTION;
	    int dialogButtonClicked = JOptionPane.showConfirmDialog (null, ConfigReader.confirmDialogMessage(), ConfigReader.confirmDialogTitle(), dialogButtonOptions);

	    if (dialogButtonClicked == JOptionPane.YES_OPTION) { //The ISSUE is here
			TestListenerAdapter tla = new TestListenerAdapter();
		    TestNG testng = new TestNG();
		    testng.setTestClasses(new Class[] { login.class });
		    testng.addListener(tla);
		    testng.run();
		    
	    } else {
	    	
		    JOptionPane.showMessageDialog (null, ConfigReader.alertDialogMessage(), ConfigReader.alertDialogTitle(), JOptionPane.OK_OPTION);
	    }
	}

}
