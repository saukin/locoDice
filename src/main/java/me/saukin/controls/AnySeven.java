
package me.saukin.controls;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import me.saukin.beans.UserBean;
import me.saukin.util.Messages;

@Named("anySeven")
@RequestScoped

public class AnySeven {
    
    @Inject
    UserBean userBean;
    @Inject
    Dice dice;
    
    final int WIN = 7;
    String s = "anySevenPage";
    
    public String processAnySeven() throws Exception {
    
        dice.rollDice();
        
        if (WIN == userBean.getResult()) {
            userBean.setPot(userBean.getBet()*4 + userBean.getPot());
            userBean.setWin(userBean.getBet()*4);
            userBean.setLost(0);
            userBean.setBundleId(userBean.getBUNDLE_WIN());
            userBean.setMess(Messages.getMessage(userBean.getBUNDLE(), userBean.getBundleId(), null).getDetail());
        } else {
            userBean.setPot(userBean.getPot() - userBean.getBet());
            userBean.setWin(0);
            userBean.setLost(userBean.getBet());
            userBean.setBundleId(userBean.getBUNDLE_LOSE());
            userBean.setMess(Messages.getMessage(userBean.getBUNDLE(), userBean.getBundleId(), null).getDetail());
        }
        return userBean.checkBank(s);
    }
}