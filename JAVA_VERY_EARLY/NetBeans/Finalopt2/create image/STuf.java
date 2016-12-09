/**example picture code
 */
package pkg25;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class STuf
{
	public static void main (String []args)
	{
	    JFrame frame = new JFrame();
		frame.setTitle("Picture Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicPanel panel = new GraphicPanel();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setSize(500,500);			// set the size of the frame
		frame.setVisible(true);
	}
	private static class GraphicPanel extends JPanel
	{
		private Image im;
		Asteroid bob = new Asteroid();
		Asteroid bob1 = new Asteroid();
		Asteroid bob2 = new Asteroid();
		Asteroid bob3 = new Asteroid();
		Asteroid bob4 = new Asteroid();
		Asteroid bob5 = new Asteroid();


		public void paintComponent(Graphics gr)
		{

			super.paintComponent(gr);
			gr.setColor(Color.black);	// draw the background
			gr.drawImage(im, 50, 40, Color.black, this);
			bob.draw(gr);
			bob1.draw(gr);
			bob2.draw(gr);
			bob3.draw(gr);
			bob4.draw(gr);
			bob5.draw(gr);
			gr.setFont(new Font("Impact", Font.PLAIN, 20));  //This sets the font style and color, Impact is a good font right? perfect
			gr.setColor(Color.white);
			gr.drawString("Score", 395, 450);
			repaint();
		}
	}
}

