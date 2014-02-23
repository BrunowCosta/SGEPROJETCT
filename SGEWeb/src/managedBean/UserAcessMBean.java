package managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.User;

@ManagedBean(name="userAcessMBean")
@SessionScoped
public class UserAcessMBean {
	
	private User userLogged;
	
	private String login;
	
	private String password;
	
	public UserAcessMBean(){}
	
	public String logon(){
		return null;
	}

	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return null;
	}
	
	public boolean isLogged(){
		if(userLogged != null)
			return true;
		return false;
	}

	public User getUserLogged() {
		return userLogged;
	}

	public void setUserLogged(User userLogged) {
		this.userLogged = userLogged;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
