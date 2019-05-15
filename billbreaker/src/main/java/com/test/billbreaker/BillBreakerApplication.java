package com.test.billbreaker;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.test.billbreaker.service.BillBreakerService;

@ComponentScan(basePackages = "com.test.billbreaker")
public class BillBreakerApplication {
	
    @Autowired
    private BillBreakerService billBreakerService;
	
	 public static void main(String[] args) {

	        ApplicationContext context = new AnnotationConfigApplicationContext(BillBreakerApplication.class);

	        BillBreakerApplication p = context.getBean(BillBreakerApplication.class);
	        p.start();
	    }


	    private void start() {
	    	Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.println("*******************************************");
				System.out.println("       Welcome to Bill Breaker         ");
				System.out.println("*******************************************");
				System.out.println("Choose one of the following options: ");
				System.out.println("1. Load Coins");
				System.out.println("2. Get change");
				System.out.println("3. Show available coin count");

				int selection = scanner.nextInt();

				switch (selection) {
				case 1: {

					while (true) {

						try {
							System.out.println("Enter the coin type wanted to load");
							String coinType = scanner.next();
							CoinTypeEnum coinTypeEnum = CoinTypeEnum.isValidCoinType(coinType);
							if (coinTypeEnum == null) {
								System.out.println("Invalid CoinType");
								continue;
							}
							System.out.println("Enter the number of coins wanted to load");
							int coinsQuantity = scanner.nextInt();

							billBreakerService.addCoins(coinTypeEnum, coinsQuantity);

						} catch (Exception ex) {
							System.out.println("Problem while loading the coins. Try again.");
						}
						break;
					}
					break;
				}
				case 2: {

					while (true) {

						try {
							System.out.println("Enter the bill to get the change");
							int billNumber = scanner.nextInt();
							boolean isValidBillNumber = BillTypeEnum.isValidBillType(billNumber);
							if (!isValidBillNumber) {
								System.out.println("Invalid billNumber");
								continue;
							}
							
							billBreakerService.findChange(billNumber);;

						} catch (Exception ex) {
							System.out.println("Problem while loading the coins. Try again.");
						}
						break;
					}
					break;
				}
				case 3: {
					
					System.out.println("Quarters count: "+billBreakerService.getAvailableQuantity(CoinTypeEnum.QUARTER));
					System.out.println("Dimes count: "+billBreakerService.getAvailableQuantity(CoinTypeEnum.DIME));
					System.out.println("Nickels count: "+billBreakerService.getAvailableQuantity(CoinTypeEnum.NICKEL));
					System.out.println("Pennys count: "+billBreakerService.getAvailableQuantity(CoinTypeEnum.PENNY));
					
					break;
				}



				}

			}
	    }

}
