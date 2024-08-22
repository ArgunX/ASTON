import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Service {
    private final List<Transaction> transactions;

    public Service(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void sortYear() {
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted((o1, o2) -> o1.getValue() - o2.getValue())
                .forEach(System.out::println);
    }

    public List<String> listCityUniq() {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

    }

    public void traderCambridge() {
        transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .forEach(System.out::println);
    }

    public String sortTraderName() {
      return transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .map(Trader::getName)
                .sorted((o1, o2) -> o1.compareTo(o2))
                .collect(Collectors.joining(", "));

    }

    public boolean traderIsMilan() {
        return transactions.stream()
                .anyMatch(x -> x.getTrader().getCity().equals("Milan"));
    }

    public void transactionCambrige() {
                transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

    }

    public int maxValueTransaction(){
          return transactions.stream()
                    .map(Transaction::getValue)
                    .max(Integer::compare).get();

    }

    public Transaction minTransaction(){
        return transactions.stream()
                .min((o1,o2)-> o1.getValue()-o2.getValue()).get();


    }

}
