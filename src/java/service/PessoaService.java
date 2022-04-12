/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.CidadeDao;
import dao.PessoaDao;
import domain.Cidade;
import domain.Pessoa;
import domain.Usuario;
import java.util.List;

/**
 *
 * @author wander
 */
public class PessoaService {
    
    private PessoaDao pessoaDao;
    
    public PessoaService() {
        // TODO: Construtor padrão
        pessoaDao = new PessoaDao();
    }
    
    public void inserir(Pessoa pessoa) {
        pessoaDao.insert(pessoa);
    }
    
    public void editar(Pessoa pessoa) {
        pessoaDao.update(pessoa);
    }
    
    public List<Pessoa> getTodasPessoas() {
        return pessoaDao.findAll();
    }
    
    public void excluir(Pessoa pessoa) {
        pessoaDao.delete(pessoa);
    }
    
    public List<Pessoa> listarPessoas(Usuario usuario) {
        return pessoaDao.findByUsuario(usuario);
    }
}
