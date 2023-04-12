insert into CommunicationsManagement.send_channel_type (send_channel_type_id, description, name)
    value
        (1, 'Отправка короткого текстового сообщения на телефон клиента', 'SMS'),
        (2, 'Отправка короткого текстового сообщение в Messenger клиента', 'Messenger'),
        (3, 'Отправка электронного письма', 'Email'),
        (4, 'Отправка PUSH сообщения', 'Push');