package com.test.billbreaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.billbreaker.CoinStorage;
import com.test.billbreaker.CoinTypeEnum;
import com.test.billbreaker.dao.BillBreakerDao;

@Component
public class BillBreakerServiceImpl implements BillBreakerService {
	
	@Autowired
	BillBreakerDao billBreakerDao;

	@Override
	public void addCoins(CoinTypeEnum coinTypeEnum, int coinQuantity) {
		billBreakerDao.addCoins(coinTypeEnum, coinQuantity);
	}

	@Override
	public void deleteCoins(CoinTypeEnum coinTypeEnum, int coinQuantity) {
		billBreakerDao.deleteCoins(coinTypeEnum, coinQuantity);
		
	}
	
	@Override
	public int getAvailableQuantity(CoinTypeEnum coinTypeEnum) {
		return CoinStorage.getAvailableQuantity(coinTypeEnum);
	}

	@Override
	public void findChange(int billNumber) {


			int neededQuarters = billNumber * 4;
			int neededDimes = billNumber * 10;
			int neededNickels = billNumber * 5;
			int neededPennys = billNumber * 1;
	
			int availableQuarters = billBreakerDao.getAvailableQuantity(CoinTypeEnum.QUARTER);
			if(availableQuarters >= neededQuarters) {
				System.out.println("Quarters: "+neededQuarters);
				billBreakerDao.deleteCoins(CoinTypeEnum.QUARTER, neededQuarters);
			}else {
				System.out.println("Quarters: "+availableQuarters);
				billBreakerDao.setToEmpty(CoinTypeEnum.QUARTER);
				int billCurrencyConsumed = availableQuarters / 4;
				billNumber = billNumber - billCurrencyConsumed;
				neededDimes = billNumber * 10;
				
				int availableDimes = billBreakerDao.getAvailableQuantity(CoinTypeEnum.DIME);
				
				if(availableDimes >= neededDimes) {
					System.out.println("Dimes: "+neededDimes);
					billBreakerDao.deleteCoins(CoinTypeEnum.DIME, neededDimes);
				}else {
					System.out.println("Dimes: "+availableDimes);
					billBreakerDao.setToEmpty(CoinTypeEnum.DIME);
					billCurrencyConsumed = availableDimes / 10;
					billNumber = billNumber - billCurrencyConsumed;
					neededNickels = billNumber * 20;
					
					int availableNickels = billBreakerDao.getAvailableQuantity(CoinTypeEnum.NICKEL);
					
					if(availableNickels >= neededNickels) {
						System.out.println("Dimes: "+neededNickels);
						billBreakerDao.deleteCoins(CoinTypeEnum.NICKEL, neededNickels);
					}else {
						System.out.println("Nickels: "+availableNickels);
						billBreakerDao.setToEmpty(CoinTypeEnum.NICKEL);
						billCurrencyConsumed = availableNickels / 20;
						billNumber = billNumber - billCurrencyConsumed;
						neededPennys = billNumber * 100;
						
						int availablePennys = billBreakerDao.getAvailableQuantity(CoinTypeEnum.PENNY);
						
						if(availablePennys >= neededPennys) {
							System.out.println("Dimes: "+neededPennys);
							billBreakerDao.deleteCoins(CoinTypeEnum.PENNY, neededPennys);
						}else {
							System.out.println("Sorry not enough coins to change.");
						}
					}
				}
				
			}
	}
	
	
}
