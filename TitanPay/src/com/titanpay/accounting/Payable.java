package com.titanpay.accounting;

import java.time.LocalDate;

public interface Payable {
	void pay(LocalDate startDate, LocalDate endDate);
}
