package views;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class ByteCodeToolMainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ByteCodeToolMainWindow() {
		Sprachen language = new Sprachen();
		
		JMenuBar jmb = new JMenuBar();
		JMenu jm = new JMenu(language.MENUBAR_ITEM_EDIT);
		jmb.add(jm);
		


		jmb.add(new JMenu(language.MENUBAR_ITEM_FILE));
		jmb.add(new JMenu(language.MENUBAR_ITEM_SOURCE));
		

		
		this.add( jmb );
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByteCodeToolMainWindow mainframe = new ByteCodeToolMainWindow();
		
		mainframe.setVisible(true);
	}

}
