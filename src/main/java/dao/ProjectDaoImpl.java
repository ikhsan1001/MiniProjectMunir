package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.ProjectDao;
import entity.Karyawan;
import entity.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao{

	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private KaryawanDao karyawanDao;
	
	@Override
	public void save(Project project) {
		// TODO Auto-generated method stub
		String query="insert into project (no,project,kantor,transport,cuti,sakit,telat,reward,lembur,tipeclaim,jumlah,nokaryawan) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			con=dataSource.getConnection();
			ps=con.prepareStatement(query);
			
			ps.setInt(1, project.getNo());
			ps.setString(2, project.getProject());
			ps.setDouble(3, project.getKantor());
			ps.setDouble(4, project.getTransport());
			ps.setDouble(5, project.getCuti());
			ps.setDouble(6, project.getSakit());
			ps.setDouble(7, project.getTelat());
			ps.setDouble(8, project.getReward());
			ps.setDouble(9, project.getLembur());
			ps.setString(10, project.getTipeClaim());
			ps.setDouble(11, project.getJumlah());
			ps.setString(12, project.getNoKaryawan().getNik());
			
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Simpan Sukses");
			}else{
				System.out.println("Simpan Gagal");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Project project) {
		// TODO Auto-generated method stub
		String query="update project set project=?,kantor=?,transport=?,cuti=?,sakit=?,telat=?,reward=?,lembur=?,tipeclaim=?,jumlah=?,nokaryawan=? where no=?";
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			con=dataSource.getConnection();
			ps=con.prepareStatement(query);
			
			
			ps.setString(1, project.getProject());
			ps.setDouble(2, project.getKantor());
			ps.setDouble(3, project.getTransport());
			ps.setDouble(4, project.getCuti());
			ps.setDouble(5, project.getSakit());
			ps.setDouble(6, project.getTelat());
			ps.setDouble(7, project.getReward());
			ps.setDouble(8, project.getLembur());
			ps.setString(9, project.getTipeClaim());
			ps.setDouble(10, project.getJumlah());
			ps.setString(11, project.getNoKaryawan().getNik());
			ps.setInt(12, project.getNo());
			
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Update Sukses");
			}else{
				System.out.println("Update Gagal");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(String noProject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Project> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project findOne(String noProject) {
		// TODO Auto-generated method stub
String query="select * from project where no='"+noProject+"'";
		
		
		
		Project project=new Project();
		Karyawan karyawan= new Karyawan();
		

		String kodeKaryawan;
		Connection conn= null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		
		try {
			conn= dataSource.getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()){

				project.setNo(rs.getInt("no"));
				project.setProject(rs.getString("project"));
				project.setKantor(rs.getDouble("kantor"));
				project.setTransport(rs.getDouble("transport"));
				project.setCuti(rs.getDouble("cuti"));
				project.setSakit(rs.getDouble("sakit"));
				project.setTelat(rs.getDouble("telat"));
				project.setReward(rs.getDouble("reward"));
				project.setLembur(rs.getDouble("lembur"));
				project.setTipeClaim(rs.getString("tipeclaim"));
				project.setJumlah(rs.getDouble("jumlah"));
				
				kodeKaryawan=(rs.getString("nokaryawan"));
				karyawan= karyawanDao.find(kodeKaryawan);
				project.setNoKaryawan(karyawan);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return project;
	}

}
