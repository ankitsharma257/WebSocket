package netgloo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection="User")
@Data
public class Emp  
{
	@Id
	int id;
	
	String name;
	String locations;
}
