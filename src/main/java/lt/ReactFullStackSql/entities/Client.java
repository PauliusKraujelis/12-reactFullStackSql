package lt.ReactFullStackSql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String email;
	
}
