insert into CommunicationsManagement.booking_status_type (booking_status_type_id, create_time, description, name, update_time)
    values
        (1, NOW(), 'Забронирован на весь лимит времени.', 'Забронирован', NOW()),
        (2, NOW(), 'Бронь времмено приостановлена. Возможно возобновление брони до окончания лимита времени.', 'Бронь приостановлена', NOW()),
        (3, NOW(), 'Бронь отменена. Возобновление невозможно.', 'Бронь отменена', NOW());