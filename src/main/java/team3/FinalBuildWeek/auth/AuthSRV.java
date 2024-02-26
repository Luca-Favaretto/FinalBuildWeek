package team3.FinalBuildWeek.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team3.FinalBuildWeek.auth.authDTO.UserLoginDTO;
import team3.FinalBuildWeek.auth.security.JWTTools;
import team3.FinalBuildWeek.auth.user.User;
import team3.FinalBuildWeek.auth.user.UserSRV;
import team3.FinalBuildWeek.exceptions.UnauthorizedException;

@Service
public class AuthSRV {
    @Autowired
    private UserSRV userSRV;

    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private PasswordEncoder bcrypt;

    public String authenticateUserAndGenerateToken(UserLoginDTO payload) {

        User user = userSRV.findByEmail(payload.email());
        if (bcrypt.matches(payload.password(), user.getPassword())) {

            return jwtTools.createToken(user);
        } else {

            throw new UnauthorizedException("Wrong credentials!");
        }

    }
}
