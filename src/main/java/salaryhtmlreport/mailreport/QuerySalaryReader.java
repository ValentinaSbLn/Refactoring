package salaryhtmlreport.mailreport;

import salaryhtmlreport.mailreport.Empolyee;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Valentina on 13.11.2016.
 */
public class QuerySalaryReader {

    private final Connection connection;

    public QuerySalaryReader(Connection connection) {
        this.connection = connection;
    }

    public List<Empolyee> readQuery(String departmentId, LocalDate dateFrom, LocalDate dateTo) {
        final List<Empolyee> employees = new ArrayList<>();
        String sqlQuery = "select emp.id as emp_id, emp.name as amp_name, sum(salary) as salary from employee emp left join" +
                "salary_payments sp on emp.id = sp.employee_id where emp.department_id = ? and" +
                " sp.date >= ? and sp.date <= ? group by emp.id, emp.name";

        try (PreparedStatement ps = connection.prepareStatement(sqlQuery);
             ResultSet results = ps.executeQuery()) {

            ps.setString(0, departmentId);
            ps.setDate(1, new Date(dateFrom.toEpochDay()));
            ps.setDate(2, new Date(dateTo.toEpochDay()));
            while (results.next()) {
                employees.add(new Empolyee(results.getString("emp_name"), results.getDouble("salary")));
            }

        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
            return Collections.emptyList();
        }
        return employees;
    }
}

