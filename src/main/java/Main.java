import entity.User;
import repository.UserRepository;

public class Main {
    public static void main(String[] args) {
        User user=new User("ali","1423");
        UserRepository userRepository=new UserRepository();
        //userRepository.save(user);
        //System.out.println(user.getUserId());
        //userRepository.delete(1);
        User showUser=userRepository.load(4);
        System.out.println(showUser.toString());


    }
}
