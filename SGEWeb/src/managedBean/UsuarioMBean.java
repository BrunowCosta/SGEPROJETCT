package managedBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import business.UsuarioRemote;

@ManagedBean(name="usuarioMBean")
@SessionScoped
public class UsuarioMBean {
	
	@EJB
	private UsuarioRemote remoteBean;
	
	public UsuarioMBean(){}
	
	public void teste() {
		System.out.println(remoteBean.teste());
	}
	
}
