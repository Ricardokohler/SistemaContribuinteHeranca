package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Company;
import model.entities.Individual;
import model.entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of taxpayers: ");
		int n = sc.nextInt();
		
		List <TaxPayer> list = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Taxpayer #" + i + " data: ");
			System.out.print("Individual ou Company? (i/c): ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
			
			if ((type == 'i') ||(type == 'I')){
				System.out.print("Health expentitures: ");
				double healthExpentitures = sc.nextDouble();
				
				Individual individual = new Individual(name, anualIncome, healthExpentitures);
				list.add(individual);
			}
			else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				
				Company company = new Company(name, anualIncome, numberOfEmployees);
				list.add(company);
			}
		}	
		
		
			System.out.println();
			System.out.println("TAXES PAID: ");
			
			for (TaxPayer x : list) {
				System.out.println(x.getName() + ", Total Tax: " + String.format("%.2f", x.tax()));
			}
			
			double sum = 0.0;
			for (TaxPayer x : list) {
				sum += x.tax();
			}
			
			System.out.println();
			System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
			System.out.println(); 
		
		
		sc.close();
	}

}
