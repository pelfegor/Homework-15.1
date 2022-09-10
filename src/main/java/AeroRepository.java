public class AeroRepository {

    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        Ticket[] tmp = new Ticket [tickets.length +1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length -1] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket findById(int id) {
        for(Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new RuntimeException("Нет такого id для удаления: " + id);
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        if (findById(id) != null) {
            for (Ticket ticket : tickets) {
                if (ticket.getId() != id) {
                    tmp[copyToIndex] = ticket;
                    copyToIndex++;
                }
            }
            tickets = tmp;
        }
    }
}
