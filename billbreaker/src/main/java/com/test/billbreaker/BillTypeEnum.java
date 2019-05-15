package com.test.billbreaker;

public enum BillTypeEnum {
	
	ONE(1), TWO(2), FIVE(5), TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100);

	private int billValue;
	
	private BillTypeEnum(int billValue) {
		this.billValue = billValue;
	}
	
	public static boolean isValidBillType(int billNumber) {
		for(BillTypeEnum billTypeEnum : values()) {
			if(billTypeEnum.getValue() == billNumber)
				return true;
		}
		return false;
	}
	
	public int getValue() {
		return billValue;
	}
}
