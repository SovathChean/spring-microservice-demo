package com.example.userservice.core.seeder;

import com.example.userservice.core.dao.UserDAO;
import com.example.userservice.core.dto.UserCreationDTO;
import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder {
    @Autowired
    private UserDAO userDAO;

    @Bean
    CommandLineRunner userSeederRunning()
    {
        List<UserCreationDTO> userCreationDTOList = new ArrayList<>();
        String password = new BCryptPasswordEncoder().encode("password");
        userCreationDTOList.add(new UserCreationDTO("useradmin", password, "+85592707070"));
        for (int i = 0; i < 10; i++)
        {
            userCreationDTOList.add(new UserCreationDTO(
                    "Name"+i,
                    password,
                    "092877899"+i
            ));
        }
        List<UserDTO> userModelList = UserMapper.INSTANCE.fromListUserCreationDTO(userCreationDTOList);
        return args -> {
            for(UserDTO user: userModelList)
            {
                userDAO.insert(user);
            }
        };
    }
}
