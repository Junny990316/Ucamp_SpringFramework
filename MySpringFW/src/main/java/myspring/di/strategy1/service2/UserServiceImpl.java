package myspring.di.strategy1.service2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import myspring.di.strategy1.dao2.UserDao;
import myspring.user.vo.UserVO;

@Component("UserServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;	

	public List<UserVO> getUserList() {
		return userdao.readAll();
	}

	@Override
	public UserVO getUser(int index) {
		return userdao.read(index);
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

}
