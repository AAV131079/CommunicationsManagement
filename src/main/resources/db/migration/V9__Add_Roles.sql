insert into CommunicationsManagement.role (role_id, create_time, description, name, update_time)
    values
        (1, NOW(), 'Администратор', 'Admin', NOW()),
        (2, NOW(), 'Сотрудник департамента', 'User', NOW());

insert into CommunicationsManagement.user_role (id, role_id, user_id)
    values
        (1, 1, 1),
        (2, 2, 2);