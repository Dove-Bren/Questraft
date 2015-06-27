package nmt.minecraft.Questraft.Window;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class QuestraftWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	


	public QuestraftWindow(String name) {
		super(name);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		
		//File menu -> new | open | save | save as | close
		JMenu fileMenu = new JMenu();
		fileMenu.setText("File");
			JMenuItem item;
			//new item
	
	}
	
}
