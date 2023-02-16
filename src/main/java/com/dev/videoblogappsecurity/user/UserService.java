package com.dev.videoblogappsecurity.user;

import com.dev.videoblogappsecurity.configuration.JwtException;
import com.dev.videoblogappsecurity.configuration.JwtProvider;
import com.dev.videoblogappsecurity.secrets.SecretService;
import com.dev.videoblogappsecurity.shared.Constants;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private SecretService secretService;

    public List<User> allUsers(){
        return userRepository.findAll();
    }

    public String authUser(String username, String pass) throws Exception {
        Optional<User> userOptional = userRepository.findUserByUsername(username);
        if(userOptional.isEmpty()){
           throw new UserException(Constants.HTTP_CODE_NOT_FOUND);
        }
        if(userOptional.get().getPassword().equals(pass)){
            return jwtProvider.generateToken(userOptional.get()
                    .getUsername(),
                    secretService.getApiKey());
        }else{
            throw new Exception(Constants.ERROR_MESSAGE_WHEN_INCORRECT_PASS);
        }
    }


    public String getUsernameFromJWT(String token){
       try{
           return jwtProvider.getUsernameFromToken(token);
       }catch (ExpiredJwtException e){
           throw  new JwtException(Constants.ERROR_MESSAGE_WHEN_JWT_EXPIRED,Constants.HTTP_CODE_JWT_EXPIRED);
       }
    }


    public void addUser(UserRequest request) throws Exception {
        Optional<User> userToFind = userRepository.findUserByUsername(request.getUsername());
        if(userToFind.isPresent()){
            throw new UserException(Constants.CODE_WHEN_USER_ALREADY_EXISTS);
        }
        try{
            User user = User.builder()
                    .fullname(request.getFullname())
                    .username(request.getUsername())
                    .password(request.getPassword())
                    .build();

            userRepository.save(user);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }









}
