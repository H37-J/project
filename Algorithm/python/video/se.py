from selenium import webdriver
import time;

web = webdriver.Chrome(executable_path='./chromedriver')

web.get('http://www.filesun.com/')
print(web.window_handles);

time.sleep(2);
web.switch_to_alert();

time.sleep(2);
id=web.find_element_by_id("outloginS1Id");
id.send_keys("these9907");

time.sleep(1);
pw=web.find_element_by_id("outloginS1Pw");
pw.send_keys("star8903");

time.sleep(1);
bu=web.find_element_by_class_name("loginBtn");
bu.click();
