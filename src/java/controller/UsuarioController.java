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
import service.UsuarioService;

/**
 *
 * @author wander
 */
@ManagedBean(name = "usuarioMB")
@SessionScoped
public class UsuarioController implements Serializable {
    
    private UsuarioService usuarioService;
    private PessoaService pessoaService;
    private Usuario usuario;
    
    public UsuarioController () {
        usuarioService = new UsuarioService();
        pessoaService = new PessoaService();
        usuario = new Usuario();
    }
       
    public String novo() { // ir para a página para inserir uma nova cidade  
        this.usuario = new Usuario();
        return "novo.xhtml";
    }
    
    public String inserir() { // inserir uma nova usuario no Banco de Dados
        usuarioService.inserir(usuario);
        return "listar.xhtml?faces-redirect=true";
    }
   
    
    public String atualizar() {
        usuarioService.editar(usuario);
        return "listar.xhtml?faces-redirect=true";
    }
    
    public List<Usuario> getTodosUsuarios() {
        return usuarioService.getTodosUsuarios();
    }
    
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public String excluir(Usuario usuario) {
        usuarioService.excluir(usuario);
        
        return "listar.xhtml?faces-redirect=true";
    }
    
    public void inicializarHibernate() {
        usuarioService.inicializarHibernate();
    }
    
    public String autenticar() {
        return "index.xhtml?faces-redirect=true";
    }
    
}
