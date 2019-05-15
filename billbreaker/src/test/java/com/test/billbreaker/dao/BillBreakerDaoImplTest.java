package com.test.billbreaker.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.test.billbreaker.CoinStorage;
import com.test.billbreaker.CoinTypeEnum;

@RunWith(MockitoJUnitRunner.class)
public class BillBreakerDaoImplTest {
	
	
	 @InjectMocks
	 BillBreakerDaoImpl billBreakerDaoImpl;
	 
	 @Test
	 public void testLoadCoinByCoinTypeQuarter() {
		 int quantity = 50;
		 int expectedQuantity = 150;
		 CoinStorage.resetQuantity(CoinTypeEnum.QUARTER);
		 billBreakerDaoImpl.addCoins(CoinTypeEnum.QUARTER, quantity);
		 assertEquals(expectedQuantity, CoinStorage.COIN_QUARTER_COUNT);
	 }
	 
	 @Test
	 public void testDeleteCoinsByCoinTypeDime() {
		 int quantity = 50;
		 int expectedQuantity = 50;
		 CoinStorage.resetQuantity(CoinTypeEnum.QUARTER);
		 billBreakerDaoImpl.deleteCoins(CoinTypeEnum.QUARTER, quantity);
		 assertEquals(expectedQuantity, CoinStorage.COIN_QUARTER_COUNT);
	 }
	 
	 @Test
	 public void testSetToEmptyByCoinTypeDime() {
		 int expectedQuantity = 0;
		 CoinStorage.resetQuantity(CoinTypeEnum.QUARTER);
		 billBreakerDaoImpl.setToEmpty(CoinTypeEnum.QUARTER);
		 assertEquals(expectedQuantity, CoinStorage.COIN_QUARTER_COUNT);
	 }
	 
	 @Test
	 public void testgetAvailableQuantity() {
		 int expectedQuantity = 100;
		 CoinStorage.resetQuantity(CoinTypeEnum.QUARTER);
		 billBreakerDaoImpl.getAvailableQuantity(CoinTypeEnum.QUARTER);
		 assertEquals(expectedQuantity, CoinStorage.COIN_QUARTER_COUNT);
	 }
	 
	
	 

}
