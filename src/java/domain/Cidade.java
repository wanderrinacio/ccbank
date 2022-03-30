package domain;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="cidade")
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name="nome")
    @Size(min=3, max=255)
    private String nome;
    
    @NotNull
    @Column(name="uf")
    @Size(min=2, max=2)
    private String uf;
    
    public Cidade(){
    }

    public Cidade(Integer id, String nome, String uf) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    
    public boolean equals(Cidade c1) {
        return this.getNome().equals(c1.getNome()) && this.getUf().equals(c1.getUf());
    }
}
