/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.CidadeDao;
import dao.UsuarioDao;
import domain.Cidade;
import domain.Usuario;
import java.util.List;

/**
 *
 * @author wander
 */
public class UsuarioService {
    
    private UsuarioDao usuarioDao;
    
    public UsuarioService() {
        // TODO: Construtor padrão
        usuarioDao = new UsuarioDao();
    }
    
    public void inserir(Usuario usuario) {
        usuarioDao.insert(usuario);
    }
    
    public void editar(Usuario usuario) {
        usuarioDao.update(usuario);
    }
    
    public List<Usuario> getTodosUsuarios() {
        return usuarioDao.findAll();
    }
    
    public void excluir(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
    
    public void inicializarHibernate() {
        usuarioDao.inicializarHibernate();
    }
}
