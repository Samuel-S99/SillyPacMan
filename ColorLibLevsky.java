import java.util.*;
import java.awt.*;

public class ColorLibLevsky
{
    public static Color BROWNina(){
        return new Color(160,80,0);
    }

    public static Color LIMEGREENbsl(){
        return new Color(45,215,57);
    }
    public static Color RNDCOLORbsl(){
        int red=(int)(Math.random()*255+1);
        int green=(int)(Math.random()*255+1);
        int blue=(int)(Math.random()*255+1);
        return new Color(red,green,blue);
          // repaint(); cool features

    }       
}