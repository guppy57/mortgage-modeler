import java.text.NumberFormat;

void main() {
    IO.println("Hello and welcome to the Mortgage Modeler!");

    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    FixedRateMortgage mortgage = new FixedRateMortgage(242500, 0.05625, 30, 0.05, 131);

    int month = 0;
    int extraPrinciple = 500;
    double basePayment = mortgage.calculatePayment();

    double totalInterestPaid = 0;
    double totalPmiPaid = 0;
    double totalPrinciplePaid = 0;

    while (mortgage.balance > 0 && month < mortgage.periods) {
        month += 1;

        double interest = mortgage.balance * mortgage.monthlyRate;
        double principlePayment = basePayment - interest;
        double principleThisMonth = principlePayment + extraPrinciple;

        if (principleThisMonth > mortgage.balance) {
           principleThisMonth = mortgage.balance;
        }

        mortgage.setBalance(mortgage.balance - principleThisMonth);
        mortgage.updateLTVandPMI();

        totalInterestPaid += interest;
        totalPmiPaid += mortgage.pmiAmount;
        totalPrinciplePaid += principleThisMonth;
    }

    double totalCost = totalInterestPaid + totalPmiPaid + totalPrinciplePaid;
    int years = month / 12;

    IO.println("Mortgage loop complete");
    IO.println("Total principle paid: " + formatter.format(totalPrinciplePaid));
    IO.println("Total interest paid: " + formatter.format(totalInterestPaid));
    IO.println("Total PMI paid: " + formatter.format(totalPmiPaid));
    IO.println("Total cost of the loan: " + formatter.format(totalCost));
    IO.println("Number of years: " + years);
}
