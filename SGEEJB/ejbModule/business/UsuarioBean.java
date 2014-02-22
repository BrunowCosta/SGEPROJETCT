package business;

import javax.ejb.Stateful;

@Stateful(mappedName="ejb.sge.bean/usuario")
public class UsuarioBean implements UsuarioRemote{

	@Override
	public String teste() {
		return "Hellow World";
	}
	
	

}