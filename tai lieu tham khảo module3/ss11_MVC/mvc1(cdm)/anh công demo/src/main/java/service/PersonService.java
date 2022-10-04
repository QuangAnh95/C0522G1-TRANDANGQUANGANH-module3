package service;

import model.Person;
import repository.IPersonRepository;
import repository.PersonRepository;

import java.util.List;

public class PersonService implements IPersonService {
    private IPersonRepository iPersonRepository = new PersonRepository();
    @Override
    public List<Person> list() {
        return iPersonRepository.list();
    }

    @Override
    public List<Person> searchByName(String name) {
        return iPersonRepository.searchByName(name);
    }
}
