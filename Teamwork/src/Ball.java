import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Ball {
	//The Diameter of the ball.
	private static final int DIAMETER = 50;
	//Coordinates x and y of the ball.
	int x = 0;
	int y = 0;
	//Variables for the movement of the ball.
	int xa = 1;
	int ya = 1;
	private Game game;

	public Ball(Game game) {
		this.game = game;
	}

	//Method for the movement of the ball,when she goes to the wall to revert her 
	//movement and game over. 
	void ballMove() {
		if (x + xa < 0) {
			xa = 1;
		} else if (x + xa > game.getWidth() - DIAMETER) {
			xa = -1;
		} else if (y + ya < 0) {
			ya = 1;
		} else if (y + ya > game.getHeight() - DIAMETER) {
			game.gameOver();
		} else if (collision()) {
			ya = -1;
			y = game.board.getTopY() - DIAMETER;
		}
		x = x + xa;
		y = y + ya;
	}

	//Method for the collision of the ball and the board.
	private boolean collision() {
		return game.board.getBounds().intersects(getBounds());
	}

	//Drawing the ball.
	public void paint(Graphics2D g) {
		//g.fillOval(x, y, DIAMETER, DIAMETER);
		ImageIcon ic = new ImageIcon(getClass().getResource("/images/ball.gif"));
		Image img = ic.getImage();
		g.drawImage(img, x, y, null);
	}

	//Geting the bounds of the board to make the collision.
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}
