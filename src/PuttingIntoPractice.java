
import java.util.Arrays;
import java.util.List;

public class PuttingIntoPractice {

    public static void main(String... args) {


        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        Trader barbara = new Trader("Barbara", "Moskow");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 100),
                new Transaction(mario, 2011, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950),
                new Transaction(barbara,2011,1200)
        );
        Service service = new Service(transactions);
        System.out.println("1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей " +
                "к большей).");
        service.sortYear();
        System.out.println("2. Вывести список неповторяющихся городов, в которых работают трейдеры.");
        System.out.println(service.listCityUniq());

        System.out.println("3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.");
        service.traderCambridge();
        System.out.println("4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном\n" +
                "порядке.");
        System.out.println(service.sortTraderName());
        System.out.println("5. Выяснить, существует ли хоть один трейдер из Милана.");
        System.out.println(service.traderIsMilan());
        System.out.println("6. Вывести суммы всех транзакций трейдеров из Кембриджа.");
        service.transactionCambrige();
        System.out.println("Максимальная сумма среди всех транзакций" +
                " = " + service.maxValueTransaction());
        System.out.println("Минимальная транзакция " + service.minTransaction());







    }
}