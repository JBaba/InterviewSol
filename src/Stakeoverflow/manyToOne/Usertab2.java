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
@Table(name = "USERTAB2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usertab2.findAll", query = "SELECT u FROM Usertab2 u"),
    @NamedQuery(name = "Usertab2.findByIdkey", query = "SELECT u FROM Usertab2 u WHERE u.idkey = :idkey")})
public class Usertab2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Lob
    @Column(name = "USERNAME")
    private String username;
    @Id
    @Basic(optional = false)
    @Column(name = "IDKEY")
    private Integer idkey;
   

    public Usertab2() {
    }

    public Usertab2(Integer idkey) {
        this.idkey = idkey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        if (!(object instanceof Usertab2)) {
            return false;
        }
        Usertab2 other = (Usertab2) object;
        if ((this.idkey == null && other.idkey != null) || (this.idkey != null && !this.idkey.equals(other.idkey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stakeoverflow.manyToOne.Usertab2[ idkey=" + idkey + " ]";
    }
    
}
