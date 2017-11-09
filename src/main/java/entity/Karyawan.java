/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "Karyawan")
@NamedQueries({
    @NamedQuery(name = "Karyawan.findAll", query = "SELECT k FROM Karyawan k")
    , @NamedQuery(name = "Karyawan.findByNo", query = "SELECT k FROM Karyawan k WHERE k.no = :no")
    , @NamedQuery(name = "Karyawan.findByNama", query = "SELECT k FROM Karyawan k WHERE k.nama = :nama")
    , @NamedQuery(name = "Karyawan.findByJenisKelamin", query = "SELECT k FROM Karyawan k WHERE k.jenisKelamin = :jenisKelamin")
    , @NamedQuery(name = "Karyawan.findByTempat", query = "SELECT k FROM Karyawan k WHERE k.tempat = :tempat")
    , @NamedQuery(name = "Karyawan.findByNik", query = "SELECT k FROM Karyawan k WHERE k.nik = :nik")
    , @NamedQuery(name = "Karyawan.findByNoAbsen", query = "SELECT k FROM Karyawan k WHERE k.noAbsen = :noAbsen")
    , @NamedQuery(name = "Karyawan.findByNoRek", query = "SELECT k FROM Karyawan k WHERE k.noRek = :noRek")})
public class Karyawan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "No")
    private Integer no;
    @Size(max = 50)
    @Column(name = "Nama")
    private String nama;
    @Size(max = 50)
    @Column(name = "Jenis_Kelamin")
    private String jenisKelamin;
    @Size(max = 50)
    @Column(name = "Tempat")
    private String tempat;
    @Size(max = 50)
    @Column(name = "NIK")
    private String nik;
    @Size(max = 50)
    @Column(name = "No_Absen")
    private String noAbsen;
    @Size(max = 50)
    @Column(name = "No_Rek")
    private String noRek;
    @OneToMany(mappedBy = "noKaryawan")
    private List<Project> projectList;

    public Karyawan() {
    }

    public Karyawan(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNoAbsen() {
        return noAbsen;
    }

    public void setNoAbsen(String noAbsen) {
        this.noAbsen = noAbsen;
    }

    public String getNoRek() {
        return noRek;
    }

    public void setNoRek(String noRek) {
        this.noRek = noRek;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
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
        if (!(object instanceof Karyawan)) {
            return false;
        }
        Karyawan other = (Karyawan) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Karyawan[ no=" + no + " ]";
    }
    
}
