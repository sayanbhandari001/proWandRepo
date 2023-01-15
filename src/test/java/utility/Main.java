package utility;

import javax.swing.JOptionPane;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import Login.login;

public class Main {

	public static void main(String[] args) {
		int dialogButtonOptions = JOptionPane.YES_NO_OPTION;
	    int dialogButtonClicked = JOptionPane.showConfirmDialog (null, "Do you want to proceed to submitting your attendance?","Warning",dialogButtonOptions);

	    if (dialogButtonClicked == JOptionPane.YES_OPTION) { //The ISSUE is here
			TestListenerAdapter tla = new TestListenerAdapter();
		    TestNG testng = new TestNG();
		    testng.setTestClasses(new Class[] { login.class });
		    testng.addListener(tla);
		    testng.run();
		    
	    } else {
	    	
		    JOptionPane.showMessageDialog (null, "You have chosen not to continue submiiting the attendance.","Warning",JOptionPane.OK_OPTION);
	    }
	}

}
