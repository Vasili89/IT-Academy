package by.it_academy.jd2.core;

import by.it_academy.jd2.core.dto.Airport;

import java.sql.*;
import java.util.*;

public class AirportsData {

    private  Map<String, Airport> airports;
    private  ArrayList<String> airportsNames;

    public Map<String, Airport> getAirports() throws SQLException, ClassNotFoundException {
        this.airports = createAirportsList();
        return this.airports;
    }

    public ArrayList<String> getAirportsNames() throws SQLException, ClassNotFoundException {
        this.airportsNames = createAirportsNames();
        return this.airportsNames;
    }

    private static Map<String, Airport> createAirportsList() throws SQLException, ClassNotFoundException {
        Map<String, Airport> air = new HashMap<>();
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "postgres");
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM bookings.airports");) {
            while (rs.next()) {
                String city = rs.getString("city");
                String code = rs.getString("airport_code");
                String time = rs.getString("timezone");
                String coord = rs.getString("coordinates");
                air.put(rs.getString("airport_name"), new Airport(city, code, time, coord));
            }
        }
        return air;
    }

    private static ArrayList<String> createAirportsNames() throws SQLException, ClassNotFoundException {
        ArrayList<String> airNames = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "postgres");
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM bookings.airports ORDER BY city");) {
            while (rs.next()) {
                airNames.add(rs.getString("airport_name"));
            }
        }
        return airNames;
    }
}
