package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.KaryawanDao;
import entity.Karyawan;
@Service("karyawanSvc")
public class KaryawanSvcImpt implements KaryawanSvc {

	@Autowired
	KaryawanDao karyawanDao;
	
	@Override
	public Karyawan find(String nama) {
		
		return karyawanDao.find(nama);
	}

}
