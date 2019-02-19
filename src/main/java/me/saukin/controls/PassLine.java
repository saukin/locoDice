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
    
    
        private final Integer[] WIN = {7,11};
        private final Integer[] POINT = {4,5,6,8,9,10};
        private final Integer[] LOSE = {2,3,12};
        private final int POINT_LOSE = 7;
        private int d1;
        private int d2;
    
    public String choosePassLine() throws Exception {
        
        d1 = (int) (Math.random()*6) + 1;
        userBean.setFirstDice(d1);
        d2 = (int) (Math.random()*6) + 1;
        userBean.setSecondDice(d2);
        userBean.setResult(d2+d1);
        
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
               
        return s;
    }    
        
    public void processPassLine() throws Exception {    
        
        for (Integer win1 : WIN) {
            if (win1 == userBean.getResult()) {
                userBean.setPot(userBean.getBet() + userBean.getPot());
            }
        }
        
        for (Integer lose1 : LOSE) {
            if (lose1 == userBean.getResult()) {
                userBean.setPot(userBean.getPot() - userBean.getBet())  ; 
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
            s = "passLinePage";
        } else if (userBean.getPoint() == userBean.getResult()) {
            userBean.setPot(userBean.getBet() + userBean.getPot());
            s = "passLinePage";
        } else {
            s = "pointPage";
        }
        
        return s;
    }  
    
//    public String choosePassOrPoint() throws Exception {
//        
//        int d3 = (int) (Math.random()*6) + 1;
//        userBean.setFirstDice(d3);
//        int d4 = (int) (Math.random()*6) + 1;
//        userBean.setFirstDice(d4);
//        userBean.setResult(d3+d4);
//        
//        String s = "";
//        
//        if (userBean.getResult() != (d1+d2) || POINT_LOSE != (d1+d2)) {
//            s = "pointPage";
//        } else {
//            processPassLine();
//            s = "passLinePage";
//        }
//               
//        return s;
//    }    
    
}
