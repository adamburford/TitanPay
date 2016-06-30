package com.titanpay.accounting;

import java.time.LocalDate;

public interface Payable {
	String pay(LocalDate startDate, LocalDate endDate);
}
