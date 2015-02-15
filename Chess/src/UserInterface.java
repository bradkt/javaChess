import java.awt.*;
import javax.swing.*;

public class UserInterface extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(10, 20, 10, 20);
		g.setColor(new Color(190,80,215));
		g.fillRect(20, 10, 20, 20);
		
	}

}
