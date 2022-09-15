import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();

    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", "1:35");
    Ticket ticket2 = new Ticket(2, 1299, "SVO", "KZN", "1:35");
    Ticket ticket3 = new Ticket(3, 1299, "SVO", "KZN", "1:35");
    Ticket ticket4 = new Ticket(4, 1399, "SVO", "KZN", "1:35");
    Ticket ticket5 = new Ticket(5, 2299, "VKO", "KZN", "1:35");
    Ticket ticket6 = new Ticket(6, 2269, "VKO", "KZN", "1:35");
    Ticket ticket7 = new Ticket(7, 2387, "VKO", "KZN", "1:35");
    Ticket ticket8 = new Ticket(8, 2369, "VKO", "KZN", "1:35");

    @Test
    public void SearchBy() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.searchBy("SVO", "KZN");
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchBy2() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.searchBy("VKO", "KZN");
        Ticket[] expected = {ticket6, ticket5, ticket8, ticket7};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void NoTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.searchBy("ABC", "DEF");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void FindAll() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.repo.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveById() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.repo.removeById(8);
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};

        assertArrayEquals(expected, actual);
    }
}
