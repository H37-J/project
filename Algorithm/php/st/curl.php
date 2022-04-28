<?php

$url ="https://www.naver.com/";

$ch=curl_init();
curl_setopt($ch,CURLOPT_URL,$url);
curl_setopt($ch,CURLOPT_RETURNTRANSFER,1);
curl_setopt($ch,CURLOPT_SSL_VERIFYPEER,FALSE);

$result=curl_exec($ch);
print_r($result);
