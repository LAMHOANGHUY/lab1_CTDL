package task2;

import java.util.Objects;

public class TapChi extends AnPham {
	private String tenTapChi;

	public TapChi(String tieuDe, int soTrang, int namXuatBan, String tacGia, double giaTien, String tenTapChi) {
		super(tieuDe, soTrang, namXuatBan, tacGia, giaTien);
		this.tenTapChi = tenTapChi;
	}

	public String getTenTapChi() {
		return tenTapChi;
	}

	public void setTen(String ten) {
		this.tenTapChi = ten;
	}

	@Override
	public String xacDinhLoaiAnPham() {
		return "Tạp chí";
	}

	@Override
	public boolean laTapChi() {
		return true;
	}

	@Override
	public boolean cungLoaiVaTacGia(AnPham anPham) {
		return anPham instanceof TapChi && this.getTacGia().equals(anPham.getTacGia());
	}

	@Override
	public boolean thoiGianXuatBanCachDay(int nam) {
		return (2021 - this.getNamXuatBan()) >= nam;
	}
	
	@Override
	public int soChuongNhieuNhat() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean timTenTapChi(String title) {
		return tenTapChi.equals(title);
	}
	
	@Override
	public void addChuongSach(ChuongSach cs) {
		// TODO Auto-generated method stub
		
	}
	public String toString() {
        return "TapChi{" +
                "tenTapChi='" + tenTapChi + '\'' +
                ", tieuDe='" + tieuDe + '\'' +
                ", soTrang=" + soTrang +
                ", namXuatBan=" + namXuatBan +
                ", tacGia='" + tacGia + '\'' +
                ", giaTien=" + giaTien +
                '}';
    }




}
