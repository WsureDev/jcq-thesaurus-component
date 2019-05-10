/*
Navicat SQLite Data Transfer

Source Server         : sqlite
Source Server Version : 30714
Source Host           : :0

Target Server Type    : SQLite
Target Server Version : 30714
File Encoding         : 65001

Date: 2019-05-10 12:18:10
*/

PRAGMA foreign_keys = OFF;

-- ----------------------------
-- Table structure for global
-- ----------------------------
DROP TABLE IF EXISTS "main"."global";
CREATE TABLE "global" (
"word_id"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
"question"  TEXT NOT NULL,
"answer"  TEXT NOT NULL,
"type"  INTEGER NOT NULL DEFAULT 0,
"commit_time"  INTEGER DEFAULT sysdate,
"commit_user"  INTEGER
);

-- ----------------------------
-- Table structure for groups
-- ----------------------------
DROP TABLE IF EXISTS "main"."groups";
CREATE TABLE "groups" (
"group_id"  INTEGER NOT NULL,
"enable"  INTEGER NOT NULL DEFAULT 0,
"editer_level"  INTEGER NOT NULL DEFAULT 2,
"welcome_enable"  INTEGER NOT NULL DEFAULT 0,
PRIMARY KEY ("group_id")
);

-- ----------------------------
-- Table structure for manage
-- ----------------------------
DROP TABLE IF EXISTS "main"."manage";
CREATE TABLE "manage" (
"manage_id"  INTEGER NOT NULL,
"email"  TEXT(40),
PRIMARY KEY ("manage_id" ASC)
);

-- ----------------------------
-- Table structure for setting
-- ----------------------------
DROP TABLE IF EXISTS "main"."setting";
CREATE TABLE "setting" (
"config"  INTEGER NOT NULL DEFAULT 0,
"master_id"  INTEGER NOT NULL,
"master_email"  TEXT,
"robot_email"  TEXT,
"robot_password"  TEXT,
"exact_key"  TEXT,
"vague_key"  TEXT,
"regex_key"  TEXT,
"answer_key"  TEXT,
"delete_key"  TEXT,
"query_key"  TEXT,
"global_key"  TEXT,
PRIMARY KEY ("config"),
CONSTRAINT "only" UNIQUE ("master_id")
);

-- ----------------------------
-- Table structure for sqlite_sequence
-- ----------------------------
DROP TABLE IF EXISTS "main"."sqlite_sequence";
CREATE TABLE sqlite_sequence(name,seq);
