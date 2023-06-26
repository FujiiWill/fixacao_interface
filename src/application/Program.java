package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		double number = sc.nextDouble();
		System.out.print("Date (dd/MM/yyyy): ");
		sc.nextLine();
		LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
		System.out.print("Contract Value: ");
		double totalValue = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		double months = sc.nextDouble();
		System.out.println("Installments:");
		
		double installmentValue = totalValue / months;
		for(int i = 1; i <= months; i++) {
			double amount = installmentValue * (1 + (0.01 * i)) * 1.02;
			System.out.printf(date.plusMonths(i).format(fmt) + " - " + String.format("%.2f\n", amount));
		}
		
		sc.close();
	}

}
