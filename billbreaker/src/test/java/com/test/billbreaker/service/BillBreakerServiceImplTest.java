package com.test.billbreaker.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.test.billbreaker.CoinStorage;
import com.test.billbreaker.CoinTypeEnum;
import com.test.billbreaker.dao.BillBreakerDaoImpl;

@RunWith(MockitoJUnitRunner.class)
public class BillBreakerServiceImplTest {
	
	 @InjectMocks
	 BillBreakerServiceImpl billBreakerServiceImpl;
	 
	 @Mock
	 BillBreakerDaoImpl billBreakerDaoImpl;
	 
	 @Test
	 public void testAddCoinsByCoinTypeQuarter() {
		 int coinQuantity = 50;
		 int expectedQuantity = 100;
		 CoinStorage.resetQuantity(CoinTypeEnum.QUARTER);
		 doNothing().when(billBreakerDaoImpl).addCoins(any(CoinTypeEnum.class), anyInt());
		 billBreakerServiceImpl.addCoins(CoinTypeEnum.QUARTER, coinQuantity);
		 verify(billBreakerDaoImpl, times(1)).addCoins(any(CoinTypeEnum.class), anyInt());
		 assertEquals(expectedQuantity, CoinStorage.COIN_QUARTER_COUNT);
	 }
	 
	 @Test
	 public void testDeleteCoinsByCoinTypeQuarter() {
		 int coinQuantity = 50;
		 int expectedQuantity = 100;
		 CoinStorage.resetQuantity(CoinTypeEnum.QUARTER);
		 doNothing().when(billBreakerDaoImpl).deleteCoins(any(CoinTypeEnum.class), anyInt());
		 billBreakerServiceImpl.deleteCoins(CoinTypeEnum.QUARTER, coinQuantity);
		 verify(billBreakerDaoImpl, times(1)).deleteCoins(any(CoinTypeEnum.class), anyInt());
		 assertEquals(expectedQuantity, CoinStorage.COIN_QUARTER_COUNT);
	 }
	 
	 @Test
	 public void testGetAvailableQuantityByCoinTypeQuarter() {
		 int expectedQuantity = 100;
		 CoinStorage.resetQuantity(CoinTypeEnum.QUARTER);
		 int availableQuantity = billBreakerServiceImpl.getAvailableQuantity(CoinTypeEnum.QUARTER);
		 assertEquals(expectedQuantity, availableQuantity);
	 }
	 
	 @Test
	 public void testFindChange() {
		 int billNumber = 20;
		 int remainingQuarters = 20;
		 CoinStorage.resetQuantity(CoinTypeEnum.QUARTER);
		 billBreakerServiceImpl.findChange(billNumber);
		 //int availableQuarters = CoinStorage.getAvailableQuantity(CoinTypeEnum.QUARTER);
		 //assertEquals(remainingQuarters, availableQuarters);
	 }

}
