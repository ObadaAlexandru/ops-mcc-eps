-- SCHEMA: EPS
CREATE SCHEMA EPS;
--    AUTHORIZATION postgres;

COMMENT ON SCHEMA EPS
    IS 'Scheme for EPS';

-- CREATE SEQUENCE hibernate_sequence START 1 INCREMENT BY 1;

-- Table: EPS.BATTERY
CREATE TABLE EPS.BATTERY
(
    REG_ID bigserial NOT NULL,
    STATE text NOT NULL,
    LEVEL int NOT NULL,
    CREATED_ON timestamp without time zone NOT NULL,
    CONSTRAINT BATTERY_PKEY PRIMARY KEY (REG_ID)
);

-- Table: EPS.PANELS
CREATE TABLE EPS.PANELS
(
    REG_ID bigserial NOT NULL,
    PANEL_ID int NOT NULL,
    STATE text NOT NULL,
    CURRENT real NOT NULL,
    VOLTAGE real NOT NULL,
    CREATED_ON timestamp without time zone NOT NULL,
    CONSTRAINT PANELS_PKEY PRIMARY KEY (REG_ID)
);

-- Table: EPS.SUBSYSTEMS
CREATE TABLE EPS.SUBSYSTEMS
(
    REG_ID bigserial NOT NULL,
    SUBSYSTEM text NOT NULL,
    STATE text NOT NULL,
    EXPECTED_STATE text NOT NULL,
    CURRENT real NOT NULL,
    VOLTAGE real NOT NULL,
    CREATED_ON timestamp without time zone NOT NULL,
    CONSTRAINT SUBSYSTEMS_PKEY PRIMARY KEY (REG_ID)
);