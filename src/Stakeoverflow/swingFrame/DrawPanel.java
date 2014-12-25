/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stakeoverflow.swingFrame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

/**
 *
 * @author Naimish
 */
public class DrawPanel extends javax.swing.JPanel {

    /**
     * Creates new form DrawPanel
     */
    double frameWidth, frameHeight;

    public DrawPanel() {
        initComponents();
        frameHeight = 400;
        frameWidth = 400;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawOval(100, 100, 100, 100);
//        int x, y, x1, y1;
//        int startX, startY, endX, endY;
//        x = 90;
//        y = 90;
//        System.out.println("" + frameHeight + " " + frameWidth);
//        startX = (int) leftSideX(0, 400);
//        startY = (int) leftSideY(0, 400);
//        endX = (int) rightSideX(0, 400);
//        endY = (int) rightSideY(0, 400);
        //x=leftSideX(y1, WIDTH);
        //y=leftSideY(y1, WIDTH);
//
//        g2d.drawLine(startX, startY, endX, endY);
        //drawRuler(grphcs, 60, 60, 0, 0);
        //find the perpendicular gradient.
        double perpGrad = -1d / 10;
        double perpTheta = Math.atan(perpGrad);
        Line2D.Double viewLine1 = getLine(60, 60, perpTheta);
        //double viewLine2Theta = perpTheta - diffTheta;
        //Line2D.Double viewLine2 = getLine(x, y, viewLine2Theta);
        g2d.draw(viewLine1);
        //g.draw(viewLine2);

    }
    
      /**
     * Returns a Line2D starting at the point x1,y1 at angle theta.
     */
    int rad = 150;
    int radSmall = 15;
    int pad = 10;
    
    private final Line2D.Double getLine(double x1, double y1, double theta) {
        double m;
        double b;
        double x2;
        double y2;
        if (theta < (-Math.PI / 2d)) {
            System.out.println("CHANGE IT! " + theta);
            m = Math.tan(theta);
            b = y1 - (m * x1);
            x2 = 0;
            y2 = (m * x2) + b;
        } else {
            m = Math.tan(theta);
            b = y1 - (m * x1);
            x2 = 2 * (rad + pad);
            y2 = (m * x2) + b;
        }
        /*
         * System.out.println("Perp theta: " + theta); System.out.println("Line
         * grad: " + m); System.out.println("Line off: " + b);
         * System.out.println("x1,y1: " + x1 + "," + y1);
         * System.out.println("x2,y2: " + x2 + "," + y2);
         *
         */

        return new Line2D.Double(x1, y1, x2, y2);
    }

    private final double TICK_DIST = 20;

    void drawRuler(Graphics g1, int x1, int y1, int x2, int y2) {
        Graphics2D g = (Graphics2D) g1.create();

        double dx = x2 - x1, dy = y2 - y1;
        double len = Math.sqrt(dx * dx + dy * dy);
        AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
        at.concatenate(AffineTransform.getRotateInstance(Math.atan2(-90, -90)));
        g.transform(at);

        // Draw horizontal ruler starting in (0, 0)
        g.drawLine(0, 0, (int) len, 0);
        for (double i = 0; i < len; i += TICK_DIST) {
            g.drawLine((int) i, -3, (int) i, 3);
        }
    }

   

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Circle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Circle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Circle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Circle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Circle().setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
