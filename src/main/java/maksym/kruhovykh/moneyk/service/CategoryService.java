package maksym.kruhovykh.moneyk.service;

import maksym.kruhovykh.moneyk.dto.CategoryDto;

import java.util.List;
public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(Long id);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(CategoryDto categoryDto);

    void deleteCategoryById(Long id);
}
