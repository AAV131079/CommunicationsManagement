drop table if exists booking;
drop table if exists booking_status_type;
drop table if exists client;
drop table if exists communication;
drop table if exists communication_type;
drop table if exists department;
drop table if exists email;
drop table if exists phone;
drop table if exists role;
drop table if exists rule;
drop table if exists send_channel_type;
drop table if exists sending_channel;
drop table if exists sending_status;
drop table if exists social_media;
drop table if exists user;

create table booking
(
    booking_id bigint not null auto_increment,
    before_date datetime(6) not null,
    create_time datetime(6) not null,
    status varchar(255) not null,
    update_time datetime(6) not null,
    primary key (booking_id)
);

create table booking_status_type
(
    booking_status_type_id bigint not null auto_increment,
    description varchar(255) not null,
    name varchar(255) not null,
    primary key (booking_status_type_id)
);

create table client
(
    client_id bigint not null auto_increment,
    birth_date datetime(6) not null,
    create_time datetime(6) not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    update_time datetime(6) not null,
    booking_id bigint,
    communication_id bigint,
    social_media_id bigint,
    available TINYINT(1) not null DEFAULT '1',
    primary key (client_id)
);

create table communication
(
    communication_id bigint not null auto_increment,
    create_time datetime(6) not null,
    update_time datetime(6) not null,
    booking_id bigint,
    communication_type_id bigint,
    user_id bigint,
    primary key (communication_id)
);

create table communication_type
(
    communication_type_id bigint not null auto_increment,
    description varchar(255) not null,
    name varchar(255) not null,
    primary key (communication_type_id)
);

create table department
(
    department_id bigint not null auto_increment,
    create_time datetime(6) not null,
    full_name varchar(255) not null,
    name varchar(255) not null,
    update_time datetime(6) not null,
    rule_id bigint,
    primary key (department_id)
);

create table email
(
    email_id bigint not null auto_increment,
    create_time datetime(6) not null,
    email varchar(255) not null,
    is_primary bit not null,
    update_time datetime(6) not null,
    client_id bigint,
    user_id bigint,
    primary key (email_id)
);

create table phone
(
    phone_id bigint not null auto_increment,
    country_code varchar(255) not null,
    create_time datetime(6) not null,
    is_primary bit not null,
    operator_code varchar(255) not null,
    phone_number varchar(255) not null,
    update_time datetime(6) not null,
    client_id bigint,
    user_id bigint,
    primary key (phone_id)
);

create table role
(
    role_id bigint not null auto_increment,
    create_time datetime(6) not null,
    description varchar(255) not null,
    name varchar(255) not null,
    update_time datetime(6) not null,
    user_id bigint,
    primary key (role_id)
);

create table rule
(
    rule_id bigint not null auto_increment,
    blocking_communications bigint not null,
    blocking_period bigint not null,
    communication_limit bigint not null,
    create_time datetime(6) not null,
    not_communication_days bigint not null,
    time_limit integer not null,
    update_time datetime(6) not null,
    primary key (rule_id)
);

create table send_channel_type
(
    send_channel_type_id bigint not null auto_increment,
    description varchar(255) not null,
    name varchar(255) not null,
    primary key (send_channel_type_id)
);

create table sending_channel
(
    sending_channel_id bigint not null auto_increment,
    create_time datetime(6) not null,
    update_time datetime(6) not null,
    rule_id bigint,
    send_channel_type_id bigint,
    primary key (sending_channel_id)
);

create table sending_status
(
    sending_status_id bigint not null auto_increment,
    create_time datetime(6) not null,
    delivery_status varchar(255) not null,
    sending_status varchar(255) not null,
    update_time datetime(6) not null,
    communication_id bigint,
    send_channel_type_id bigint,
    primary key (sending_status_id)
);

create table social_media
(
    social_media_id bigint not null auto_increment,
    create_time datetime(6) not null,
    facebook varchar(255),
    instagram varchar(255),
    twitter varchar(255),
    update_time datetime(6) not null,
    primary key (social_media_id)
);

create table user
(
    user_id bigint not null auto_increment,
    birth_date datetime(6) not null,
    create_time datetime(6) not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    password varchar(255) not null,
    update_time datetime(6) not null,
    user_name varchar(255) not null,
    department_id bigint,
    social_media_id bigint,
    primary key (user_id)
);

alter table user add constraint UK_lqjrcobrh9jc8wpcar64q1bfh unique (user_name);
alter table client add constraint FK83h8npyf4pbq9xm7hnv88seho foreign key (booking_id) references booking (booking_id);
alter table client add constraint FK9gn696249twt53wqdgidrkcyf foreign key (communication_id) references communication (communication_id);
alter table client add constraint FKdl9gqmkjdtj7kqsflx43aa9y9 foreign key (social_media_id) references social_media (social_media_id);
alter table communication add constraint FK7uktjs903rws1g728cc89wgul foreign key (booking_id) references booking (booking_id);
alter table communication add constraint FK2ucuf46xehar2bf7j5uwlr3gm foreign key (communication_type_id) references communication_type (communication_type_id);
alter table communication add constraint FKt3k0y4r9lcunh7o0ej8p2ltch foreign key (user_id) references user (user_id);
alter table department add constraint FKcyxum1b9pgexglpunrwm8amg4 foreign key (rule_id) references rule (rule_id);
alter table email add constraint FK7hpes7ib2wlx1opd0aefw9lxd foreign key (client_id) references client (client_id);
alter table email add constraint FK4qxwfk0jqc0au545318wfiqxx foreign key (user_id) references user (user_id);
alter table phone add constraint FK3o48ec26lujl3kf01hwqplhn2 foreign key (client_id) references client (client_id);
alter table phone add constraint FKb0niws2cd0doybhib6srpb5hh foreign key (user_id) references user (user_id);
alter table role add constraint FK61g3ambult7v7nh59xirgd9nf foreign key (user_id) references user (user_id);
alter table role add constraint FKg38vy2gcj50mg1yunjgfofj9g foreign key (role_id) references user (user_id);
alter table sending_channel add constraint FKjdaqrsj1ca8vi86ksxuvx99rm foreign key (rule_id) references rule (rule_id);
alter table sending_channel add constraint FKrf290mfb0ihdxp0upr5gw0083 foreign key (send_channel_type_id) references send_channel_type (send_channel_type_id);
alter table sending_status add constraint FKdd7j00w7xpd0t8nnkpasvc378 foreign key (communication_id) references communication (communication_id);
alter table sending_status add constraint FKhuof4r507ebm7v9grr4iop26g foreign key (send_channel_type_id) references send_channel_type (send_channel_type_id);
alter table user add constraint FKgkh2fko1e4ydv1y6vtrwdc6my foreign key (department_id) references department (department_id);
alter table user add constraint FKj8okb0ekgygnseelq60cx6oh1 foreign key (social_media_id) references social_media (social_media_id);