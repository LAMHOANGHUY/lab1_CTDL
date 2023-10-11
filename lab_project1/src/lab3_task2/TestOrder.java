package lab3_task2;

import java.util.Arrays;

public class TestOrder {
	public static void main(String[] args) {
	Product p1 = new Product("001", "CoCaCocla", 9.0, "SortDrink");
	Product p2 = new Product("002", "PepSi", 10.0, "SortDrink");
	Product p3 = new Product("003", "Chis", 12.0, "Snack");
	Product p4 = new Product("004", "Graham Cookie", 7.0, "Cookie");
	
	OrderItem it1 = new OrderItem(p1, 2);
	OrderItem it2 = new OrderItem(p2, 2);
	OrderItem it3 = new OrderItem(p3, 2);
	OrderItem it4 = new OrderItem(p4, 2);
	OrderItem []items = {it1,it2,it3,it4};
	
	Order myOrder = new Order(items);
	myOrder.contains(p1);
	System.out.println(myOrder.contains(p4));
	System.out.println(Arrays.toString(myOrder.filter("Snack")));
	}
}
