INSERT INTO PRODUCT(CATEGORY_MAIN,CATEGORY_SUB,CONTENT,DES_IMAGE1,DES_IMAGE2,DES_IMAGE3,DETAILS,MAIN_IMAGE1,
                    MAIN_IMAGE2,MAIN_IMAGE3,PRICE,SIZE,STATUS,STOCK,TITLE,COMINGDATE) SELECT CATEGORY_MAIN,CATEGORY_SUB,CONTENT,DES_IMAGE1,DES_IMAGE2,DES_IMAGE3,DETAILS,MAIN_IMAGE1,
                                                                                             MAIN_IMAGE2,MAIN_IMAGE3,PRICE,SIZE,STATUS,STOCK,TITLE,COMINGDATE FROM PRODUCT;

INSERT INTO USER(CREATE_AT,UPDATE_AT,ACCOUNT_ID,ADDRESS_SET,EMAIL,NAME,PASSWORD,POINT,PROFILE,ROLE,REQUEST,DELETED,DELETED_DATE) SELECT CREATE_AT,UPDATE_AT,ACCOUNT_ID,ADDRESS_SET,EMAIL,NAME,PASSWORD,POINT,PROFILE,ROLE,REQUEST,DELETED,DELETED_DATE FROM USER WHERE ID=9;
