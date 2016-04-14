package br.com.emmanuelneri.model;

import br.com.emmanuelneri.utils.LocalDateJsonAdapter;
import br.com.emmanuelneri.utils.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Pessoa implements Model<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro = LocalDate.now();

    @NotNull
    @Size(min = 1)
    private String nome;

    @NotNull
    @Size(min = 14, max = 11)
    private String cpf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @XmlJavaTypeAdapter(LocalDateJsonAdapter.class)
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
}
