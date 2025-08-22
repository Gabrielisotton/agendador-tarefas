package com.isotton.agendadortarefas.business.mapper;

import com.isotton.agendadortarefas.business.dto.TarefasDTO;
import com.isotton.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);
    TarefasDTO paraTarefaDTO(TarefasEntity entity);

}
