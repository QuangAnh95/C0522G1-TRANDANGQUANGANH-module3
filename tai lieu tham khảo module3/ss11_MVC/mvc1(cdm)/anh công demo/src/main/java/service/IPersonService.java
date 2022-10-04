package service;

import model.Person;

import java.util.List;

public interface IPersonService {
    List<Person> list();
    List<Person> searchByName(String name);
}
