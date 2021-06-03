package kodlamaio.northwind.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolRegisterDto {
	private int id;
	private String name;
	private boolean is_graduate;
	private LocalDate dateOfEntry;
	private LocalDate dateOfGraduation;

}
