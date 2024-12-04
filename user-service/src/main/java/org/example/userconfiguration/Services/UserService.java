package org.example.userconfiguration.Services;


import jakarta.transaction.Transactional;
import org.example.userconfiguration.dto.UserDto;
import org.example.userconfiguration.entities.User;
import org.example.userconfiguration.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Transactional
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users
                .stream()
                .map(user -> mapper.map(user, UserDto.class))
                .toList();
    }

    public UserDto getUserById(Long id) {
        return userRepository
                .findById(id).map(user -> mapper.map(user, UserDto.class))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return null;
        }
        return mapper.map(user, UserDto.class);
    }


    public UserDto createUser(UserDto userDto) {
        // check if user already exists
        if (getUserByEmail(userDto.getEmail()) != null) {
            throw new RuntimeException("User already exists");
        }
        //return mapper.map(userRepository.save(mapper.map(userDto, User.class)), UserDto.class);
        userRepository.save(mapper.map(userDto, User.class));
        return userDto;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user = mapper.map(userDto, User.class); // update the
        user.setId(id);

        userRepository.save(user);
        return userDto;
    }
}
