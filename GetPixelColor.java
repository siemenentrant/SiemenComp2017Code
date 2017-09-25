package getpixelcolor;
/**
 *
 * @author Siemen Competitor 2017
 */
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
 
public class GetPixelColor {
 	/**
 	* @param args the command line arguments
 	* @throws IOException 
 	*/  
public static void main(String args[]) throws IOException {      
    	int red_pixels = 0;
    	int green_pixels = 0;
    	int total_pixels = 0;   
    	try {
        	//read image file      
        	File file1 = new File("~Labanya/sc_proj_2017/Image_files/img_1743_right_time0.jpg"); 	            
        	BufferedImage image1 = ImageIO.read(file1);
        	//write file
        	FileWriter fstream = new FileWriter("C:/Users/labanyam/output.txt");
        	BufferedWriter out = new BufferedWriter(fstream);
        	//
        	//find red and green pixels
        	for (int y = 0; y < image1.getHeight(); y++) {
            	for (int x = 0; x < image1.getWidth(); x++) {
                  int c = image1.getRGB(x,y);
                  Color color = new Color(c);            
                  if(!color.equals(Color.WHITE)) {       	              
             	// Count red color pixels    	
              	if (color.getRed() > 150 && color.getGreen() < 80 && color.getBlue() < 80) {
                        red_pixels++;
                    }            	
               	// Count green color pixels
                  else if (color.getGreen() > 80 && color.getBlue() < 80) {
                        green_pixels++;
                    }
             	}
                 total_pixels = red_pixels + green_pixels;       	
            	}
        	}	
        	double color1_perc = (red_pixels/(double)total_pixels)*100;
        	double color2_perc = (green_pixels/(double)total_pixels)*100;
            System.out.println("Total colored pixels: " + total_pixels );
            System.out.println("Red Color pixels: " + red_pixels );
            System.out.println("Green Color pixels: " + green_pixels );
            System.out.println("Red Color percentage: " + color1_perc );
            System.out.println("Green Color percentage: " + color2_perc );  
        	out.close();  	
    	} catch (IOException e) {
        	e.printStackTrace();
    	}  
	}
}
