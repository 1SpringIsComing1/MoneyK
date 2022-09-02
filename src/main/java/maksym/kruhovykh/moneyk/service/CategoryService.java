package maksym.kruhovykh.moneyk.service;

import maksym.kruhovykh.moneyk.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto findCategoryById(Long id);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(Long id, CategoryDto categoryDto);

    void deleteCategoryById(Long id);
}
