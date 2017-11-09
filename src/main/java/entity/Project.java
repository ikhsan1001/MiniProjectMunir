/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "Project")
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")
    , @NamedQuery(name = "Project.findByNo", query = "SELECT p FROM Project p WHERE p.no = :no")
    , @NamedQuery(name = "Project.findByProject", query = "SELECT p FROM Project p WHERE p.project = :project")
    , @NamedQuery(name = "Project.findByKantor", query = "SELECT p FROM Project p WHERE p.kantor = :kantor")
    , @NamedQuery(name = "Project.findByTransport", query = "SELECT p FROM Project p WHERE p.transport = :transport")
    , @NamedQuery(name = "Project.findByCuti", query = "SELECT p FROM Project p WHERE p.cuti = :cuti")
    , @NamedQuery(name = "Project.findBySakit", query = "SELECT p FROM Project p WHERE p.sakit = :sakit")
    , @NamedQuery(name = "Project.findByTelat", query = "SELECT p FROM Project p WHERE p.telat = :telat")
    , @NamedQuery(name = "Project.findByReward", query = "SELECT p FROM Project p WHERE p.reward = :reward")
    , @NamedQuery(name = "Project.findByLembur", query = "SELECT p FROM Project p WHERE p.lembur = :lembur")
    , @NamedQuery(name = "Project.findByTipeClaim", query = "SELECT p FROM Project p WHERE p.tipeClaim = :tipeClaim")
    , @NamedQuery(name = "Project.findByJumlah", query = "SELECT p FROM Project p WHERE p.jumlah = :jumlah")})
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "No")
    private Integer no;
    @Size(max = 50)
    @Column(name = "Project")
    private String project;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Kantor")
    private Double kantor;
    @Column(name = "Transport")
    private Double transport;
    @Column(name = "Cuti")
    private Double cuti;
    @Column(name = "Sakit")
    private Double sakit;
    @Column(name = "Telat")
    private Double telat;
    @Column(name = "Reward")
    private Double reward;
    @Column(name = "Lembur")
    private Double lembur;
    @Size(max = 50)
    @Column(name = "Tipe_Claim")
    private String tipeClaim;
    @Column(name = "Jumlah")
    private Double jumlah;
    @JoinColumn(name = "No_Karyawan", referencedColumnName = "No")
    @ManyToOne
    private Karyawan noKaryawan;

    public Project() {
    }

    public Project(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Double getKantor() {
        return kantor;
    }

    public void setKantor(Double kantor) {
        this.kantor = kantor;
    }

    public Double getTransport() {
        return transport;
    }

    public void setTransport(Double transport) {
        this.transport = transport;
    }

    public Double getCuti() {
        return cuti;
    }

    public void setCuti(Double cuti) {
        this.cuti = cuti;
    }

    public Double getSakit() {
        return sakit;
    }

    public void setSakit(Double sakit) {
        this.sakit = sakit;
    }

    public Double getTelat() {
        return telat;
    }

    public void setTelat(Double telat) {
        this.telat = telat;
    }

    public Double getReward() {
        return reward;
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }

    public Double getLembur() {
        return lembur;
    }

    public void setLembur(Double lembur) {
        this.lembur = lembur;
    }

    public String getTipeClaim() {
        return tipeClaim;
    }

    public void setTipeClaim(String tipeClaim) {
        this.tipeClaim = tipeClaim;
    }

    public Double getJumlah() {
        return jumlah;
    }

    public void setJumlah(Double jumlah) {
        this.jumlah = jumlah;
    }

    public Karyawan getNoKaryawan() {
        return noKaryawan;
    }

    public void setNoKaryawan(Karyawan noKaryawan) {
        this.noKaryawan = noKaryawan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Project[ no=" + no + " ]";
    }
    
}
