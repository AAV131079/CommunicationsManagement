insert into CommunicationsManagement.send_channel_type (send_channel_type_id, create_time, description, name, update_time)
    value
        (1, NOW(), 'Отправка короткого текстового сообщения на телефон клиента', 'SMS', NOW())
        (2, NOW(), 'Отправка короткого текстового сообщение в Messenger клиента', 'Messenger', NOW())
        (3, NOW(), 'Отправка электронного письма', 'Email', NOW())
        (4, NOW(), 'Отправка PUSH сообщения', 'Push', NOW());