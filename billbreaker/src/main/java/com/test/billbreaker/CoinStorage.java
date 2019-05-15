package com.test.billbreaker;

public class CoinStorage {
	
	public static int COIN_PENNY_COUNT = 100;
	public static int COIN_NICKEL_COUNT = 100;
	public static int COIN_DIME_COUNT = 100;
	public static int COIN_QUARTER_COUNT = 100;
	
	public static void loadCoin(CoinTypeEnum coinTypeEnum, int quantity) {
		
		switch(coinTypeEnum.name()) {
		case "PENNY": {
			CoinStorage.COIN_PENNY_COUNT = CoinStorage.COIN_PENNY_COUNT + quantity;
			break;
		}
		case "NICKEL": {
			CoinStorage.COIN_NICKEL_COUNT = CoinStorage.COIN_NICKEL_COUNT + quantity;
			break;
		}
		case "DIME": {
			CoinStorage.COIN_DIME_COUNT = CoinStorage.COIN_DIME_COUNT + quantity;	
			break;
		}
		case "QUARTER": {
			CoinStorage.COIN_QUARTER_COUNT = CoinStorage.COIN_QUARTER_COUNT + quantity;		
			break;
		}
		}
	}
	
	public static void deleteCoin(CoinTypeEnum coinTypeEnum, int quantity) {
		
		switch(coinTypeEnum.name()) {
		case "PENNY": {
			CoinStorage.COIN_PENNY_COUNT = CoinStorage.COIN_PENNY_COUNT - quantity;
			break;
		}
		case "NICKEL": {
			CoinStorage.COIN_NICKEL_COUNT = CoinStorage.COIN_NICKEL_COUNT - quantity;	
			break;
		}
		case "DIME": {
			CoinStorage.COIN_DIME_COUNT = CoinStorage.COIN_DIME_COUNT - quantity;	
			break;
		}
		case "QUARTER": {
			CoinStorage.COIN_QUARTER_COUNT = CoinStorage.COIN_QUARTER_COUNT - quantity;		
			break;
		}
		}
	}
	
	public static void setToEmpty(CoinTypeEnum coinTypeEnum) {
		
		switch(coinTypeEnum.name()) {
		case "PENNY": {
			CoinStorage.COIN_PENNY_COUNT = 0;
			break;
		}
		case "NICKEL": {
			CoinStorage.COIN_NICKEL_COUNT = 0;
			break;
		}
		case "DIME": {
			CoinStorage.COIN_DIME_COUNT = 0;	
			break;
		}
		case "QUARTER": {
			CoinStorage.COIN_QUARTER_COUNT = 0;	
			break;
		}
		}
	}
	
	public static void resetQuantity(CoinTypeEnum coinTypeEnum) {
		
		switch(coinTypeEnum.name()) {
		case "PENNY": {
			CoinStorage.COIN_PENNY_COUNT = 100;
			break;
		}
		case "NICKEL": {
			CoinStorage.COIN_NICKEL_COUNT = 100;
			break;
		}
		case "DIME": {
			CoinStorage.COIN_DIME_COUNT = 100;	
			break;
		}
		case "QUARTER": {
			CoinStorage.COIN_QUARTER_COUNT = 100;	
			break;
		}
		}
	}
	
	public static int getAvailableQuantity(CoinTypeEnum coinTypeEnum) {
		
		switch(coinTypeEnum.name()) {
		case "PENNY": {
			return CoinStorage.COIN_PENNY_COUNT;
		}
		case "NICKEL": {
			return CoinStorage.COIN_NICKEL_COUNT;
		}
		case "DIME": {
			return CoinStorage.COIN_DIME_COUNT;
		}
		case "QUARTER": {
			return CoinStorage.COIN_QUARTER_COUNT;
		}
		}
		return 0;
		
	}


}
