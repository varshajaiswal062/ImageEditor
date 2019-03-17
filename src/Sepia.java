
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import static javax.swing.Spring.height;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author crazy_fairy
 */
public class Sepia extends PicEditor {
    

    
    static String mSepia(String location)throws IOException
	{String s = null;
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
                {int p =img.getRGB(x,y);
                int a=(p>>24)&0xff;
                int r=(p>>16)&0xff;
                int g=(p>>8)&0xff;
                int b=p&0xff;
                
                
                int tr=(int) (0.393*r+0.769*g+0.189*b);
                int tb=(int) (0.272*r+0.534*g+0.131*b);        
                int tg=(int) (0.349*r+0.686*g+0.168*b);
                
                if(tr>255)
                    {r=255;}
                else{r=tr;}
                
                if(tg>255)
                    {g=255;}
                else{g=tg;}
                
                if(tb>255)
                    {b=255;}
                else{b=tb;}
                p=(a<<24) |(r<<16)|(g<<8)|b;
                img.setRGB(x,y,p);
                        }
                

            }
            
        try
           {f=new File("C:\\Users\\varsh\\Desktop\\sepia.jpg");
           ImageIO.write(img, "jpg", f);
           s="C:\\Users\\varsh\\Desktop\\sepia.jpg";
           }
           catch(IOException e)
           {System.out.println("Error");
           }
        return s;
}

}
            

            
