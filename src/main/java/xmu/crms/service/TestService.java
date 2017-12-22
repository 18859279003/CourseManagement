package xmu.crms.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import xmu.crms.mapper.TestMapper;
import xmu.crms.model.User;
@Transactional
public class TestService {
	public TestMapper test;
	 public List<User> getAll() {
	        // TODO Auto-generated method stub
	        return test.getUser();
	    }

}
