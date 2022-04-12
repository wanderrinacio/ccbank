/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.CidadeDao;
import domain.Cidade;
import java.util.List;

/**
 *
 * @author wander
 */
public class CidadeService {
    
    private CidadeDao cidadeDao;
    
    public CidadeService() {
        // TODO: Construtor padrão
        cidadeDao = new CidadeDao();
    }
    
    public boolean inserir(Cidade cidade) {
       
        // verificar se a cidade e esta ja existe
        // se no existe, inserir no banco de dados e retornar a cidade com o codigo gerado
        // se existe, retornar erro de nao foi possivel inserir
        
        return cidadeDao.insert(cidade);
    }
    
    public void editar(Cidade cidade) {
        cidadeDao.update(cidade);
    }
    
    public List<Cidade> getTodasCidades() {
        return cidadeDao.findAll();
    }
    
    public void excluir(Cidade cidade) {
        cidadeDao.delete(cidade);
    }
}
