package org.ebndrnk.newsystem.service;

import lombok.RequiredArgsConstructor;
import org.ebndrnk.newsystem.mapper.EntityMapper;
import org.ebndrnk.newsystem.model.dao.User;
import org.ebndrnk.newsystem.model.dto.UserDTO;
import org.ebndrnk.newsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
private final UserRepository userRepository;

    public UserDTO saveUser(UserDTO userDTO){
        User user = EntityMapper.mapToUser(userDTO);
        return EntityMapper.mapToUserDTO(userRepository.save(user));
    }

    public List<UserDTO>  saveAll(List<UserDTO> userDTOS){
        List<User> users = userRepository.saveAll(userDTOS.stream()
                .map(EntityMapper::mapToUser)
                .toList());

        return users.stream()
                .map(EntityMapper::mapToUserDTO)
                .toList();
    }
}
