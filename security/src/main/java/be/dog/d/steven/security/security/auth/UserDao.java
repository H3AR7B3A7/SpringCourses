package be.dog.d.steven.security.security.auth;

import java.util.Optional;

public interface UserDao {

    public Optional<User> selectUserByUsername(String username);

}
