
package me.saukin.controls;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import me.saukin.beans.UserBean;

@Named("Dice")
@RequestScoped

public class Dice {
    
    @Inject
    UserBean userBean;
    
    private int d1;
    private int d2;
    
    public Dice() {
        
    }
    
    public void rollDice() {
        
        d1 = (int) (Math.random()*6) + 1;
        userBean.setFirstDice(d1);
        d2 = (int) (Math.random()*6) + 1;
        userBean.setSecondDice(d2);
        userBean.setResult(d2+d1);
       
    }
    
}
