package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonType;

import kodlamaio.northwind.entities.dtos.EmployerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employer_update")
@TypeDefs({
    @TypeDef(name = "json", typeClass = JsonType.class)
})
public class EmployerUpdate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="employer_id")
	private int employerId;
	
	@JsonIgnore
	@Column(name = "verifyed")
    private boolean verifyed;
	
	@Type(type = "json")
	@Column(name="update", columnDefinition = "json")
	private EmployerDto employerUpdate;
	

}
