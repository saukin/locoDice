
package me.saukin.controls;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import me.saukin.beans.UserBean;


/**
 * class process Any Seven game
 * 
 * @author saukin
 */

@Named("anySeven")
@RequestScoped

public class AnySeven {
    
    @Inject
    UserBean userBean;
    @Inject
    Dice dice;
    
    final int WIN = 7;
    String s = "anySevenPage";
    
    
    /**
     * method process Any Seven game 
     * 
     * @return String : address of the final page in  case if the bank is empty
     *         or address of the Any Seven game page
     */
    
    public String processAnySeven() {
    
        dice.rollDice();
        
        if (WIN == userBean.getResult()) {
            dice.doWinX4();
        } else {
            dice.doLose();
        }
        return userBean.checkBank(s);
    }
}