
package me.saukin.beans;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import me.saukin.util.Messages;
import me.saukin.controls.FieldBet;
import me.saukin.controls.AnySeven;
import me.saukin.controls.PassLine;

@Named
@SessionScoped


public class LocaleBean implements Serializable {
    
    @Inject
    UserBean userBean; 
    AnySeven anySeven;
    FieldBet fieldBet;
    PassLine passLine;
    
    
    private Locale locale;

        
    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
    }

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    
    /**
     * method set localization and checks if the lose/win message exists and 
     * switch its language
     * 
     * @param a - language
     * @param b - locale
     */
    
    public void setLanguage(String a, String b) {
        locale = new Locale(a, b);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        if (!userBean.getMess().equals("")) {
            userBean.setMess(Messages.getMessage(userBean.getBUNDLE(), userBean.getBundleId(), null).getDetail());
        }
    }

}
