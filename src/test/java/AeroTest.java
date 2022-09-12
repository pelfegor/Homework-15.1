import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AeroTest {

    AeroRepository repo = new AeroRepository();
    AeroManager manager = new AeroManager(repo);

    Ticket ticket1 = new Ticket(1, 10000, "Sheremetevo", "Yerevan", 260);
    Ticket ticket2 = new Ticket(2, 9000, "Vnukovo", "Yerevan", 260);
    Ticket ticket3 = new Ticket(3, 9500, "Sheremetevo", "Yerevan", 260);
    Ticket ticket4 = new Ticket(4, 11000, "Vnukovo", "Yerevan", 260);
    Ticket ticket5 = new Ticket(5, 10500, "Sheremetevo", "Yerevan", 260);

    @BeforeEach
    public void setup() {

    }

    @Test
    public void ShouldRemove() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        repo.removeById(4);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket5};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void ShouldFindById() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket expected = ticket5;
        Ticket actual = repo.findById(5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldSearchByTextIfManyTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket3, ticket1, ticket5};
        Ticket[] actual = manager.searchBy("Sheremetevo", "Yerevan");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSearchByTextIfOneTicket() {
        manager.add(ticket1);


        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.searchBy("Sheremetevo", "Yerevan");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSearchByTextIfNoTickets() {

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("Sheremetevo", "Yerevan");

        Assertions.assertArrayEquals(expected, actual);
    }

}
