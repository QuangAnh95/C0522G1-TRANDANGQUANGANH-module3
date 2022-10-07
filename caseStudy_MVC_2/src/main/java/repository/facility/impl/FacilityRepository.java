package repository.facility.impl;

import model.Facility;
import repository.BaseRepository;
import repository.facility.IFacilityRepository;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {
    private static final String FIND_ALL = "select * from facility where is_delete = 0;";
    private static final String INSERT = "insert into facility(facility_name, facility_area, facility_cost, " +
            "max_people, standard_room, description_other_convenience, pool_area, number_of_floors, facility_free, " +
            "rent_type_id, facility_type_id) values(?,?,?,?,?,?,?,?,?,?,?);";
    private static final String FIND_BY_ID = "select * from facility where facility_id = ? and is_delete = 0;";
    private static final String UPDATE = "update facility set facility_name = ?, facility_area = ?, " +
            "facility_cost = ?, max_people = ?, standard_room = ?, description_other_convenience = ?, " +
            "pool_area = ?, number_of_floors = ?, facility_free = ?, rent_type_id = ?, facility_type_id = ? " +
            "where facility_id = ? and is_delete = 0;";
    private static final String DELETE = "update facility set is_delete = 1 where facility_id = ? and is_delete = 0;";
    private static final String SEARCH = "select * from facility f join facility_type t on f.facility_type_id = " +
            "t.facility_type_id where f.is_delete = 0 and f.facility_name like ? and t.facility_type_name like ?;";
    @Override
    public List<Facility> findAll() {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("facility_id");
                String name = resultSet.getString("facility_name");
                int area = resultSet.getInt("facility_area");
                double cost= resultSet.getDouble("facility_cost ");
                int maxPeople = resultSet.getInt("max_people");
                String standardRoom = resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                int rentType = resultSet.getInt("rent_type_id ");
                int facilityType = resultSet.getInt("facility_type_id ");
                Facility facility = new Facility(id,name,area,cost,maxPeople,standardRoom,description,poolArea,numberOfFloors,facilityFree,rentType,facilityType);
                facilityList.add(facility);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return facilityList;
    }

    @Override
    public boolean create(Facility facility) {
        return false;
    }

    @Override
    public Facility findById(int idFind) {
        return null;
    }

    @Override
    public boolean edit(Facility facility) {
        return false;
    }

    @Override
    public boolean delete(int idDelete) {
        return false;
    }

    @Override
    public List<Facility> search(String nameSearch, String facilityTypeSearch) {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1,"%" + nameSearch + "%" );
            preparedStatement.setString(1, "%" + facilityTypeSearch + "%" );
            ResultSet resultSet =preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("facility_id");
                String name = resultSet.getString("facility_name");
                int area = resultSet.getInt("facility_area");
                double cost= resultSet.getDouble("facility_cost ");
                int maxPeople = resultSet.getInt("max_people");
                String standardRoom = resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                int rentType = resultSet.getInt("rent_type_id ");
                int facilityType = resultSet.getInt("facility_type_id ");
                Facility facility = new Facility(id,name,area,cost,maxPeople,standardRoom,description,poolArea,numberOfFloors,facilityFree,rentType,facilityType);
                facilityList.add(facility);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facilityList;
    }
}
