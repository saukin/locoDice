
package me.saukin.beans;



import java.io.Serializable;
import java.util.Objects;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Named("user")
@SessionScoped


public class UserBean implements Serializable {
    
    private String nickName;
    private int pot;
    private int bet;
    private int firstDice = 1;
    private int secondDice = 6;
    private int result;
    private int point;
    private String mess = "";
    private int win;
    private int lost;
    
    protected String BUNDLE = "me.saukin.bundles.messages";
    protected String BUNDLE_WIN = "congrats";
    protected String BUNDLE_LOSE = "sorry";
    protected String bundleId ="";

    public String getBUNDLE() {
        return BUNDLE;
    }

    public String getBUNDLE_WIN() {
        return BUNDLE_WIN;
    }

    public String getBUNDLE_LOSE() {
        return BUNDLE_LOSE;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public String getBundleId() {
        return bundleId;
    }
    
    


    public UserBean() {
    }

    public UserBean(String nickName, int pot, int bet, int firstDice, int secondDice, int result, int point, String mess, int win, int lost) {
        this.nickName = nickName;
        this.pot = pot;
        this.bet = bet;
        this.firstDice = firstDice;
        this.secondDice = secondDice;
        this.result = result;
        this.point = point;
        this.mess = mess;
        this.win = win;
        this.lost = lost;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void setFirstDice(int firstDice) {
        this.firstDice = firstDice;
    }

    public void setSecondDice(int secondDice) {
        this.secondDice = secondDice;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setMess(String message) {
        this.mess = message;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public String getNickName() {
        return nickName;
    }

    public int getPot() {
        return pot;
    }

    public int getBet() {
        return bet;
    }

    public int getFirstDice() {
        return firstDice;
    }

    public int getSecondDice() {
        return secondDice;
    }

    public int getResult() {
        return result;
    }

    public int getPoint() {
        return point;
    }

    public String getMess() {
        return mess;
    }

    public int getWin() {
        return win;
    }

    public int getLost() {
        return lost;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.nickName);
        hash = 13 * hash + this.pot;
        hash = 13 * hash + this.bet;
        hash = 13 * hash + this.firstDice;
        hash = 13 * hash + this.secondDice;
        hash = 13 * hash + this.result;
        hash = 13 * hash + this.point;
        hash = 13 * hash + Objects.hashCode(this.mess);
        hash = 13 * hash + this.win;
        hash = 13 * hash + this.lost;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserBean other = (UserBean) obj;
        if (this.pot != other.pot) {
            return false;
        }
        if (this.bet != other.bet) {
            return false;
        }
        if (this.firstDice != other.firstDice) {
            return false;
        }
        if (this.secondDice != other.secondDice) {
            return false;
        }
        if (this.result != other.result) {
            return false;
        }
        if (this.point != other.point) {
            return false;
        }
        if (this.win != other.win) {
            return false;
        }
        if (this.lost != other.lost) {
            return false;
        }
        if (!Objects.equals(this.nickName, other.nickName)) {
            return false;
        }
        if (!Objects.equals(this.mess, other.mess)) {
            return false;
        }
        return true;
    }
    

    public String resetCh() {
       mess = "";
       bundleId = "";
       return "choicePage";
    }
    
    public String resetEnd() {
       mess = "";
       bundleId = "";
       return "byebyePage";
    }

    public String checkBank(String s) {
        if (this.pot == 0) {
            s = "byebyePage";
        }
        return s;
    }
    
}

