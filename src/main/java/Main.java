import entity.User;
import repository.UserRepository;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        User[] user=new User[5];

        UserRepository userRepository = new UserRepository();

        user=userRepository.loadAll(3);
        System.out.println(Arrays.toString(user));
//        userRepository.saveAll(user);

        //userRepository.save(user);
        //System.out.println(user.getUserId());
        //userRepository.delete(1);
//        User showUser=userRepository.load(4);
//        System.out.println(showUser.toString());
//        System.out.println(userRepository.load(3).toString());
//        User user2=userRepository.load(3);
//        User user = new User(3, "reza", "123");
//    userRepository.save(user);
//        user2.setPassword("234");
//        userRepository.update(user2);
//        System.out.println(userRepository.load(3).toString());
    }
}
