import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageTest {
public static Image img;
  public static void main(String[] args) {
       InputStream is = ImageTest.class.getClassLoader().getResourceAsStream(
                            "com/supportwizard/timetracking/client/backimage.jpg");
            try {
                img = ImageIO.read(is);
            } catch (IOException ex) {
                
            }
            
                    System.out.println("System.getProperty(user.home) =====>"+ System.getProperty("user.home"));
            long programStartTimeL = 1353476720534L;
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy HH:mm");
            System.out.println("=====>"+ sdf.format((new Date(programStartTimeL))));
            
    ImagePanel panel = new ImagePanel(new ImageIcon(img).getImage());

    JFrame frame = new JFrame();
    frame.getContentPane().add(panel);
   // frame.pack();
  //  frame.setVisible(true);
  }
}

class ImagePanel extends JPanel {

  public  Image img;

  public ImagePanel(String img) {
      
    this(new ImageIcon(img).getImage());
  }

  public ImagePanel(Image img) {
    this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }

  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
  }

}
