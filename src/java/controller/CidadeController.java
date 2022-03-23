/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CidadeDao;
import domain.Cidade;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author wander
 */
@ManagedBean(name = "cidadeMB")
@SessionScoped
public class CidadeController implements Serializable {
    
    private CidadeDao cidadeDao;
    
    public CidadeController () {
        //cidadeDao = new CidadeDao();
    }
    
    public String novo(){        
        return "novo.xhtml";
    }
    
    public String inserir(Cidade cidade){
        //cidadeDao.insert(cidade);
        System.out.println(cidade.getNome());
        return "index.xhtml";
    }
    
}
