package be.dog.d.steven.multipledb.dao;

import be.dog.d.steven.multipledb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
}
