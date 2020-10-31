/**
 * @(#)myFirstGuiProgram.java
 *
 * myFirstGuiProgram application
 *
 * @Nam Nguyen
 * @version 1.00 2013/10/2
 */

import javax.swing.*;

import java.awt.*;

 

class GUIGreet

{

public static void main (String[] args)

{

            new GUIGreet();

}

 

GUIGreet()

{

JFrame frame = new JFrame("Graphical Greeting");

JPanel pane = new JPanel(new BorderLayout());

pane.add(new Greeting(), BorderLayout.CENTER);

frame.setContentPane(pane);

frame.setSize(400,100);

frame.setVisible(true);

}

}

 

class Greeting extends JComponent

{

public Greeting ()

{

repaint();

}

 

public void paint (Graphics g)

{

g.drawString("Hello, world",150,50);

}

}
