/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vivas.demo.primefaces.controller;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import vn.vivas.demo.primefaces.repository.DataBaseUtil;

/**
 *
 * @author HAU
 */
@ManagedBean(name="login")
@SessionScoped
public class LoginController implements Serializable{
    private String username;
    private String password;
    private DataBaseUtil baseUtil = new DataBaseUtil();
    public String login(){
        if(baseUtil.login(username, password)){
            return "home.xhtml?faces-redirect=true";
        } else {
            RequestContext.getCurrentInstance().update("msg");
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Login error: username/pass not correct!"));
            return "";
        }
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
