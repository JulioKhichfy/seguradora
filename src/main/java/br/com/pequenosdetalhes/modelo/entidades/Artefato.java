package br.com.pequenosdetalhes.modelo.entidades;

//import java.io.File;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.pequenosdetalhes.modelo.enumeracoes.CategoriaCor;
import br.com.pequenosdetalhes.modelo.enumeracoes.CategoriaMaterial;
import br.com.pequenosdetalhes.modelo.enumeracoes.CategoriaTipoArtefato;

@Entity
public class Artefato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	private String nome;
	
	private String descricao;
	
	@NotNull
	@Enumerated(EnumType.STRING)//para salvar no banco como String
	private CategoriaCor categoriaCor;
	
	@NotNull
	@Enumerated(EnumType.STRING)//para salvar no banco como String
	private CategoriaMaterial categoriaMaterial;
	
	@NotNull
	@Enumerated(EnumType.STRING)//para salvar no banco como String
	private CategoriaTipoArtefato CategoriaTipoArtefato;
	
	private Integer quantidade;
	
	private Double peso;
	
	private String dimensao;
	
	private Date dataDeReserva;
	
	private Double preco;
	
	private Boolean disponibilidade;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="artefato_imagemartefato", joinColumns={@JoinColumn(name="artefato_id", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="imagem_artefato_id", referencedColumnName="id")})
	private Set<ImagemArtefato> imagensArtefatos;
		
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

	public CategoriaCor getCategoriaCor() {
		return categoriaCor;
	}

	public void setCategoriaCor(CategoriaCor categoriaCor) {
		this.categoriaCor = categoriaCor;
	}

	public CategoriaMaterial getCategoriaMaterial() {
		return categoriaMaterial;
	}

	public void setCategoriaMaterial(CategoriaMaterial categoriaMaterial) {
		this.categoriaMaterial = categoriaMaterial;
	}

	public CategoriaTipoArtefato getCategoriaTipoArtefato() {
		return CategoriaTipoArtefato;
	}

	public void setCategoriaTipoArtefato(CategoriaTipoArtefato categoriaTipoArtefato) {
		CategoriaTipoArtefato = categoriaTipoArtefato;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getDimensao() {
		return dimensao;
	}

	public void setDimensao(String dimensao) {
		this.dimensao = dimensao;
	}

	public Date getDataDeReserva() {
		return dataDeReserva;
	}

	public void setDataDeReserva(Date dataDeReserva) {
		this.dataDeReserva = dataDeReserva;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Boolean getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Artefato other = (Artefato) obj;
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

	public Set<ImagemArtefato> getImagensArtefatos() {
		return imagensArtefatos;
	}

	public void setImagensArtefatos(Set<ImagemArtefato> imagensArtefatos) {
		this.imagensArtefatos = imagensArtefatos;
	}

	
	
}
