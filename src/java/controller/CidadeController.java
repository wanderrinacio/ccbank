/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CidadeDao;
import domain.Cidade;
import domain.Conta;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import service.CidadeService;

/**
 *
 * @author wander
 */
@ManagedBean(name = "cidadeMB")
@SessionScoped
public class CidadeController implements Serializable {
    
    private CidadeService cidadeService;
    private Cidade cidade;
    //private CidadeLogin cidadeLogin
    
    public CidadeController () {
        cidadeService = new CidadeService();
        this.cidade = new Cidade();
    }
    
    public String novo() { // ir para a página para inserir uma nova cidade  
        this.cidade = new Cidade();
        return "novo.xhtml";
    }
    
    public String inserir() { // inserir uma nova cidade no Banco de Dados
        this.cidade = new Cidade();
        cidadeService.inserir(cidade);
        return "novo.xhtml?faces-redirect=true";
    }
    
    public String editar(Cidade cidade) { 
        this.cidade = cidade;     
        return "editar.xhtml?faces-redirect=true";
    }
    
    public String atualizar() {
        cidadeService.editar(cidade);
        return "listar.xhtml?faces-redirect=true";
    }
    
    public List<Cidade> getTodasCidades() {
        return cidadeService.getTodasCidades();
    }
    
    public Cidade getCidade() {
        return this.cidade;
    }
    
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    
    public String excluir(Cidade cidade) {
        cidadeService.excluir(cidade);
        
        return "listar.xhtml?faces-redirect=true";
    }
}
