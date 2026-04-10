public class FixedRateMortgage {
    public int purchasePrice;
    public double interestRate;
    public int lengthYears;
    public double downPaymentPercent;
    public double pmiAmount;
    public double principle;
    public double monthlyRate;
    public int periods;
    public boolean pmiActive;
    public double balance;
    public double ltv;

    public FixedRateMortgage(int purchasePrice, double interestRate, int lengthYears, double downPaymentPercent, double pmiAmount) {
        this.purchasePrice = purchasePrice;
        this.interestRate = interestRate;
        this.lengthYears = lengthYears;
        this.downPaymentPercent = downPaymentPercent;
        this.pmiAmount = pmiAmount;
        this.principle = purchasePrice * (1 - downPaymentPercent);
        this.monthlyRate = interestRate / 12;
        this.periods = lengthYears * 12;
        this.pmiActive = downPaymentPercent < 0.2;
        this.balance = principle;
        this.ltv = principle / purchasePrice;
    }

    public double calculatePayment() {
        double factor = Math.pow((1 + this.monthlyRate), periods);
        return principle * (monthlyRate * factor) / (factor - 1);
    }

    public void updateLTVandPMI() {
        this.setLtv(balance / purchasePrice);
        this.setPmiActive(this.ltv >= 0.8);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getLengthYears() {
        return lengthYears;
    }

    public void setLengthYears(int lengthYears) {
        this.lengthYears = lengthYears;
    }

    public double getDownPaymentPercent() {
        return downPaymentPercent;
    }

    public void setDownPaymentPercent(double downPaymentPercent) {
        this.downPaymentPercent = downPaymentPercent;
    }

    public double getPmiAmount() {
        return pmiAmount;
    }

    public void setPmiAmount(double pmiAmount) {
        this.pmiAmount = pmiAmount;
    }

    public double getPrinciple() {
        return principle;
    }

    public void setPrinciple(int principle) {
        this.principle = principle;
    }

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(double monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public boolean isPmiActive() {
        return pmiActive;
    }

    public void setPmiActive(boolean pmiActive) {
        this.pmiActive = pmiActive;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLtv() {
        return ltv;
    }

    public void setLtv(double ltv) {
        this.ltv = ltv;
    }
}