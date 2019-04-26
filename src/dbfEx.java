import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbfEx {

	Frame F;
	dbfEx(){
		Frame F = new Frame();
		WindowEvents E = new WindowEvents();
		F.addWindowListener(E);
		F.setSize(400, 200);
		F.setVisible(true);

	}
	
	public static void main (String abc[]) {
		
		new dbfEx(); 
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/qa","root","");
			Statement Stat = con.createStatement();
			ResultSet Rec = Stat.executeQuery("Select * From School");
			while(Rec.next()) {
				System.out.println(Rec.getInt(1) + ".." + Rec.getString(2) + " .." + Rec.getInt(3));
			}
			}catch(Exception e) {
				System.out.print(e.toString());
			}
	}
	
	class WindowEvents implements WindowListener{

		@Override
		public void windowActivated(WindowEvent x) {
			// TODO Auto-generated method stub
			System.out.println("window is initalised");
			
		}

		@Override
		public void windowClosed(WindowEvent x) {
			// TODO Auto-generated method stub
			System.out.println("window is closed");
		}

		@Override
		public void windowClosing(WindowEvent x) {
			// TODO Auto-generated method stub
			
			System.exit(0);
			
		}

		@Override
		public void windowDeactivated(WindowEvent x) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent x) {
			// TODO Auto-generated method stub
			System.out.println("window is minimising");
		}

		@Override
		public void windowIconified(WindowEvent x) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent x) {
			// TODO Auto-generated method stub
			System.out.println("window is opened");
			
		}
		
		
		
	}
}
