package com.test.billbreaker.service;

import com.test.billbreaker.CoinTypeEnum;

public interface BillBreakerService {
	
	void addCoins(CoinTypeEnum coinTypeEnum, int coinQuantity);
	void deleteCoins(CoinTypeEnum coinTypeEnum, int coinQuantity);
	void findChange(int billNumber);
	int getAvailableQuantity(CoinTypeEnum coinTypeEnum);
}
