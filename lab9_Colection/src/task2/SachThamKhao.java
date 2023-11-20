package task2;

import java.util.List;

public class SachThamKhao extends AnPham {
	private String linhVuc;
	private List<ChuongSach> dsChuong;

	public SachThamKhao(String tieuDe, int soTrang, int namXuatBan, String tacGia, double giaTien, String linhVuc,
			List<ChuongSach> dsChuong) {
		super(tieuDe, soTrang, namXuatBan, tacGia, giaTien);
		this.linhVuc = linhVuc;
		this.dsChuong = dsChuong;
	}

	public String getLinhVuc() {
		return linhVuc;
	}

	public List<ChuongSach> getChuongSachList() {
		return dsChuong;
	}

	@Override
	public String xacDinhLoaiAnPham() {
		return "Sach Tham Khao";
	}

	@Override
	public boolean laTapChi() {
		return false;
	}

	@Override
	public int soChuongNhieuNhat() {
		int soTrangMax = Integer.MIN_VALUE;
		for (ChuongSach chuong : dsChuong) {
			if (chuong.getSoTrang() > soTrangMax) {
				soTrangMax = chuong.getSoTrang();
			}
		}
		return soTrangMax;
	}

	@Override
	public boolean cungLoaiVaTacGia(AnPham anPham) {
		return anPham instanceof SachThamKhao && this.getTacGia().equals(anPham.getTacGia());
	}

	@Override
	public boolean thoiGianXuatBanCachDay(int nam) {
		return (2021 - this.getNamXuatBan()) >= nam;
	}


	@Override
	public boolean timTenTapChi(String title) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addChuongSach(ChuongSach cs) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "SachThamKhao{" + "linhVuc=" + linhVuc + '\'' + ", dsChuongSach=" + dsChuong + ", tieuDe=" + tieuDe
				+ '\'' + ", soTrang=" + soTrang + ", namXuatBan=" + namXuatBan + ", tacGia=" + tacGia + '\''
				+ ", giaTien=" + giaTien + '}' ;
	}
}
