package sisdoc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sisdoc.model.User;

public class DocumentDAO {

    private Connection connection;

    public DocumentDAO() {
        ConnectionClass con = new ConnectionClass();
        try {
            connection = con.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPerson(User person) {
        try {
            String query = "insert into person(name, phone, profession) values ('" + person.getName() + "', '" + person.getPhone() + "', '" + person.getProfession() + "')";

            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removePerson(int personid) {
        String query = "delete from person where person.idperson = " + personid + " ";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePerson(User person) {
        String query = "update person set person.name='" + person.getName() + "', person.phone='" + person.getPhone()
                + "', person.profession='" + person.getProfession() + "' where person.idperson = " + person.getPersonId() + " ";
        System.out.println(query);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getPersons() throws SQLException {
        String query = "select * from person";
        ArrayList<User> persons = new ArrayList<User>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            User person = new User();
            person.setName(res.getString("name"));
            person.setPhone(res.getString("phone"));
            person.setProfession(res.getString("profession"));
            person.setPersonId(res.getInt("idperson"));
            persons.add(person);
        }
        return persons;
    }

    public User getPersonById(int personid) throws SQLException {
        User person = new User();
        String query = "select * from person where person.idperson = " + personid + " ";
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        if (res.next()) {
            person.setName(res.getString("name"));
            person.setPhone(res.getString("phone"));
            person.setProfession(res.getString("profession"));
            person.setPersonId(res.getInt("idperson"));
        }
        return person;
    }
}
