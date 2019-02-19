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


public void processFieldBet() throws Exception {
    
        Integer[] win = {3,4,9,10,11};
        Integer[] winX2 = {2};
        Integer[] winX3 = {12};
        Integer[] lose = {5,6,7,8};
        
        
        int d1 = (int) (Math.random()*6) + 1;
        userBean.setFirstDice(d1);
        int d2 = (int) (Math.random()*6) + 1;
        userBean.setSecondDice(d2);
        
        for (Integer win1 : win) {
            if (win1 == d1+d2) {
                userBean.setPot(userBean.getBet() + userBean.getPot());
            }
        } 
        
        for (Integer winX21 : winX2) {
            if (winX21 == d1+d2) {    
                userBean.setPot(userBean.getBet()*2 + userBean.getPot());
            }
        }
        
        
        for (Integer winX31 : winX3) {
            if (winX31 == d1+d2) {
                userBean.setPot(userBean.getBet()*3 + userBean.getPot());
            } 
        }
        
        for (Integer lose1 : lose) {
            if (lose1 == d1+d2) {
                userBean.setPot(userBean.getPot() - userBean.getBet())  ;     
            }
        }
        
    }
}