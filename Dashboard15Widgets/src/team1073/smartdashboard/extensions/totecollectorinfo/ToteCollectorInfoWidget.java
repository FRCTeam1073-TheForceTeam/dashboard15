
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

public class ToteCollectorInfoWidget extends Widget {
    
    public static final DataType[] TYPES = {DataType.NUMBER };
    public static final String NAME = "ToteCollectorInfo";
    private double value;
    public final MultiProperty mode = new MultiProperty(this, "Collector");


    
    
    public ToteCollectorInfoWidget() {
        mode.add("Collecting", 0);
        mode.add("At Rest", 1);
        mode.add("Purging", 2);
    }

    @Override
    public void setValue(Object o) {
        this.value = ((Number) o).doubleValue();
        repaint();
    }

    @Override
    public void init() {
        setPreferredSize(new Dimension(100, 32));
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
        
        g2.drawOval(1, 1, 30, 30);
        Color c0 = new Color(0, 0, 0);
        Color c1 = new Color(0, 255, 0);
        Color c2 = new Color(255, 215, 0);
        Color c3 = new Color(255, 0, 0);

        if (value == 0) 
        {
            g2.setPaint(c1);
            g2.fillOval(1, 1, 30, 30);
            g2.setPaint(c0);
            g2.drawString(toteCollect, 35, 20);
            g2.drawOval(1, 1, 30, 30);
        }
        if (value == 1) 
        {
            g2.setPaint(c2);
            g2.fillOval(1, 1, 30, 30);
            g2.setPaint(c0);
            g2.drawString(toteConstant, 35, 20);
            g2.drawOval(1, 1, 30, 30);
        }
           if (value == 2) 
        {
            g2.setPaint(c3);
            g2.fillOval(1, 1, 30, 30);
            g2.setPaint(c0);
            g2.drawString(totePurge, 35, 20);
            g2.drawOval(1, 1, 30, 30);
        }
        //if collecting = flash green
        //if constant = nothing
        //if purging = flash red
    }
}