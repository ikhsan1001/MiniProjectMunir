package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Karyawan;
@Repository
public class KaryawanDaoImpt implements KaryawanDao {
	
	@Autowired
	private DataSource dataSource;

	@Override
	public Karyawan find(String nama) {
		Karyawan karyawan = new Karyawan();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select * from Karyawan where Nama='"+nama+"'";
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				karyawan.setNo(rs.getInt("No"));
				karyawan.setNama(rs.getString("Nama"));
				karyawan.setJenisKelamin(rs.getString("JENIS_KELAMIN"));
				karyawan.setNik(rs.getString("NIK"));
				karyawan.setNoAbsen(rs.getString("No_ABSEN"));
				karyawan.setNoRek(rs.getString("NO_REK"));
				karyawan.setTempat(rs.getString("TEMPAT"));
				
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return karyawan;
	
	}

}
