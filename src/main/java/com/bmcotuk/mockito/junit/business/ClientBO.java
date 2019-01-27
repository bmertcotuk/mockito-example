package com.bmcotuk.mockito.junit.business;

import java.util.List;

import com.bmcotuk.mockito.junit.business.exception.DifferentCurrenciesException;
import com.bmcotuk.mockito.junit.model.Amount;
import com.bmcotuk.mockito.junit.model.Product;

public interface ClientBO {

	Amount getClientProductsSum(List<Product> products)
			throws DifferentCurrenciesException;

}