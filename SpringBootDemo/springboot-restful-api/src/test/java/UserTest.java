import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.andy.main.pojo.User;

public class UserTest {

	@Test
	public void testUse() {
		List<User> list = new ArrayList<User>();
		User user;
		for(int i=0;i<10;i++) {
		    user = new User();
			user.setAge(20+i);
			user.setName("Andy"+i);
			list.add(user);
		}
		for(User user1:list) {
			System.out.println(user1);
		}	
	}
	
	@Test
	public void testContains() {
		System.out.println(",Andy0,Andy1,Andy2,".contains(",Andy1,"));
		System.out.println(",Andy0,Andy1,Andy2,".contains(",Andy,"));
	}
	
	
}
