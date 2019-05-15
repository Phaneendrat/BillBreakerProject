package com.test.billbreaker;

public enum CoinTypeEnum {
	
	PENNY(0.01), NICKEL(0.05), DIME(0.10), QUARTER(0.25);

	private double coinValue;
	
	private CoinTypeEnum(double coinValue) {
		this.coinValue = coinValue;
	}
	
	public static CoinTypeEnum isValidCoinType(String coinName) {
		for(CoinTypeEnum coinTypeEnum : values()) {
			if(coinTypeEnum.name().equals(coinName))
				return coinTypeEnum;
		}
		return null;
	}
}
