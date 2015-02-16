/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team1073.smartdashboard.extensions.elevatorLevel;


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
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class ElevatorLevelWidget extends Widget
{
    public static final DataType[] TYPES = {DataType.NUMBER};
    public static final String NAME = "Elevator Level";
    private int value = -1;
    public final MultiProperty mode = new MultiProperty(this, "Level");

    
    public ElevatorLevelWidget()
    {
        /*This constructor is only necessary for testing purposes*/
        mode.add("Level G", 0);
        mode.add("Level 1", 1);
        mode.add("Level 2", 2);
        mode.add("Level 3", 3);

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
        setPreferredSize(new Dimension(50, 75));
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
        Color c1 = new Color(85, 249, 249);
        Color c2 = new Color(0, 0, 0);
        Color c3 = new Color(255, 236, 139);
        
        Ellipse2D.Double C1 = new Ellipse2D.Double(1, 1, 17, 17);
        Ellipse2D.Double C2 = new Ellipse2D.Double(1, 19, 17, 17);
        Ellipse2D.Double C3 = new Ellipse2D.Double(1, 37, 17, 17);
        Ellipse2D.Double C4 = new Ellipse2D.Double(1, 55, 17, 17);
        g2.setPaint(c3);
        g2.fill(C1);
        g2.fill(C2);
        g2.fill(C3);
        g2.fill(C4);
        g2.setPaint(c2);
        g2.draw(C1);
        g2.draw(C2);
        g2.draw(C3);
        g2.draw(C4);
        g2.drawString("3", 7, 14);
        g2.drawString("2", 7, 32);
        g2.drawString("1", 7, 50);
        g2.drawString("G", 7, 68);
        g2.drawString("Level", 20, size.height/2+3);
        
        if(value == 3)
        {
        g2.setColor(c1);
        g2.fill(C1);
        g2.setColor(c2);
        g2.draw(C1);
        g2.drawString("3", 7, 14);
        }
        else if(value == 2)
        {
        g2.setColor(c1);
        g2.fill(C2);
        g2.setColor(c2);
        g2.draw(C2);
        g2.drawString("2", 7, 32);
        }
        else if(value == 1)
        {
        g2.setColor(c1);
        g2.fill(C3);
        g2.setColor(c2);
        g2.draw(C3);
        g2.drawString("1", 7, 50);
        }
        else if(value == 0)
        {
        g2.setColor(c1);
        g2.fill(C4);
        g2.setColor(c2);
        g2.draw(C4);
        g2.drawString("G", 7, 68);
        }
            
    }
    
}