from selenium import webdriver
from selenium.webdriver.common.by import By

# passo 1
driver = webdriver.Chrome()
driver.get('https://www.google.com')
driver.maximize_window()
search_box = driver.find_element(By.CSS_SELECTOR, ('.gLFyf'))
search_box.send_keys('Computação ULBRA Torres')
search_box.submit()
driver.quit()

# passo 2
import time
browser = webdriver.Chrome()
browser.get("https://www.browserstack.com/users/sign_in") 
time.sleep(10)
user = browser.find_element_by_id("user_email_login")
password = browser.find_element_by_id("user_password")
user.send_keys("evaldtygor@gmail.com")
password.send_keys("codeislife")
login_attempt = browser.find_element_by_xpath("//*[@type='submit']")
login_attempt.submit()
browser.quit()


