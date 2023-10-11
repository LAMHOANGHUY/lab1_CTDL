package lab3_task2;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		this.items = items;
	}

	// Phương thức tính tiền hóa đơn
	public double cost() {
		int totalCost = 0;
		for (int i = 0; i < items.length; i++) {
			totalCost += items[i].getP().getPrice() * items[i].getQuality();

		}
		return totalCost;
	}

	// phương thức kiểm tra một săn phẩm có trong danh sách order hay không.
	public boolean contains(Product p) {
		// Comparator dùng để chỉ định tiêu chí để sort mảng các sản phẩm order.
		Arrays.sort(items, new Comparator<OrderItem>() {
			@Override
			public int compare(OrderItem o1, OrderItem o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		return searchBinary(p, 0, items.length - 1);
	}

	// phương thức bổ trợ tìm kiếm nhị phân một sản phẩm trong danh sách order.
	// phương thức được triển khai theo cách tìm kiếm nhị phân đệ quy.
	public boolean searchBinary(Product target, int right, int left) {
		if (right > left)
			return false;
		int mid = (right + left) / 2;
		int compare = items[mid].compare(target);
		if (compare == 0)
			return true;
		if (compare < 0) {
			return searchBinary(target, right, mid - 1);
		} else {
			return searchBinary(target, mid + 1, left);
		}
	}

	// phương thức lọc các sản phẩm có cùng loại được chỉ định.
	public Product[] filter(String type) {
		// tạo một mảng các giá trị boolean để đánh dấu các phần tử có loại "type" trong
		// mảng
		// với các sản phẩm có loại "type" sẽ được đánh dấu là true và ngược lại là
		// false.
		boolean[] listNode = new boolean[items.length];
		int count = 0;
		for (int i = 0; i < listNode.length; i++) {
			if (items[i].getP().getType().equals(type)) {
				listNode[i] = true;
				count++;
			} else
				listNode[i] = false;
		}
		// Dựa vào số lượng các sản phẩm được đánh dấu để lập một mảng chứa các sản phẩm
		// có loại "type".
		Product[] filterProduct = new Product[count];
		count = 0;
		for (int i = 0; i < listNode.length; i++) {
			if (listNode[i] == true) {
				filterProduct[count++] = items[i].getP();
			}
		}
		return filterProduct;
	}

}
