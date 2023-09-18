package org.example.app.repositories.positions;

import org.example.app.database.DBConn;
import org.example.app.entities.Position;
import org.example.app.utils.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PositionReadRepository {

    List<Position> list;

    public List<Position> readPositions() {

        try (Statement stmt = DBConn.connect().createStatement()) {

            list = new ArrayList<>();

            String sql = "SELECT id, name FROM " + Constants.TABLE_POSITIONS;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(new Position(
                        rs.getInt("id"),
                                rs.getString("name")
                        )
                );
            }
            // Повертаємо колекцію даних
            return list;
        } catch (SQLException e) {
            // Якщо помилка, повертаємо порожню колекцію
            return Collections.emptyList();
        }
    }
}
