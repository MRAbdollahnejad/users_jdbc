import entity.User;
import repository.UserRepository;

public class Main {
    public static void main(String[] args) {

//        User[] user=new User[5];
//        user[0]=new User("omid","123");
//        user[1]=new User("mohammad","123");
//        user[2]=new User("javad","123");
//        user[3]=new User("nilofar","123");
//        user[4]=new User("fateme","123");
        UserRepository userRepository = new UserRepository();
//        userRepository.saveAll(user);

        //userRepository.save(user);
        //System.out.println(user.getUserId());
        //userRepository.delete(1);
//        User showUser=userRepository.load(4);
//        System.out.println(showUser.toString());
        System.out.println(userRepository.load(3).toString());
        User user2=userRepository.load(3);
//        User user = new User(3, "reza", "123");
//    userRepository.save(user);
        user2.setPassword("234");
        userRepository.update(user2);
        System.out.println(userRepository.load(3).toString());
    }
}
