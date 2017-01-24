#Criar uma aplicação de locação de peças de decoração para festas.
	
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


Iremos construir uma aplicação web utilizando:
	- spring-mvc 
	- spring-jdbc (para acessar o banco de dados)
	- spring-orm  (para integrar com hibernate)
	- spring-data-jpa (para abstrair o acesso ao banco de dados)
	- spring-aop  (caso precise implementar orientado a aspecto)
	- MySql DB
	- hibernate
	- c3p0 (biblioteca para multiconexão) // para não precisar ficar "abrindo conexão toda hora"

- Para construir o Front-End iremos utilizar:
	- javascript
	- jquery
	- bootstrap