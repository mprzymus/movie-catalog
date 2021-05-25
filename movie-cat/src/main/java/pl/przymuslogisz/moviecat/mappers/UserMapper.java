package pl.przymuslogisz.moviecat.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.przymuslogisz.moviecat.dtos.UserDto;
import pl.przymuslogisz.moviecat.model.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);
}
