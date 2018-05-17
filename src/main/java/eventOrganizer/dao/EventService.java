package eventOrganizer.dao;

import eventOrganizer.entities.event.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EventService implements EventServiceDAO {
    @Autowired
    DataSource dataSource;
    JdbcTemplate template;

    @PostConstruct
    public void init() {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Event> getEvents() {
        final String QUERY_SQL = "SELECT e.id, e.name, ge.name AS ge_name, cl.firstName, cl.surname, cl.phone, e.totalAmount, e.prepayment, e.paymentAtEvent,e.finalPayment, cl.linkToProfileVK, cl.getLinkToProfileFaceBook ,cl.dateOfBirth, e.date, e.timeBegin, e.timeEnd, pl.name AS pl_name, pl.address AS pl_address, pl.description AS pl_desc, e.source, e.rating, e.voteCount FROM EVENT e INNER JOIN GENRE_EVENT ge ON e.genre_id=ge.id \n" +
                "INNER JOIN PLACE_EVENT pl ON e.place_id=pl.id INNER JOIN CLIENT cl ON e.client_id=cl.id";
        return template.query(QUERY_SQL, new EventRowMapper());
    }

    private static final class EventRowMapper implements RowMapper<Event> {

        @Override
        public Event mapRow(ResultSet resultSet, int i) throws SQLException {
            Event event = new Event();
            Client client = new Client();
            GenreEvent genreEvent = new GenreEvent();
            PlaceEvent placeEvent = new PlaceEvent();
            Salary salary = new Salary();

            event.setId(resultSet.getInt("id"));
            event.setName(resultSet.getString("name"));
            event.setDate(resultSet.getTimestamp("date"));
            event.setTimeBegin(resultSet.getTimestamp("timeBegin"));
            event.setTimeEnd(resultSet.getTimestamp("timeEnd"));
            event.setSource(resultSet.getString("source"));
            event.setRating(resultSet.getInt("rating"));
            event.setVoteCount(resultSet.getString("voteCount"));

            genreEvent.setName(resultSet.getString("ge_name"));

            client.setFirstName(resultSet.getString("firstName"));
            client.setSurname(resultSet.getString("surname"));
            client.setPhone(resultSet.getString("phone"));
            client.setLinkToProfileVk(resultSet.getString("linkToProfileVK"));
            client.setLinkToProfileFaceBook(resultSet.getString("getLinkToProfileFaceBook"));
            client.setDateOfBirth(resultSet.getTimestamp("dateOfBirth"));

            placeEvent.setName(resultSet.getString("pl_name"));
            placeEvent.setAddress(resultSet.getString("pl_address"));
            placeEvent.setDescription(resultSet.getString("pl_desc"));

            salary.setTotalAmount(resultSet.getInt("totalAmount"));
            salary.setPrepayment(resultSet.getInt("prepayment"));
            salary.setPaymentAtEvent(resultSet.getInt("paymentAtEvent"));
            salary.setFinalPayment(resultSet.getInt("finalPayment"));

            event.setClient(client);
            event.setGenreEvent(genreEvent);
            event.setPlaceEvent(placeEvent);
            event.setSalary(salary);

            return event;
        }
    }
}
