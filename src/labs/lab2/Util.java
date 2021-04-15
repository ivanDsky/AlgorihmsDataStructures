package labs.lab2;

import javax.swing.*;
import java.awt.*;

public class Util {
    public static String toPattern(String inp){
        //TODO review pattern
        StringBuilder ret = new StringBuilder("");
        char prev = '0';
        for(int i = 0;i < inp.length(); ++i){
            char cur = inp.charAt(i);
            if(cur == '*')ret.append(".*");
            else if(cur == '?')ret.append(".");
            else if(cur == '\\')ret.append("\\\\\\\\");
            else {
                ret.append('[');
                if(cur == '[')ret.append("\\\\[");
                else ret.append(cur);
                ret.append(']');
            }

        }
        return ret.toString();
    }

    public static void centerFrame(JFrame frame){
        Point centerPoint = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        centerPoint = new Point(centerPoint.x - frame.getWidth() / 2,centerPoint.y - frame.getHeight() / 2);
        frame.setLocation(centerPoint);
    }
}
