package kodlamaio.northwind.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.northwind.core.utilities.helpers.imageHelper.ImageUploadService;
import kodlamaio.northwind.core.utilities.helpers.imageHelper.cloudinary.CloudinaryImageManager;

@Configuration
public class AppConfiguration {
	public Environment environment;
	
	
	@Bean
	public Cloudinary cloudinaryService() {
		return new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dbvgqit6v",
				"api_key", "238378879683936",
				"api_secret", "jRlQPutI9ypL9ZLNy2pkOf092wE"));
		
	}
	

	@Bean 
	public ImageUploadService imageService() {
		return new CloudinaryImageManager(cloudinaryService());
	}
}
