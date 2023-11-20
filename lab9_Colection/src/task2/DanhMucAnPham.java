package task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhMucAnPham {
	private List<AnPham> dsAnPham;

	public DanhMucAnPham() {
		super();
		this.dsAnPham = new ArrayList<>();
	}

	public List<AnPham> getDsAnPham() {
		return dsAnPham;
	}

	// Phương thức thêm ấn phẩm vào danh sách
	public void themAnPham(AnPham anPham) {
		this.dsAnPham.add(anPham);
	}

	// Phương thức kiểm tra ấn phẩm là tạp chí và có thời gian xuất bản cách đây 10
	// năm hay không
	public void kiemTraTapChiThoiGianXuatBan() {
		for (AnPham anPham : dsAnPham) {
			if (anPham.laTapChi() && anPham.thoiGianXuatBanCachDay(10)) {
				System.out.println("Tap chi co thoi gian xuat ban cach day 10 nam: " + anPham.getTieuDe());
			}
		}
	}

	// Phương thức kiểm tra hai ấn phẩm có cùng loại và cùng tác giả hay không
	public void kiemTraCungLoaiVaTacGia(AnPham anPham1, AnPham anPham2) {
		if (anPham1.cungLoaiVaTacGia(anPham2)) {
			System.out.println("Hai an pham cung loai va cung tac gia.");
		} else {
			System.out.println("Hai an pham khong cung loai hoac khong cung tac gia.");
		}
	}

	public double tinhTongTien() {
		double tongTien = 0;
		for (AnPham a : dsAnPham) {
            tongTien += a.getGiaTien();
        }
		return tongTien;
	}

	public SachThamKhao timSachThamKhaoCoChuongNhieuNhat() {
		AnPham anPhamCoTrangNhieuNhat = null;
		int soTrangMax = 0;
		for (AnPham anPham : dsAnPham) {
			int soChuongNhieuNhat = anPham.soChuongNhieuNhat();
			if (soChuongNhieuNhat > soTrangMax) {
				soTrangMax = soChuongNhieuNhat;
				anPhamCoTrangNhieuNhat = anPham;
			}

		}
		return (SachThamKhao) anPhamCoTrangNhieuNhat;
	}

	public boolean timTapChi(TapChi tapChi) {
		for (AnPham anPham : dsAnPham) {
			if (anPham.xacDinhLoaiAnPham().equals("Tạp chí")) {
				// Nếu là tạp chí, kiểm tra tên
				if (((TapChi) anPham).getTenTapChi().equals(tapChi.getTenTapChi())) {
					return true;
				}
			}
		}
		return false;
	}

	public List<TapChi> tapChiXuatBanTrongNam(int namXuatBan) {
		List<TapChi> tapChiList = new ArrayList<>();

		for (AnPham anPham : dsAnPham) {
			if (anPham.xacDinhLoaiAnPham().equals("Tạp chí") && anPham.getNamXuatBan() == namXuatBan - 1) {
				tapChiList.add((TapChi) anPham);
			}
		}

		return tapChiList;
	}

	public void sapXepDSAnpham() {
		dsAnPham.sort((Comparator<? super AnPham>) new Comparator<AnPham>() {
			@Override
			public int compare(AnPham o1, AnPham o2) {
				int compare = o1.getTieuDe().compareTo(o2.getTieuDe());
				if (compare == 0) {
					compare = o2.getNamXuatBan() - o1.getNamXuatBan();
				}
				return compare;
			}
		});
	}

	public Map<Integer, Integer> thongKeAnPham() {
		Map<Integer, Integer> dsDaThongKe = new HashMap<>();
		for (AnPham ap : dsAnPham) {
			dsDaThongKe.put(ap.getNamXuatBan(), dsDaThongKe.getOrDefault(ap.getNamXuatBan(), 0) + 1);
		}
		return dsDaThongKe;
	}
}
