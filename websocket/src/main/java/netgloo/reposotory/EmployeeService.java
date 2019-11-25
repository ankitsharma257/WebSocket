package netgloo.reposotory;

import java.util.Collection;
import java.util.List;

import netgloo.model.Emp;

public interface EmployeeService 
{
	public List<Emp> createEmployee(List<Emp> emp);

	public Collection<Emp> FindbyNameAndlocations(String string);

}
