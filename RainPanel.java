import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JPanel;

public class RainPanel extends JPanel {

    private float mWind = 2.05f;
    private float mGravity = 9.8f;
    private double mRainChance = 0.99;

    private int mRepaintTimeMS = 16;
    private float mRainWidth=1;
    private double mDdropInitialVelocity = 10;
    private double mDropDiam = 1;
    private Color mColor=new Color(200, 200, 255);

    private ArrayList<Rain> rainV;
    private ArrayList<Drop> dropV;

    public RainPanel() {
        rainV = new ArrayList<>();
        dropV = new ArrayList<>();
    }

    public int getHeight() {
        return this.getSize().height;
    }

    public int getWidth() {
        return this.getSize().width;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(mRainWidth));
        g2.setColor(mColor);

        Iterator<Drop> iterator2 = dropV.iterator();
        while (iterator2.hasNext()) {
            Drop drop = iterator2.next();
            drop.update();
            drop.draw(g2);

            if (drop.y >= getHeight()) {
                iterator2.remove();
            }
        }

        Iterator<Rain> iterator = rainV.iterator();
        while (iterator.hasNext()) {
            Rain rain = iterator.next();
            rain.update();
            rain.draw(g2);

            if (rain.y >= getHeight()) {
                long dropCount = 1 + Math.round(Math.random() * 4);
                for (int i = 0; i < dropCount; i++) {
                    dropV.add(new Drop(rain.x, getHeight()));
                }
                iterator.remove();

            }
        }

        if (Math.random() < mRainChance) {

            int rC = 0;

            do {

                rainV.add(new Rain());

            } while(++rC < 12);
        } 
    }

    public class Rain {
        float x;
        float y;
        float prevX;
        float prevY;

        public Rain() {
            Random r = new Random();
            x = r.nextInt(getWidth());
            y = 0;
        }

        public void update() {
            prevX = x;
            prevY = y;

            x += mWind;
            y += mGravity;
        }

        public void draw(Graphics2D g2) {
            Line2D line = new Line2D.Double(x, y, prevX, prevY);
            g2.draw(line);
        }
    }

    public class Drop {

        double x0;  
        double y0;  
        double v0;
        double t;
        double angle;
        double x;
        double y;

        public Drop(double x0, double y0) {
            super();
            this.x0 = x0;
            this.y0 = y0;

            v0 = mDdropInitialVelocity;
            angle = Math.toRadians(Math.round(Math.random() * 180));
        }

        private void update() {
            t += mRepaintTimeMS / 100f;
            x = x0 + v0 * t * Math.cos(angle);
            y = y0 - (v0 * t * Math.sin(angle) - mGravity * t * t / 2);
        }

        public void draw(Graphics2D g2) {
            Ellipse2D.Double circle = new Ellipse2D.Double(x, y, mDropDiam, mDropDiam);
            g2.fill(circle);
        }
    }
}