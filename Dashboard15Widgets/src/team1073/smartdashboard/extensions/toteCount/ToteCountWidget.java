/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team1073.smartdashboard.extensions.toteCount;


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

public class ToteCountWidget extends Widget
{
    public static final DataType[] TYPES = {DataType.NUMBER};
    public static final String NAME = "Tote Count";
    private int value = -1;
    public final MultiProperty mode = new MultiProperty(this, "Tote Count");

    
    public ToteCountWidget()
    {
        /*This constructor is only necessary for testing purposes*/
        mode.add("None", 0);
        mode.add("One", 1);
        mode.add("Two", 2);
        mode.add("Three", 3);
        mode.add("Four", 4);
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
        setPreferredSize(new Dimension(100, 57));
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
        Color c1 = new Color(0,0,0);
        Color c2 = new Color(0, 191, 255);
        Color c3 = new Color(0, 178, 238);
        GradientPaint gp = new GradientPaint(0, 0, c2, size.width/2, 0, c3);
        String num = ""+value;
        
        g2.setPaint(gp);
        g2.fill(new Rectangle2D.Double(0, 0, size.width, size.height));
        g2.setPaint(c1);
        g2.setFont(new Font("Default", Font.BOLD, 72));
        g2.drawString(num, 0, size.height-1);
        g2.setFont(new Font ("default", Font.BOLD, 12));
        g2.drawString("totes", 60, size.height-1);
    }
    
}