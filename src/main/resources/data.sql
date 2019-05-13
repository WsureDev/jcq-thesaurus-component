INSERT INTO setting (
config  ,master_id  ,exact_key,vague_key,regex_key,answer_key,delete_key,query_key,global_key)
SELECT
0       ,844157922  ,'精确问'  ,'模糊问'  ,'正则问'  ,'答'        ,'删问'   ,'查问'   ,'全局'
WHERE not EXISTS (SELECT config FROM setting where config = 0);
