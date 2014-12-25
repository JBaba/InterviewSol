/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stakeoverflow.manyToOne;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Naimish
 */
@Entity
@Table(name = "USERTAB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usertab.findAll", query = "SELECT u FROM Usertab u"),
    @NamedQuery(name = "Usertab.findByIdnum", query = "SELECT u FROM Usertab u WHERE u.idnum = :idnum"),
    @NamedQuery(name = "Usertab.findByIdkey", query = "SELECT u FROM Usertab u WHERE u.idkey = :idkey")})
public class Usertab implements Serializable {
    private static final long serialVersionUID = 1L;
    @Lob
    @Column(name = "SNAME")
    private String sname;
    @Column(name = "IDNUM")
    private Integer idnum;
    @Id
    @Basic(optional = false)
    @Column(name = "IDKEY")
    private Integer idkey;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SNAME")
    private Usertab2 owner;

    public Usertab() {
    }

    public Usertab2 getOwner() {
        return owner;
    }

    public void setOwner(Usertab2 owner) {
        this.owner = owner;
    }

    public Usertab(Integer idkey) {
        this.idkey = idkey;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getIdnum() {
        return idnum;
    }

    public void setIdnum(Integer idnum) {
        this.idnum = idnum;
    }

    public Integer getIdkey() {
        return idkey;
    }

    public void setIdkey(Integer idkey) {
        this.idkey = idkey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkey != null ? idkey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usertab)) {
            return false;
        }
        Usertab other = (Usertab) object;
        if ((this.idkey == null && other.idkey != null) || (this.idkey != null && !this.idkey.equals(other.idkey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stakeoverflow.manyToOne.Usertab[ idkey=" + idkey + " ]";
    }
    
}
