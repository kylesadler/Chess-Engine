import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ChessEngineGUI {
	
	private JFrame mainFrame;
	private JPanel[][] board;
	private Chessboard chessboard;
	
	public ChessEngineGUI() {
		
		mainFrame = new JFrame("SadlerFish // a knockoff Stockfish");
		board = getNewBoard();
		chessboard = new Chessboard();
		
		mainFrame.setPreferredSize(new Dimension (1300, 1400));
		mainFrame.setLayout(new GridLayout(10,10));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		
		display();
		
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
	}
	
	private void display() {
		getBoard(chessboard);
		
		for(int i = 0; i < 10; i++) { //top row empty
			mainFrame.add(new JPanel());
		}
		
		//display board
		for(int i = 0; i < 8; i++) { 
			mainFrame.add(new JPanel());
			for(int j = 0; j < 8; j++) {
				mainFrame.add(board[i][j]);
			}
			mainFrame.add(new JPanel());
		}
		
		for(int i = 0; i < 10; i++) { //bottom row empty
			mainFrame.add(new JPanel());
		}
	}
	
	private JPanel addPiece(int piece, JPanel panel) {
		
		// clear square
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
		
		// get piece file name
		String file = "";
		switch(piece) {
			case 1:
				file = "white_pawn"; break;
			case -1:
				file = "black_pawn"; break;
			case 2:
				file = "white_rook"; break;
			case -2:
				file = "black_rook"; break;
			case 3:
				file = "white_knight"; break;
			case -3:
				file = "black_knight"; break;
			case 4:
				file = "white_bishop"; break;
			case -4:
				file = "black_bishop"; break;
			case 5:
				file = "white_queen"; break;
			case -5:
				file = "black_queen"; break;
			case 6:
				file = "white_king"; break;
			case -6:
				file = "black_king"; break;
			default:
				file = "none";
		}
		
		// add piece to panel
		if(!file.equals("none")) {
			try {
				BufferedImage pieceImg = ImageIO.read(new File(file));
				JLabel pieceLabel = new JLabel(new ImageIcon(pieceImg));
				panel.add(pieceLabel);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return panel;
	}

	// copies chessboard to GUI buffer
	private void getBoard(Chessboard b) {

		for(int i = 0; i < 8; i++) { 
			for(int j = 0; j < 8; j++) {
				
				int piece = chessboard.getBoard()[i][j];
				board[i][j] = addPiece(piece, board[i][j]);
				
			}
		}
	}
	
	private JPanel[][] getNewBoard() {
		JPanel[][] output = new JPanel[8][8];
		
		for(int i = 0; i < 8; i++) { 
			for(int j = 0; j < 8; j++) {
				
				if((i + j) % 2 == 0) {
					JPanel whitePanel = new JPanel();
					whitePanel.setBackground(Color.white);
					output[i][j] = whitePanel;
					
				}else {
					JPanel blackPanel = new JPanel();
					blackPanel.setBackground(Color.black);
					output[i][j] = blackPanel;
				}
				
			}
		}
		
		return output;
	}
	
	public static void main(String args[]) {
		new ChessEngineGUI();
	}

}
