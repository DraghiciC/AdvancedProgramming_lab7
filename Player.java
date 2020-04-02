import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Player extends JPanel {

	/**
	 * Create the panel.
	 */
	int size;
	public Player(Token[] list,String s) {
		size=list.length;
		s= s+" : ";
		for (int i = 0;i<size;i++) {
			if(list[i].value!=-1) {
			final String str = Integer.toString(list[i].value+1);
			s= s+ str+" , ";}
		}
		JLabel lblNewLabel = new JLabel(s);
		add(lblNewLabel);
	}
}
