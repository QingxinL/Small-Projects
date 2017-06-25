from bs4 import BeautifulSoup
from urllib.request import urlopen
import re
#url = 'https://careers.twosigma.com/careers/JobDetail/New-York-New-York-United-States-Electronic-Algorithmic-Trader-Campus-Hire/723'
#url='https://careers.twosigma.com/careers/JobDetail/New-York-New-York-United-States-Software-Engineering-Internship/2944'
#url='https://careers.twosigma.com/careers/JobDetail/New-York-New-York-United-States-Full-Stack-Analytics-Engineer/1046'
url='https://careers.twosigma.com/careers/JobDetail/New-York-New-York-United-States-Quantitative-Researcher-in-Machine-Learning/1439'
html = urlopen(url)
soup = BeautifulSoup(html,'lxml')


start = soup.find(text=re.compile('[a-z]* qualifications:'))
requirements = start.find_next('ul').findAll('li')
for requirement in requirements:
    print(requirement.text)

