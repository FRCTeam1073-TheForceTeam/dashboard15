/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team1073.smartdashboard.extensions.distance;

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

public class DistanceWidget extends StaticWidget
{
    public static final DataType[] TYPES = {DataType.NUMBER };
    public static final String NAME = "Distance Widget";
    private double value;
    public final MultiProperty distance = new MultiProperty(this, "Distance");
    private int feet;
    private int inches;
    private int inches2;
    private String strFeet = "";
    private String strInches = "";


    
    
    public DistanceWidget()
    {
        distance.add("10 Feet", 229);
        distance.add(" Feet", 200);
        distance.add(NAME, value);
    }

  //  @Override
    public void setValue(Object o) 
    {
        this.value = ((Number) o).doubleValue();
        inches = (int) (value/2.54);
        feet = inches / 12;
        inches2 = inches % 12;
        strFeet = "" + feet;
        strInches = "" + inches2;
        repaint();
    }

    @Override
    public void init() 
    {
        setPreferredSize(new Dimension(100, 100));
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
        
        Color c1 = new Color(255,255,255);
        g2.setPaint(c1);
        g2.fill(new Rectangle2D.Double(0, 0, size.width, size.height));
        
        
        
        
        g2.setPaint(Color.BLACK);
        g2.setFont(new Font("Default", Font.BOLD, 25));
        g2.drawString(strFeet, 0, 0);
        g2.drawString(strInches, size.width, size.height);
        g2.setFont(new Font("Default", Font.BOLD, 25));
        g2.drawString("Feet", (size.width/2), 0);
        g2.drawString("Inches", size.width-25, size.height-1);
    }
}