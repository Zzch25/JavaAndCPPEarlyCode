
package pkg25;

/**
 *
 * @author Zachary Job
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class NewJFrameV2_0DoNotCopyMoronsAsItRequiresAMassiveReworkingOutiftCrewToFixProperly extends javax.swing.JFrame implements KeyListener, ActionListener {

    public NewJFrameV2_0DoNotCopyMoronsAsItRequiresAMassiveReworkingOutiftCrewToFixProperly() {
        initComponents();
        /*GraphicPanel panel = new GraphicPanel();   GRAPHIC SAMPLE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        getContentPane().add(panel);*/
        addKeyListener(this);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startButton = new javax.swing.JButton();
        optionsButton = new javax.swing.JButton();
        hiScoreButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        quitButton = new javax.swing.JMenu();
        exitButton = new javax.swing.JMenuItem();
        backButton = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        twentyFiveButton = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 1000));

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        optionsButton.setText("Options");
        optionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsButtonActionPerformed(evt);
            }
        });

        hiScoreButton.setText("Hi-Scores");
        hiScoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hiScoreButtonActionPerformed(evt);
            }
        });

        pauseButton.setText("Pause");
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        quitButton.setText("File");

        exitButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        quitButton.add(exitButton);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        quitButton.add(backButton);

        jMenuBar1.add(quitButton);

        jMenu2.setText("Help");

        twentyFiveButton.setText("25");
        jMenu2.add(twentyFiveButton);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(hiScoreButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(optionsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pauseButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(364, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(startButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hiScoreButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pauseButton)
                .addContainerGap(474, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        leaveMenu();
    }//GEN-LAST:event_startButtonActionPerformed

    private void optionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optionsButtonActionPerformed

    private void hiScoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hiScoreButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hiScoreButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed

    }//GEN-LAST:event_pauseButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        returnToMenu();

        for(int i = 0; i < astArr.length; i++)
        {            
            astArr[i] = null;
        }
        for(int i = 0; i < shiArr.length; i++)
        {
            if(shiArr[i].erase() == true) 
                shiArr[i] = null;
        }
    }//GEN-LAST:event_backButtonActionPerformed
    public static void main(String args[]) {
        new NewJFrameV2_0DoNotCopyMoronsAsItRequiresAMassiveReworkingOutiftCrewToFixProperly().setVisible(true);
    }
    /*private static class GraphicPanel extends JPanel    GRAPHIC SAMPLE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
			gr.drawImage(im, 50, 40, 100, 100, Color.black, this);
			bob.draw(gr);
			bob1.draw(gr);
			bob2.draw(gr);
			bob3.draw(gr);
			bob4.draw(gr);
			bob5.draw(gr);
			repaint();
		}
    }*/

    public void returnToMenu()
    {
        backButton.setEnabled(false);

        optionsButton.setVisible(true);
        startButton.setVisible(true);
        hiScoreButton.setVisible(true);
        pauseButton.setVisible(false);
    }
    public void leaveMenu()
    {
        backButton.setEnabled(true);

        optionsButton.setVisible(false);
        startButton.setVisible(false);
        hiScoreButton.setVisible(false);
        pauseButton.setVisible(false);
    }
    public void keyPressed(KeyEvent e){}
    public void keyReleased(KeyEvent e)
    {
        keyCodeP = setUserCmdIn.getCmd(e.getKeyCode());
    }
    public void keyTyped(KeyEvent e)
    {
        keyCodeR = setUserCmdOut.getCmd(e.getKeyCode());
    }

    public void actionPerformed(ActionEvent e)
    {
      Object s = e.getSource();
      if (s == startButton)
      {
         running = !running;
         if (running)
         {
            runGameLoop();
         }
         else
         {
            startButton.setText("Start");
         }
      }
      else if (s == pauseButton)
      {
        paused = !paused;
         if (paused)
         {
            pauseButton.setText("Unpause");
         }
         else
         {
            pauseButton.setText("Pause");
         }
      }
      else if (s == quitButton)
      {
         System.exit(0);
      }
      else if (s == backButton)
      {
          running = !running;
      }
   }

   public void runGameLoop()
   {
      Thread loop = new Thread()
      {
         public void run(Graphics gr)
         {
            gameLoop(gr);
         }
      };
      loop.start();
   }

   //Only run this in another Thread!
   public void gameLoop(Graphics gr)
   { 
      int fpsTrip = 0;
      int fpsInterval = 10000;

      for(int i = 0; i < astArr.length; i++)
      {
               for(int u = 0; u < astArr.length + 1; u++)
               {
                    if(u == 0)
                    {
                        xY[0] = 200 + xP.nextInt(800);
                        xY[1] = 200 + xP.nextInt(800);
                    }
                    else if(i != u)
                    {
                        if(checkC.isCollision(xY, astArr[i].getRad(), astArr[u].getPos(), astArr[u].getRad()) == true)
                        {
                            u = 0;
                        }
                        else
                        {
                            astArr[i].inPos(xY); 
                        }
                    }
                }
       }
      
      while (running)
      {
         if(fpsTrip < fpsInterval)
         {
             fpsTrip++;
         }
         else
         {
             fpsTrip = 0;

             for(Asteroid e: astArr)
             {
                 e.move(gr);
             }

             shipC = false;
             for(int i = 0; i < cuPlyrs; i++)
             {
                 if(shiArr[i] != null)
                 {
                    for(int u = 0; u < cuPlyrs; i++)
                    {
                        if(u != i & checkC.isCollision(shiArr[i].getPos(), shiArr[i].getRadius(), shiArr[u].getPos(), shiArr[u].getRadius()) == true & shiArr[u] != null)
                        {
                            shiArr[i] = null;
                            shiArr[u] = null;
                            shipC = true;
                        }
                    }
                    for(int u = 0; u < astArr.length; i++)
                    {
                        if(u != i & checkC.isCollision(shiArr[i].getPos(), shiArr[i].getRadius(), astArr[u].getPos(), astArr[i].getRad()) == true & astArr[u] != null)
                        {
                            shiArr[i] = null;
                            shipC = true;
                        }
                    }
                 }
             }
             if(shipC == false)
             {
                 for(int i = 0; i < cuPlyrs; i++)
                 {
                     shiArr[i].move(keyCodeP, gr);
                     shiArr[i].move(keyCodeR, gr);
                 }
             }
         }
         for(int i = 0; i < shiArr.length; i++)
         {
             if(topScore < shiArr[i].getScore())
                 topScore = shiArr[i].getScore();
                 id = i + 1;
             if(shiArr[i] == null)
             {
                 endC++;
             }
         }
         if(endC == shiArr.length)
         {
             running = !running;
             
             gr.setFont(new Font("Impact", Font.PLAIN, 20));  //This sets the font style and color, Impact is a good font right? perfect
             gr.setColor(Color.white);
             gr.drawString(id + " won with score of " + topScore, 500, 500);
             
             for(int z = 0; z < winDis; z++)
             {
                for(int a = 0; a < winDis; z++){}
             }
             
             returnToMenu();
         }
         endC = 0;
         topScore = 0;
      }  
   }

   private int winDis = 250000000;
   private int id = 0;
   private int p = 0;
   private boolean running = false;
   private boolean paused = false;
   private int endC = 0;
   private int topScore = 0;
   private boolean shipC = false;
   private int fps = 60;
   private int frameCount = 0;
   private int[] keyCodeP = new int[2];
   private int[] keyCodeR = new int[2];
   private int cuPlyrs = 1; //subtract 1 from actual out of 4
   Asteroid[] astArr = new Asteroid[10];
   Ship[] shiArr = new Ship[maxPlyr];
   public static final int maxPlyr = 4;
   Collision checkC = new Collision();
   KeySort setUserCmdIn = new KeySort();
   KeySort setUserCmdOut = new KeySort();
   Random xP = new Random();
   Random yP = new Random();
   private int[] xY = new int[2];

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem backButton;
    private javax.swing.JMenuItem exitButton;
    private javax.swing.JButton hiScoreButton;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton optionsButton;
    private javax.swing.JButton pauseButton;
    private javax.swing.JMenu quitButton;
    private javax.swing.JButton startButton;
    private javax.swing.JMenuItem twentyFiveButton;
    // End of variables declaration//GEN-END:variables
}
