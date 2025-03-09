CREATE TABLE SPRING_SESSION (
	PRIMARY_ID CHAR(36) NOT NULL,
	SESSION_ID CHAR(36) NOT NULL,
	CREATION_TIME BIGINT NOT NULL,
	LAST_ACCESS_TIME BIGINT NOT NULL,
	MAX_INACTIVE_INTERVAL INT NOT NULL,
	EXPIRY_TIME BIGINT NOT NULL,
	PRINCIPAL_NAME VARCHAR(100),
	CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
);

CREATE UNIQUE INDEX  SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
CREATE INDEX  SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
CREATE INDEX  SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);

CREATE TABLE SPRING_SESSION_ATTRIBUTES (
	SESSION_PRIMARY_ID CHAR(36) NOT NULL,
	ATTRIBUTE_NAME VARCHAR(200) NOT NULL,
	ATTRIBUTE_BYTES LONGVARBINARY NOT NULL,
	CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
	CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION(PRIMARY_ID) ON DELETE CASCADE
);

CREATE TABLE REVINFO (
	REV INT NOT NULL AUTO_INCREMENT,
	REVTSTMP BIGINT DEFAULT NULL,
	CONSTRAINT REVINFO_PK PRIMARY KEY (REV)
);

CREATE TABLE COMCOMPANY (
	CREATED_DT			    DATETIME		  	NULL		,
	CREATED_USER_ID		  	VARCHAR(50)			NULL		,
	CREATED_HOST_IP		  	VARCHAR(50)			NULL		,
	CREATED_APP_URL		  	VARCHAR(500)		NULL		,
	MODIFIED_DT			    DATETIME		  	NULL		,
	MODIFIED_USER_ID	  	VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP	  	VARCHAR(50)			NULL		,
	MODIFIED_APP_URL	  	VARCHAR(500)		NULL		,
  	ORG_CD				    VARCHAR(50)			NOT NULL	,
	ORG_NM			    	VARCHAR(100)		NOT NULL	,  	
  	BIZ_REG_NO 			    VARCHAR(20) 		NULL		,
  	CORP_NO 				VARCHAR(20) 		NULL 		,
  	REPR_NM 		   		VARCHAR(500)		NULL		,
  	TH1_CO_REPR_NM 			VARCHAR(500)		NULL		,
  	TH2_CO_REPR_NM 			VARCHAR(500)		NULL		,
  	HEAD_ADDR_TYPE			VARCHAR(50)			NULL		,
  	HEAD_POST_NO			VARCHAR(50)			NULL		,
  	HEAD_MAIN_ADDR			VARCHAR(500)		NULL		,
  	HEAD_SUB_ADDR			VARCHAR(500)		NULL		,
  	BIZ_ADDR_TYPE			VARCHAR(50)			NULL		,
  	BIZ_POST_NO				VARCHAR(50)			NULL		,
  	BIZ_MAIN_ADDR			VARCHAR(500)		NULL		,
  	BIZ_SUB_ADDR			VARCHAR(500)		NULL		,  	
  	BIZ_TYP_NM				VARCHAR(500)		NULL		,
  	BIZ_ITEM_NM				VARCHAR(500)		NULL		,
  	ESTA_DT				    DATETIME			NULL        ,  	
	constraint pk_comcompany primary key(ORG_CD)	
);
COMMENT ON TABLE COMCOMPANY IS '회사정보';

CREATE TABLE COMCODE (
	CREATED_DT			  	    DATETIME		  	NULL		,
	CREATED_USER_ID			    VARCHAR(50)			NULL		,
	CREATED_HOST_IP			    VARCHAR(50)			NULL		,
	CREATED_APP_URL			    VARCHAR(500)		NULL		,
	MODIFIED_DT				    DATETIME		  	NULL		,
	MODIFIED_USER_ID		    VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		    VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		    VARCHAR(500)		NULL    	,
	SYSTEM_TYPE_CODE		    VARCHAR(3)			NOT NULL	,
	CODE_ID	  	      	    	VARCHAR(255) 		NOT NULL	,
  	CODE				        VARCHAR(255) 		NOT NULL	,
	CODE_NAME			        VARCHAR(255) 		NOT NULL	,
	CODE_NAME_ABBR			    VARCHAR(255) 		NULL 		,
  	P_CODE_ID  		    	    VARCHAR(255)		NULL 		,
	FROM_DT				        DATETIME		  	NOT NULL	,
	TO_DT				        DATETIME		  	NOT NULL	,
	HIERARCHY_LEVEL			    INT				  	NOT NULL	,
	PRT_SEQ				        INT				    NULL		,
  	LOW_LEVEL_CODE_LENGTH 		INT				    NULL		,
	CMT					            VARCHAR(2000) 	NULL 		,
	constraint pk_comcode primary key(SYSTEM_TYPE_CODE, CODE_ID)	
);

CREATE TABLE COMDEPT (
	CREATED_DT			  		DATETIME		  	NULL		,
	CREATED_USER_ID				VARCHAR(50)		  	NULL		,
	CREATED_HOST_IP				VARCHAR(50)		  	NULL		,
	CREATED_APP_URL				VARCHAR(500)	  	NULL		,
	MODIFIED_DT			  		DATETIME		  	NULL		,
	MODIFIED_USER_ID			VARCHAR(50)		  	NULL		,
	MODIFIED_HOST_IP			VARCHAR(50)		  	NULL		,
	MODIFIED_APP_URL			VARCHAR(500)	  	NULL		,	
	ORG_CD				      	VARCHAR(50)		  	NOT NULL	,
  	DEPT_CD				      	VARCHAR(10) 	  	NOT NULL	,
  	P_DEPT_CD			      	VARCHAR(255)	  	NULL 		,
  	DEPT_NM_KOR			  		VARCHAR(255) 	  	NOT NULL	,
  	DEPT_ABBR_KOR		  		VARCHAR(255) 	  	NULL 		,
  	DEPT_NM_ENG			  		VARCHAR(255) 	  	NULL 		,
  	DEPT_ABBR_ENG		  		VARCHAR(255) 	  	NULL 		,
	FROM_DT				      	DATE			  	NULL		,
	TO_DT				        DATE			  	NULL		,
	PRT_SEQ				      	INT				  	NULL		,
	CMT					        VARCHAR(2000) 	 	NULL 		,
	constraint pk_comdept 		primary key(ORG_CD, DEPT_CD)
	/*constraint fk_comdept1	 	foreign key(P_DEPT_CD) references COMDEPT(DEPT_CD)*/
); 

CREATE TABLE COMFILEINFO (
	CREATED_DT			  	DATETIME			NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT				DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
 	FILE_ID					BIGINT		 		NOT NULL	,
  	APP_URL				    VARCHAR(50)			NULL 		,
  	USER_ID				    VARCHAR(20)			NULL		,
  	CONTENT_TYPE		  	VARCHAR(50)			NULL 		,
  	UUID				    VARCHAR(1000)		NOT NULL	,
  	FILE_PATH			    VARCHAR(1000)		NULL 		,
  	FILE_NM				    VARCHAR(1000)		NULL 		,
  	FILE_SIZE			    INT					NULL 		,
  	DOWNLOAD_CNT		  	INT					NULL 		,
	constraint pk_comfileinfo primary key(FILE_ID)
);

CREATE TABLE COMUSER (
	CREATED_DT			    DATETIME		  	NULL		,
	CREATED_USER_ID		  	VARCHAR(50)			NULL		,
	CREATED_HOST_IP		  	VARCHAR(50)			NULL		,
	CREATED_APP_URL		  	VARCHAR(500)		NULL		,
	MODIFIED_DT			    DATETIME		  	NULL		,
	MODIFIED_USER_ID	  	VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP	  	VARCHAR(50)			NULL		,
	MODIFIED_APP_URL	  	VARCHAR(500)		NULL		,
  	USER_ID				    VARCHAR(50)			NOT NULL	,
	USER_NAME			    VARCHAR(100)		NULL		,  	
  	MOBILE_NUM 			    VARCHAR(20) 		NULL		,
  	EMAIL 				    VARCHAR(320) 		NULL 		,
  	PWD 		   		    VARCHAR(2000)		NULL		,
  	FK_FILE				    VARCHAR(500)		NULL        ,
  	NON_EXPIRED_YN		  	BOOLEAN			  	NOT NULL    ,
  	NON_LOCKED_YN		    BOOLEAN			  	NOT NULL	,
  	PASS_NON_EXPIRED_YN		BOOLEAN			  	NOT NULL	,
  	ENABLED_YN			    BOOLEAN			  	NOT NULL	,
	constraint pk_comuser primary key(USER_ID)
	--constraint fk_comuser1	foreign key(FK_FILE) references COMFILEINFO(PK_FILE)
);
COMMENT ON TABLE COMUSER IS '사용자정보';

CREATE TABLE COMUSERCOMPANY (
	CREATED_DT			    DATETIME		  	NULL		,
	CREATED_USER_ID		  	VARCHAR(50)			NULL		,
	CREATED_HOST_IP		  	VARCHAR(50)			NULL		,
	CREATED_APP_URL		  	VARCHAR(500)		NULL		,
	MODIFIED_DT			    DATETIME		  	NULL		,
	MODIFIED_USER_ID	  	VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP	  	VARCHAR(50)			NULL		,
	MODIFIED_APP_URL	  	VARCHAR(500)		NULL		,
  	USER_ID				    VARCHAR(50)			NOT NULL	,
	ORG_CD				    VARCHAR(50)			NOT NULL	,		
	STAFF_NO			    VARCHAR(50)			NULL		,
	DEPT_CD				    VARCHAR(10) 		NULL 		,		
  	USE_YN			   		BOOLEAN			  	NOT NULL	,
	constraint pk_comusercompany primary key(USER_ID, ORG_CD)
	--constraint fk_comuser1	foreign key(FK_FILE) references COMFILEINFO(PK_FILE)
);
COMMENT ON TABLE COMUSERCOMPANY IS '사용자회사정보';

CREATE TABLE COMROLE (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,		
	ROLE_CD				    VARCHAR(50)			NOT NULL	,	
 	ROLE_NM             	VARCHAR(50)			NOT NULL   	,
 	ORG_CD				    VARCHAR(50)			NOT NULL	,
	MENU_GROUP_CD			VARCHAR(10)			NULL    	,
 	DESCRIPTION			  	VARCHAR(500)		NULL		,
	constraint pk_comrole primary key(ROLE_CD, ORG_CD)
);

CREATE TABLE COMUSERROLE (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,  	
  	USER_ID				   	VARCHAR(50)			NOT NULL	,
  	ROLE_CD				    VARCHAR(50)			NOT NULL	,
  	ORG_CD				    VARCHAR(50)			NOT NULL	,  	
	constraint pk_comuserrole 	primary key(USER_ID, ROLE_CD, ORG_CD)
	/*constraint fk_comuserauthority1	foreign key(USER_ID) references COMUSER(USER_ID)*/
	/*constraint fk_comuserauthority2	foreign key(AUTH_CD) references COMAUTHORITY(AUTH_CD)*/
); 
COMMENT ON TABLE COMUSERROLE IS '사용자권한매핑관리';


CREATE TABLE COMRESOURCE (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME		  	NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
  	RESOURCE_ID	  	  		VARCHAR(10)			NOT NULL	,
  	RESOURCE_NAME		  	VARCHAR(50)			NOT NULL	,
  	RESOURCE_TYPE		  	VARCHAR(10)			NOT NULL	,
  	URL					    VARCHAR(500)		NULL		,
  	DESCRIPTION			  	VARCHAR(500)		NULL		,
	constraint pk_comresource	primary key(RESOURCE_ID)
);
COMMENT ON TABLE COMRESOURCE IS '웹서버 리소스관리';

CREATE TABLE COMMENUGROUP (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,		
	MENU_GROUP_CD			VARCHAR(10)			NOT NULL	,
  	MENU_GROUP_NM			VARCHAR(50)			NOT NULL	,
  	MENU_GROUP_URL		  	VARCHAR(50)			NOT NULL	,
  	ORG_CD				    VARCHAR(10)			NOT NULL	,
  	DESCRIPTION			  	VARCHAR(500)		NULL		,
	constraint pk_commenugroup	primary key(MENU_GROUP_CD, ORG_CD)
);
COMMENT ON TABLE COMMENUGROUP IS '메뉴그룹관리';

CREATE TABLE COMMENU (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT				DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,		
	MENU_GROUP_CD		  	VARCHAR(50)			NOT NULL	,
  	MENU_CD			        VARCHAR(10)			NOT NULL	,
	MENU_NM			        VARCHAR(50)			NOT NULL	,
	ORG_CD				    VARCHAR(10)			NOT NULL	,
  	MENU_TYPE			  	VARCHAR(10)			NOT NULL	,
	P_MENU_CD			    VARCHAR(50)			NULL		,	
  	APP_URL				    VARCHAR(50)			NULL		,
  	APP_ICON_TYPE			VARCHAR(50)			NULL		,
  	APP_ICON				VARCHAR(500)		NULL		,
  	SEQ					    INT				  	NULL		,
	LVL					    INT				  	NULL		,
	constraint pk_commenu		primary key(MENU_GROUP_CD, MENU_CD, ORG_CD)
);
COMMENT ON TABLE COMMENU IS '메뉴관리';

CREATE TABLE COMMENUROLE (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT				DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,		
	MENU_GROUP_CD		  	VARCHAR(50)			NOT NULL	,
  	MENU_CD			        VARCHAR(10)			NOT NULL	,
	ROLE_CD				    VARCHAR(50)			NOT NULL	,
	ORG_CD				    VARCHAR(10)			NOT NULL	,
	constraint pk_commenurole		primary key(MENU_GROUP_CD, MENU_CD, ROLE_CD, ORG_CD)
);
COMMENT ON TABLE COMMENUROLE IS '메뉴롤관계관리';

CREATE TABLE COMLOGINHISTORY (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
	ID					    INT				    NOT NULL	,
	USER_ID				    VARCHAR(50)			NOT NULL	,
	EVENT_TYPE			  	VARCHAR(500)		NOT NULL	,
	EVENT_DT			    DATETIME		  	NOT NULL	,
	CLIENT_IP			    VARCHAR(500)		NOT NULL	,
	SUCCESS_YN			  	BOOLEAN			  	NOT NULL	,
	constraint pk_comloginhistory primary key(ID) 	
);
COMMENT ON TABLE COMLOGINHISTORY IS '로그인이력';


CREATE TABLE COMLOGINSOCIAL (
	CREATED_DT			  	DATETIME		  	NULL		,
	CREATED_USER_ID			VARCHAR(50)			NULL		,
	CREATED_HOST_IP			VARCHAR(50)			NULL		,
	CREATED_APP_URL			VARCHAR(500)		NULL		,
	MODIFIED_DT			  	DATETIME			NULL		,
	MODIFIED_USER_ID		VARCHAR(50)			NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)			NULL		,
	MODIFIED_APP_URL		VARCHAR(500)		NULL		,
	REG_ID				    VARCHAR(50)		    NOT NULL	,
	CODE				    VARCHAR(50)			NOT NULL	,
	USER_NAME			  	VARCHAR(500)		NULL		,
	USER_EMAIL				VARCHAR(500)		NULL		,
	USER_ID				  	VARCHAR(500)		NULL		,
	USE_YN				  	BOOLEAN				NOT NULL	,									
	constraint pk_comloginsocial primary key(REG_ID, CODE) 	
);
COMMENT ON TABLE COMLOGINSOCIAL IS '소셜로그인';

CREATE TABLE COMHOLIDAY (
	CREATED_DT			  	DATETIME		    NULL		,
	CREATED_USER_ID			VARCHAR(50)		  	NULL		,
	CREATED_HOST_IP			VARCHAR(50)		  	NULL		,
	CREATED_APP_URL			VARCHAR(500)	  	NULL		,
	MODIFIED_DT			  	DATETIME		    NULL		,
	MODIFIED_USER_ID		VARCHAR(50)		  	NULL		,
	MODIFIED_HOST_IP		VARCHAR(50)		  	NULL		,
	MODIFIED_APP_URL		VARCHAR(500)	  	NULL		,
	ORG_CD				    VARCHAR(10)			NOT NULL	,
  	HOLIDAY_DT			  	DATETIME		  	NOT NULL	,
  	HOLIDAY_NM			  	VARCHAR(255)  		NOT NULL 	,
	CMT					    VARCHAR(2000) 		NULL 		,
	constraint pk_comholiday primary key(ORG_CD, HOLIDAY_DT)	
);
COMMENT ON TABLE COMHOLIDAY IS '공휴일관리';