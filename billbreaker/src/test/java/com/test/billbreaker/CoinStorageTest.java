package com.test.billbreaker;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CoinStorageTest {
	
	 @InjectMocks
	 CoinStorage coinStorage;
	 
	 @Test
	 public void testLoadCoinByCoinTypeQuarter() {
		 int quantity = 50;
		 int expectedQuantity = 150;
		 coinStorage.loadCoin(CoinTypeEnum.QUARTER, quantity);
		 assertEquals(expectedQuantity, CoinStorage.COIN_QUARTER_COUNT);
	 }
	 
	 @Test
	 public void testLoadCoinByCoinTypeDime() {
		 int quantity = 50;
		 int expectedQuantity = 150;
		 coinStorage.loadCoin(CoinTypeEnum.DIME, quantity);
		 assertEquals(expectedQuantity, CoinStorage.COIN_DIME_COUNT);
	 }
	 
	 @Test
	 public void testLoadCoinByCoinTypeNickel() {
		 int quantity = 50;
		 int expectedQuantity = 150;
		 coinStorage.loadCoin(CoinTypeEnum.NICKEL, quantity);
		 assertEquals(expectedQuantity, CoinStorage.COIN_NICKEL_COUNT);
	 }
	 
	 @Test
	 public void testLoadCoinByCoinTypePenny() {
		 int quantity = 50;
		 int expectedQuantity = 150;
		 coinStorage.loadCoin(CoinTypeEnum.PENNY, quantity);
		 assertEquals(expectedQuantity, CoinStorage.COIN_PENNY_COUNT);
	 }
	 

}
