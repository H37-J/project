from selenium import webdriver
import time;
web = webdriver.Chrome(executable_path='./chromedriver')

web.get('https://search.naver.com/search.naver?where=view&sm=tab_jum&query=%ED%8C%8C%EC%A3%BC+%ED%99%88%EB%8B%A5%ED%84%B0+119')

print(web.window_handles);

time.sleep(2);


bu=web.find_element_by_class_name("total_tit");
print(bu)
bu.click();
