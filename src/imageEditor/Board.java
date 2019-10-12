package imageEditor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel{
    
    private BufferedImage image;
    private List<String> formatList;
    
    public Board(){
        formatList = new ArrayList<>();
        formatList.add("bmp");
        formatList.add("gif");
        formatList.add("jpeg");
        formatList.add("jpg");
        formatList.add("png");
        formatList.add("tiff");
        formatList.add("tif");
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
    
    public boolean loadImage(String path, String imageFormat){
        if(formatList.contains(imageFormat)){
            try {
                image = ImageIO.read(new File(path));
                return true;
            } catch (IOException ex) {
                return false;
            }
        }
        return false;
    }
    
    public boolean saveImage(File file, String imageFormat) {
        if(formatList.contains(imageFormat)){
            try {
                ImageIO.write(image, imageFormat, file);
                return true;
            } catch (IOException ex) {
                return false;
            }
        }
        return false;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
