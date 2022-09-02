package maksym.kruhovykh.moneyk.service.mapper;

import maksym.kruhovykh.moneyk.dto.CategoryDto;
import maksym.kruhovykh.moneyk.repository.entity.Category;
import org.springframework.stereotype.Component;

@org.mapstruct.Mapper(componentModel = "spring")
@Component
public interface CategoryMapper extends Mapper<Category, CategoryDto> {
}
