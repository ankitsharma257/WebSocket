package netgloo.reposotory;

import java.util.List;
import java.util.Optional;


import netgloo.model.Emp;

public interface UserDal 
{
	public List<Emp> FindbyNameAndlocations(String loaction);
}
