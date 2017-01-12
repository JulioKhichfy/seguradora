package br.com.seguradora.modelo.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.seguradora.modelo.enumeracoes.CategoriaCarroceria;
import br.com.seguradora.modelo.enumeracoes.CategoriaCombustivel;

@Entity
public class Carro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	private String marca;
	
	@NotNull
	@NotEmpty
	private String modelo;
	
	@NotNull
	@NotEmpty
	private String placa;
	
	@NotNull
	private Date anoFabricacao;
	
	@NotNull
	private Double preco;
	
	@NotNull
	@Enumerated(EnumType.STRING)//para salvar no banco como String
	private CategoriaCombustivel categoriaCombustivel;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private CategoriaCarroceria categoriaCarroceria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Date getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Date anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoFabricacao == null) ? 0 : anoFabricacao.hashCode());
		result = prime * result + ((categoriaCarroceria == null) ? 0 : categoriaCarroceria.hashCode());
		result = prime * result + ((categoriaCombustivel == null) ? 0 : categoriaCombustivel.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
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
		Carro other = (Carro) obj;
		if (anoFabricacao == null) {
			if (other.anoFabricacao != null)
				return false;
		} else if (!anoFabricacao.equals(other.anoFabricacao))
			return false;
		if (categoriaCarroceria != other.categoriaCarroceria)
			return false;
		if (categoriaCombustivel != other.categoriaCombustivel)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		return true;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public CategoriaCombustivel getCategoriaCombustivel() {
		return categoriaCombustivel;
	}

	public void setCategoriaCombustivel(CategoriaCombustivel categoriaCombustivel) {
		this.categoriaCombustivel = categoriaCombustivel;
	}

	public CategoriaCarroceria getCategoriaCarroceria() {
		return categoriaCarroceria;
	}

	public void setCategoriaCarroceria(CategoriaCarroceria categoriaCarroceria) {
		this.categoriaCarroceria = categoriaCarroceria;
	}

}
