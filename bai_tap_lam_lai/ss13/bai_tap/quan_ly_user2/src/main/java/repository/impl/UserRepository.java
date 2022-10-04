package repository.impl;

import model.User;
import repository.BaseRepository;
import repository.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String SELECT = "select * from users;";
    private static final String SAVE = "insert into users(`name`,email,country)\n" +
            "values (?,?,?)";
    private  static final String SELECT_2 = "call userlist()";
    private static final String UPDATE_USERS_SQL_2 = "call edit_list(?,?,?,?);";
    private static final String DELETE = "delete from users where id = ?";
    private static final String DELETE_2 = "call edit_list()";
    private static final String FIND = "select * from users where id = ?";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    @Override
    public List<User> list() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            User user;
//           PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
//            ResultSet resultSet = preparedStatement.executeQuery();
            CallableStatement callableStatement = connection.prepareCall(SELECT_2);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                user = new User();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email=resultSet.getString("email");
                String country= resultSet.getString("country");
                user.setId(id);
                user.setName(name);
                user.setEmail(email);
                user.setCountry(country);
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public void save(User user) {
        Connection connection= BaseRepository.getConnectDB();
            try {
                CallableStatement callableStatement = connection.prepareCall(DELETE_2);
                callableStatement.setString(1, user.getName());
                callableStatement.setString(2, user.getEmail());
                callableStatement.setString(3, user.getCountry());
                callableStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }



    @Override
    public void delete(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        User user = null;
        Connection connection= BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country= resultSet.getString("country");
                user = new User(id1,name,email,country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean updateUser(User user) {
//        boolean rowUpdated = false;
//        try (Connection connection= BaseRepository.getConnectDB();
//             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
//            statement.setString(1, user.getName());
//            statement.setString(2, user.getEmail());
//            statement.setString(3, user.getCountry());
//            statement.setInt(4, user.getId());
//
//            rowUpdated = statement.executeUpdate() > 0;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return rowUpdated;
//    }
        boolean rowUpdated = false;
        try (Connection connection= BaseRepository.getConnectDB();
             CallableStatement callableStatement = connection.prepareCall(UPDATE_USERS_SQL_2);) {
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            callableStatement.setInt(4, user.getId());

            rowUpdated = callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }
}
