

## Endpoints da API

#### Login usuario

#### Endpoint login (Metodo Post)
```
http://localhost:8080/login
```

#### Json modelo
```
{
    "email":"teste@gmail.com",
    "password":"1234"
}
```

### Cadastro Usuario

#### Endpoint cadastro (Metodo Post)

```
http://localhost:8080/users
```

#### Json modelo
```
{
 "name": "teste",
 "email": "teste@gmail.com",
 "phone": "11111111",
 "password": "1234"
} 
```


#### Endpoint autalizar dados (Metodo put)

```
http://localhost:8080/users
```

#### Json modelo
```
{
 "name": "teste",
 "email": "teste@gmail.com",
 "phone": "11111111"
} 
```

## Endpoints Para Administração

### Endpoint editar role (Metodo put)

Esse endpoint nao suporta parametros passados no body da requisição

```
# idUSer = id do usuario gerado no banco de dados
# idRole = id do enum registrado na classe UserRole

http://localhost:8080/admin/user/manager/edityrole?idUser=2&idRole=2
```


### Endpoints Para Busca de usuario

#### Endpooint buscar todos (Metodo get)

```
http://localhost:8080/admin/user/manager/list-user
```

#### Endpooint buscar por id (Metodo get)

```
# id = id do usuario
http://localhost:8080/admin/user/manager/user/id
```

### Endpoint para busca de todos os produtos (Metodo get)

```
http://localhost/products
```

### Endpoints de Produtos
#### Endpoint para busca de todos os produtos (Metodo get)

```
http://localhost/products
```

#### Endpoint para busca produto por id (Metodo get)

```
# id = id do produto
http://localhost/products/id
```
### Endpoints de Pedidos
#### Endpoint para busca de todos os pedidos (Metodo get)

```
http://localhost/admin/order
```

#### Endpoint para busca pedido por id (Metodo get)

```
# id = id do pedido
http://localhost/admin/order/id
```
### Endpoints de Categorias
#### Endpoint para busca de todas as categorias (Metodo get)

```
http://localhost/categories
```

#### Endpoint para busca pedido por id (Metodo get)

```
# id = id da categoria
http://localhost/categories/id
```


