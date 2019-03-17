
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author crazy_fairy
 */
public class Grayscale {
     static String mGrayScale(String location)throws IOException
        {String s=null;
         BufferedImage img=null;
	 File f=null;
	try{f=new File(location);
            img=ImageIO.read(f);
	}catch(IOException e){
		System.out.print("Error");}
        
    
        int width=img.getWidth();
        int height=img.getHeight();
        for(int y=0;y<height;y++)
        {
            for(int x=0;x<width;x++)
            {
                int p =img.getRGB(x,y);
                int a=(p>>24)&0xff;
                int r=(p>>16)&0xff;
                int g=(p>>8)&0xff;
                int b=p&0xff;
                int avg=(r+g+b)/3;
                p=(a<<24) |(avg<<16)|(avg<<8)|avg;
                img.setRGB(x,y,p);
            }
        }
        try
           {f=new File("C:\\Users\\varsh\\Desktop\\grayscale.jpg");
           ImageIO.write(img, "jpg", f);
           s="C:\\Users\\varsh\\Desktop\\grayscale.jpg";
           
           }
           catch(IOException e)
           {System.out.println("Error");
           }
        return s;
        }
    
}
