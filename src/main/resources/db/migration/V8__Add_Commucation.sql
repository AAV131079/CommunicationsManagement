insert into CommunicationsManagement.communication (communication_id, create_time, booking_id, communication_type_id, user_id, description, content)
    values
        (1, NOW(), null, 1, 1, 'Массовая рассылка. Поздравление клиента. Уведомление об акции', 'С Новым годом вас спешу поздравить, пусть он подарит вам чудесные мгновения'),
        (2, NOW(), null, 2, 1, 'Уведомление о переносе рабочего дня на паску', 'Напоминание. Рабочий день переносится на субботу'),
        (3, NOW(), null, 4, 1, 'Опросил мнения о нашей компании', 'Оцените, насколько вы удовлетворены взаимодействию со спеиалистом. Отправьте от 1 до 5.');

insert into CommunicationsManagement.client_communication (id, client_id, communication_id)
    values
        (1, 1, 1),
        (2, 2, 1),
        (3, 3, 1),
        (4, 1, 2),
        (5, 1, 3);