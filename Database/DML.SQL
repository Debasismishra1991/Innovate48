Insert into PRODUCT (PRODUCT_ID,PRODUCT_NAME) values (100,'InvestOne');
Insert into PRODUCT (PRODUCT_ID,PRODUCT_NAME) values (101,'Investran');
Insert into PRODUCT (PRODUCT_ID,PRODUCT_NAME) values (102,'IntelliMatch');

Insert into CLIENT (CLIENT_ID,CLIENT_NAME) values (200,'PIF');
Insert into CLIENT (CLIENT_ID,CLIENT_NAME) values (201,'LIG');
Insert into CLIENT (CLIENT_ID,CLIENT_NAME) values (202,'Fidelity');

Insert into MODULE (MODULE_ID,PRODUCT_ID,MODULE_NAME) values (300,100,'Account');
Insert into MODULE (MODULE_ID,PRODUCT_ID,MODULE_NAME) values (301,100,'Security');
Insert into MODULE (MODULE_ID,PRODUCT_ID,MODULE_NAME) values (303,100,'Trade');

Insert into FIELDS (FIELD_ID,MODULE_ID,FIELD_NAME,FIELD_DESC) values (400,300,'ACCT','Account Number');
Insert into FIELDS (FIELD_ID,MODULE_ID,FIELD_NAME,FIELD_DESC) values (401,300,'ACCDT','Account Date');

Insert into LK_CLIENT_PRODUCT (CLI_PRO_ID,CLIENT_ID,PRODUCT_ID) values (500,202,100);
Insert into LK_CLIENT_PRODUCT (CLI_PRO_ID,CLIENT_ID,PRODUCT_ID) values (501,202,102);

Insert into MAPPING (CLI_PRO_ID,MODULE_ID,FIELD_ID,FIELD_VALUE) values (500,300,400,'Account Number');