package com.charter.rewards;

import com.charter.rewards.model.Customer;
import com.charter.rewards.model.Month;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.List;

@SpringBootApplication
public class RewardsApplication {

	public static void main( String[] args ) {
		List<Customer> customers = readCustomerRecordData();
		for (Customer customer : customers) {
			System.out.println("Customer Name: " + customer.getName() );
			System.out.println("---------------------------------------------------");
			calculateTotalRewardPoints(customer);
		}
	}

	public static List<Customer> readCustomerRecordData() {
		List<Customer> customers = null;

		try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream inputStream = new FileInputStream(new File("src\\main\\resources\\data.json"));
			TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>() {};
			customers = mapper.readValue(inputStream, typeReference);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return customers;
	}

	public static void calculateTotalRewardPoints(Customer customer) {
		double pointsEarnedInMonth;
		double totalPointsEarned = 0;
		for(Month month : customer.getMonth()) {
			pointsEarnedInMonth = 0;
			for(Integer transaction : month.getTransactions()) {
				pointsEarnedInMonth += calculateRewardPointsForTransaction((double) transaction);
			}
			System.out.println(customer.getName() + "'s rewards for the month of " + month.getMonth() + ": " + pointsEarnedInMonth);
			totalPointsEarned += pointsEarnedInMonth;
		}

		System.out.println(customer.getName() + "'s total reward points: " + totalPointsEarned);
		System.out.println();
	}

	public static Double calculateRewardPointsForTransaction(double purchase) {
		double pointsEarned;
		purchase = purchase - 50;
		if(purchase < 0) { pointsEarned = 0; return pointsEarned;}
		purchase = purchase - 50;
		if(purchase < 0) { pointsEarned = purchase + 50; }
		else { pointsEarned = 50 + purchase*2; }
		return pointsEarned;
	}


}
