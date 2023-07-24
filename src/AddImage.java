import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddImage extends JPanel {

    //Variable Create
    Image Png;
    CarImage Car;

    public AddImage() throws Exception {

        //Add Background Image in png Variable
        ImageIcon I = new ImageIcon("background.png");
        Png = I.getImage();

        //Add Car png in Car Variable
        Car = new CarImage();

        //Method For Key Press Listen
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                try {
                    Car.move(e); // Call move() Method From CarImage Class
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                Car.stop(e); // Call stop() Method From CarImage Class
            }
        });
        setFocusable(true);
    }

    //Method For Showing Background Image & Car Image
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(Png,0,0,this);
        g.drawImage(Car.carImage,Car.x,460, this);
        repaint();
    }
}
