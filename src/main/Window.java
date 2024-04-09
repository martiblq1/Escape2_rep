package main;
import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame
{
	private Panel panel;
	
	Window()
	{
		this.setUndecorated(true);
		this.setVisible(true);
		this.setTitle("Escape game 2");
		this.setLayout(new BorderLayout());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		panel = new Panel();
		this.add(panel);
		this.pack();
	}
	
	public Panel get_panel()
	{
		return panel;
	}
}
