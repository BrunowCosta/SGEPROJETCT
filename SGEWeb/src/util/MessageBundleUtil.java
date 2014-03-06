package util;

import java.util.ResourceBundle;

public class MessageBundleUtil {
	
	private static MessageBundleUtil instance;
	
	public static MessageBundleUtil getInstanse(){
		if (instance == null)
			instance = new MessageBundleUtil();
		return instance;
	}
	
	private MessageBundleUtil() {}
	
	public ResourceBundle getResourceBundle() {
		return  ResourceBundle.getBundle("message.message", JsfUtil.getInstanse().getCurrentLocale());
	}
	
	public String getValue(String key) {
		String value = getResourceBundle().getString(key);
		return value;
	}
}
