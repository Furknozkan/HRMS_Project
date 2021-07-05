package kodlamaio.northwind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployerDto {
	private int id;
	private String emailAddress;
	private String password;
	private String companyName;
	private String webAddress;
	private String phoneNumber;



}
