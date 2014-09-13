import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class Board {

	private static final int Y = 550;//The Y coordinate of the board.
	private static final int WIDTH = 100;//The width of the board.
	private static final int HEIGHT = 10;//The height of the board.
	int x = 0;//The X coordinate of the board.
	int xa = 0;//The movement of the board.
	private Game game;

	public Board(Game game) {
		this.game = game;
	}
	
	//The movement method of the board.
	public void boardMove() {
		if (x + xa > 0 && x + xa < game.getWidth() - WIDTH) {
			x = x + xa;
		}
	}

	//Drawing the board.
	public void paint(Graphics2D g) {
		g.fillRect(x, Y, WIDTH, HEIGHT);
	}

	//Methods for changing the movement of the board with key of the keyboard.
	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			xa = -1;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xa = 1;
		}
	}

	//Getting bounds of the board.
	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}

	//Gettint Top coordinate Y for the collision between the ball and the board.
	public int getTopY() {
		return Y;
	}
}
