package kodlamaio.northwind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguagesRegisterDto {
	private int id;
	private int candidate_cv_id;
	private int candidate_id;
	private String languages;
	private String level;
	

}
