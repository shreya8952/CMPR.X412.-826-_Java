//how do you test this demo?

//start from example I, run the program and observe.  This window will not close by itself, so, you need to kill it using 
//task manager in Windows, other operating system will have their way of closing the window forcefully

//then comment this example and uncomment other examples, and keep going down until you are done with all ten examples.

// Example I
// Shortest GUI Application in Java

import java.awt.*;

class TestGraphics {
	public static void main(String[] args) {
		Frame newFrame = new Frame();
		newFrame.setSize(550, 200);
		newFrame.setVisible(true);
	}
}


/*

//un comment me to study me  :-)
 
// Example  II 
// Instead of using Frame as 'Has-a' relationship
// You can extend your class from Frame with a 'Is-a' relationship
import java.awt.*;

class TestGraphics extends Frame {

	public static void main(String[] args) {
		TestGraphics screen = new TestGraphics();
		screen.setSize(550, 200);
		screen.setVisible(true);
	}
}

*/


/*
//yes, go ahead comment the previous example, and un comment me to study me
 
// Example  III
// How about "Hello World" in Graphics?
// Stretch the window and observe the rendering
  
import java.awt.*;

class TestGraphics extends Frame {
	public void paint(Graphics g){
		g.drawString("Hello World and Java 5185 - This window will not close", 100, 100);
	}
	
	public static void main(String[] args) {
		TestGraphics screen = new TestGraphics();
		screen.setSize(550, 200);
		screen.setVisible(true);
	}
}
*/

/*
//Example IV
//writing text in a window, yes you can edit it
import java.awt.Frame;
import java.awt.TextField;

public final class TestGraphics
    {

    public static void main( String args[] )
        {
        Frame frame = new Frame();
        TextField textField = new TextField("Hello World - go ahead edit me", 30);
        frame.add(textField);
        frame.setSize(550, 200);
        frame.setVisible(true);
        }
    }
*/

/*
//Example V
//Add More controls and lay them down with FlowLayout
import java.awt.*;

public class TestGraphics {
	public static void main(String[] args) {
		Frame content = new Frame(
				"This is introduction to graphics programming");
		content.setBackground(Color.CYAN);
		content.setLayout(new FlowLayout());
		content.add(new Label("Day1:"));
		content.add(new Button("Monday"));
		content.add(new Label("Day2:"));
		content.add(new Button("Tuesday"));
		content.add(new Button("Wednesday"));
		content.add(new Button("Thursday"));
		content.add(new Button("Friday"));
		content.add(new Button("Saturday"));
		content.add(new Button("Sunday"));
		content.add(new Checkbox("Check Me"));
		content.add(new TextField("Write Here", 30));
		content.setSize(550, 200); // width, height
		content.setVisible(true);
	}
}
*/

/*
//Example VI : Event Handling
//Different way of handling events - window listener
//imagine, finally this window closes as well
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestGraphics {
	public static void main(String[] args) {
		Frame content = new Frame(
				"This window closes");
		content.setBackground(Color.white);
		content.setLayout(new BorderLayout());
		content.add(new Button("Monday"), BorderLayout.NORTH);
		content.add(new Button("Tuesday"), BorderLayout.WEST);
		content.add(new Button("Wednesday"), BorderLayout.CENTER);
		content.add(new Button("Thursday"), BorderLayout.EAST);
		content.add(new Button("Friday"), BorderLayout.SOUTH );
		content.setSize(550, 200); // width, height
		content.setVisible(true);
		content.addWindowListener(new WindowAdapter() {
			//inner anonymous class
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
*/

/*
// Example VII 

//Program to demonstrate action listeners and event handlers

import java.awt.*;
import java.awt.event.*;

class TestGraphics extends Frame implements ActionListener {
	// constructor
	public TestGraphics(String s) {
		super(s);
		setLayout(new FlowLayout());
		Button pushButton = new Button("Go Ahead, Click Me");
		add(pushButton);
		pushButton.addActionListener(this); 
		addWindowListener(new WindowAdapter() {
			//inner anonymous class
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	// define action for Button press
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Go Ahead, Click Me")) {
			System.out.println("ouch!");
		}
	}

	public static void main(String[] args) {
		TestGraphics screen = new TestGraphics("Graphic Example");
		screen.setSize(550, 200);
		screen.setVisible(true);
	}
}
*/

/*
//Example VIII
//Make this window close by pressing the x button at top right
//Program to demonstrate event handlers
import java.awt.*;
import java.awt.event.*;

class TestGraphics extends Frame implements WindowListener {
	// constructor
	public TestGraphics(String s) {
		super(s);
		addWindowListener(this); // listen for events on this Window
	}
	public void paint(Graphics g){
		g.drawString("Hello World and Java 5185 - This window will close", 100, 100);
	}

	// define methods in WindowListener interface
	public void windowClosing(WindowEvent event) {
		System.exit(0);
	}

	//must implement these methods
	//for now let us just give an empty body
	public void windowClosed(WindowEvent event) {
	} 

	public void windowDeiconified(WindowEvent event) {
	}

	public void windowIconified(WindowEvent event) {
	}

	public void windowActivated(WindowEvent event) {
	}

	public void windowDeactivated(WindowEvent event) {
	}

	public void windowOpened(WindowEvent event) {
	}

	public static void main(String[] args) {
		TestGraphics screen = new TestGraphics("Graphic Example");
		screen.setSize(550, 200);
		screen.setVisible(true);
	}
}
*/

/*
//Example IX
//Working more with Text Field

import java.awt.*;
import java.awt.event.*;

public final class TestGraphics {

	public static void main(String args[]) {
		final Frame frame = new Frame();
		final TextField textfield = new TextField("Type something");
		textfield.setEnabled(true);
		textfield.setEditable(true);
		textfield.addTextListener(new TextListener() {
			public void textValueChanged(TextEvent e) {
				System.out.println(textfield.getText());
			}
		});
		frame.add(textfield);
		frame.setSize(550, 200);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.validate();
		frame.setVisible(true);
	}
}
*/

/*
// Example  X
// How about working with mouse clicks
//and making it close as well
  
import java.awt.*;
import java.awt.event.*;

class TestGraphics extends Frame implements MouseListener {
	int xPos=20, yPos=30;
	
	public void paint(Graphics g){
		try {
		this.addMouseListener(this);
		g.drawString("Hello World and Java 5185 - This text will move with mouse click", xPos, yPos);
	} catch (Exception e) {
	    e.printStackTrace();
	 }
	}
	public void mouseClicked(MouseEvent evt)
	{
	         xPos = evt.getX();
	         yPos = evt.getY();
	         repaint();
	}
	
	public void mouseEntered (MouseEvent me) {}
	public void mousePressed (MouseEvent me) {}
	public void mouseReleased (MouseEvent me) {}
	public void mouseExited (MouseEvent me) {}
	
	public boolean mouseDown(Event evt, int x, int y)
	{
		xPos = x;
		yPos = y;
		repaint();
		return true;
	}
	
	public static void main(String[] args) {
		TestGraphics screen = new TestGraphics();
		screen.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		screen.addMouseListener(screen);
		screen.setSize(550, 200);
		screen.setVisible(true);
	}
}
*/