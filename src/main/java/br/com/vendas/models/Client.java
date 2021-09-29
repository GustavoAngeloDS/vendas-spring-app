package br.com.vendas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String cpf;

    private String name;

    private String lastname;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private Set<Order> orders = new HashSet<>();


}
