package PopulateService;

import Storage.Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorkersTablePopulateService {
    public static final String TRAINEE = "Trainee";
    public static final String JUNIOR = "Junior";
    public static final String MIDDLE = "Middle";
    public static final String SENIOR = "Senior";
    public static void main(String[] args) {
        Connection connection = Database.getINSTANCE().getConnection();
        String[] names =
                {"Solomiya", "Olexandr", "Emiliya", "Olena", "Anna", "Ivan", "Oleh", "Arthur", "Eugen", "Viktoriya"};

        String[] birthday =
                {"2001-01-01", "2002-02-02", "1999-03-03", "1992-08-08", "1995-04-04", "1998-05-05", "2000-06-06",
                        "2003-07-07", "1997-09-09", "1996-10-10"};

        String[] level =
                {JUNIOR, TRAINEE, JUNIOR, SENIOR, MIDDLE, MIDDLE, JUNIOR, TRAINEE, SENIOR, MIDDLE};

        Integer[] salaries = {1100, 350, 1100, 7000, 3000, 3000, 1100, 400, 9000, 3000};

        String[] clientNames = {"Michael Jordan", "John Johnson", "Sarah Jigsaw", "Andrew Ivanovich", "Roger Moore"};

        try(PreparedStatement ps = connection.prepareStatement
                (
                "INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES (?, ?, ?, ?)");
                ) {

            for (int i = 0; i < names.length; i++) {
                ps.setString(1, names[i]);
                ps.setDate(2, Date.valueOf(birthday[i]));
                ps.setString(3, level[i]);
                ps.setInt(4, salaries[i]);
                ps.addBatch();
            }

            ps.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
