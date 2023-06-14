import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GUI3 extends Canvas {
    static int width = 1000, height=1000;//размеры окна

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //преобразуем Graphics в Graphics2D (для сглаживания)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/str.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int imageWidth = image.getWidth(), imageHeight=image.getHeight();
        int y = 0, x = 0;
        boolean XDriwe=true,YDriwe=true;
        while (true) {
            if(XDriwe&&YDriwe){
                if(x>=width-imageWidth-115){
                    XDriwe=false;
                }else{ g2.drawImage(image, x, y, this);
                    try {
                        TimeUnit.MILLISECONDS.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    g2.clearRect(x, y, imageWidth, imageHeight);
                    x+=5;}
            }else if(!XDriwe&&YDriwe) {
                if(y>=height-imageHeight-140){
                    YDriwe=false;
                }else{ g2.drawImage(image, x, y, this);
                    try {
                        TimeUnit.MILLISECONDS.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    g2.clearRect(x, y, imageWidth, imageHeight);
                    y+=5;}
            }else if(!XDriwe&&!YDriwe) {
                if(x<=100){
                    XDriwe=true;
                }else{ g2.drawImage(image, x, y, this);
                    try {
                        TimeUnit.MILLISECONDS.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    g2.clearRect(x, y, imageWidth, imageHeight);
                    x-=5;}
            }else if(XDriwe&&!YDriwe) {
                if(y<=100){
                    YDriwe=true;
                }else { g2.drawImage(image, x, y, this);
                    try {
                        TimeUnit.MILLISECONDS.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    g2.clearRect(x, y, imageWidth, imageHeight);
                    y-=5;}
            }

        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("шарик");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width/2-width/2,dim.height/2-height/2, width,height);
        GUI3 m=new GUI3();
        frame.add(m);
        frame.setVisible(true);
    }
}
