package team3.FinalBuildWeek.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team3.FinalBuildWeek.auth.authDTO.LoginRegisterDTO;
import team3.FinalBuildWeek.auth.authDTO.UserLoginDTO;
import team3.FinalBuildWeek.auth.user.User;
import team3.FinalBuildWeek.auth.user.UserDTO;
import team3.FinalBuildWeek.auth.user.UserSRV;
import team3.FinalBuildWeek.exceptions.BadRequestException;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthCTRL {
    @Autowired
    private AuthSRV authSRV;
    @Autowired
    private UserSRV userSRV;


    @PostMapping("/login")
    public LoginRegisterDTO login(@RequestBody @Validated UserLoginDTO payload, BindingResult validation) throws IOException {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        return new LoginRegisterDTO(authSRV.authenticateUserAndGenerateToken(payload));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@RequestBody @Validated UserDTO userDTO, BindingResult validation) throws IOException {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }

        return this.userSRV.save(userDTO);
    }

}
