from selenium import webdriver
from selenium.webdriver.common.by import By

#start browser
driver = webdriver.Chrome()

#change python url
driver.get('https://www.python.org/')

#write text "Python" on input
driver.find_element(By.CSS_SELECTOR, ('#id-search-field')).send_keys("Python")

#click search button
driver.find_element(By.CSS_SELECTOR, ('#submit')).click

#close browser
driver.quit()
