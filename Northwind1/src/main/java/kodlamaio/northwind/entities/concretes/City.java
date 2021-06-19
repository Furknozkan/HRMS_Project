package kodlamaio.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cities")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
public class City {
	@Id
	@GeneratedValue
	@Column(name="city_id")
	private int city_id;
	
	@Column(name="name")
	private String cityName;
	


}
