/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team1073.smartdashboard.extensions.roller;


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
import java.awt.geom.RoundRectangle2D;

public class RollerWidget extends Widget
{
    public static final DataType[] TYPES = {DataType.NUMBER};
    public static final String NAME = "Roller";
    private int value = -1;
    public final MultiProperty mode = new MultiProperty(this, "Roller");

    
    public RollerWidget()
    {
        /*This constructor is only necessary for testing purposes*/
        mode.add("OFF", 0);
        mode.add("ON", 1);

    }
    @Override
    public void setValue(Object o) 
    {
        this.value = ((Number) o).intValue();
       
        repaint();

    }

    @Override
    public void init() 
    {
        setPreferredSize(new Dimension(100, 14));
    }

    @Override
    public void propertyChanged(Property prprt) 
    {
        setValue(prprt.getValue());
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        Dimension size = getSize();
        String r = "Roller";
        Color c0 = new Color(0, 0, 0);
        Color c1 = new Color(0, 255, 0);
        Color c2 = new Color(255, 0, 0);
        
        g2.drawOval(1, 1, 10, 10);
        g2.drawString(r, 13, 11);
        if(value == 0)
        {
            g2.setPaint(c2);
            g2.fillOval(1, 1, 10, 10);
        }
        else
        {
            g2.setPaint(c1);
            g2.fillOval(1, 1, 10, 10);
        }

    }
    
}