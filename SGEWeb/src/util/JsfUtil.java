package util;

import java.util.Locale;

import javax.faces.context.FacesContext;

public class JsfUtil {
	
	private static JsfUtil instance;
	
	public static JsfUtil getInstanse(){
		if (instance == null)
			instance = new JsfUtil();
		return instance;
	}
	
	private JsfUtil() {}
	
	public void setCurrentLocale(Locale locale) {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}
	
	public Locale getCurrentLocale() {
		return FacesContext.getCurrentInstance().getViewRoot().getLocale();
	}
	
	public void invalidateSession() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

}
