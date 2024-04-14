package com.MMS.MMS.service.entityServices;

import com.MMS.MMS.model.User;
import com.MMS.MMS.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // No DTOs allowed here!

    private final UserRepository userRepo;

    public UserService(UserRepository userRepository) {
        this.userRepo = userRepository;
    }

    public User getUserById(ObjectId userId) throws UserNotFoundException {
        User user = userRepo.findUserByUserID(userId);

        if(user == null){
            throw new UserNotFoundException();
        }
        return user;
    }

    public void deleteUserById(ObjectId userID) throws UserNotFoundException {

        User user = getUserById(userID);
        userRepo.deleteUserByUserID(user.getUserID());

    }

    public void saveUser(User user) throws BadUserDataException {

        try {
            userRepo.save(user);
        }
        catch(Exception e){
            throw new BadUserDataException();
        }

    }

}
