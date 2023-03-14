import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.*;


public class Main {


    public static void main(String[] args) {

        DrawFrame frame = new DrawFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}





    class DrawFrame extends JFrame{ //this is the canvas basically
       public static final int FRAME_WIDTH = 500;
        public static final int FRAME_HEIGHT = 500;

        public DrawFrame(){
            setTitle("Color Changer");
            setSize(FRAME_WIDTH, FRAME_HEIGHT);
            DrawPanel panel = new DrawPanel();
            add(panel);
        }
    }

    class DrawPanel extends JPanel{ //holds all buttons and shapes, whatever you put on it

     Color c = Color.red;


     public ActionListener change(Color b){
         return e->{
             c = b;
             repaint();
         };
     }
    public DrawPanel(){
        JButton redButton = new JButton("Red Circle");
        redButton.addActionListener(change(Color.red));
        JButton greenButton = new JButton("Green Circle");
        greenButton.addActionListener(change(Color.green));
        JButton blueButton = new JButton("Blue Circle");
        blueButton.addActionListener(change(Color.blue));

        add(redButton);
        add(greenButton);
        add(blueButton);
        setLayout(new FlowLayout());
    }


    @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;


            Ellipse2D circle = new Ellipse2D.Double();
            circle.setFrame(170,170,100,100);
            g2.draw(circle);
            g2.setColor(c);
            g2.fill(circle);
        }
    }








