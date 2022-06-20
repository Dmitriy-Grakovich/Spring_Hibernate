package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      Car car1 = new Car("Mazda",7);
      user1.setCar(car1);
      userService.add(user1);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      Car car2 = new Car("vaz",2110);
      user2.setCar(car2);
      userService.add(user2);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      Car car3 = new Car("lada", 219170);
      user3.setCar(car3);
      userService.add(user3);



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }
      System.out.println(userService.getUserByCar("vaz", 2110));

      context.close();
   }
}
