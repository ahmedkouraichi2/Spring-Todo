package com.enotes.repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enotes.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CategoryRepository  extends JpaRepository<Category,Long>{
	
	List<Category> findCategoryByUser(Long userId);
	
	@Query("select t.category.id from Todo t where t.id = :todoId")
    Long findCategoryByTodoId(Long todoId);
	
	
	@Query("select c from Category c inner join Todo t on t.category.id = c.id where t.startDate >= :startDate and t.startDate <= :endDate and c.user.id = :userId")
	List<Category> getAllTodoByCategoriesForToday(@Param("startDate") ZonedDateTime startDate, @Param("endDate") ZonedDateTime endDate, @Param("userId")Long userId);
	

	

}
