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

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static maksym.kruhovykh.moneyk.shared.Constants.ExceptionMessages.COULD_NOT_UPDATE_ENTITY_WITH_ID;
import static maksym.kruhovykh.moneyk.shared.Constants.ExceptionMessages.ENTITY_NOT_FOUND_WITH_ID;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category mappedCategory = categoryMapper.mapDtoToEntity(categoryDto);
        Category category = categoryRepository.save(mappedCategory);
        return categoryMapper.mapEntityToDto(category);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> {
            String message = String.format(ENTITY_NOT_FOUND_WITH_ID, id);
            log.info(message);
            return new EntityNotFoundException(message);
        });

        return categoryMapper.mapEntityToDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        if (categoryRepository.findById(categoryDto.getId()).isPresent()) {
            Category mappedCategory = categoryMapper.mapDtoToEntity(categoryDto);
            Category savedCategory = categoryRepository.save(mappedCategory);
            return categoryMapper.mapEntityToDto(savedCategory);
        } else {
            throw new EntityNotFoundException(String.format(COULD_NOT_UPDATE_ENTITY_WITH_ID, categoryDto.getId()));
        }
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
