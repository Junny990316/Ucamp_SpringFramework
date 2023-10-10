package myspring.di.strategy1.dao2;

import java.util.List;
import myspring.user.vo.UserVO;

public interface UserDao {

	public List<UserVO> readAll();

	public UserVO read(int id);

}
