INSERT IGNORE -- do nothing if already exists, so data.sql doesn't fail on existing bookdb
INTO my_user_details
(ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED,
 CREDENTIALS_NON_EXPIRED, ENABLED, ID, PASSWORD, ROLES,
 USERNAME)
VALUES (TRUE, TRUE,
        TRUE, TRUE, 1,
        'pass',
        'ROLE_USER',
        'user'); -- Create user "user" with password "pass"