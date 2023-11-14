--------------------------------------------------------
--  DDL for Function DATAS
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "C##MYHOME"."DATAS" (
    p_city In VARCHAR2
    ,p_street In VARCHAR2
    ,p_bon_bun In VARCHAR2
    ,p_bu_bun In VARCHAR2
    ,p_dan_gi_myeong In VARCHAR2
    ,p_square_meter In VARCHAR2
    ,p_layer In VARCHAR2
    ,p_construction_date In VARCHAR2
)
RETURN VARCHAR2
IS
   v_result VARCHAR2(32767) := '';
BEGIN

   SELECT LISTAGG('{x:'||CONCAT(CONTRACT_DATE||LPAD(CONTRACT_DAY, 2, '0'), ',y:'||TRIM(REPLACE(AMOUNT, ',', '')))||'}' ,',') WITHIN GROUP (ORDER BY CONTRACT_DATE||LPAD(CONTRACT_DAY, 2, '0')) INTO v_result
   FROM apt
   WHERE city = p_city
   and street = p_street
   and bon_bun = p_bon_bun
   and bu_bun = p_bu_bun
   and dan_gi_myeong = p_dan_gi_myeong
   and square_meter = p_square_meter
   and layer = p_layer
   and construction_date = p_construction_date
   ;

   RETURN REPLACE(rtrim(v_result, ','), ' ', '');
END DATAS;

/
--------------------------------------------------------
--  DDL for Function GET_AMOUNT
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "C##MYHOME"."GET_AMOUNT" (
    p_city In VARCHAR2
    ,p_street In VARCHAR2
    ,p_bon_bun In VARCHAR2
    ,p_bu_bun In VARCHAR2
    ,p_dan_gi_myeong In VARCHAR2
    ,p_square_meter In VARCHAR2
    ,p_layer In VARCHAR2
    ,p_construction_date In VARCHAR2
)
RETURN VARCHAR2
IS
   v_result VARCHAR2(32767) := '';
BEGIN
   SELECT LISTAGG(REPLACE(AMOUNT,',',''),',') WITHIN GROUP (ORDER BY AMOUNT) INTO v_result
   FROM apt
   WHERE city = p_city
   and street = p_street
   and bon_bun = p_bon_bun
   and bu_bun = p_bu_bun
   and dan_gi_myeong = p_dan_gi_myeong
   and square_meter = p_square_meter
   and layer = p_layer
   and construction_date = p_construction_date;

   RETURN REPLACE(rtrim(v_result, ','), ' ', '');
END get_amount;

/
--------------------------------------------------------
--  DDL for Function GET_CONTRACT
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "C##MYHOME"."GET_CONTRACT" (
    p_city In VARCHAR2
    ,p_street In VARCHAR2
    ,p_bon_bun In VARCHAR2
    ,p_bu_bun In VARCHAR2
    ,p_dan_gi_myeong In VARCHAR2
    ,p_square_meter In VARCHAR2
    ,p_layer In VARCHAR2
    ,p_construction_date In VARCHAR2
)
RETURN VARCHAR2
IS
   v_result VARCHAR2(32767) := '';
BEGIN
   SELECT REGEXP_REPLACE(LISTAGG(CONTRACT_DATE||LPAD(CONTRACT_DAY, 2, '0'),',') WITHIN GROUP (ORDER BY CONTRACT_DATE,LPAD(CONTRACT_DAY, 2, '0')), '([^,]+)(,\1)*(,|$)', '\1\3') INTO v_result
--   SELECT LISTAGG(CONTRACT_DATE||LPAD(CONTRACT_DAY, 2, '0'),',') WITHIN GROUP (ORDER BY CONTRACT_DATE,LPAD(CONTRACT_DAY, 2, '0')) INTO v_result
   FROM apt
   WHERE city = p_city
   and street = p_street
   and bon_bun = p_bon_bun
   and bu_bun = p_bu_bun
   and dan_gi_myeong = p_dan_gi_myeong
   and square_meter = p_square_meter
   and layer = p_layer
   and construction_date = p_construction_date;

   RETURN REPLACE(rtrim(v_result, ','), ' ', '');
END GET_CONTRACT;

/
--------------------------------------------------------
--  DDL for Function GET_TRANSACTIONCOUNT
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "C##MYHOME"."GET_TRANSACTIONCOUNT" (
    p_city In VARCHAR2
    ,p_street In VARCHAR2
    ,p_bon_bun In VARCHAR2
    ,p_bu_bun In VARCHAR2
    ,p_dan_gi_myeong In VARCHAR2
    ,p_square_meter In VARCHAR2
    ,p_layer In VARCHAR2
    ,p_construction_date In VARCHAR2
    ,p_contract_date In VARCHAR2
    ,p_contract_day In VARCHAR2
)
RETURN VARCHAR2
IS
   v_result VARCHAR2(32767) := '';
BEGIN
   SELECT ROUND(AVG(REPLACE(AMOUNT,',',''))) INTO v_result
   FROM apt
   WHERE city = p_city
   and street = p_street
   and bon_bun = p_bon_bun
   and bu_bun = p_bu_bun
   and dan_gi_myeong = p_dan_gi_myeong
   and square_meter = p_square_meter
   and layer = p_layer
   and construction_date = p_construction_date
   and contract_date = p_contract_date
   and contract_day = p_contract_day
   ;

   RETURN REPLACE(rtrim(v_result, ','), ' ', '');
END GET_TRANSACTIONCOUNT;

/
--------------------------------------------------------
--  DDL for Function GET_TRANSACTIONCOUNT_LIST
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "C##MYHOME"."GET_TRANSACTIONCOUNT_LIST" (
    p_city In VARCHAR2
    ,p_street In VARCHAR2
    ,p_bon_bun In VARCHAR2
    ,p_bu_bun In VARCHAR2
    ,p_dan_gi_myeong In VARCHAR2
    ,p_square_meter In VARCHAR2
    ,p_layer In VARCHAR2
    ,p_construction_date In VARCHAR2
)
RETURN VARCHAR2
IS
   v_result VARCHAR2(32767) := '';
BEGIN
   SELECT REGEXP_REPLACE(LISTAGG(GET_TRANSACTIONCOUNT(A.CITY,A.STREET,A.BON_BUN,A.BU_BUN,A.DAN_GI_MYEONG,A.SQUARE_METER,A.LAYER,A.CONSTRUCTION_DATE,A.CONTRACT_DATE,A.CONTRACT_DAY),','), '([^,]+)(,\1)*(,|$)', '\1\3') INTO v_result
   FROM (
       SELECT 
       A.CITY,A.STREET,A.BON_BUN,A.BU_BUN,A.DAN_GI_MYEONG,A.SQUARE_METER,A.LAYER,A.CONSTRUCTION_DATE,A.CONTRACT_DATE,A.CONTRACT_DAY
       FROM apt A
       WHERE city = p_city
       and street = p_street
       and bon_bun = p_bon_bun
       and bu_bun = p_bu_bun
       and dan_gi_myeong = p_dan_gi_myeong
       and square_meter = p_square_meter
       and layer = p_layer
       and construction_date = p_construction_date
       GROUP BY A.CITY,A.STREET,A.BON_BUN,A.BU_BUN,A.DAN_GI_MYEONG,A.SQUARE_METER,A.LAYER,A.CONSTRUCTION_DATE,A.CONTRACT_DATE,A.CONTRACT_DAY
       ) A
   ;

   RETURN REPLACE(rtrim(v_result, ','), ' ', '');
END GET_TRANSACTIONCOUNT_LIST;

/
