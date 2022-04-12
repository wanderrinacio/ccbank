/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Pessoa;
import domain.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import service.PessoaService;

/**
 *
 * @author wander
 */
@ManagedBean(name = "pessoaMB")
@SessionScoped
public class PessoaController implements Serializable {
    
    private PessoaService pessoaService;
    private Pessoa pessoa;
    private List<Pessoa> pessoas;
    
    public PessoaController () {
        pessoaService = new PessoaService();
        this.pessoa = new Pessoa();
    }
    
   
    public String novo() { // ir para a página para inserir uma nova cidade  
        this.pessoa = new Pessoa();
        return "novo.xhtml";
    }
    
    public String inserir() { // inserir uma nova pessoa no Banco de Dados
        pessoaService.inserir(pessoa);
        return "listar.xhtml?faces-redirect=true";
    }
    
    public String movimentar(Pessoa pessoa) { 
        this.pessoa = pessoa;     
        return "editar.xhtml?faces-redirect=true";
    }
    
    public String atualizar() {
        pessoaService.editar(pessoa);
        return "listar.xhtml?faces-redirect=true";
    }
    
    public List<Pessoa> getListaPessoas(Usuario usuario) {
        if (null == usuario) {
            return getTodasPessoas();
        } else {
            return pessoaService.listarPessoas(usuario);
        }
    }
    
    private List<Pessoa> getTodasPessoas() {
        return pessoaService.getTodasPessoas();
    }
    
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    
    public String excluir(Pessoa pessoa) {
        pessoaService.excluir(pessoa);
        
        return "listar.xhtml?faces-redirect=true";
    }
    
    public String visualizarPessoas(Usuario usuario) {        
        return "../pessoa/listar.xhtml?faces-redirect=true";      
    }
}
