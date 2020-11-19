package com.abhisheksharma.fourthwall.cinema.service;

import com.abhisheksharma.fourthwall.cinema.domain.User;
import com.abhisheksharma.fourthwall.cinema.service.dto.UserDTO;

public interface UserService {

    User registerUser(UserDTO userDTO, String password);
}
