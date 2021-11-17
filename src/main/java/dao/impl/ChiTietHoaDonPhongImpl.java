package dao.impl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityTransaction;

import dao.AbstractDao;
import dao.ChiTietHoaDonPhongDao;
import model.ChiTietHoaDonPhong;

public class ChiTietHoaDonPhongImpl extends AbstractDao implements ChiTietHoaDonPhongDao {

	public ChiTietHoaDonPhongImpl() throws RemoteException {
		super();
	}

	@Override
	public List<ChiTietHoaDonPhong> getListChiTietHDPByDate(Date tuNgay, Date denNgay) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChiTietHoaDonPhong> getListChiTietHDPByMaHD(int maHD) throws RemoteException {
		String sql = "select * from ChiTietHoaDonPhong where maHD = " + maHD;
		return (List<ChiTietHoaDonPhong>) getList(sql, ChiTietHoaDonPhong.class);
	}

	@Override
	public boolean themChiTietHDP(model.ChiTietHoaDonPhong cthdp) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		
		try {
			tr.begin();
			em.merge(cthdp.getHoaDonPhong());
			
			em.merge(cthdp.getPhong());
			em.persist(cthdp);
			tr.commit();

			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			
		}

		return false;
	}

	@Override
	public boolean xoaChiTietHDP(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean xoaChiTietHDPByMaHD(int maHD) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean capNhatChiTietHDP(ChiTietHoaDonPhongDao cthdp) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}