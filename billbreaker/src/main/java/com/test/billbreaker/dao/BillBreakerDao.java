package com.test.billbreaker.dao;

import com.test.billbreaker.CoinTypeEnum;

public interface BillBreakerDao {
	
	void addCoins(CoinTypeEnum coinTypeEnum, int coinQuantity);
	void deleteCoins(CoinTypeEnum coinTypeEnum, int coinQuantity);
	void setToEmpty(CoinTypeEnum coinTypeEnum);
	int getAvailableQuantity(CoinTypeEnum coinTypeEnum);

}
