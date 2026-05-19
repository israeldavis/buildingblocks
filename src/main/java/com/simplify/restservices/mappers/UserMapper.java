package com.simplify.restservices.mappers;

import com.simplify.restservices.dtos.UserMsDto;
import com.simplify.restservices.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // User Object
    // User to UserDto
    @Mappings({
            @Mapping(source = "id" ,target = "userid"),
            @Mapping(source = "email" ,target = "emailaddress")
    })
    UserMsDto userToUserMsDto(User user);

    //List<User> to List<UserDto>
    List<UserMsDto> usersToUserDtos(List<User> users);

}
