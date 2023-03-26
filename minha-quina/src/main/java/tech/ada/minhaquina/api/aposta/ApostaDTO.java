package tech.ada.minhaquina.api.aposta;

import lombok.*;
import tech.ada.minhaquina.api.usuario.UsuarioModel;
import tech.ada.minhaquina.api.validation.GameConstraint;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApostaDTO {

    private Integer numeroSorteio;
    @GameConstraint
    private int[] dezenas;
    private LocalDate dataJogo;

    public ApostaDTO(ApostaModel apostaModel){
        this(apostaModel.getNumeroSorteio(), apostaModel.getDezenas(), apostaModel.getDataJogo());
    }

    public static ApostaModel convertToModel(ApostaModel apostaModel, ApostaDTO apostaDTO, UsuarioModel usuarioModel){
        apostaModel.setNumeroSorteio(apostaDTO.getNumeroSorteio());
        apostaModel.setDezenas(apostaDTO.getDezenas());
        apostaModel.setDataJogo(apostaDTO.getDataJogo());
        apostaModel.setUsuario(usuarioModel);
        return apostaModel;
    }
}
