package maksym.kruhovykh.moneyk.service.mapper;



public interface Mapper<ENTITY, DTO> {
    ENTITY mapDtoToEntity(DTO dto);

    DTO mapEntityToDto(ENTITY entity);
}
