package me.saukin.controls;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import me.saukin.beans.UserBean;


/**
 * Class process Pass Line game 
 * 
 * @author saukin
 */

@Named("passLine")
@RequestScoped

public class PassLine {
    
    @Inject
    UserBean userBean;
    @Inject
    Dice dice;
    
        private final Integer[] WIN = {7,11};
        private final Integer[] POINT = {4,5,6,8,9,10};
        private final Integer[] LOSE = {2,3,12};
        private final int POINT_LOSE = 7;
        
        
/**
 * method choose what to do after rolling the dice: do win/lose or point
 * 
 * @return String : address of the final page in  case if the bank is empty
*         or address of the Pass Line game page or Point page
 */
        
    public String choosePassLine()  {
        
        dice.rollDice();
        
        String s = "";
        
        for (Integer point1 : POINT) {
            if (point1 == userBean.getResult()) {
                userBean.setPoint(userBean.getResult());
                s = "pointPage";
            }
        }
        
        if (s.equalsIgnoreCase("")) {
            processPassLine();
            s = "passLinePage";
        }
        
        return userBean.checkBank(s);
    }    
    

/**
 * 
 * method checks the result and sets win/lose outcome
 */
    
    public void processPassLine() {    
        
        for (Integer win1 : WIN) {
            if (win1 == userBean.getResult()) {
                dice.doWin();
            }
        }
        
        for (Integer lose1 : LOSE) {
            if (lose1 == userBean.getResult()) {
                dice.doLose();
            }
        }  
        
    }
    

/**
 * 
 * method process the point algorithm, 
 *        checks the result and sets win/lose/point outcome
 * 
 * @return String: address of the final page in  case if the bank is empty
*         or address of the Pass Line game page or Point page
 */
    
    public String processPoint() {
        
        dice.rollDice();
        
        String s;
    
        if (userBean.getResult() == POINT_LOSE) {
            dice.doLose();
            s = "passLinePage";
        } else if (userBean.getPoint() == userBean.getResult()) {
            dice.doWin();
            s = "passLinePage";
        } else {
            s = "pointPage";
        }
        
        return userBean.checkBank(s);
    }  
    

    
}
