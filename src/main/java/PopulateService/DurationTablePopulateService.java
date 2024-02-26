package PopulateService;

import Storage.Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DurationTablePopulateService {
    public static void main(String[] args) {
        Connection connection = Database.getINSTANCE().getConnection();

        int[] clientId = {1, 2, 1, 2, 3, 4, 5, 1, 1, 5};

        String[] startDates = {
                "2023-01-08", "2016-05-01", "2020-03-26", "2019-04-13", "2017-08-30",
                "2020-12-10", "2018-01-01", "2013-11-11", "2022-07-01", "2023-08-01"
                };

        String[] finishDates = {
                "2023-08-24", "2022-06-13", "2022-07-26", "2021-09-20", "2020-01-09",
                "2022-02-24", "2023-10-10", "2017-12-12", "2023-05-05", "2023-09-02"
                };

        try(
                PreparedStatement ps = connection.prepareStatement
                ("INSERT INTO project(CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?, ?, ?)");
        ) {

            for (int i = 0; i < clientId.length; i++) {
                ps.setInt(1, clientId[i]);
                ps.setDate(2, Date.valueOf(startDates[i]));
                ps.setDate(3, Date.valueOf(finishDates[i]));
                ps.addBatch();
            }

            ps.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
