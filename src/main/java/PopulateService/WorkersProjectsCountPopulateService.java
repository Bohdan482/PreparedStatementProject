package PopulateService;

import Storage.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorkersProjectsCountPopulateService {
    public static void main(String[] args) {
        Connection connection = Database.getINSTANCE().getConnection();

        int[] projectId =
                {1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 9, 10, 10, 10, 10};

        int[] workerId =
                {9, 7, 6, 9, 3, 10, 7, 1, 9, 7, 5, 6, 9, 1, 2, 4, 6, 9, 4, 1, 2, 3, 5, 9, 1, 2, 3, 5, 1, 8, 4, 5};

        try (
                PreparedStatement ps = connection.prepareStatement
                        ("INSERT INTO project_worker(PROJECT_ID, WORKER_ID) VALUES(?, ?)")
        ) {

            for (int i = 0; i < projectId.length; i++) {
                ps.setInt(1, projectId[i]);
                ps.setInt(2, workerId[i]);
                ps.addBatch();
            }

            ps.executeBatch();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
