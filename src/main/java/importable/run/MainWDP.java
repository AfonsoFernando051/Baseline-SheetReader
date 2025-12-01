package importable.run;

import java.io.InputStream;
import java.util.List;

import importable.model.Customer;
import importable.model.Product;
import importable.old.OldCustomerImporter;
import importable.old.OldProductImporter;


public class MainWDP {

	public static void main(String[] args) {
		readDataWithoutDesignPatterns();
	}

	private static void readDataWithoutDesignPatterns() {
		System.out.println("--- Using static methods with hardcoded values. Very rigid. ---");
		try {
			InputStream customerStream = MainWDP.class.getClassLoader().getResourceAsStream("customers.xlsx");
			byte[] customerFile = customerStream.readAllBytes();
			List<Customer> customers = OldCustomerImporter.importSheetData("0", true, "A", "B", "D", "F", "G",
					customerFile);
			System.out.println("\nCustomers imported: " + customers.size());
			for (Object c : customers) {
				System.out.println(c);
			}

			InputStream productStream = MainWDP.class.getClassLoader().getResourceAsStream("products.xlsx");
			byte[] productFile = productStream.readAllBytes();
			List<Product> products = OldProductImporter.importSheetData("0", true, "A", "B", "D", "C",
					productFile);
			System.out.println("\nProducts imported: " + products.size());
			for (Object p : products) {
				System.out.println(p);
			}
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}