package br.com.sistema.ldap.menagedbean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.ServletException;

@RequestScoped
@ManagedBean
public class Login extends ManagedBeanAbstract {

	private String usuario;
	
	private String senha;
	
	public void logar() throws ServletException, IOException{		
		getRequest().login(getUsuario(), getSenha());		
		
		if(getRequest().authenticate(getResponse())){
			System.out.println("## - Autenticado");
			getExternalContext().redirect("/restrita/protegido.xhtml");
		}else {
			System.out.println("## - Não Autenticado");
		}		
		
	}	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	
}
