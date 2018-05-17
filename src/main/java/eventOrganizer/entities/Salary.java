package eventOrganizer.entities;

import java.util.Objects;

public class Salary {
    private int totalAmount;
    private int prepayment;
    private int paymentAtEvent;
    private int finalPayment;

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(int prepayment) {
        this.prepayment = prepayment;
    }

    public int getPaymentAtEvent() {
        return paymentAtEvent;
    }

    public void setPaymentAtEvent(int paymentAtEvent) {
        this.paymentAtEvent = paymentAtEvent;
    }

    public int getFinalPayment() {
        return finalPayment;
    }

    public void setFinalPayment(int finalPayment) {
        this.finalPayment = finalPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return totalAmount == salary.totalAmount &&
                prepayment == salary.prepayment &&
                paymentAtEvent == salary.paymentAtEvent &&
                finalPayment == salary.finalPayment;
    }

    @Override
    public int hashCode() {

        return Objects.hash(totalAmount, prepayment, paymentAtEvent, finalPayment);
    }
}
