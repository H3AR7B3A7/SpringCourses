package be.dog.d.steven.multipledb.dao;

import be.dog.d.steven.multipledb.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
}
