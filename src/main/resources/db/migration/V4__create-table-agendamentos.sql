create table agendamentos(
    id bigint not null auto_increment,
    local_id bigint not null,
    socio_id bigint not null,
    data_inicio timestamp not null,
    data_fim timestamp not null,

    primary key(id),
    constraint fk_schedules_local_id foreign key (local_id) references locais(id),
    constraint fk_schedules_socio_id foreign key (socio_id) references socios(id)
);