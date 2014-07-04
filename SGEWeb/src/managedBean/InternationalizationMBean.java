package managedBean;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import util.JsfUtil;

@ManagedBean(name="internationalizationMBean")
@SessionScoped
public class InternationalizationMBean {
	
	private static Map<String,Locale> supportedCountries;
	
	static {
		supportedCountries = new HashMap<String,Locale>();
		supportedCountries.put("Português - Brasil", Locale.getDefault());
		supportedCountries.put("English - UK", Locale.UK);
		supportedCountries.put("Deutsch", Locale.GERMAN);
		supportedCountries.put("Pусский", new Locale("ru"));
	}
	
	private String locale;
	
	public InternationalizationMBean() {
		this.locale = JsfUtil.getInstanse().getCurrentLocale().toString();
	}

	public String changeLocale() {
		for (Map.Entry<String, Locale> locale : supportedCountries.entrySet()) {
		    if(locale.getValue().toString().equals(this.locale)){
		    	JsfUtil.getInstanse().setCurrentLocale(locale.getValue());
		   	 	break;
		    }
		}
		return null;
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
	
}