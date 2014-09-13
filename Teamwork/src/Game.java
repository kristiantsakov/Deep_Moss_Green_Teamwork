import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {
	Ball ball = new Ball(this);
	Board board = new Board(this);

	//Keypress method for the board.
	public Game() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				board.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				board.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	//Moving method for items inside applet.
	private void move() {
		ball.ballMove();
		board.boardMove();
	}

	
	//Drawing the ball and the board.
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLUE);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		board.paint(g2d);
	}

	//Game over
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over",
				JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	//Applet frame(width and height)
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
		frame.add(game);
		frame.setSize(400, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
}
