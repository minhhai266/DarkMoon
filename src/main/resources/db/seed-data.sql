-- Seed data for DarkMoon / Moon Blight.
-- Target database: MariaDB/MySQL, schema generated from current JPA entities.
-- Safe to run multiple times because every INSERT uses stable IDs and ON DUPLICATE KEY UPDATE.
--
-- Login seed accounts use password: 12345678
--
-- Enum values used by converters:
-- roles: ADMIN=1, STAFF=2
-- article types: IMPORTANT=1, UPDATE=2, NEWS=3, EVENT=4
-- contact categories: TECHNICAL_SUPPORT=1, BUG_REPORT=2, ACCOUNT_BILLING=3,
-- ACCESSIBILITY=4, CREATOR_PROGRAM=5, PRESS_CONTACT=6, OTHER=7
-- contact platforms: WINDOW=1, LINUX=2, ANDROID=3, IOS=4, OTHER=5
-- log actions: CREATE=1, UPDATE=2, DELETE=3, RESTORE=4, APPROVE=5,
-- LOCK=6, UNLOCK=7, CHANGE_PASSWORD=8, LOGIN=9, LOGOUT=10, PROCESS=11
--
-- log entity types: ARTICLE=1, STORY=2, WORLD=3, CHARACTER=4, FAQ=5, USER=6, CONTACT=7

SET NAMES utf8mb4;
START TRANSACTION;

INSERT INTO `users`
    (`id`, `username`, `email`, `password`, `role`, `is_active`, `full_name`, `created_at`, `updated_at`, `must_change_password`)
VALUES
    (1001, 'seed_admin', 'seed.admin@moonblight.local', '$2a$10$BAa5Jhk8kWJZffXn5Ra1kepR73eo07kE3qXomqkT7I/byhOzCAmDm', 1, 1, 'Seed Admin', '2026-06-15 08:00:00', '2026-06-15 08:00:00', 0),
    (1002, 'seed_staff', 'seed.staff@moonblight.local', '$2a$10$BAa5Jhk8kWJZffXn5Ra1kepR73eo07kE3qXomqkT7I/byhOzCAmDm', 2, 1, 'Seed Staff', '2026-06-15 08:05:00', '2026-06-15 08:05:00', 0),
    (1003, 'seed_writer', 'seed.writer@moonblight.local', '$2a$10$BAa5Jhk8kWJZffXn5Ra1kepR73eo07kE3qXomqkT7I/byhOzCAmDm', 2, 1, 'Seed Writer', '2026-06-15 08:10:00', '2026-06-15 08:10:00', 1),
    (1004, 'seed_locked', 'seed.locked@moonblight.local', '$2a$10$BAa5Jhk8kWJZffXn5Ra1kepR73eo07kE3qXomqkT7I/byhOzCAmDm', 2, 0, 'Seed Locked Staff', '2026-06-15 08:15:00', '2026-06-15 08:15:00', 0),
    (1005, 'seed_reviewer', 'seed.reviewer@moonblight.local', '$2a$10$BAa5Jhk8kWJZffXn5Ra1kepR73eo07kE3qXomqkT7I/byhOzCAmDm', 2, 1, 'Seed Reviewer', '2026-06-15 08:20:00', '2026-06-15 08:20:00', 0)
ON DUPLICATE KEY UPDATE
    `username` = VALUES(`username`),
    `email` = VALUES(`email`),
    `password` = VALUES(`password`),
    `role` = VALUES(`role`),
    `is_active` = VALUES(`is_active`),
    `full_name` = VALUES(`full_name`),
    `updated_at` = VALUES(`updated_at`),
    `must_change_password` = VALUES(`must_change_password`);

INSERT INTO `articles`
    (`id`, `title`, `content`, `type`, `thumbnail_url`, `is_deleted`, `created_by`, `created_at`, `updated_by`, `updated_at`)
VALUES
    (2001, 'Important Launch Notice', 'Moon Blight opens the first public test gate with core story and support content enabled.', 1, '/uploads/articles/16a9751eeb4bbd54ea9190bcf2aab9a6.webp', 0, 1002, '2026-06-15 09:00:00', NULL, '2026-06-15 09:00:00'),
    (2002, 'Combat Update 1.1', 'Balance notes for stamina, dodge timing, shadow damage, and enemy patrol routes.', 2, '/uploads/articles/4cfd6bc19ee863a91b1beb0a5c6fdbe9.jpeg', 0, 1002, '2026-06-15 09:10:00', 1005, '2026-06-15 10:10:00'),
    (2003, 'Developer Diary', 'A short news post about level design, atmosphere, and character writing direction.', 3, '/uploads/articles/51a99733bd15c9ed29fe179e90de71e4.jpeg', 0, 1003, '2026-06-15 09:20:00', NULL, '2026-06-15 09:20:00'),
    (2004, 'Night Market Event', 'Limited event announcement with bonus rewards and new community challenges.', 4, '/uploads/articles/60d27877-07d6-4270-9801-1b0cc5e9e08c_okita-souji_FHD.jpg', 0, 1003, '2026-06-15 09:30:00', NULL, '2026-06-15 09:30:00'),
    (2005, 'Archived Alpha Note', 'Old alpha announcement kept for CMS soft delete and restore testing.', 3, '/uploads/articles/9b5b143c373bbdd49fd391acdbfe81f4.jpeg', 1, 1002, '2026-06-15 09:40:00', 1002, '2026-06-15 11:00:00'),
    (2006, 'Patch Preview', 'Preview of upcoming bug fixes, quality of life improvements, and UI polish.', 2, '/uploads/articles/a9cebea390a2239db48f94d7b33e80e0.webp', 0, 1005, '2026-06-15 09:50:00', NULL, '2026-06-15 09:50:00'),
    (2007, 'Server Maintenance', 'Important maintenance notice for database backup and service restart.', 1, '/uploads/articles/f849fae7f2c60c8a7b156b6f618908e0.png', 0, 1001, '2026-06-15 10:00:00', NULL, '2026-06-15 10:00:00'),
    (2008, 'Community Screenshot Event', 'Players can submit screenshots from the abandoned district for weekly highlights.', 4, '/uploads/articles/ec71368a-23bb-414e-8c72-d9f5e2dc80ed_cherry-blossoms_FHD.jpg', 0, 1005, '2026-06-15 10:05:00', NULL, '2026-06-15 10:05:00')
ON DUPLICATE KEY UPDATE
    `title` = VALUES(`title`),
    `content` = VALUES(`content`),
    `type` = VALUES(`type`),
    `thumbnail_url` = VALUES(`thumbnail_url`),
    `is_deleted` = VALUES(`is_deleted`),
    `updated_by` = VALUES(`updated_by`),
    `updated_at` = VALUES(`updated_at`);

INSERT INTO `stories`
    (`id`, `tag`, `title`, `content`, `image`, `quote_content`, `quote_author`, `priority`, `deleted`, `created_by`, `created_at`, `updated_by`, `updated_at`)
VALUES
    (3001, 'origin', 'The First Eclipse', 'The first eclipse split the old city from the living world and awakened the Moon Blight.', '/uploads/stories/16a9751eeb4bbd54ea9190bcf2aab9a6.webp', 'The moon did not rise. It opened.', 'Archivist Ren', 100, 0, 1002, '2026-06-15 10:20:00', NULL, '2026-06-15 10:20:00'),
    (3002, 'chapter-one', 'Ash Road', 'Survivors cross the ash road to reach the signal tower before midnight.', '/uploads/stories/51a99733bd15c9ed29fe179e90de71e4.jpeg', 'Every footprint glowed behind us.', 'Mira Vale', 85, 0, 1002, '2026-06-15 10:30:00', 1005, '2026-06-15 11:15:00'),
    (3003, 'faction', 'The Hollow Choir', 'A hidden faction turns memories into weapons and guards the inner district.', '/uploads/stories/f6a918a603258046f89efefe5a21c4ba.jpg', 'They sang names nobody should remember.', 'Old Hunter Kael', 70, 0, 1003, '2026-06-15 10:40:00', NULL, '2026-06-15 10:40:00'),
    (3004, 'archive', 'Lost Prologue', 'A retired prologue kept for restore testing in the CMS.', '/uploads/stories/16a9751eeb4bbd54ea9190bcf2aab9a6.webp', 'This path was sealed for a reason.', 'Unknown', 20, 1, 1003, '2026-06-15 10:50:00', 1002, '2026-06-15 11:20:00'),
    (3005, 'finale', 'Bell Under Black Water', 'The bell below the flooded chapel marks the border of the final act.', '/uploads/stories/51a99733bd15c9ed29fe179e90de71e4.jpeg', 'When it rings, the dead answer.', 'Sister Elia', 95, 0, 1005, '2026-06-15 11:00:00', NULL, '2026-06-15 11:00:00')
ON DUPLICATE KEY UPDATE
    `tag` = VALUES(`tag`),
    `title` = VALUES(`title`),
    `content` = VALUES(`content`),
    `image` = VALUES(`image`),
    `quote_content` = VALUES(`quote_content`),
    `quote_author` = VALUES(`quote_author`),
    `priority` = VALUES(`priority`),
    `deleted` = VALUES(`deleted`),
    `updated_by` = VALUES(`updated_by`),
    `updated_at` = VALUES(`updated_at`);

INSERT INTO `worlds`
    (`id`, `tag`, `title`, `content`, `image`, `priority`, `deleted`, `created_by`, `created_at`, `updated_by`, `updated_at`)
VALUES
    (4001, 'capital', 'Nocturne Capital', 'A ruined capital where moonlight pools in streets and old machines still whisper.', '/uploads/worlds/4cfd6bc19ee863a91b1beb0a5c6fdbe9.jpeg', 100, 0, 1002, '2026-06-15 11:10:00', NULL, '2026-06-15 11:10:00'),
    (4002, 'forest', 'Glassroot Forest', 'A forest of transparent roots that stores echoes from every traveler.', '/uploads/worlds/51a99733bd15c9ed29fe179e90de71e4.jpeg', 80, 0, 1003, '2026-06-15 11:20:00', NULL, '2026-06-15 11:20:00'),
    (4003, 'chapel', 'Flooded Chapel', 'A drowned sanctuary connected to the hidden endgame route.', '/uploads/worlds/a9cebea390a2239db48f94d7b33e80e0.webp', 90, 0, 1005, '2026-06-15 11:30:00', 1005, '2026-06-15 11:55:00'),
    (4004, 'old-map', 'Old District Draft', 'Removed draft area retained for deleted world testing.', '/uploads/worlds/f6a918a603258046f89efefe5a21c4ba.jpg', 10, 1, 1002, '2026-06-15 11:40:00', 1002, '2026-06-15 11:50:00'),
    (4005, 'market', 'Night Market', 'A moving market where vendors trade in memories, charms, and broken compasses.', '/uploads/worlds/4cfd6bc19ee863a91b1beb0a5c6fdbe9.jpeg', 65, 0, 1003, '2026-06-15 11:45:00', NULL, '2026-06-15 11:45:00')
ON DUPLICATE KEY UPDATE
    `tag` = VALUES(`tag`),
    `title` = VALUES(`title`),
    `content` = VALUES(`content`),
    `image` = VALUES(`image`),
    `priority` = VALUES(`priority`),
    `deleted` = VALUES(`deleted`),
    `updated_by` = VALUES(`updated_by`),
    `updated_at` = VALUES(`updated_at`);

INSERT INTO `characters`
    (`id`, `name`, `race`, `description`, `quote`, `image`, `priority`, `deleted`, `created_by`, `created_at`, `updated_by`, `updated_at`)
VALUES
    (5001, 'Mira Vale', 'Human', 'A field investigator who follows forbidden lunar signals through the capital.', 'I only need one true clue.', '/uploads/characters/51a99733bd15c9ed29fe179e90de71e4.jpeg', 100, 0, 1002, '2026-06-15 12:00:00', NULL, '2026-06-15 12:00:00'),
    (5002, 'Kael Thorn', 'Human', 'An old hunter carrying a silver compass that points toward unfinished regrets.', 'Do not trust quiet streets.', '/uploads/characters/f6a918a603258046f89efefe5a21c4ba.jpg', 85, 0, 1003, '2026-06-15 12:10:00', 1005, '2026-06-15 12:40:00'),
    (5003, 'Sister Elia', 'Vessel', 'A chapel keeper bound to the bell under black water.', 'Mercy can still be sharp.', '/uploads/characters/9b5b143c373bbdd49fd391acdbfe81f4.jpeg', 90, 0, 1002, '2026-06-15 12:20:00', NULL, '2026-06-15 12:20:00'),
    (5004, 'Archivist Ren', 'Shade', 'A keeper of broken maps who remembers every version of the city.', 'History is a locked room.', '/uploads/characters/51a99733bd15c9ed29fe179e90de71e4.jpeg', 75, 0, 1005, '2026-06-15 12:30:00', NULL, '2026-06-15 12:30:00'),
    (5005, 'Discarded Scout', 'Human', 'Deprecated test character kept to verify soft delete behavior.', 'This record should stay hidden.', '/uploads/characters/f6a918a603258046f89efefe5a21c4ba.jpg', 5, 1, 1003, '2026-06-15 12:35:00', 1002, '2026-06-15 12:45:00'),
    (5006, 'The Hollow Conductor', 'Unknown', 'The leader of the Hollow Choir and a late-game narrative threat.', 'Sing, and the door will open.', '/uploads/characters/9b5b143c373bbdd49fd391acdbfe81f4.jpeg', 95, 0, 1005, '2026-06-15 12:50:00', NULL, '2026-06-15 12:50:00')
ON DUPLICATE KEY UPDATE
    `name` = VALUES(`name`),
    `race` = VALUES(`race`),
    `description` = VALUES(`description`),
    `quote` = VALUES(`quote`),
    `image` = VALUES(`image`),
    `priority` = VALUES(`priority`),
    `deleted` = VALUES(`deleted`),
    `updated_by` = VALUES(`updated_by`),
    `updated_at` = VALUES(`updated_at`);

INSERT INTO `faqs`
    (`id`, `title`, `content`, `priority`, `deleted`, `created_by`, `created_at`, `updated_by`, `updated_at`)
VALUES
    (6001, 'How do I report a bug?', 'Open the support page, choose Bug Report, select your platform, and describe the issue with clear steps.', 100, 0, 1002, '2026-06-15 13:00:00', NULL, '2026-06-15 13:00:00'),
    (6002, 'Can I recover my account?', 'Use the forgot password flow and verify the OTP sent to your registered email address.', 90, 0, 1002, '2026-06-15 13:05:00', NULL, '2026-06-15 13:05:00'),
    (6003, 'Which platforms are supported?', 'The current support form tracks Window, Linux, Android, iOS, and Other platform reports.', 80, 0, 1003, '2026-06-15 13:10:00', 1005, '2026-06-15 13:45:00'),
    (6004, 'How are content priorities used?', 'Higher priority items are displayed earlier on public story, world, character, and FAQ pages.', 70, 0, 1005, '2026-06-15 13:15:00', NULL, '2026-06-15 13:15:00'),
    (6005, 'Old beta FAQ', 'Deleted FAQ retained for restore testing.', 10, 1, 1003, '2026-06-15 13:20:00', 1002, '2026-06-15 13:50:00'),
    (6006, 'How long does OTP last?', 'Password reset OTP records are expected to expire after five minutes.', 60, 0, 1005, '2026-06-15 13:25:00', NULL, '2026-06-15 13:25:00')
ON DUPLICATE KEY UPDATE
    `title` = VALUES(`title`),
    `content` = VALUES(`content`),
    `priority` = VALUES(`priority`),
    `deleted` = VALUES(`deleted`),
    `updated_by` = VALUES(`updated_by`),
    `updated_at` = VALUES(`updated_at`);

INSERT INTO `contact_messages`
    (`id`, `visitor_name`, `visitor_email`, `category`, `platform`, `message`, `processed`, `processed_by`, `processed_at`)
VALUES
    (7001, 'Alice Test', 'alice.test@example.com', 1, 1, 'The game freezes after opening the settings screen on Window.', 0, NULL, NULL),
    (7002, 'Binh Nguyen', 'binh.nguyen@example.com', 2, 3, 'The first boss can get stuck behind the broken gate.', 1, 1002, '2026-06-15 14:10:00'),
    (7003, 'Cara Lee', 'cara.lee@example.com', 3, 4, 'I need help with account access after reinstalling on iOS.', 0, NULL, NULL),
    (7004, 'Duc Tran', 'duc.tran@example.com', 4, 2, 'Please add a stronger subtitle contrast option on Linux.', 1, 1005, '2026-06-15 14:20:00'),
    (7005, 'Evan Press', 'evan.press@example.com', 6, 5, 'Requesting press contact information for a preview article.', 0, NULL, NULL),
    (7006, 'Faye Creator', 'faye.creator@example.com', 5, 1, 'I want to join the creator program for Moon Blight.', 1, 1002, '2026-06-15 14:30:00'),
    (7007, 'Guest Other', 'guest.other@example.com', 7, NULL, 'General feedback message with no specific platform selected.', 0, NULL, NULL)
ON DUPLICATE KEY UPDATE
    `visitor_name` = VALUES(`visitor_name`),
    `visitor_email` = VALUES(`visitor_email`),
    `category` = VALUES(`category`),
    `platform` = VALUES(`platform`),
    `message` = VALUES(`message`),
    `processed` = VALUES(`processed`),
    `processed_by` = VALUES(`processed_by`),
    `processed_at` = VALUES(`processed_at`);

INSERT INTO `password_reset_tokens`
    (`id`, `email`, `otp`, `expired_at`, `used`)
VALUES
    (8001, 'seed.staff@moonblight.local', '111111', '2099-01-01 00:00:00', 0),
    (8002, 'seed.writer@moonblight.local', '222222', '2020-01-01 00:00:00', 0),
    (8003, 'seed.locked@moonblight.local', '333333', '2099-01-01 00:00:00', 1),
    (8004, 'seed.reviewer@moonblight.local', '444444', '2099-01-01 00:00:00', 0)
ON DUPLICATE KEY UPDATE
    `email` = VALUES(`email`),
    `otp` = VALUES(`otp`),
    `expired_at` = VALUES(`expired_at`),
    `used` = VALUES(`used`);

INSERT INTO `audit_logs`
    (`id`, `entity_id`, `entity_type`, `action`, `description`, `created_at`, `user_id`)
VALUES
    (9001, 1002, 6, 9, 'Seed login: seed_staff', '2026-06-15 15:00:00', 1002),
    (9002, 2001, 1, 1, 'Seed created article: Important Launch Notice', '2026-06-15 15:05:00', 1002),
    (9003, 2002, 1, 2, 'Seed updated article: Combat Update 1.1', '2026-06-15 15:10:00', 1005),
    (9004, 2005, 1, 3, 'Seed deleted article: Archived Alpha Note', '2026-06-15 15:15:00', 1002),
    (9005, 3004, 2, 4, 'Seed restore-ready story: Lost Prologue', '2026-06-15 15:20:00', 1003),
    (9006, 1004, 6, 6, 'Seed locked account: seed_locked', '2026-06-15 15:25:00', 1001),
    (9007, 1004, 6, 7, 'Seed unlocked account test record', '2026-06-15 15:30:00', 1001),
    (9008, 1003, 6, 8, 'Seed password change required for seed_writer', '2026-06-15 15:35:00', 1003),
    (9009, 7002, 7, 11, 'Seed processed contact: boss stuck bug report', '2026-06-15 15:40:00', 1002),
    (9010, 4003, 3, 2, 'Seed updated world: Flooded Chapel', '2026-06-15 15:45:00', 1005),
    (9011, 5006, 4, 1, 'Seed created character: The Hollow Conductor', '2026-06-15 15:50:00', 1005),
    (9012, 6005, 5, 3, 'Seed deleted FAQ: Old beta FAQ', '2026-06-15 15:55:00', 1002),
    (9013, 1005, 6, 5, 'Seed approved staff reviewer', '2026-06-15 16:00:00', 1001),
    (9014, 1002, 6, 10, 'Seed logout: seed_staff', '2026-06-15 16:05:00', 1002)
ON DUPLICATE KEY UPDATE
    `entity_id` = VALUES(`entity_id`),
    `entity_type` = VALUES(`entity_type`),
    `action` = VALUES(`action`),
    `description` = VALUES(`description`),
    `created_at` = VALUES(`created_at`),
    `user_id` = VALUES(`user_id`);

COMMIT;
