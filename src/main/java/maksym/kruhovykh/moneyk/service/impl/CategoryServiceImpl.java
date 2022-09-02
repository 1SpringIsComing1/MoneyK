package maksym.kruhovykh.moneyk.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import maksym.kruhovykh.moneyk.dto.CategoryDto;
import maksym.kruhovykh.moneyk.repository.CategoryRepository;
import maksym.kruhovykh.moneyk.repository.entity.Category;
import maksym.kruhovykh.moneyk.service.CategoryService;
import maksym.kruhovykh.moneyk.service.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    @PostConstruct
    public void init(){
        log.info("Category Service is created");
    }
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category mappedCategory = categoryMapper.mapDtoToEntity(categoryDto);
        Category category = categoryRepository.save(mappedCategory);
        return categoryMapper.mapEntityToDto(category);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return null;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return null;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public void deleteCategoryById(Long id) {

    }
}
