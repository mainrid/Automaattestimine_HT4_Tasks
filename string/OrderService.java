package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderService {

	private DataSource dataSource;

	public OrderService(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Order> getFilledOrders() {
		List<Order> filledOrders = new ArrayList<Order>();
		for (Order order : dataSource.getOrders()) {
			if (order.isFilled()) {
				filledOrders.add(order);
			}
		}
		return filledOrders;

	}

	public List<Order> getOrdersOver(double amount) {
		List<Order> ordersOverAmount = new ArrayList<Order>();
		for (Order order : dataSource.getOrders()) {
			if (order.getTotal() > amount) {
				ordersOverAmount.add(order);
			}
		}
		return ordersOverAmount;
	}

	public List<Order> getOrdersSortedByDate() {
		List<Order> sortedOrders = new ArrayList<Order>(this.dataSource.getOrders());
		Collections.sort(sortedOrders, orderDateComparator());
		return sortedOrders;
	}

	private Comparator<Order> orderDateComparator() {
		return new Comparator<Order>() {
			public int compare(Order o1, Order o2) {
				if (o1.getOrderDate() == null || o2.getOrderDate() == null)
					return 0;
				return o1.getOrderDate().compareTo(o2.getOrderDate());
			}
		};
	}
}
