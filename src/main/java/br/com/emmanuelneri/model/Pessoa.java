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

    @NotNull(message = "Data de cadastro não pode ser nula")
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro = LocalDate.now();

    @NotNull(message = "Nome não pode ser nulo")
    @Size(min = 1, max = 200)
    private String nome;

    @NotNull(message = "CPF não pode ser nulo")
    @Size(min = 11, max = 11, message = "CPF deve conter 11 dígitos")
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
