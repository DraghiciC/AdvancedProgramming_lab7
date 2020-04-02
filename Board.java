import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Board extends JPanel {

	/**
	 * Create the panel.
	 */
	int numar;
	public Board(Token[] list,Token[] list_p1,Token[] list_p2,Game game) {
		setLayout(new GridLayout(2, 0, 0, 0));
		for (int i = 0;i<40;i++) {
			if(list[i].value!=-1) {
			final String str = Integer.toString(list[i].value);
			final int poz=i;
			JButton btnNewButton = new JButton(str);
			add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					list[poz].value=-1;
					if(game.current_player==1) {
						game.current_player=2;
						for(int i =0;i<20;i++)
							if(game.p1[i].value==-1)
							{
								game.p1[i].value=poz;
								break;
							}
					}
					else
					{
						game.current_player=1;
						for(int i =0;i<20;i++)
						if(game.p2[i].value==-1)
						{
							game.p2[i].value=poz;
							break;
						}
					}
					int ok=1;
					for(int i=0;i<40;i++)
						if(game.b[i].value!=-1)
						{
							ok=0;
						}
					if(ok==0) {
					game.initialize(list, list_p1, list_p2);
					}
					else {
						System.out.print("finish");
						game.rezultat();
					}
				}
			});
			}
		}
	}
}
