package br.com.sistema.ldap.menagedbean;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class ManagedBeanAbstract {
	
	
	public String getDadosLogin() {		
		String login = getExternalContext().getUserPrincipal().getName();

		if(getIsR()){
			login += " | APLICATIVO-R ";
		}
		if(getIsX()){
			login += " | APLICATIVO-X ";
		}		
		if(getIsY()){
			login += " | APLICATIVO-Y ";
		}
		return login.toUpperCase();
	}
	
	public Boolean getIsR() {
		return getExternalContext().isUserInRole("APLICATIVO-R");
	}

	public Boolean getIsX() {
		return getExternalContext().isUserInRole("APLICATIVO-X");
	}

	public Boolean getIsY() {
		return getExternalContext().isUserInRole("APLICATIVO-Y");
	}

	public void logout() throws ServletException, IOException{
		 getRequest().logout();
		 getExternalContext().redirect("../index.xhtml");
	} 	
		
	protected HttpSession getSession() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return (HttpSession) fc.getExternalContext().getSession(false);
	}
		
	protected ExternalContext getExternalContext() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext();
	}
	
	protected HttpServletRequest getRequest() {
		FacesContext context = FacesContext.getCurrentInstance();
	    return (HttpServletRequest) context.getExternalContext().getRequest();
	}
	
	protected HttpServletResponse getResponse() {
		FacesContext context = FacesContext.getCurrentInstance();
	    return (HttpServletResponse) context.getExternalContext().getResponse();
	}
		
}
