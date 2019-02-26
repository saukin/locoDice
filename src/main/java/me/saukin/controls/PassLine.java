package me.saukin.controls;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import me.saukin.beans.UserBean;

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
        
    
    public String choosePassLine() throws Exception {
        
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
        
    public void processPassLine() throws Exception {    
        
        for (Integer win1 : WIN) {
            if (win1 == userBean.getResult()) {
                userBean.setPot(userBean.getBet() + userBean.getPot());
                userBean.setWin(userBean.getBet());
                userBean.setLost(0);
            }
        }
        
        for (Integer lose1 : LOSE) {
            if (lose1 == userBean.getResult()) {
                userBean.setPot(userBean.getPot() - userBean.getBet())  ;
                userBean.setWin(0);
                userBean.setLost(userBean.getBet());
            }
        }  
        
    }
        
    public String processPoint() {
        
        int d3 = (int) (Math.random()*6) + 1;
        userBean.setFirstDice(d3);
        int d4 = (int) (Math.random()*6) + 1;
        userBean.setSecondDice(d4);
        userBean.setResult(d3+d4);
        
        String s;
    
        if (userBean.getResult() == 7) {
            userBean.setPot(userBean.getPot() - userBean.getBet());
            userBean.setWin(0);
            userBean.setLost(userBean.getBet());
            s = "passLinePage";
        } else if (userBean.getPoint() == userBean.getResult()) {
            userBean.setPot(userBean.getBet() + userBean.getPot());
            userBean.setWin(userBean.getBet());
            userBean.setLost(0);
            s = "passLinePage";
        } else {
            s = "pointPage";
        }
        
        return s;
    }  
    

    
}
