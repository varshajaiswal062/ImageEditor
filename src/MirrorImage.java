/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author crazy_fairy
 */
import java.io.File;
import java.io.IOException;
import java.awt.*;
import static java.awt.PageAttributes.MediaType.C;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import static javax.swing.Spring.height;
public class MirrorImage extends PicEditor 
{

    /**
     *
     * 
     * @throws IOException
     */
    static String mirror(String location)throws IOException
	{ImageIcon mirrorImg;
            String s="";
        
        System.out.print(location);
         BufferedImage simg=null;
	 File f=null;
	f=new File(location);
	simg=ImageIO.read(f);
	
	int width=simg.getWidth();
	int height=simg.getHeight();
	BufferedImage mimg=new BufferedImage(width*2,height,BufferedImage.TYPE_INT_ARGB);
	
	for(int y=0;y<height;y++)
	 {for(int lx=0,rx=width*2-1;lx<width;lx++,rx--)
		{int p=simg.getRGB(lx,y);
		 mimg.setRGB(lx,y,p);
		 mimg.setRGB(rx,y,p);
		}
	 }
	try{
		f=new File("C:\\Users\\varsh\\Desktop\\mirrorimage.png");
		ImageIO.write(mimg,"png",f);
                s="C:\\Users\\varsh\\Desktop\\mirrorimage.png";
	}catch(IOException e){
		System.out.print("Error");}
        
       
       return s;
        }
        }




