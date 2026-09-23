package com.uk.lld.solid;

public class CheckoutService {

    public double calculateTotal(double amount, String discountType) {
        if ("VIP".equals(discountType)) {
            return amount * 0.90;
        } else if ("HOLIDAY".equals(discountType)) {
            return amount * 0.85;
        }
        return amount;
    }
}

/*
* Open/Closed Principle (OCP) states that software entities (classes, modules, functions) should be open for extension but closed for modification.
* You should be able to add new functionality to a system without altering existing tested code.
*
*
* CheckoutService class cannot introduce a new discount type and return the discounted amount without changing the calculateTotal(., .) function.
*
*
* SOLUTION
*
* We satisfy OCP by utilizing polymorphism and Inversion of Control (IoC).
* We define a rigid abstraction (an interface) and allow the core system to operate purely on that abstraction.
*
* public interface DiscountStrategy {
    BigDecimal applyDiscount(BigDecimal amount);
  }
*
* public final class VipDiscount implements DiscountStrategy {
    private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.90");

    @Override
    public BigDecimal applyDiscount(BigDecimal amount) {
        return amount.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_EVEN);
    }
  }
*
*
* public final class HolidayDiscount implements DiscountStrategy {
    private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.85");

    @Override
    public BigDecimal applyDiscount(BigDecimal amount) {
        return amount.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_EVEN);
    }
  }
*
*
* public final class BlackFridayDiscount implements DiscountStrategy {
    @Override
    public BigDecimal applyDiscount(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.50")).setScale(2, RoundingMode.HALF_EVEN);
    }
  }
*
*
* public class CheckoutService {
    public BigDecimal calculateTotal(BigDecimal amount, DiscountStrategy discountStrategy) {
        return discountStrategy.applyDiscount(amount);
    }
}
*
*/