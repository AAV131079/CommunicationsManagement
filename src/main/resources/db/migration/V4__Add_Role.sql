insert into CommunicationsManagement.role (role_id, create_time, description, name, update_time)
    value
        (1, NOW(), 'Администратор', 'Admin', NOW())
        (2, NOW(), 'Простой пользователь', 'User', NOW());