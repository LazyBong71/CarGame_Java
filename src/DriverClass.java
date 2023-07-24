import javax.swing.JFrame;

public class DriverClass extends JFrame {
    public static void main (String[] args) throws Exception{

        JFrame F = new JFrame(); //Set JFrame Variable
        F.setTitle("Car Driving Game By C211046"); //Set Frame Title
        F.setSize(1000, 560); //Set Initial Frame Size
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close Running When Close Frame
        F.add(new AddImage()); //Show All Image in Frame From AddImage Class
        F.setVisible(true); // Visible Frame On window

    }
}
//ID : C211046
//Fahim Reza
