package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class DiscountResponse {

	private int discountPercent;

	public int getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}
}
