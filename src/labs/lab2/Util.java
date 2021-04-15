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

    public static String removeEndSpaces(String org){
        int st = 0;
        int fn = org.length();
        for(int i = 0;i < org.length(); ++i){
            if(Character.isSpaceChar(org.charAt(i)))st++;else break;
        }
        for(int i = org.length() - 1;i >= 0; --i){
            if(Character.isSpaceChar(org.charAt(i)))fn--;else break;
        }
        if(st >= fn)return null;
        return org.substring(st,fn);
    }
}
