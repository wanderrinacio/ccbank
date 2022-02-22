/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Grego
 */
@Entity
@Table(name = "historico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historico.findAll", query = "SELECT h FROM Historico h")
    , @NamedQuery(name = "Historico.findById", query = "SELECT h FROM Historico h WHERE h.id = :id")
    , @NamedQuery(name = "Historico.findByOperacao", query = "SELECT h FROM Historico h WHERE h.operacao = :operacao")
    , @NamedQuery(name = "Historico.findByTipoMovimento", query = "SELECT h FROM Historico h WHERE h.tipoMovimento = :tipoMovimento")
    , @NamedQuery(name = "Historico.findByDataHora", query = "SELECT h FROM Historico h WHERE h.dataHora = :dataHora")
    , @NamedQuery(name = "Historico.findByValor", query = "SELECT h FROM Historico h WHERE h.valor = :valor")
    , @NamedQuery(name = "Historico.findByObservacao", query = "SELECT h FROM Historico h WHERE h.observacao = :observacao")})
public class Historico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "operacao")
    private String operacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoMovimento")
    private String tipoMovimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Size(max = 500)
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Conta contaId;

    public Historico() {
    }

    public Historico(Integer id) {
        this.id = id;
    }

    public Historico(Integer id, String operacao, String tipoMovimento, Date dataHora, double valor) {
        this.id = id;
        this.operacao = operacao;
        this.tipoMovimento = tipoMovimento;
        this.dataHora = dataHora;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Conta getContaId() {
        return contaId;
    }

    public void setContaId(Conta contaId) {
        this.contaId = contaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historico)) {
            return false;
        }
        Historico other = (Historico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Historico[ id=" + id + " ]";
    }
    
}
