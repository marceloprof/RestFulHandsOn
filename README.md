# RestFulHandsOn
Hands On Backend Restful Java

Endpoints para os servicos de abastecimento

#RESTFUL Jersey 2.19
Foi utilizado a tecnologia Restful Jersey 1.8 baseada na especificação JAX-RS. Escolhida pela portabilidade, ja que por exemplo a implementação do RestEasy, nativa do JBoss não permite o empacotamento das depenências para deploy neste servidor. Devido às premissa da 12factor a aplicação tem que ser independente de servidores e portanto escolhida esta opção.

#SERVERS
A aplicação foi construída e homologada no Wildfly 8.2.1, mas pode ser implatada em servidores java web

#MAVEN
A gestão de dependência e build é realizada pelo MAVEN pela facilidade e grande aplicação no mercado. O build da aplicação deve ser realizado com os comandos: #CLEAN INSTALL caso esteja utilzando o Wildfly, a aplicação já está com o POM.XML configurado para utilizar o plugin deste servidor, somente acrescente o #wildfly:deploy junto aos comandos do Maven.

#DADOS
Os dados estão sendo persistidos em um arquivo JSON temporariamente, mas deverá ser adicionado um modulo de persistencia mais robusto, como sugestão o MONGO DB, que já persiste o JSON diretamente.

#TESTES UNITÁRIOS
Os testes unitários utlizam da própria API do Jersey: jersey-test-framework-core que facilita a execução dos testes atraves de containers em memoria ou externo, com uma configuração bem simples.

