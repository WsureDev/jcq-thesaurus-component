/*
Navicat SQLite Data Transfer

Source Server         : sqlite
Source Server Version : 30714
Source Host           : :0

Target Server Type    : SQLite
Target Server Version : 30714
File Encoding         : 65001

Date: 2019-05-11 11:11:10
*/

PRAGMA foreign_keys = OFF;

-- ----------------------------
-- Table structure for global
-- ----------------------------
CREATE TABLE IF NOT EXISTS "global" (
"word_id"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
"question"  TEXT NOT NULL,
"answer"  TEXT NOT NULL,
"type"  INTEGER NOT NULL DEFAULT 0,
"commit_time"  TimeStamp NOT NULL DEFAULT (datetime('now','localtime')),
"commit_user"  BIGINT
);

CREATE TABLE IF NOT EXISTS "disable" (
"qq"  BIGINT NOT NULL,
"group_id"  BIGINT NOT NULL,
"commit_user"  BIGINT NOT NULL,
"commit_time"  TEXT NOT NULL DEFAULT (datetime('now','localtime'))
);


-- ----------------------------
-- Table structure for private
-- ----------------------------
CREATE TABLE IF NOT EXISTS "private" (
"word_id"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
"question"  TEXT NOT NULL,
"answer"  TEXT NOT NULL,
"type"  INTEGER NOT NULL DEFAULT 0,
"commit_time"  TimeStamp NOT NULL DEFAULT (datetime('now','localtime')),
"commit_user"  BIGINT
);

-- ----------------------------
-- Table structure for groups
-- ----------------------------
CREATE TABLE IF NOT EXISTS "groups" (
"group_id"  BIGINT NOT NULL,
"enable"  INTEGER NOT NULL DEFAULT 0,
"editer_level"  INTEGER NOT NULL DEFAULT 2,
"welcome_enable"  INTEGER NOT NULL DEFAULT 0,
PRIMARY KEY ("group_id")
);

-- ----------------------------
-- Table structure for manage
-- ----------------------------
CREATE TABLE IF NOT EXISTS "manage" (
"manage_id"  BIGINT NOT NULL,
"email"  TEXT(40),
PRIMARY KEY ("manage_id" ASC)
);

-- ----------------------------
-- Table structure for setting
-- ----------------------------
CREATE TABLE IF NOT EXISTS "setting" (
"key"  TEXT NOT NULL,
"value"  TEXT NOT NULL,
PRIMARY KEY ("key"),
CONSTRAINT "keyOnly" UNIQUE ("key") ON CONFLICT REPLACE
)
;

