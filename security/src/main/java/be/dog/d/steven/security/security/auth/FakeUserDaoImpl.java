package be.dog.d.steven.security.security.auth;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static be.dog.d.steven.security.security.UserRole.*;

@Repository("fake")
@RequiredArgsConstructor
public class FakeUserDaoImpl implements UserDao{

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> selectUserByUsername(String username) {
        return getUsers()
                .stream()
                .filter(user -> username.equals(user.getUsername()))
                .findFirst();
    }

    private List<User> getUsers(){
        List<User> users = Lists.newArrayList(
            new User(
                    "admin",
                    passwordEncoder.encode("admin"),
                    ADMIN.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            ),
            new User(
                    "professor",
                    passwordEncoder.encode("professor"),
                    PROFESSOR.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            ),
            new User(
                    "student",
                    passwordEncoder.encode("student"),
                    STUDENT.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            )
        );

        return users;
    }
}