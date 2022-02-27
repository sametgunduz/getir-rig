package design.boilerplate.readingisgood.security.mapper;

import design.boilerplate.readingisgood.model.User;
import design.boilerplate.readingisgood.model.User.UserBuilder;
import design.boilerplate.readingisgood.security.dto.AuthenticatedUserDto;
import design.boilerplate.readingisgood.security.dto.RegistrationRequest;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-27T19:41:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User convertToUser(RegistrationRequest registrationRequest) {
        if ( registrationRequest == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.name( registrationRequest.getName() );
        user.username( registrationRequest.getUsername() );
        user.password( registrationRequest.getPassword() );
        user.email( registrationRequest.getEmail() );

        return user.build();
    }

    @Override
    public AuthenticatedUserDto convertToAuthenticatedUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        AuthenticatedUserDto authenticatedUserDto = new AuthenticatedUserDto();

        authenticatedUserDto.setName( user.getName() );
        authenticatedUserDto.setUsername( user.getUsername() );
        authenticatedUserDto.setPassword( user.getPassword() );
        authenticatedUserDto.setUserRole( user.getUserRole() );

        return authenticatedUserDto;
    }

    @Override
    public User convertToUser(AuthenticatedUserDto authenticatedUserDto) {
        if ( authenticatedUserDto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.name( authenticatedUserDto.getName() );
        user.username( authenticatedUserDto.getUsername() );
        user.password( authenticatedUserDto.getPassword() );
        user.userRole( authenticatedUserDto.getUserRole() );

        return user.build();
    }
}
