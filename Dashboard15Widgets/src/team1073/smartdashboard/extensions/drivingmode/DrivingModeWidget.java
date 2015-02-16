

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team1073.smartdashboard.extensions.drivingmode;


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
import java.awt.geom.RoundRectangle2D;

public class DrivingModeWidget extends StaticWidget
{
    public static final DataType[] TYPES = {DataType.NUMBER};
    public static final String NAME = "Driving Mode";
    private int value = -1;
    public final MultiProperty mode = new MultiProperty(this, "Driving Status");

    
    public DrivingModeWidget(){
        /*This constructor is only necessary for testing purposes*/
        mode.add("None", 0);
        mode.add("Cubic", 1);
        mode.add("FieldRel", 2);
        mode.add("Both", 3);
        mode.add("Error", -1);
        // else = "UnexpectedError"
        // errors are black&yellow
    }
    //@Override
    public void setValue(Object o) 
    {
        this.value = ((Number) o).intValue();
       
        repaint();

    }

    @Override
    public void init() 
    {
        setPreferredSize(new Dimension(120, 70));
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
        //background
        Color c1 = new Color(0, 205, 0);
        Color c2 = new Color(238, 0, 0);
        Color c3 = new Color(0, 0, 0);
        Color c4 = new Color(251, 223, 32);
        
        
        
        String mode1 = "Cubic Drive";
        String mode2 = "Field Relative";
        g2.setPaint(c3);
        g2.drawOval(1, 1, 30, 30);
        g2.drawOval(1, 35, 30, 30);
        g2.drawString(mode1, 35, 20);
        g2.drawString(mode2, 35, 54);
        if (value == 0)
        {
            g2.setPaint(c2);
            g2.fillOval(1, 1, 30, 30);
            g2.fillOval(1, 35, 30, 30);
            g2.setPaint(c3);
            g2.drawOval(1, 1, 30, 30);
            g2.drawOval(1, 35, 30, 30);
            
        }
        else if(value == 1)
        {
            g2.setPaint(c1);
            g2.fillOval(1, 1, 30, 30);
            g2.setPaint(c2);
            g2.fillOval(1, 35, 30, 30);
            g2.setPaint(c3);
            g2.drawOval(1, 1, 30, 30);
            g2.drawOval(1, 35, 30, 30);
        }
        else if(value == 2)
        {
            g2.setPaint(c2);
            g2.fillOval(1, 1, 30, 30);
            g2.setPaint(c1);
            g2.fillOval(1, 35, 30, 30);
            g2.setPaint(c3);
            g2.drawOval(1, 1, 30, 30);
            g2.drawOval(1, 35, 30, 30);
        }
        else if(value == 3)
        {
            g2.setPaint(c1);
            g2.fillOval(1, 1, 30, 30);
            g2.fillOval(1, 35, 30, 30);
            g2.setPaint(c3);
            g2.drawOval(1, 1, 30, 30);
            g2.drawOval(1, 35, 30, 30);
        }
        else if(value == -1) {          //by julia
            g2.setPaint(c3);
            g2.fillOval(1, 1, 30, 30);
            g2.fillOval(1, 35, 30, 30);
            // fill circles black
        }
        
        else {
            g2.setPaint(c4);
            g2.fillOval(1, 1, 30, 30);
            g2.fillOval(1, 35, 30, 30);
            g2.setPaint(c3);
            g2.drawOval(1, 1, 30, 30);
            g2.drawOval(1, 35, 30, 30);
               // fill circles yellow   
        }
        
    }
    
}