package myspring.di.strategy1.service2;

import java.util.List;

import myspring.user.vo.UserVO;

public interface UserService {
	
	public List<UserVO> getUserList();

	public UserVO getUser(int index);
	
}
