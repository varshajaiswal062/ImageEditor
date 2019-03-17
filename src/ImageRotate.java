import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author crazy_fairy
 */
public class ImageRotate {
    
    public static final int ROTATE_LEFT=1;
    public static final int ROTATE_RIGHT=-1;
    static String rotate90(File input,int direction)
    {String s="";
        try
        {   
            File f=null;
            ImageInputStream iis=ImageIO.createImageInputStream(input);
            Iterator<ImageReader> iterator=ImageIO.getImageReaders(iis);
            ImageReader reader=iterator.next();
            String format=reader.getFormatName();
            BufferedImage image=ImageIO.read(iis);
            int width=image.getWidth();
            int height=image.getHeight();
            BufferedImage rotated=new BufferedImage(height,width,image.getType());
            
            for(int y=0;y<height;y++)
            {
                for(int x=0;x<width;x++)
                {
                    switch(direction)
                    {
                        case ROTATE_LEFT:
                            rotated.setRGB(y, (width-1)-x, image.getRGB(x, y));
                            break;
                        case ROTATE_RIGHT:
                            rotated.setRGB((height-1)-y, x, image.getRGB(x, y));
                            break;
                    }
                }
            }
            f=new File("C:\\Users\\varsh\\Desktop\\rotateimage.png");
            ImageIO.write(rotated,"png",f);
            s="C:\\Users\\varsh\\Desktop\\rotateimage.png";
            
        }
        catch(IOException ex)
        {        }
        
        return s;
    }

  
}