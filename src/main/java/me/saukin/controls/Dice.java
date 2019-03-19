
package me.saukin.controls;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import me.saukin.beans.UserBean;

@Named("dice")
@RequestScoped

public class Dice implements Serializable {
    
    @Inject
    UserBean userBean;
    
    
    private int d1 = 1;
    private int d1Rear = 6;
    private int d1Left = 2;
    private int d1Right = 5;
    private int d1Top = 3 ;
    private int d1Bottom = 4;
    
    private int d2 = 6;
    private int d2Rear = 1;
    private int d2Left = 5;
    private int d2Right = 2;
    private int d2Top = 4;
    private int d2Bottom = 3;
    
    public Dice() {
        
    }
    
    public void rollDice() {
        
        d1 = (int) (Math.random()*6) + 1;
        userBean.setFirstDice(d1);
        d2 = (int) (Math.random()*6) + 1;
        userBean.setSecondDice(d2);
        userBean.setResult(d2+d1);
        
        d1Rear = 7 - d1;
        int max1 = Math.max(d1, d1Rear);
        
        switch (max1) {
            case 4:
                d1Left = 5;
                d1Right = 2;
                d1Top = 1;
                d1Bottom = 6;
                break;
            case 5:
                d1Left = 3;
                d1Right = 4;
                d1Top = 1;
                d1Bottom = 6;
                break;
            default:
                d1Left = 3;
                d1Right = 4;
                d1Top = 5;
                d1Bottom = 2;
                break;
        }
        
        d2Rear = 7 - d2;
        int max2 = Math.max(d2, d2Rear);
        
        switch (max2) {
            case 4:
                d2Left = 5;
                d2Right = 2;
                d2Top = 1;
                d2Bottom = 6;
                break;
            case 5:
                d2Left = 3;
                d2Right = 4;
                d2Top = 1;
                d2Bottom = 6;
                break;
            default:
                d2Left = 3;
                d2Right = 4;
                d2Top = 5;
                d2Bottom = 2;
                break;
        }
       
    }

    public int getD1() {
        return d1;
    }

    public int getD1Rear() {
        return d1Rear;
    }

    public int getD1Left() {
        return d1Left;
    }

    public int getD1Right() {
        return d1Right;
    }

    public int getD1Top() {
        return d1Top;
    }

    public int getD1Bottom() {
        return d1Bottom;
    }

    public int getD2() {
        return d2;
    }

    public int getD2Rear() {
        return d2Rear;
    }

    public int getD2Left() {
        return d2Left;
    }

    public int getD2Right() {
        return d2Right;
    }

    public int getD2Top() {
        return d2Top;
    }

    public int getD2Bottom() {
        return d2Bottom;
    }
    
    
    
}
