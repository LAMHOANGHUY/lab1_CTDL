package task2;

import java.util.ArrayList;

public class test {
	public static void main(String[] args) {

		DanhMucAnPham danhMuc = new DanhMucAnPham();
		// Tạo sách tham khảo
		ArrayList<ChuongSach> dsChuong = new ArrayList<>();
		dsChuong.add(new ChuongSach("Chương 1", 20));
		dsChuong.add(new ChuongSach("Chương 2", 15));

		SachThamKhao sachThamKhao1 = new SachThamKhao("Sach Y Hoc", 300, 2015, "Nguyen Van A", 150000, "Y Hoc",
				dsChuong);
		SachThamKhao sachThamKhao2 = new SachThamKhao("Sach Số học ", 160, 2022, "Nguyen Van B", 250000, "CNTT",
				dsChuong);
		SachThamKhao sachThamKhao3 = new SachThamKhao("Sach Giao duc", 100, 2021, "Nguyen Van A", 150000, "Y Hoc",
				dsChuong);

		// Tạo tạp chí
		TapChi tapChi1 = new TapChi("Tạp Chi Giáo Dục", 50, 2023, "Nguyễn Văn A", 50000, "Giáo Dục");
		TapChi tapChi2 = new TapChi("Tạp Chi Đời Sống", 60, 2002, "Nguyễn Văn A", 30000, "Đời Sống");

		// Thêm ấn phẩm vào danh mục
		danhMuc.themAnPham(sachThamKhao3);
		danhMuc.themAnPham(sachThamKhao2);
		danhMuc.themAnPham(tapChi1);
		danhMuc.themAnPham(tapChi2);

		// Kiểm tra các phương thức
		System.out.println("Loại sách: " + sachThamKhao1.xacDinhLoaiAnPham());
		System.out.println("Loại tạp chí: " + tapChi1.xacDinhLoaiAnPham());
		System.out.println();
		System.out.println("Tạp chí có thời gian xuất ban cách đây 10 năm: " + tapChi2.thoiGianXuatBanCachDay(10));
		System.out.println();
		// Kiểm tra hai ấn phẩm có cùng loại và cùng tác giả hay không
		danhMuc.kiemTraCungLoaiVaTacGia(tapChi1, tapChi2);
//		danhMuc.kiemTraCungLoaiVaTacGia(tapChi1, sachThamKhao1);
		System.out.println();
		System.out.println("Tổng tiền ấn phẩm: " + danhMuc.tinhTongTien());
		System.out.println("---------------");
		// Tìm sách tham khảo có chương sách nhiều trang nhất
		System.out.println("Sách tham khảo có chương sách nhiều trang nhất: ");
		System.out.println(danhMuc.timSachThamKhaoCoChuongNhieuNhat());
		System.out.println();
		System.out.println("Danh sách ấn phẩm có chứa tạp chí có tên cho trước hay không: " + danhMuc.timTapChi(tapChi1));
		System.out.println("-----------------");
		System.out.println("Tạp chí được xuất bản vào một năm trước: " + danhMuc.tapChiXuatBanTrongNam(2024).toString());
		System.out.println("-----------------");
		System.out.println("Sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất bản: ");
		System.out.println(danhMuc.getDsAnPham().toString());
		danhMuc.sapXepDSAnpham();
		System.out.println("-----------------");
		System.out.println(danhMuc.thongKeAnPham().toString());

	}

}

//       