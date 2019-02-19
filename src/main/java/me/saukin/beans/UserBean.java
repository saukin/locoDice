
package me.saukin.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("user")
@SessionScoped


public class UserBean implements Serializable {
    
    private String nickName;
    private int pot;
    private int bet;
    private int firstDice;
    private int secondDice;
    private int result;
    private int point;
    private String message;

    public UserBean() {
    }

    public UserBean(String nickName, int pot, int bet, int firstDice, int secondDice, int result, int point, String message) {
        this.nickName = nickName;
        this.pot = pot;
        this.bet = bet;
        this.firstDice = firstDice;
        this.secondDice = secondDice;
        this.result = result;
        this.point = point;
        this.message = message;
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

    public void setMessage(String message) {
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.nickName);
        hash = 67 * hash + this.pot;
        hash = 67 * hash + this.bet;
        hash = 67 * hash + this.firstDice;
        hash = 67 * hash + this.secondDice;
        hash = 67 * hash + this.result;
        hash = 67 * hash + this.point;
        hash = 67 * hash + Objects.hashCode(this.message);
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
        if (!Objects.equals(this.nickName, other.nickName)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
}

