package managedBean;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import util.JsfUtil;
import util.MessageBundleUtil;

@ManagedBean(name="internationalizationMBean")
@SessionScoped
public class InternationalizationMBean {
	
	private Map<String,Locale> supportedCountries;
	
	private String locale;
	
	public InternationalizationMBean() {
		this.chargeSupportedCountries();
		this.locale = JsfUtil.getInstanse().getCurrentLocale().toString();
	}

	public void changeLocale() {
//		String newLocaleValue = e.getNewValue().toString();
		String newLocaleValue = this.locale;
		for (Map.Entry<String, Locale> locale : this.supportedCountries.entrySet()) {
		    if(locale.getValue().toString().equals(newLocaleValue)){
		    	JsfUtil.getInstanse().setCurrentLocale(locale.getValue());
		   	 	break;
		    }
		}
		this.chargeSupportedCountries();
	}
	
	//Defines locales supported by the app.
	private void chargeSupportedCountries() {
		this.supportedCountries = new HashMap<String,Locale>();
		this.supportedCountries.put(MessageBundleUtil.getInstanse().getValue("locale.brazil"), Locale.getDefault());
		this.supportedCountries.put(MessageBundleUtil.getInstanse().getValue("locale.uk"), Locale.UK);
		this.supportedCountries.put(MessageBundleUtil.getInstanse().getValue("locale.ger"), Locale.GERMAN);
	}
		
	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Map<String,Locale> getSupportedCountries() {
		return supportedCountries;
	}

	public void setSupportedCountries(Map<String,Locale> supportedCountries) {
		this.supportedCountries = supportedCountries;
	}
	
}