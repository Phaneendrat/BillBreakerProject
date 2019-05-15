package com.test.billbreaker.dao;

import org.springframework.stereotype.Component;

import com.test.billbreaker.CoinStorage;
import com.test.billbreaker.CoinTypeEnum;

@Component
public class BillBreakerDaoImpl implements BillBreakerDao {

	@Override
	public void addCoins(CoinTypeEnum coinTypeEnum, int coinQuantity) {
		CoinStorage.loadCoin(coinTypeEnum, coinQuantity);
	}

	@Override
	public void deleteCoins(CoinTypeEnum coinTypeEnum, int coinQuantity) {
		CoinStorage.deleteCoin(coinTypeEnum, coinQuantity);
		
	}
	
	@Override
	public void setToEmpty(CoinTypeEnum coinTypeEnum) {
		CoinStorage.setToEmpty(coinTypeEnum);
		
	}

	@Override
	public int getAvailableQuantity(CoinTypeEnum coinTypeEnum) {
		return CoinStorage.getAvailableQuantity(coinTypeEnum);
	}

	

}
