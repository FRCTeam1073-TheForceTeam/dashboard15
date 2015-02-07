
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team1073.smartdashboard.extensions.totecollectorinfo;

import edu.wpi.first.smartdashboard.gui.StaticWidget;
import edu.wpi.first.smartdashboard.gui.Widget;
import edu.wpi.first.smartdashboard.properties.MultiProperty;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class ToteCollectorInfoWidget extends StaticWidget {
    
    public static final DataType[] TYPES = {DataType.NUMBER };
    public static final String NAME = "ToteCollectorInfo Widget";
    private double value;
    public final MultiProperty distance = new MultiProperty(this, "ToteCollectorIfo");
    private int feet;
    private int inches;
    private int inches2;
    private String strFeet = "";
    private String strInches = "";


    
    
    public ToteCollectorInfoWidget() {
       /* distance.add("10 Feet", 229);
        distance.add(" Feet", 200);
        distance.add(NAME, value);
       */
    }

  //  @Override
    public void setValue(Object o) {
        this.value = ((Number) o).doubleValue();
        repaint();
    }

    @Override
    public void init() {
        setPreferredSize(new Dimension(500, 500));
    }

    @Override
    public void propertyChanged(Property prprt) {
        setValue(prprt.getValue());
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        Dimension size = getSize();
        
        String toteCollect = "Collecting";
        String toteConstant = "Doing Nothing";
        String totePurge = "Purging";
        
        g2.drawOval(100, 100, 50, 50);
        
        if (value == 0) {
            Color c1 = new Color(0, 255, 0);
            g2.setPaint(c1);
            g2.fillOval(100, 100, 50, 50);
        }
        if (value == 1) {
            Color c1 = new Color(255, 255, 255);
            g2.setPaint(c1);
            g2.fillOval(100, 100, 50, 50);
        }
           if (value == 2) {
            Color c1 = new Color(255, 0, 0);
            g2.setPaint(c1);
            g2.fillOval(100, 100, 50, 50);
        }
        //if collecting = flash green
        //if constant = nothing
        //if purging = flash red
    }
}