package services;

import dto.CategoryDto;
import java.util.List;

import com.enotes.entity.Category;

public interface CategoryService {
	CategoryDto save(CategoryDto category);
	List<CategoryDto> findAll();
	Category findById(Long id);
	List<CategoryDto> findAllByUserId(Long userId);
    void delete(Long id);
    List<CategoryDto> getAllTodoByCategoriesForToday(Long userId);

}









