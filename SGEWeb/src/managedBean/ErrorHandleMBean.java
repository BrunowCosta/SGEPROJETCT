package managedBean;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="errorHandleMBean")
@RequestScoped
public class ErrorHandleMBean {
	
	//TODO verificar o ciclo de vida jsf, para ver se isso é viavel.
	Map<String, Object> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
	
	public Integer getStatusCode() {
		return (Integer) requestMap.get("javax.servlet.error.status_code");
	}
	
	public String getMessage() {
		return (String) requestMap.get("javax.servlet.error.message");
	}
	
	public String getExpectionType() {
		return requestMap.get("javax.servlet.error.exception_type").toString();
	}
	
	public String getExpection() {
		return requestMap.get("javax.servlet.error.exception").toString();
	}
	
	public String getRequestURI() {
		return (String) requestMap.get("javax.servlet.error.request_uri");
	}
	
	public String getServletName() {
		return (String) requestMap.get("javax.servlet.error.servlet_name");
	}


}
