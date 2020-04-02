

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class Game {

	private JFrame frame;
	Token[] p1=new Token[20];
	Token[] p2=new Token[20];
	Token[] b=new Token[40];
	JPanel Player_1;
	JPanel Player_2;
	String pl1="Andrei";
	String pl2="Mihai";
	Board board;
	int current_player=1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Game() {
		frame = new JFrame();
		frame.setBounds(10, 10, 1800, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		for(int i=0;i<20;i++)
			p1[i]=new Token(-1);
		Player_1 = new Player(p1,pl1);
		frame.getContentPane().add(Player_1, BorderLayout.SOUTH);
		for(int i=0;i<20;i++)
			p2[i]=new Token(-1);
		Player_2 = new Player(p2,pl2);
		frame.getContentPane().add(Player_2, BorderLayout.NORTH);
		for(int i=0;i<40;i++)
			b[i]=new Token(i+1);
		board = new Board(b,p1,p2,this);
		frame.getContentPane().add(board, BorderLayout.CENTER);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(Token[] list,Token[] list_p1,Token[] list_p2) {
		frame.getContentPane().removeAll();
		Player_1 = new Player(p1,pl1);
		frame.getContentPane().add(Player_1, BorderLayout.SOUTH);
		Player_2 = new Player(p2,pl2);
		frame.getContentPane().add(Player_2, BorderLayout.NORTH);
		board = new Board(b,p1,p2,this);
		frame.getContentPane().add(board, BorderLayout.CENTER);
		this.frame.setVisible(true);
	}
	public void rezultat() {
		frame.getContentPane().removeAll();
		int aux,ok=1;
		while(ok==1) {
			ok=0;
			for(int i=0;i<19;i++) {
				if(p1[i].value>p1[i+1].value) {
					aux=p1[i].value;
					p1[i].value=p1[i+1].value;
					p1[i+1].value=aux;
					ok=1;
				}
			}
		}
		ok=1;
		while(ok==1) {
			ok=0;
			for(int i=0;i<19;i++) {
				if(p2[i].value>p2[i+1].value) {
					aux=p2[i].value;
					p2[i].value=p2[i+1].value;
					p2[i+1].value=aux;
					ok=1;
				}
			}
		}
		
		int score1=0;
		int score2=0;
		aux=0;
		int []llap = new int[20]; 
	    for(int i = 0; i < 20; i++) 
	        llap[i] = 2; 
	    for (int j = 20 - 2; j >= 0; j--) 
	    { 
	        int i = j - 1; 
	        int k = j + 1; 
	        while (i >= 0 && k < 20) 
	        { 
	            if (p1[i].value + p1[k].value == 2 * p1[j].value) 
	            { 
	                llap[j] = Math.max(llap[k] + 1, llap[j]); 
	                aux = Math.max(aux, llap[j]); 
	                i -= 1; 
	                k += 1; 
	            } 
	            else if (p1[i].value + p1[k].value < 2 * p1[j].value) 
	                k += 1; 
	            else
	                i -= 1; 
	        } 
	    } 
	    score1=aux;
	    aux=0;
		llap = new int[20]; 
	    for(int i = 0; i < 20; i++) 
	        llap[i] = 2; 
	    for (int j = 20 - 2; j >= 0; j--) 
	    { 
	        int i = j - 1; 
	        int k = j + 1; 
	        while (i >= 0 && k < 20) 
	        { 
	            if (p1[i].value + p1[k].value == 2 * p1[j].value) 
	            { 
	                llap[j] = Math.max(llap[k] + 1, llap[j]); 
	                aux = Math.max(aux, llap[j]); 
	                i -= 1; 
	                k += 1; 
	            } 
	            else if (p1[i].value + p1[k].value < 2 * p1[j].value) 
	                k += 1; 
	            else
	                i -= 1; 
	        } 
	    } 
	    score2=aux; 
	    String s;
	    if(score1>score2) {
	    	s=pl1;
	    }
	    else {
	    	s=pl2;
	    }
	    JLabel lblNewLabel = new JLabel(s+" a castigat");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 43));
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		this.frame.setVisible(true);
	}
}
