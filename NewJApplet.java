/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JApplet;

/**
 *
 * @author dhcho
 */
public class NewJApplet extends JApplet {

 
    public void init() {
        // TODO start asynchronous download of heavy resources
        Waar war = new Waar();
        war.setGUI(). addKeyListener();
        //this.setLayout(null);
        this.setBackground(Color.blue);
        this.setSize(1200, 800);
        this.setLocation(0, 0);
        //this.add(war.panel2);
        this.add(war.howToPlayLbl);
        this.add(war.bs_1.pb);

        this.add(war.bossStr1);
        this.add(war.bs_2.pb);

        this.add(war.bossStr2);

        this.add(war.bs_3.pb);

        this.add(war.bossStr3);

        this.add(war.bs_4.pb);

        this.add(war.bossStr4);

        this.add(war.bs_5.pb);

        this.add(war.bossStr5);

        this.add(war.bs_6.pb);

        this.add(war.bossStr6);

        this.add(war.a);
        this.add(war.b);
        this.add(war.panel3);
        this.setVisible(true);
        this.addKeyListener(war.keyL);
                    this.add(war.bs_1.pb);
                    this.add(war.bs_2.pb);
                    this.add(war.bs_3.pb);
                    this.add(war.bs_4.pb);
                    this.add(war.bs_5.pb);
                    this.add(war.bs_6.pb);
                    this.requestFocus();
                        this.remove(war.bs_1.pb);
                        this.remove(war.bs_2.pb);
                        this.remove(war.bs_3.pb);
                        this.remove(war.bs_4.pb);
                        this.remove(war.bs_5.pb);
                        this.remove(war.bs_6.pb);
                        this.add(war.bs_1.pb);
                        this.add(war.bs_2.pb);
                        this.add(war.bs_3.pb);
                        this.add(war.bs_4.pb);
                        this.add(war.bs_5.pb);
                        this.add(war.bs_6.pb);
                        this.add(war.panel3);
                        this.add(war.panel2);
                        war.start();

                        this.requestFocus();
        
    }
    
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
 

    // TODO overwrite start(), stop() and destroy() methods
}
