package managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.User;
import util.JsfUtil;

@ManagedBean(name="acessMBean")
@SessionScoped
public class AcessMBean {
	
	private User userLogged;
	
	private String login;
	
	private String password;
	
	public AcessMBean(){}
	
	public String logon(){
		return null;
	}

	public String logout(){
		JsfUtil.getInstanse().invalidateSession();
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
