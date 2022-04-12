/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.CidadeDao;
import dao.ContaDao;
import domain.Cidade;
import domain.Conta;
import java.util.List;

/**
 *
 * @author wander
 */
public class ContaService {
    
    private ContaDao contaDao;
    
    public ContaService() {
        // TODO: Construtor padrão
        contaDao = new ContaDao();
    }
    
    public void inserir(Conta conta) {
        contaDao.insert(conta);
    }
    
    public void editar(Conta conta) {
        contaDao.update(conta);
    }
    
    public List<Conta> getTodasContas() {
        return contaDao.findAll();
    }
    
    public void excluir(Conta conta) {
        contaDao.delete(conta);
    }
}
