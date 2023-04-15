insert into CommunicationsManagement.client (client_id, birth_date, create_time, update_time, first_name, last_name,
    booking_id, social_media_id, available)
    values
        (1, DATE('1998-05-01'), NOW(), NOW(), 'Никола', 'Тесла', null, 2, 1),
        (2, DATE('1988-12-02'), NOW(), NOW(), 'Чарлз', 'Дарвин', null, null, 1),
        (3, DATE('1988-04-04'), NOW(), NOW(), 'Теодор', 'Рузвельт', null, null, 1);