package br.com.netprecision.testetecnico.vitoriaoliveira.etidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    @NotBlank
    private String nomeProduto;
    @NotNull
    @Positive
    private BigDecimal preco;
    
    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private List<ProdutoPedido> pedidos = new ArrayList<>();
    

}