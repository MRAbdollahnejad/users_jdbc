import entity.User;
import repository.UserRepository;

public class Main {
    public static void main(String[] args) {
        User user=new User("ali","123");
        UserRepository userRepository=new UserRepository();
        userRepository.save(user);
        System.out.println(user.getUserId());

    }
}
