import java.awt.*;
import javax.swing.*;

public class ChessEngineGUI {
	
	private JFrame mainFrame;
	
	
	public ChessEngineGUI() {
		
		mainFrame = new JFrame("StackFish // the redneck Stockfish");
		
		mainFrame.setPreferredSize(new Dimension (1300, 1400));
		mainFrame.setLayout(new GridLayout(10,10));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		
		display();
		
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
	}
	
	private void display() {
		
		for(int i = 0; i < 10; i++) { //top row empty
			mainFrame.add(new JPanel());
		}
		
		for(int i = 0; i < 8; i++) { //make board
			
			mainFrame.add(new JPanel());
			
			for(int j = 0; j < 8; j++) {
				
				if((i + j) % 2 == 0) {
					addWhitePanel();
				}else {
					addBlackPanel();
				}
				
			}
			
			mainFrame.add(new JPanel());
			
		}
		
		for(int i = 0; i < 10; i++) { //bottom row empty
			mainFrame.add(new JPanel());
		}
	}
	
	private void addWhitePanel() {
		JPanel whitePanel = new JPanel();
		whitePanel.setBackground(Color.white);
		mainFrame.add(whitePanel);
	}
	
	private void addBlackPanel() {
		JPanel blackPanel = new JPanel();
		blackPanel.setBackground(Color.black);
		mainFrame.add(blackPanel);
	}
	
	public static void main(String args[]) {
		// new ChessEngineGUI();
		Chessboard cb = new Chessboard();
		System.out.println(cb.toString());
		cb.move(6, 4, 4 ,4);
		System.out.println(cb.toString());
		cb.move(1, 4, 3 ,4);
		System.out.println(cb.toString());
		cb.move(7, 6, 5 ,5);
		System.out.println(cb.toString());
		cb.move(1, 1, 3 ,1);
		System.out.println(cb.toString());
		cb.move(5, 5, 4 ,3);
		System.out.println(cb.toString());
		cb.move(3, 4, 4, 3);
		System.out.println(cb.toString());
		System.out.println("oof");
		
	}
}
