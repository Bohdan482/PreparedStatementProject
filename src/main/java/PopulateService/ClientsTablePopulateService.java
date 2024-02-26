package PopulateService;

import Storage.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientsTablePopulateService {
    public static void main(String[] args) {
        Connection connection = Database.getINSTANCE().getConnection();

        String[] clientNames = {"Michael Jordan", "John Johnson", "Sarah Jigsaw", "Andrew Ivanovich", "Roger Moore"};

        try(
                PreparedStatement ps = connection.prepareStatement
                ("INSERT INTO client (NAME) VALUES (?)")
        ) {

            for (String name: clientNames) {
                ps.setString(1, name);
                ps.addBatch();
            }

            ps.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
