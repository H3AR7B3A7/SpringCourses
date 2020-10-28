package be.dog.d.steven.security.security;

import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static be.dog.d.steven.security.security.UserPermission.*;

@RequiredArgsConstructor
public enum UserRole {
    ADMIN(Sets.newHashSet(
            COURSE_READ,
            COURSE_WRITE,
            STUDENT_READ,
            STUDENT_WRITE)),

    STUDENT(Sets.newHashSet());

    private final Set<UserPermission> permissions;

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
}