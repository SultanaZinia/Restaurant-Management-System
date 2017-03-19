/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaresturentdesktopclient;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author siamzz
 */
@Entity
@Table(name = "USER_LOGIN", catalog = "", schema = "RESTURENT_MANAGEMENT")
@NamedQueries({
    @NamedQuery(name = "UserLogin_1.findAll", query = "SELECT u FROM UserLogin_1 u"),
    @NamedQuery(name = "UserLogin_1.findByUserId", query = "SELECT u FROM UserLogin_1 u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserLogin_1.findByUserName", query = "SELECT u FROM UserLogin_1 u WHERE u.userName = :userName"),
    @NamedQuery(name = "UserLogin_1.findByUserPassword", query = "SELECT u FROM UserLogin_1 u WHERE u.userPassword = :userPassword")})
public class UserLogin_1 implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private BigDecimal userId;
    @Basic(optional = false)
    @Column(name = "USER_NAME")
    private String userName;
    @Basic(optional = false)
    @Column(name = "USER_PASSWORD")
    private String userPassword;

    public UserLogin_1() {
    }

    public UserLogin_1(BigDecimal userId) {
        this.userId = userId;
    }

    public UserLogin_1(BigDecimal userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        BigDecimal oldUserId = this.userId;
        this.userId = userId;
        changeSupport.firePropertyChange("userId", oldUserId, userId);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        String oldUserName = this.userName;
        this.userName = userName;
        changeSupport.firePropertyChange("userName", oldUserName, userName);
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        String oldUserPassword = this.userPassword;
        this.userPassword = userPassword;
        changeSupport.firePropertyChange("userPassword", oldUserPassword, userPassword);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserLogin_1)) {
            return false;
        }
        UserLogin_1 other = (UserLogin_1) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaresturentdesktopclient.UserLogin_1[ userId=" + userId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
