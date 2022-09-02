package maksym.kruhovykh.moneyk.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import maksym.kruhovykh.moneyk.dto.CategoryDto;
import maksym.kruhovykh.moneyk.service.CategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/category")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryController {
    CategoryService categoryService;

    @PostMapping
    @ResponseStatus(CREATED)
    CategoryDto createCategory(@Validated @RequestBody CategoryDto categoryDto) {
        return categoryService.createCategory(categoryDto);
    }

    @GetMapping("/{categoryId}")
    @ResponseStatus(OK)
    CategoryDto findById(@PathVariable("categoryId") Long categoryId) {
        return categoryService.findCategoryById(categoryId);
    }

    @PutMapping("/{categoryId}")
    @ResponseStatus(OK)
    CategoryDto update(@PathVariable("categoryId") Long categoryId, @Validated @RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(categoryId, categoryDto);
    }
}

