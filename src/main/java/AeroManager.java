import java.util.Arrays;

public class AeroManager {

    private AeroRepository repo;

    public AeroManager(AeroRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] findAll() {
        return repo.findAll();
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket: repo.findAll()) {
            if (matches(ticket, from, to)) {
                int copyToIndex = 0;
                Ticket[] resultNew = new Ticket[result.length + 1];
                for (Ticket prod : result){
                    resultNew[copyToIndex] = prod;
                    copyToIndex++;
                }
                resultNew[resultNew.length-1] = ticket;
                result = resultNew;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().equals(from)) {
            if (ticket.getTo().equals(to)) {
                return true;
            }
        }
        return false;
    }
}
