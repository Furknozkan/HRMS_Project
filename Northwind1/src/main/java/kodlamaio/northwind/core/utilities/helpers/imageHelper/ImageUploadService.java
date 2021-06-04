package kodlamaio.northwind.core.utilities.helpers.imageHelper;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.northwind.core.utilities.results.DataResult;

public interface ImageUploadService {
	DataResult<?> save(MultipartFile image);

}
