/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CidadeDao;
import domain.Cidade;
import domain.Conta;
import domain.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import service.CidadeService;
import service.ContaService;

/**
 *
 * @author wander
 */
@ManagedBean(name = "contaMB")
@SessionScoped
public class ContaController implements Serializable {
    
    private ContaService contaService;
    private Conta conta;
    //private CidadeLogin cidadeLogin
    
    public ContaController () {
        contaService = new ContaService();
        this.conta = new Conta();
    }
    
    public String novo() { // ir para a página para inserir uma nova cidade  
        this.conta = new Conta();
        return "novo.xhtml";
    }
    
    public String inserir() { // inserir uma nova conta no Banco de Dados
        this.conta = new Conta();
        contaService.inserir(conta);
        return "novo.xhtml?faces-redirect=true";
    }
    
    public String movimentar(Conta conta) { 
        this.conta = conta;     
        return "editar.xhtml?faces-redirect=true";
    }
    
    public String atualizar() {
        contaService.editar(conta);
        return "listar.xhtml?faces-redirect=true";
    }
    
    public List<Conta> getTodasContas() {
        return contaService.getTodasContas();
    }
    
    public Conta getConta() {
        return this.conta;
    }
    
    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    
    public String excluir(Conta conta) {
        contaService.excluir(conta);
        
        return "listar.xhtml?faces-redirect=true";
    }
}
