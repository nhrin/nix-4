package dao;

import lombok.SneakyThrows;
import models.Location;
import models.Problem;
import models.Route;
import models.Solution;
import util.Graphs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    private static final String url = "jdbc:postgresql://localhost:5432/db_unit_10_jdbc";
    private static final String username = "postgres";
    private static final String password = "1488";


    @SneakyThrows
    public static List<Location> findAllLocations() {
        List<Location> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            connection.getCatalog();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM location");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                list.add(new Location(id, name));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @SneakyThrows
    public static Problem addingProblem(String from, String to) {
        List<Location> list = findAllLocations();
        Problem problem = new Problem();
        for (Location location : list) {
            if (location.getCityName().equals(from)) {
                problem.setIdFrom(location.getId());
            }
            if (location.getCityName().equals(to)) {
                problem.setIdTo(location.getId());
            }
        }
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Problem (from_id, to_id) VALUES (?, ?)");
            statement.setInt(1, problem.getIdFrom());
            statement.setInt(2, problem.getIdTo());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return problem;
    }

    public static int[][] getMatrix() {

        List<Route> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            connection.getCatalog();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM route");
            while (rs.next()) {
                int id = rs.getInt(1);
                int fromId = rs.getInt(2);
                int toId = rs.getInt(3);
                int cost = rs.getInt(4);
                list.add(new Route(id, fromId, toId, cost));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int[][] matrix = new int[list.size()][list.size()];
        for (Route route : list) {
            matrix[route.getIdFrom()][route.getIdTo()] = route.getCost();
        }
        return matrix;
    }

    public static List<Problem> getProblems() {
        List<Problem> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            connection.getCatalog();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM problem");
            while (rs.next()) {
                int id = rs.getInt(1);
                int idFrom = rs.getInt(2);
                int idTo = rs.getInt(3);
                list.add(new Problem(id, idFrom, idTo));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @SneakyThrows
    public void addSolution() {
        List<Problem> problems = getProblems();
        List<Solution> solutions = new ArrayList<>();
        int[][] matrix = getMatrix();
        for (Problem problem : problems) {
            int cost = Graphs.dijkstra(problem.getIdFrom(), problem.getIdTo(), matrix);
            solutions.add(new Solution(problem.getId(), cost));
        }
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Solution (problem_id, cost) VALUES (?, ?)");

            for (Solution solution : solutions) {
                statement.setInt(1, solution.getIdProblem());
                statement.setInt(2, solution.getCost());
                statement.execute();
            }

        }

    }
}
