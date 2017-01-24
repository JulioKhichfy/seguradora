#Criar uma aplica��o de loca��o de pe�as de decora��o para festas.
	
##Entidades (artefatos e festasPreDefinidas e clientes e pedidos)	

	>>*********ADMIN
	cadastro de artefatos
		->id
		->nome
		->descricao
		->categoriacor
		->categoriaMaterial
		->categoriatipoArtefato
		->quantidade
		->peso
		->dimensao
		->preco
		->dataDeReserva
		->disponibilidade
		
	cadastro de festasTemas
		->id
		->nome
		->descricao
		->categoriaTema
		->Set<Artefatos> artefatos
		->preco
		->dataDeReserva
		->disponibilidade
		
												>>********* TODOS
														cadastro de clientes(Decoradora)
															->id
															->nome
															->email
															->cidade
															->Bairro
															->rua
															->numero
															->bloco
															->apartamento
															->cep
															->telefone
															
																						>>********* CLIENTES
																									Cadastro de Pedidos
																										->id
																										->isFestaPredefinida
																										->nomeFesta
																										->Set<Artefatos>
																										->clienteId


Iremos construir uma aplica��o web utilizando:
	- spring-mvc 
	- spring-jdbc (para acessar o banco de dados)
	- spring-orm  (para integrar com hibernate)
	- spring-data-jpa (para abstrair o acesso ao banco de dados)
	- spring-aop  (caso precise implementar orientado a aspecto)
	- MySql DB
	- hibernate
	- c3p0 (biblioteca para multiconex�o) // para n�o precisar ficar "abrindo conex�o toda hora"

- Para construir o Front-End iremos utilizar:
	- javascript
	- jquery
	- bootstrap