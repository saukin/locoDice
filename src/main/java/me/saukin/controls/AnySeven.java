
package me.saukin.controls;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import me.saukin.beans.UserBean;

@Named("anySeven")
@RequestScoped

public class AnySeven {
    
    @Inject
    UserBean userBean;
    
    
    
    public void processAnyBet() throws Exception {
    
        int win = 7;
        
        int d1 = (int) (Math.random()*6) + 1;
        userBean.setFirstDice(d1);
        int d2 = (int) (Math.random()*6) + 1;
        userBean.setSecondDice(d2);
        
        if (win == d1+d2) {
            userBean.setPot(userBean.getBet()*4 + userBean.getPot());
        } else {
            userBean.setPot(userBean.getPot() - userBean.getBet())  ;
        }
        
    }
}