package me.saukin.controls;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import me.saukin.beans.UserBean;

@Named("fieldBet")
@RequestScoped

public class FieldBet {
    
    @Inject
    UserBean userBean;
    @Inject
    Dice dice;


    
public String processFieldBet() throws Exception {
    
        Integer[] win = {3,4,9,10,11};
        int winX2 = 2;
        int winX3 = 12;
        Integer[] lose = {5,6,7,8};
        String s = "fieldBetPage";
        
        dice.rollDice();
        
        for (Integer win1 : win) {
            if (win1 == userBean.getResult()) {
                userBean.setPot(userBean.getBet() + userBean.getPot());
                userBean.setWin(userBean.getBet());
                userBean.setLost(0);
                
            }
            
        } 
        
        if (winX2 == userBean.getResult()) {    
                userBean.setPot(userBean.getBet()*2 + userBean.getPot());
                userBean.setWin(userBean.getBet()*2);
                userBean.setLost(0);
                
        }
        
        
        if (winX3 == userBean.getResult()) {
                userBean.setPot(userBean.getBet()*3 + userBean.getPot());
                userBean.setWin(userBean.getBet()*3);
                userBean.setLost(0);
                
        }
        
        for (Integer lose1 : lose) {
            if (lose1 == userBean.getResult()) {
                userBean.setPot(userBean.getPot() - userBean.getBet());
                userBean.setLost(userBean.getBet());
                userBean.setWin(0);
               
            }
        }
        
        return userBean.checkBank(s);

   }
        

}