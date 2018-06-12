package org.academiadecodigo.stormrooters;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.vecmath.Vector2d;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

    public class CursorImage extends JPanel implements Runnable{
        BufferedImage img;
        double angle;
        int imgw;
        int imgh;
        JFrame f;
        PointerInfo cursor = MouseInfo.getPointerInfo();
        Point point = new Point(cursor.getLocation());
        AffineTransform at = new AffineTransform();

        public void Test(JFrame f){
            this.f = f;
            setSize(400, 400);

            try {
                img = ImageIO.read(new File("res/rocket.png"));
            } catch (IOException e) {}

            imgw = img.getWidth();
            imgh = img.getHeight();

            Thread t = new Thread(this);
            t.start();
        }

        public static void main(String[] Args){
            JFrame frame = new JFrame();

            frame.add(new Test(frame));
            frame.setVisible(true);
            frame.setSize(400,400);
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D)g;
            g2.drawImage(img,at,this);
        }

        public void run(){
            while(true){
                cursor = MouseInfo.getPointerInfo();
                point = new Point(cursor.getLocation());
                SwingUtilities.convertPointFromScreen(point, f);

                Vector2d mouse = new Vector2d(point.getX(),point.getY());
                Vector2d rocket = new Vector2d(100,100);
                Vector2d facing = new Vector2d(0, -1);

                mouse.sub(rocket);
                mouse.normalize();
                facing.normalize();

                angle = mouse.angle(facing);
                System.out.println(Math.toDegrees(angle));
                at.setToTranslation(100,100);
                at.rotate(angle, imgw/2, imgh/2);
                repaint();

                try {Thread.sleep(25);
                } catch (InterruptedException e) {}
            }
        }
    }
}
