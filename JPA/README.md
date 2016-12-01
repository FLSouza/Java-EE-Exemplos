# JPA - Java Persistence API 

A especificação JPA serve para unir o paradigma relacional e o orientado a objetos, que são bem diferentes. Os benefícios de se usar JPA é que não é necessário escrever SQL, pois toda a comunicação com o banco é abstraída pela pela especificação.



Relações de cardinalidade:

@ManyToOne - para um relacionamento muitos-para-um 

@OneToMany - para um relacionamento um-para-muitos 

@ManyToMany - para um relacionamento muitos-para-muitos 

@OneToOne - para um relacionamento um-para-um


# MySQL

O banco utilizado nos exemplos é o MySQL - link: http://dev.mysql.com/downloads/ 

As configurações do banco pode ser alteradas no persistence.xml(src->META-INF->persistence.xml). 

# Java 7

Foi utilizado o Java 7 para criação dos exemplos.