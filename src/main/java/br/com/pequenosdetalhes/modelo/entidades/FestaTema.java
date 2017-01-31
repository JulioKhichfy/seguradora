package br.com.pequenosdetalhes.modelo.entidades;


import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.pequenosdetalhes.modelo.enumeracoes.CategoriaTema;


@Entity
public class FestaTema {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	private String nome;
	
	@NotNull
	@NotEmpty
	private String descricao;
	
	private Double preco;
	
	private Date dataDeReserva;
	
	@NotNull
	private Boolean disponibilidade;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private CategoriaTema categoriaTema;
	
	@ManyToOne
	@JoinColumn(name="USUARIO")
	private Usuario usuario; 
	
	//@ManyToMany(fetch=FetchType.EAGER) -> pior maneira de tratar o erro de lazy
	@ManyToMany
	private Set<Artefato> artefatos;
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Date getDataDeReserva() {
		return dataDeReserva;
	}

	public void setDataDeReserva(Date dataDeReserva) {
		this.dataDeReserva = dataDeReserva;
	}

	public Boolean getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public CategoriaTema getCategoriaTema() {
		return categoriaTema;
	}

	public void setCategoriaTema(CategoriaTema categoriaTema) {
		this.categoriaTema = categoriaTema;
	}

	public Set<Artefato> getArtefatos() {
		return artefatos;
	}

	public void setArtefatos(Set<Artefato> artefatos) {
		this.artefatos = artefatos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoriaTema == null) ? 0 : categoriaTema.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FestaTema other = (FestaTema) obj;
		if (categoriaTema != other.categoriaTema)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
