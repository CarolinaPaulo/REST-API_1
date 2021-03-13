create table ordem_servico(
	id bigint not null auto_increment,
    client_id bigint not null,
    descricao text not null,
    preco decimal(10,2) not null,
	status varchar(20) not null,
    data_avertura datetime not null,
    data_finalizacao datetime,
    
    primary key (id)
);

alter table ordem_servico add constraint fk_ordem_servico_client
foreign key(client_id) references client (id);
