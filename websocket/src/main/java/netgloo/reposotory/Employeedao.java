package netgloo.reposotory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import netgloo.model.Emp;

@Repository
public interface Employeedao  extends MongoRepository<Emp,Integer > ,UserDal
{

	/*List<Employee> findByName(String name); 
	//findByName(String name);
*/	
}


