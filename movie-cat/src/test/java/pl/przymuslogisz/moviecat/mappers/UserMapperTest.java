package pl.przymuslogisz.moviecat.mappers;

import org.junit.jupiter.api.Test;
import pl.przymuslogisz.moviecat.model.User;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {
    private final UserMapper userMapper = UserMapper.INSTANCE;

    private final static Long ID = 3L;
    private final static String USER_NAME = "Some_name";

    @Test
    void userToUserDto() {
        User user = createUser();

        var mapped = userMapper.userToUserDto(user);

        assertEqualsToConst(mapped);
    }

    public static void assertEqualsToConst(pl.przymuslogisz.moviecat.dtos.UserDto mapped) {
        assertEquals(mapped.id(), ID);
        assertEquals(mapped.userName(), USER_NAME);
    }

    public static User createUser() {
        var user = new User();
        user.setId(ID);
        user.setUserName(USER_NAME);
        user.setComments(Set.of());
        user.setLogin("login");
        user.setPassword("pass");
        return user;
    }
}