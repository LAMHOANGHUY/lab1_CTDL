package task2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Lớp cha chứa thông tin chung của ấn phẩm
public abstract class AnPham {
	protected String tieuDe;
	protected int soTrang;
	protected int namXuatBan;
	protected String tacGia;
	protected double giaTien;

	public AnPham(String tieuDe, int soTrang, int namXuatBan, String tacGia, double giaTien) {
		this.tieuDe = tieuDe;
		this.soTrang = soTrang;
		this.namXuatBan = namXuatBan;
		this.tacGia = tacGia;
		this.giaTien = giaTien;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public String getTacGia() {
		return tacGia;
	}

	public double getGiaTien() {
		return giaTien;
	}

	public abstract String xacDinhLoaiAnPham();

	// Phương thức trừu tượng để kiểm tra loại của ấn phẩm
	public abstract boolean laTapChi();

	// Phương thức trừu tượng để kiểm tra cùng loại và cùng tác giả
	public abstract boolean cungLoaiVaTacGia(AnPham anPham);

	// Phương thức trừu tượng để kiểm tra thời gian xuất bản cách đây bao nhiêu năm
	public abstract boolean thoiGianXuatBanCachDay(int nam);


	public abstract int soChuongNhieuNhat();

	public abstract boolean timTenTapChi(String title);

	public abstract void addChuongSach(ChuongSach cs);

	@Override
	public String toString() {
		return "AnPham [tieuDe=" + tieuDe + ", soTrang=" + soTrang + ", namXuatBan=" + namXuatBan + ", tacGia=" + tacGia
				+ ", giaTien=" + giaTien + "]";
	}

}

//	public boolean coThoiGianXuatBanCachDay(int namHienTai, int soNam) {
//		return (namHienTai - namXuatBan) >= soNam;
//	}

//	// Phương thức kiểm tra hai ấn phẩm có cùng loại và cùng tác giả hay không
//	public boolean kiemTraCungLoaiVaTacGia(AnPham anPham) {
//		return this.xacDinhLoaiAnPham().equals(anPham.xacDinhLoaiAnPham()) && this.tacGia.equals(anPham.tacGia);
//	}
//	// Phương thức tính tổng tiền của ấn phẩm