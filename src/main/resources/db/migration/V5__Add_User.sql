insert into CommunicationsManagement.rule (rule_id, blocking_communications, blocking_period, communication_limit, create_time, not_communication_days, time_limit, update_time)
    value (1, 1000, 10, 15, NOW(),30, 21, NOW());
insert into CommunicationsManagement.department (department_id, create_time, full_name, name, update_time, rule_id)
    value (1, NOW(), 'Marketing department', 'MMM', NOW(), 1);
insert into CommunicationsManagement.social_media (social_media_id, create_time, facebook, instagram, twitter, update_time)
    value (1, NOW(), 'facebook', 'instagram', 'twitter', NOW());
insert into CommunicationsManagement.user (user_id, birth_date, create_time, first_name, last_name, password, update_time, user_name, department_id, social_media_id)
    value (1, DATE('2000-01-01'), NOW(), 'Super', 'User', '$2a$08$HewMgfQeQ/H4o7DSQ5cNrO7lxgfTe87F/v1aoTThDFX0sqWkfLBFK', NOW(), 'Admin',  1, 1);