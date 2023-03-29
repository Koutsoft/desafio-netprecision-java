# Desafio NetPrecision em Java

O desafio consiste em criar um sistema básico para auxiliar as vendas de uma  lanchonete 

# Tecnologias utilizadas

<blockquote>
   <p> Java 11</p>
   <p>Banco H2</p> 
   <p>Docker</p>  
   <p>Insomnia </p> 
  <p>Spring-boot</p>   
</blockquote>

# Features


- [x] Criar um pedido
- [x] Fechamento do pedido
- [x] Calcular o valor final do pedido
- [x] Listar todos os pedidos
- [x] Deletar o pedido
- [x] Listar todos os produtos


 
 # Endpoints
 
 Para criar um pedido
 
 Criar pedido POST /pedidos e assim será criado automaticamente um novo pedido.
 

>[http://localhost:8080/pedidos/]()

Adiciona um novo produto ao pedido usando o  PUT /pedidos/{idDoPedido}/{idDoProduto}/{quantidade}


>[http://localhost:8080/pedidos/{idDoPedido}/{idDoProduto}/{quantidade}]()


Fechamento do pedido e retornando o valor do pedido e do troco usando o PUT a /pedidos/{idDoPedido}/{valorAserpago}

>[http://localhost:8080/pedidos/{id}/{valorAserpago}]()


Calcular o valor final do pedido usando o GET /pedidos{idDoPedido} 
>[http://localhost:8080/pedidos/{id}]()

Listar todos os pedidos usando o GET /pedidos


>[http://localhost:8080/pedidos/]()


Deletar o pedido usando o DELETE /pedidos/{idPedido}/{idDoProtudo}/{quantidade}

>[http://localhost:8080/pedidos/{idPedido}/{idDoProtudo}/{quantidade}]()


Listar todos os produtos usando GET /produtos

>[http://localhost:8080/produtos/]()



