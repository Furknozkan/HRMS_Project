package kodlamaio.northwind.core.utilities.helpers.imageHelper.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.northwind.core.utilities.helpers.imageHelper.ImageUploadService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;

public class CloudinaryImageManager implements ImageUploadService{

	private Cloudinary cloudinary;
	
	
	@Autowired
	public CloudinaryImageManager(Cloudinary cloudinary) {
		super();
		this.cloudinary = cloudinary;
	}


	@Override
	public DataResult<?> save(MultipartFile file) {
		try {
			Map uploadResult = cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
			;
			return new SuccessDataResult<Map>(uploadResult);
		
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		return new ErrorDataResult<Map>();
	}

}
