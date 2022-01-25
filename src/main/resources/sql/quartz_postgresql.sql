/*
 Navicat Premium Data Transfer

 Source Server         : clink2-test1_9
 Source Server Type    : PostgreSQL
 Source Server Version : 100014
 Source Host           : pgm-2zeu7qlhrwi64o0umo.pg.rds.aliyuncs.com:3432
 Source Catalog        : clink_quartz
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 100014
 File Encoding         : 65001

 Date: 25/01/2022 23:48:31
*/


-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS "qrtz_blob_triggers";
CREATE TABLE "qrtz_blob_triggers" (
  "sched_name" varchar(120)  NOT NULL,
  "trigger_name" varchar(200)  NOT NULL,
  "trigger_group" varchar(200)  NOT NULL,
  "blob_data" bytea
)
;

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS "qrtz_calendars";
CREATE TABLE "qrtz_calendars" (
  "sched_name" varchar(120)  NOT NULL,
  "calendar_name" varchar(200)  NOT NULL,
  "calendar" bytea NOT NULL
)
;

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS "qrtz_cron_triggers";
CREATE TABLE "qrtz_cron_triggers" (
  "sched_name" varchar(120)  NOT NULL,
  "trigger_name" varchar(200)  NOT NULL,
  "trigger_group" varchar(200)  NOT NULL,
  "cron_expression" varchar(120)  NOT NULL,
  "time_zone_id" varchar(80) 
)
;

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS "qrtz_fired_triggers";
CREATE TABLE "qrtz_fired_triggers" (
  "sched_name" varchar(120)  NOT NULL,
  "entry_id" varchar(95)  NOT NULL,
  "trigger_name" varchar(200)  NOT NULL,
  "trigger_group" varchar(200)  NOT NULL,
  "instance_name" varchar(200)  NOT NULL,
  "fired_time" int8 NOT NULL,
  "sched_time" int8 NOT NULL,
  "priority" int4 NOT NULL,
  "state" varchar(16)  NOT NULL,
  "job_name" varchar(200) ,
  "job_group" varchar(200) ,
  "is_nonconcurrent" bool,
  "requests_recovery" bool
)
;

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS "qrtz_job_details";
CREATE TABLE "qrtz_job_details" (
  "sched_name" varchar(120)  NOT NULL,
  "job_name" varchar(200)  NOT NULL,
  "job_group" varchar(200)  NOT NULL,
  "description" varchar(250) ,
  "job_class_name" varchar(250)  NOT NULL,
  "is_durable" bool NOT NULL,
  "is_nonconcurrent" bool NOT NULL,
  "is_update_data" bool NOT NULL,
  "requests_recovery" bool NOT NULL,
  "job_data" bytea
)
;

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS "qrtz_locks";
CREATE TABLE "qrtz_locks" (
  "sched_name" varchar(120)  NOT NULL,
  "lock_name" varchar(40)  NOT NULL
)
;

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS "qrtz_paused_trigger_grps";
CREATE TABLE "qrtz_paused_trigger_grps" (
  "sched_name" varchar(120)  NOT NULL,
  "trigger_group" varchar(200)  NOT NULL
)
;

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS "qrtz_scheduler_state";
CREATE TABLE "qrtz_scheduler_state" (
  "sched_name" varchar(120)  NOT NULL,
  "instance_name" varchar(200)  NOT NULL,
  "last_checkin_time" int8 NOT NULL,
  "checkin_interval" int8 NOT NULL
)
;

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS "qrtz_simple_triggers";
CREATE TABLE "qrtz_simple_triggers" (
  "sched_name" varchar(120)  NOT NULL,
  "trigger_name" varchar(200)  NOT NULL,
  "trigger_group" varchar(200)  NOT NULL,
  "repeat_count" int8 NOT NULL,
  "repeat_interval" int8 NOT NULL,
  "times_triggered" int8 NOT NULL
)
;

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS "qrtz_simprop_triggers";
CREATE TABLE "qrtz_simprop_triggers" (
  "sched_name" varchar(120)  NOT NULL,
  "trigger_name" varchar(200)  NOT NULL,
  "trigger_group" varchar(200)  NOT NULL,
  "str_prop_1" varchar(512) ,
  "str_prop_2" varchar(512) ,
  "str_prop_3" varchar(512) ,
  "int_prop_1" int4,
  "int_prop_2" int4,
  "long_prop_1" int8,
  "long_prop_2" int8,
  "dec_prop_1" numeric(13,4),
  "dec_prop_2" numeric(13,4),
  "bool_prop_1" bool,
  "bool_prop_2" bool
)
;

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS "qrtz_triggers";
CREATE TABLE "qrtz_triggers" (
  "sched_name" varchar(120)  NOT NULL,
  "trigger_name" varchar(200)  NOT NULL,
  "trigger_group" varchar(200)  NOT NULL,
  "job_name" varchar(200)  NOT NULL,
  "job_group" varchar(200)  NOT NULL,
  "description" varchar(250) ,
  "next_fire_time" int8,
  "prev_fire_time" int8,
  "priority" int4,
  "trigger_state" varchar(16)  NOT NULL,
  "trigger_type" varchar(8)  NOT NULL,
  "start_time" int8 NOT NULL,
  "end_time" int8,
  "calendar_name" varchar(200) ,
  "misfire_instr" int2,
  "job_data" bytea
)
;

-- ----------------------------
-- Primary Key structure for table qrtz_blob_triggers
-- ----------------------------
ALTER TABLE "qrtz_blob_triggers" ADD CONSTRAINT "qrtz_blob_triggers_pkey" PRIMARY KEY ("sched_name", "trigger_name", "trigger_group");

-- ----------------------------
-- Primary Key structure for table qrtz_calendars
-- ----------------------------
ALTER TABLE "qrtz_calendars" ADD CONSTRAINT "qrtz_calendars_pkey" PRIMARY KEY ("sched_name", "calendar_name");

-- ----------------------------
-- Primary Key structure for table qrtz_cron_triggers
-- ----------------------------
ALTER TABLE "qrtz_cron_triggers" ADD CONSTRAINT "qrtz_cron_triggers_pkey" PRIMARY KEY ("sched_name", "trigger_name", "trigger_group");

-- ----------------------------
-- Indexes structure for table qrtz_fired_triggers
-- ----------------------------
CREATE INDEX "idx_qrtz_ft_inst_job_req_rcvry" ON "qrtz_fired_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "instance_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "requests_recovery" "pg_catalog"."bool_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_ft_j_g" ON "qrtz_fired_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_group"  "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_ft_jg" ON "qrtz_fired_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_group"  "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_ft_t_g" ON "qrtz_fired_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_group"  "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_ft_tg" ON "qrtz_fired_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_group"  "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_ft_trig_inst_name" ON "qrtz_fired_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "instance_name"  "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table qrtz_fired_triggers
-- ----------------------------
ALTER TABLE "qrtz_fired_triggers" ADD CONSTRAINT "qrtz_fired_triggers_pkey" PRIMARY KEY ("sched_name", "entry_id");

-- ----------------------------
-- Indexes structure for table qrtz_job_details
-- ----------------------------
CREATE INDEX "idx_qrtz_j_grp" ON "qrtz_job_details" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_group"  "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_j_req_recovery" ON "qrtz_job_details" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "requests_recovery" "pg_catalog"."bool_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table qrtz_job_details
-- ----------------------------
ALTER TABLE "qrtz_job_details" ADD CONSTRAINT "qrtz_job_details_pkey" PRIMARY KEY ("sched_name", "job_name", "job_group");

-- ----------------------------
-- Primary Key structure for table qrtz_locks
-- ----------------------------
ALTER TABLE "qrtz_locks" ADD CONSTRAINT "qrtz_locks_pkey" PRIMARY KEY ("sched_name", "lock_name");

-- ----------------------------
-- Primary Key structure for table qrtz_paused_trigger_grps
-- ----------------------------
ALTER TABLE "qrtz_paused_trigger_grps" ADD CONSTRAINT "qrtz_paused_trigger_grps_pkey" PRIMARY KEY ("sched_name", "trigger_group");

-- ----------------------------
-- Primary Key structure for table qrtz_scheduler_state
-- ----------------------------
ALTER TABLE "qrtz_scheduler_state" ADD CONSTRAINT "qrtz_scheduler_state_pkey" PRIMARY KEY ("sched_name", "instance_name");

-- ----------------------------
-- Primary Key structure for table qrtz_simple_triggers
-- ----------------------------
ALTER TABLE "qrtz_simple_triggers" ADD CONSTRAINT "qrtz_simple_triggers_pkey" PRIMARY KEY ("sched_name", "trigger_name", "trigger_group");

-- ----------------------------
-- Primary Key structure for table qrtz_simprop_triggers
-- ----------------------------
ALTER TABLE "qrtz_simprop_triggers" ADD CONSTRAINT "qrtz_simprop_triggers_pkey" PRIMARY KEY ("sched_name", "trigger_name", "trigger_group");

-- ----------------------------
-- Indexes structure for table qrtz_triggers
-- ----------------------------
CREATE INDEX "idx_qrtz_t_c" ON "qrtz_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "calendar_name"  "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_g" ON "qrtz_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_group"  "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_j" ON "qrtz_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_group"  "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_jg" ON "qrtz_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_group"  "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_n_g_state" ON "qrtz_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_group"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_state"  "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_n_state" ON "qrtz_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_group"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_state"  "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_next_fire_time" ON "qrtz_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "next_fire_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_nft_misfire" ON "qrtz_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "misfire_instr" "pg_catalog"."int2_ops" ASC NULLS LAST,
  "next_fire_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_nft_st" ON "qrtz_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_state"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "next_fire_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_nft_st_misfire" ON "qrtz_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "misfire_instr" "pg_catalog"."int2_ops" ASC NULLS LAST,
  "next_fire_time" "pg_catalog"."int8_ops" ASC NULLS LAST,
  "trigger_state"  "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_nft_st_misfire_grp" ON "qrtz_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "misfire_instr" "pg_catalog"."int2_ops" ASC NULLS LAST,
  "next_fire_time" "pg_catalog"."int8_ops" ASC NULLS LAST,
  "trigger_group"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_state"  "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_state" ON "qrtz_triggers" USING btree (
  "sched_name"  "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_state"  "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table qrtz_triggers
-- ----------------------------
ALTER TABLE "qrtz_triggers" ADD CONSTRAINT "qrtz_triggers_pkey" PRIMARY KEY ("sched_name", "trigger_name", "trigger_group");

-- ----------------------------
-- Foreign Keys structure for table qrtz_blob_triggers
-- ----------------------------
ALTER TABLE "qrtz_blob_triggers" ADD CONSTRAINT "qrtz_blob_triggers_sched_name_fkey" FOREIGN KEY ("sched_name", "trigger_name", "trigger_group") REFERENCES "qrtz_triggers" ("sched_name", "trigger_name", "trigger_group") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table qrtz_cron_triggers
-- ----------------------------
ALTER TABLE "qrtz_cron_triggers" ADD CONSTRAINT "qrtz_cron_triggers_sched_name_fkey" FOREIGN KEY ("sched_name", "trigger_name", "trigger_group") REFERENCES "qrtz_triggers" ("sched_name", "trigger_name", "trigger_group") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table qrtz_simple_triggers
-- ----------------------------
ALTER TABLE "qrtz_simple_triggers" ADD CONSTRAINT "qrtz_simple_triggers_sched_name_fkey" FOREIGN KEY ("sched_name", "trigger_name", "trigger_group") REFERENCES "qrtz_triggers" ("sched_name", "trigger_name", "trigger_group") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table qrtz_simprop_triggers
-- ----------------------------
ALTER TABLE "qrtz_simprop_triggers" ADD CONSTRAINT "qrtz_simprop_triggers_sched_name_fkey" FOREIGN KEY ("sched_name", "trigger_name", "trigger_group") REFERENCES "qrtz_triggers" ("sched_name", "trigger_name", "trigger_group") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table qrtz_triggers
-- ----------------------------
ALTER TABLE "qrtz_triggers" ADD CONSTRAINT "qrtz_triggers_sched_name_fkey" FOREIGN KEY ("sched_name", "job_name", "job_group") REFERENCES "qrtz_job_details" ("sched_name", "job_name", "job_group") ON DELETE NO ACTION ON UPDATE NO ACTION;
