package netgloo.reposotory;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import netgloo.model.Emp;


@Service
public class Employeeserviceimpt implements EmployeeService
{
	@Autowired
	Employeedao dao;
	

	
	public List<Emp> createEmployee(List<Emp> emp)
	{
		return dao.insert(emp);
	}



	public Collection<Emp> FindbyNameAndlocations(String string) {
		// TODO Auto-generated method stub
		return dao.FindbyNameAndlocations(string);
	}




	}





