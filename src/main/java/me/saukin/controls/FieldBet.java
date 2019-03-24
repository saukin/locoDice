package me.saukin.controls;

import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;
import me.saukin.beans.UserBean;


/**
 * Class process Field Bet game 
 * 
 * @author saukin
 */

@Named("fieldBet")
@RequestScoped

public class FieldBet {
    
    @Inject
    UserBean userBean;
    @Inject
    Dice dice;
    

/**
* method process Field Bet game 
* 
* @return String : address of the final page in  case if the bank is empty
*         or address of the Field Bet game page
*/
    
    
public String processFieldBet() throws Exception {
        
        
        Integer[] win = {3,4,9,10,11};
        int winX2 = 2;
        int winX3 = 12;
        Integer[] lose = {5,6,7,8};
         
        String s = "fieldBetPage";
       
        
        dice.rollDice();
        
        for (Integer win1 : win) {
            if (win1 == userBean.getResult()) {
                dice.doWin();
            }
            
        } 
        
        if (winX2 == userBean.getResult()) {    
            dice.doWinX2();
        }
        
        
        if (winX3 == userBean.getResult()) {
            dice.doWinX3();    
        }
        
        for (Integer lose1 : lose) {
            if (lose1 == userBean.getResult()) {
                dice.doLose();
            }
        }
        
        return userBean.checkBank(s);

   }
        

}