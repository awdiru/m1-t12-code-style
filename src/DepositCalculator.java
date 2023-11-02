import java.util.Scanner;

public class DepositCalculator {
    double countsHardPercent(double amount, int period) {
        double pay = amount * Math.pow((1 + 0.06 / 12), 12 * period);
        return describeCircle(pay);
    }

    double countsSimplePercent (double amount, int period) {
        return describeCircle(amount + amount * 0.06 * period);
    }

    double describeCircle(double value) {
        double scale = Math.pow(10, 2);
        return Math.round(value * scale) / scale;
    }

    void executesProgram() {
        Scanner scanner = new Scanner (System.in);

        System.out.println ("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt ();

        System.out.println ("Введите срок вклада в годах:");
        int period = scanner.nextInt ();

        System.out.println ("Выберите тип вклада, " +
                "1 - вклад с обычным процентом, " +
                "2 - вклад с капитализацией:");
        int command = scanner.nextInt ();

        double finalAmount = 0;

        if (command == 1) {
            finalAmount = countsSimplePercent (amount, period);

        } else if (command == 2) {
            finalAmount = countsHardPercent (amount, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + finalAmount);
    }
}