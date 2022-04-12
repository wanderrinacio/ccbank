/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.sun.faces.el.ELUtils;
import domain.Cidade;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.faces.annotation.FacesConfig;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import service.CidadeService;
import utils.UtilMensagens;

/**
 *
 * @author wander
 */
@ManagedBean(name = "cidadeMB")
@SessionScoped
public class CidadeController implements Serializable {
    
    private CidadeService cidadeService;
    private List<Cidade> listaCidades;
    private Cidade cidade;
    
    public CidadeController () {
        cidadeService = new CidadeService();
        getTodasCidades();
        this.cidade = new Cidade();
    }
   
    
    public String novo() { // ir para a página para inserir uma nova cidade  
        this.cidade = new Cidade();
        return "novo.xhtml";
    }
    
    public String inserir() { // inserir uma nova cidade no Banco de Dados        
        if (cidadeService.inserir(cidade)) {      
            getTodasCidades();
            UtilMensagens.mensagemSucesso("Sucesso", "Cidade incluída com Sucesso");
            return "listar.xhtml?faces-redirect=true";
        } else {
            UtilMensagens.mensagemErro("Erro", "Cidade não foi incluída");
            return null;
        }      
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
        listaCidades = cidadeService.getTodasCidades();
        return listaCidades;
    }
    
    public Cidade getCidade() {
        return this.cidade;
    }
    
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    
    public String excluir(Cidade cidade) {
        cidadeService.excluir(cidade);
        listaCidades = getTodasCidades();
        return "listar.xhtml?faces-redirect=true";
    }
    
    public List<Cidade> getCidades() {
        return listaCidades;
    }
}
