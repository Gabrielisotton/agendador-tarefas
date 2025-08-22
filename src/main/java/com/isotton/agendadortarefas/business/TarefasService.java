package com.isotton.agendadortarefas.business;

import com.isotton.agendadortarefas.business.dto.TarefasDTO;
import com.isotton.agendadortarefas.business.mapper.TarefasConverter;
import com.isotton.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.isotton.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.isotton.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.isotton.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor

public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa( String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);



        return tarefaConverter.paraTarefaDTO(
                tarefasRepository.save(entity));
    }

}
