/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stakeoverflow.swingFrame;

/**
 *
 * @author Naimish
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class ShapeTest extends JFrame {

    private static final long serialVersionUID = 1L;
    private int width = 300;
    private int height = 300;
    private int padding = 50;
    private BufferedImage graphicsContext;
    private JPanel contentPanel = new JPanel();
    private JLabel contextRender;
    private Stroke dashedStroke = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 2f, new float[] {3f, 3f}, 0f);
    private Stroke solidStroke = new BasicStroke(3.0f);
    private RenderingHints antialiasing;
    private Random random = new Random();

    public static void main(String[] args) {
        //you should always use the SwingUtilities.invodeLater() method
        //to perform actions on swing elements to make certain everything
        //is happening on the correct swing thread
        Runnable swingStarter = new Runnable()
        {
            @Override
            public void run(){
                new ShapeTest();
            }
        };

        SwingUtilities.invokeLater(swingStarter);
    }

    public ShapeTest(){
        antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphicsContext = new BufferedImage(width + (2 * padding), width + (2 * padding), BufferedImage.TYPE_INT_RGB);
        contextRender = new JLabel(new ImageIcon(graphicsContext));

        contentPanel.add(contextRender);
        contentPanel.setSize(width + padding * 2, height + padding * 2);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setContentPane(contentPanel);
        //take advantage of auto-sizing the window based on the size of its contents
        this.pack();
        this.setLocationRelativeTo(null);
        this.paint();
        setVisible(true);
    }

    public void paint() {

        Graphics2D g2d = graphicsContext.createGraphics();
        g2d.setRenderingHints(antialiasing);

        //Set up the font to print on the circles
        Font font = g2d.getFont();
        font = font.deriveFont(Font.BOLD, 14f);
        g2d.setFont(font);

        //clear the background
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, graphicsContext.getWidth(), graphicsContext.getHeight());

        //set up the large circle
        Point2D largeCircleCenter = new Point2D.Double((double)width / 2 + padding, (double)height / 5 + padding);
        double largeCircleRadius = (double)width / 5;
        Ellipse2D largeCircle = getCircleByCenter(largeCircleCenter, largeCircleRadius);

        //here we build the small circle
        Point2D smallCircleCenter = new Point2D.Double();
        double smallCircleRadius = 15;
      
        //the resulting end point of the vector is a random distance from the center of the large circle
        //in a random direction, and guaranteed to not place the small circle outside the large
        smallCircleCenter.setLocation(largeCircleCenter);
        Ellipse2D smallCircle = getCircleByCenter(smallCircleCenter, smallCircleRadius);

        //before we draw any of the circles or lines, set the clip to the large circle
        //to prevent drawing outside our boundaries
        // -- g2d.setClip(largeCircle);



        //chose a random angle for the line through the center of the small circle
        double angle = random.nextDouble() * 360.0d;
        //we create two lines that start at the center and go out at the angle in
        //opposite directions. We use 2*largeCircleRadius to make certain they
        //will be large enough to fill the circle, and the clip we set prevent stray
        //marks outside the big circle
        Line2D centerLine1 = getVector(smallCircleCenter, angle, largeCircleRadius * 2);
        Line2D centerLine2 = getVector(smallCircleCenter, angle, -largeCircleRadius * 2);
        
        Line2D centerLine90 = getVector(smallCircleCenter, 45, 200);
        // set line width
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.RED);
        g2d.draw(centerLine90);
        
        Ellipse2D lineEndCircle = getCircleByCenter(centerLine90.getP2(), smallCircleRadius + 10);
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.BLUE);
        g2d.draw(lineEndCircle);
        
        // Level 3 Circales 
        
        Point2D endCir = centerLine90.getP2();
        Line2D centerLine5 = getVector(endCir, 90, smallCircleRadius+30);
        g2d.setColor(Color.black);
        g2d.draw(centerLine5);
        
        
        Ellipse2D lineEndCircle2 = getCircleByCenter(centerLine5.getP2(), smallCircleRadius - 5);
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.BLUE);
        g2d.draw(lineEndCircle2);
        g2d.fill(lineEndCircle2);
        
        Line2D centerLine6 = getVector(endCir,0, smallCircleRadius+30);
        g2d.setColor(Color.black);
        g2d.draw(centerLine6);
        
        
        Ellipse2D lineEndCircle3 = getCircleByCenter(centerLine6.getP2(), smallCircleRadius - 5);
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.BLUE);
        g2d.draw(lineEndCircle3);
        g2d.fill(lineEndCircle3);
        
        //now we just add 20 and 120 to our angle for the center-line, start at the center
        //and again, use largeCircleRadius*2 to make certain the lines are big enough
        Line2D sightVector1 = getVector(smallCircleCenter, angle + 60, largeCircleRadius * 2);
        Line2D sightVector2 = getVector(smallCircleCenter, angle + 120, largeCircleRadius * 2);

        //fill the small circle with blue
        g2d.setColor(Color.BLUE);
        g2d.fill(smallCircle);

        //draw the two center lines lines
        g2d.setStroke(dashedStroke);
        g2d.draw(centerLine1);
        g2d.draw(centerLine2);
        
        

        //create and draw the black offset vector
        Line2D normalVector = getVector(smallCircleCenter, angle + 90, largeCircleRadius * 2);
        g2d.setColor(Color.black);
        g2d.draw(normalVector);

        //draw the offset vectors
        g2d.setColor(new Color(0, 200, 0));
        g2d.draw(sightVector1);
        g2d.draw(sightVector2);


        //we save the big circle for last, to cover up any stray marks under the stroke
        //of its perimeter. We also set the clip back to null to prevent the large circle
        //itselft from accidentally getting clipped
        g2d.setClip(null);
        g2d.setStroke(solidStroke);
        g2d.setColor(Color.BLACK);
        g2d.draw(largeCircle);

        g2d.dispose();
        //force the container for the context to re-paint itself
        contextRender.repaint();

    }

    private static Line2D getVector(Point2D start, double degrees, double length){
        //we just multiply the unit vector in the direction we want by the length
        //we want to get a vector of correct direction and magnitute
        double endX = start.getX() + (length * Math.sin(Math.PI * degrees/ 180.0d));
        double endY = start.getY() + (length * Math.cos(Math.PI * degrees/ 180.0d));
        Point2D end = new Point2D.Double(endX, endY);
        Line2D vector = new Line2D.Double(start, end);
        return vector;
    }

    private static Ellipse2D getCircleByCenter(Point2D center, double radius)
    {
        Ellipse2D.Double myCircle = new Ellipse2D.Double(center.getX() - radius, center.getY() - radius, 2 * radius, 2 * radius);
        return myCircle;
    }

}