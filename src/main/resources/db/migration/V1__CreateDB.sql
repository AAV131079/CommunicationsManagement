alter table client drop foreign key FK83h8npyf4pbq9xm7hnv88seho;
alter table client drop foreign key FK9gn696249twt53wqdgidrkcyf;
alter table communication drop foreign key FK7uktjs903rws1g728cc89wgul;
alter table communication drop foreign key FK2ucuf46xehar2bf7j5uwlr3gm;
alter table communication drop foreign key FKd85hfscy6k3yq0iarwuht09hm;
alter table department drop foreign key FKcyxum1b9pgexglpunrwm8amg4;
alter table email drop foreign key FKo4n7ey7da7adl64srct8ji56s;
alter table phone drop foreign key FKcchyhsnqcjy7dfq2j4286bwk0;
alter table role drop foreign key FKjjcbyny2rand07lh9nano7mb6;
alter table sending_channel drop foreign key FKjdaqrsj1ca8vi86ksxuvx99rm;
alter table sending_channel drop foreign key FKrf290mfb0ihdxp0upr5gw0083;
alter table sending_status drop foreign key FKdd7j00w7xpd0t8nnkpasvc378;
alter table sending_status drop foreign key FKhuof4r507ebm7v9grr4iop26g;
alter table usr drop foreign key FKpxhk0d0wmwt6budg7q4qsic5n;
alter table usr drop foreign key FK6ci8j00ktshun4srn579qcywd;

drop table if exists booking;
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
drop table if exists usr;

create table booking
(
    booking_id bigint not null auto_increment,
    before_date datetime(6) not null,
    create_time datetime(6) not null,
    status varchar(255) not null,
    update_time datetime(6) not null, primary key (booking_id)
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
    communication_id bigint, primary key (client_id)
);

create table communication
(
    communication_id bigint not null auto_increment,
    create_time datetime(6) not null,
    update_time datetime(6) not null,
    booking_id bigint,
    communication_type_id bigint,
    user_id bigint, primary key (communication_id)
);

create table communication_type
(
    communication_type_id bigint not null auto_increment,
    create_time datetime(6) not null,
    description varchar(255) not null,
    name varchar(255) not null,
    update_time datetime(6) not null, primary key (communication_type_id)
);

create table department
(
    department_id bigint not null auto_increment,
    create_time datetime(6) not null,
    full_name varchar(255) not null, name varchar(255) not null,
    update_time datetime(6) not null,
    rule_id bigint, primary key (department_id)
);

create table email
(
    email_id bigint not null auto_increment,
    create_time datetime(6) not null,
    email varchar(255) not null,
    is_primary bit not null,
    update_time datetime(6) not null,
    user_id bigint, primary key (email_id)
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
    user_id bigint, primary key (phone_id)
);

create table role
(
    role_id bigint not null auto_increment,
    create_time datetime(6) not null,
    description varchar(255) not null,
    name varchar(255) not null,
    update_time datetime(6) not null,
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
    create_time datetime(6) not null,
    description varchar(255) not null,
    name varchar(255) not null,
    update_time datetime(6) not null,
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

create table usr
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
    social_media_id bigint, primary key (user_id)
);

alter table usr add constraint UK_1412nadjy5bfavpyuj3p4pexx unique (user_name);
alter table client add constraint FK83h8npyf4pbq9xm7hnv88seho foreign key (booking_id) references booking (booking_id);
alter table client add constraint FK9gn696249twt53wqdgidrkcyf foreign key (communication_id) references communication (communication_id);
alter table communication add constraint FK7uktjs903rws1g728cc89wgul foreign key (booking_id) references booking (booking_id);
alter table communication add constraint FK2ucuf46xehar2bf7j5uwlr3gm foreign key (communication_type_id) references communication_type (communication_type_id);
alter table communication add constraint FKd85hfscy6k3yq0iarwuht09hm foreign key (user_id) references usr (user_id);
alter table department add constraint FKcyxum1b9pgexglpunrwm8amg4 foreign key (rule_id) references rule (rule_id);
alter table email add constraint FKo4n7ey7da7adl64srct8ji56s foreign key (user_id) references usr (user_id);
alter table phone add constraint FKcchyhsnqcjy7dfq2j4286bwk0 foreign key (user_id) references usr (user_id);
alter table role add constraint FKjjcbyny2rand07lh9nano7mb6 foreign key (role_id) references usr (user_id);
alter table sending_channel add constraint FKjdaqrsj1ca8vi86ksxuvx99rm foreign key (rule_id) references rule (rule_id);
alter table sending_channel add constraint FKrf290mfb0ihdxp0upr5gw0083 foreign key (send_channel_type_id) references send_channel_type (send_channel_type_id);
alter table sending_status add constraint FKdd7j00w7xpd0t8nnkpasvc378 foreign key (communication_id) references communication (communication_id);
alter table sending_status add constraint FKhuof4r507ebm7v9grr4iop26g foreign key (send_channel_type_id) references send_channel_type (send_channel_type_id);
alter table usr add constraint FKpxhk0d0wmwt6budg7q4qsic5n foreign key (department_id) references department (department_id);
alter table usr add constraint FK6ci8j00ktshun4srn579qcywd foreign key (social_media_id) references social_media (social_media_id);