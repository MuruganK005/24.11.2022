package com.candidate.service.Service;

import com.candidate.dto.LogInDTO;
import com.candidate.dto.UserDTO;

public interface UserService {
    String signUp(UserDTO userDTO) throws Exception;

    String login(LogInDTO logInDTO);
}
