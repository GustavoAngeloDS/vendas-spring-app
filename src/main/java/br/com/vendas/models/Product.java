package br.com.vendas.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String description;


	@OneToMany(mappedBy = "order")
	@JsonIgnore
	private Set<OrderItem> orderItens = new HashSet<>();
}
