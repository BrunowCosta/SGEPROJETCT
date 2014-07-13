package managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.ocpsoft.rewrite.annotation.Join;

import util.JsfUtil;

import com.modern.ejb.model.User;

@ManagedBean(name="acessMBean")
@SessionScoped
@Join(path="/login.html", to="/resources/view/public/login.xhtml")
public class AcessMBean {
	
	private User userLogged;
	
	private String login;
	
	private String password;
	
	public AcessMBean() {}
	
	public String logon() {
		User user = new User();
		this.setUserLogged(user);
		return null;
	}

	public String logout() {
		JsfUtil.getInstanse().invalidateSession();
		return "index";
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
